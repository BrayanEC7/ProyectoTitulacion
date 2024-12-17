package com.monsalve.inmoviliaria.Service;

import com.monsalve.inmoviliaria.Controller.Dto.EmpresasDto;
import com.monsalve.inmoviliaria.Model.EmpresasEntity;
import com.monsalve.inmoviliaria.Service.Repository.EmpresasRepository;
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
public class EmpresasService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    EmpresasRepository repository;

    public List<EmpresasDto> getAll(){
        try{
            return repository.findAll()
                    .stream()
                    .map(x->modelMapper.map(x, EmpresasDto.class))
                    .collect(Collectors.toList());
        }catch(Exception ex){
            return null;
        }
    }

    public EmpresasDto saveEmpresa(EmpresasDto registro){
        try{
            return  this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registro, EmpresasEntity.class)
                    ), EmpresasDto.class);
        }catch(Exception ex){
            return null;
        }
    }

    public Boolean deleteEmpresa(UUID id){
        try{
            Optional<EmpresasEntity> registro= repository.findById(id);
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
