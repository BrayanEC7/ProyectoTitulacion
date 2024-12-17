package com.monsalve.inmoviliaria.Service;

import com.monsalve.inmoviliaria.Controller.Dto.LoginResponseDto;
import com.monsalve.inmoviliaria.Controller.Dto.RolDto;
import com.monsalve.inmoviliaria.Model.RolEntity;
import com.monsalve.inmoviliaria.Service.Repository.RolRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RolService {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    RolRepository repository;

    public List<RolDto> getAll(){
        try{
            return repository.findAll().stream().map(x->modelMapper.map(x, RolDto.class))
                    .collect(Collectors.toList());
        }catch(Exception ex){
            return null;
        }
    }

    public List<RolDto> getRolConCliente() {

        List<Object[]> resultados = repository.findAllPropiedades();
        List<RolDto> propiedadesDtoList = new ArrayList<>();
        for (Object[] resultado : resultados) {
            RolEntity propiedadesEntity = (RolEntity) resultado[0];
            String nombreCliente = (String) resultado[1];

            RolDto propiedadesDto = new RolDto();
            propiedadesDto.setId(propiedadesEntity.getId());
            propiedadesDto.setUser(propiedadesEntity.getUser());
            propiedadesDto.setPassword(propiedadesEntity.getPassword());
            propiedadesDto.setEstado_rol(propiedadesEntity.getEstado_rol());
            propiedadesDto.setNombre_rol(propiedadesEntity.getNombre_rol());
            propiedadesDto.setClienteId(propiedadesEntity.getCliente().getId());
            propiedadesDto.setNombre_cli(nombreCliente);
            propiedadesDtoList.add(propiedadesDto);
        }
        return propiedadesDtoList;
    }
    public LoginResponseDto login(String user, String clave){
        LoginResponseDto response= new LoginResponseDto();
        response.setCodigo(400);
        try{
            RolEntity usuariouser=repository.findByUser(user);
            if(usuariouser==null){
                response.setMensaje("UsuarioNulo");
                response.setToken("");
                return response;
            }

            if(!usuariouser.getPassword().equals(clave)){
                response.setMensaje("ClaveErronea");
                return response;
            }
            String datos="id="+usuariouser.getCliente().getId()+"!=!";
            datos+="usuario="+usuariouser.getUser()+"!=!";
            datos+="password="+usuariouser.getPassword()+"!=!";
            datos+="cargo="+usuariouser.getNombre_rol()+"!=!";
            datos+="persona="+usuariouser.getCliente().getNombre_cli()+"!=!";
            datos+="fechayhora="+ LocalDateTime.now();
            Base64 base64 = new Base64();
            String token= new String(base64.encode(datos.getBytes()));
            response.setCodigo(200);
            response.setMensaje("Inicio de Sesión Satisfactorio");
            response.setToken(token);
            return response;
        }catch(Exception ex){
            log.error("error al loguearse log",ex.getMessage());
            response.setMensaje("error al loguearse  -> "+ ex.getCause());
            response.setToken("");
            return response;
        }
    }

    /*public String findByUserAndPassword(String user, String clave){
        try{
            RolEntity usuariosEntity=repository.findByUserAndPassword(user,clave);
            if(usuariosEntity.equals(null)) return "";
            String datos="id="+usuariosEntity.getId()+"!=!";
            datos+="usuario="+usuariosEntity.getUser()+"!=!";
            datos+="password="+usuariosEntity.getPassword()+"!=!";
            datos+="cargo="+usuariosEntity.getNombre_rol()+"!=!";
           // datos+="cargo="+usuariosEntity.getCargo_rol()+"!=!";
            datos+="fechayhora="+ LocalDateTime.now();
            Base64 base64 = new Base64();
            return new String(base64.encode(datos.getBytes()));
        }catch(Exception ex){
            log.error("error al loguearse",ex.getCause());
            return null;
        }
    }*/

    public RolDto saveRol(RolDto registro){
        try {
            return this.modelMapper.map(repository.save(
                    this.modelMapper.map(registro, RolEntity.class)
            ), RolDto.class);
        }catch (Exception ex){
            return null;
        }
    }

    public Boolean deleteRol(UUID id){
        try{
            Optional<RolEntity> registro= repository.findById(id);
            if(registro.isPresent()){
                repository.delete(registro.get());
                return true;
            }
            return false;
        }catch(Exception ex){
            return false;
        }
    }
}
