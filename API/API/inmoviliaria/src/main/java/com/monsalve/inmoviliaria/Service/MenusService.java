package com.monsalve.inmoviliaria.Service;

import com.monsalve.inmoviliaria.Controller.Dto.MenuDto;
import com.monsalve.inmoviliaria.Model.MenuEntity;
import com.monsalve.inmoviliaria.Service.Repository.MenuRepository;
import jakarta.persistence.Tuple;
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
public class MenusService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    MenuRepository repository;
    public List<MenuDto> getAll(){
        try{
            return repository.findAll()
                    .stream()
                    .map(x->modelMapper.map(x, MenuDto.class))
                    .collect(Collectors.toList());
        }catch(Exception ex){
            return null;
        }
    }

    public List<MenuDto> getAllConMenuPadres(){
        try{
            var datos=repository.finAllMenuPadres();
            return this.lista(datos);
        }catch(Exception ex){
            log.error("Error al listar Menus : ",ex.getMessage());
            return null;
        }
    }

    private List<MenuDto> lista(List<Tuple> datos){
        List<MenuDto> lista = new ArrayList<>();
        for (Tuple ele : datos){
            MenuDto dtotmp=new MenuDto();
            dtotmp.setMenu_idllave_pk((UUID) ele.get("menu_idllave_pk"));
            dtotmp.setNombre((String) ele.get("nombre"));
            dtotmp.setIcono((String) ele.get("icono"));
            dtotmp.setOrden((String) ele.get("orden"));
            dtotmp.setUrl((String) ele.get("url"));
            dtotmp.setCodigoPadre((UUID) ele.get("codigoPadre"));
            dtotmp.setNombrePadre((String) ele.get("nombrePadre"));
            lista.add(dtotmp);
        }
        return  lista;
    }


    public MenuDto saveMenu(MenuDto registro){
        try{
            return  this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registro, MenuEntity.class)
                    ), MenuDto.class);
        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteMenu(UUID id){
        try{
            Optional<MenuEntity> registro=
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
