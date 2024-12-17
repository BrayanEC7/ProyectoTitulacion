package com.monsalve.inmoviliaria.Service;

import com.monsalve.inmoviliaria.Controller.Dto.PedidosDto;
import com.monsalve.inmoviliaria.Model.PedidosEntity;
import com.monsalve.inmoviliaria.Service.Repository.PedidosRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PedidosService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PedidosRepository repository;

    public List<PedidosDto> getAll(){
        try{
            return repository.findAll()
                    .stream()
                    .map(x->modelMapper.map(x, PedidosDto.class))
                    .collect(Collectors.toList());
        }catch(Exception ex){
            return null;
        }
    }



    public PedidosDto saveDepartamento(PedidosDto registro){
        try{
            return  this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registro, PedidosEntity.class)
                    ), PedidosDto.class);
        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteDepartamento(UUID id){
        try{
            Optional<PedidosEntity> registro=
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
