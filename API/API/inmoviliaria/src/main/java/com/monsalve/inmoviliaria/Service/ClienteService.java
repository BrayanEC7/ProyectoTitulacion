package com.monsalve.inmoviliaria.Service;

import com.monsalve.inmoviliaria.Controller.Dto.ClientesDto;
import com.monsalve.inmoviliaria.Model.ClientesEntity;
import com.monsalve.inmoviliaria.Service.Repository.ClientesRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class ClienteService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ClientesRepository repository;

    public List<ClientesDto> getAll(){
        try{
            return repository.findAll()
                    .stream()
                    .map(x->modelMapper.map(x, ClientesDto.class))
                    .collect(Collectors.toList());
        }catch(Exception ex){
            return null;
        }
    }

    public List<ClientesDto> getAllClienteRol(){
        List<Object[]> resultados = repository.findAllCliente();
        List<ClientesDto> clientesDtoList = new ArrayList<>();
        for (Object[] resultado : resultados) {
            ClientesEntity clientesEntity = (ClientesEntity) resultado[0];
            String nombreRol = (String) resultado[1];
            ClientesDto clientesDto = new ClientesDto();
            clientesDto.setId(clientesEntity.getId());
            clientesDto.setNombre_cli(clientesEntity.getNombre_cli());
            clientesDto.setApellidos_cli(clientesEntity.getApellidos_cli());
            clientesDto.setNrodoc_cli(clientesEntity.getNrodoc_cli());
            clientesDto.setTelefono_cli(clientesEntity.getTelefono_cli());
            clientesDto.setCorreo_cli(clientesEntity.getCorreo_cli());
            clientesDto.setDescripcion_cli(clientesEntity.getDescripcion_cli());
            clientesDto.setNombre_rol(nombreRol);
            clientesDto.setTipodoc_cli(clientesEntity.getTipodoc_cli());
            clientesDto.setDepartamento_cli(clientesEntity.getDepartamento_cli());
            clientesDto.setDistrito_cli(clientesEntity.getDistrito_cli());
            clientesDto.setDireccion_cli(clientesEntity.getDireccion_cli());
            //clientesDto.setGenero_cli(clientesEntity.getGenero_cli());

            clientesDto.setNombre_rol(nombreRol);
            clientesDtoList.add(clientesDto);

        }
        return clientesDtoList;
    }
    public List<ClientesDto> getAllClienteRolNull(){
        List<Object[]> resultados = repository.findAllClienteRolNull();
        List<ClientesDto> clientesDtoList = new ArrayList<>();
        for (Object[] resultado : resultados) {
            ClientesEntity clientesEntity = (ClientesEntity) resultado[0];
            ClientesDto clientesDto = new ClientesDto();
            clientesDto.setId(clientesEntity.getId());
            clientesDto.setNombre_cli(clientesEntity.getNombre_cli());
            clientesDto.setApellidos_cli(clientesEntity.getApellidos_cli());
            clientesDto.setNrodoc_cli(clientesEntity.getNrodoc_cli());
            clientesDto.setTelefono_cli(clientesEntity.getTelefono_cli());
            clientesDto.setCorreo_cli(clientesEntity.getCorreo_cli());
          //  clientesDto.setGenero_cli(clientesEntity.getGenero_cli());
            clientesDto.setDescripcion_cli(clientesEntity.getDescripcion_cli());
            clientesDtoList.add(clientesDto);
        }
        return clientesDtoList;
    }

    public List<ClientesDto> getAllClienteNotTrabajador(){
        List<Object[]> resultados = repository.findAllClienteNotTrabajador();
        List<ClientesDto> clientesDtoList = new ArrayList<>();
        for (Object[] resultado : resultados) {
            ClientesEntity clientesEntity = (ClientesEntity) resultado[0];
            ClientesDto clientesDto = new ClientesDto();
            clientesDto.setId(clientesEntity.getId());
            clientesDto.setNombre_cli(clientesEntity.getNombre_cli());
            clientesDto.setApellidos_cli(clientesEntity.getApellidos_cli());
            clientesDto.setNrodoc_cli(clientesEntity.getNrodoc_cli());
            clientesDto.setTelefono_cli(clientesEntity.getTelefono_cli());
            clientesDto.setCorreo_cli(clientesEntity.getCorreo_cli());
          //  clientesDto.setGenero_cli(clientesEntity.getGenero_cli());
            clientesDto.setDescripcion_cli(clientesEntity.getDescripcion_cli());
            clientesDtoList.add(clientesDto);
        }
        return clientesDtoList;
    }
    public ClientesDto saveCliente(ClientesDto registro){
        try{
            return  this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registro, ClientesEntity.class)
                    ), ClientesDto.class);
        }catch(Exception ex){
            return null;
        }
    }

    public Boolean deleteCliente(UUID id){
        try{
            Optional<ClientesEntity> registro=
                    repository.findById(id);
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
