package com.monsalve.inmoviliaria.Service;

import com.monsalve.inmoviliaria.Controller.Dto.InformacionDto;
import com.monsalve.inmoviliaria.Model.InformacionEntity;
import com.monsalve.inmoviliaria.Service.Repository.InformacionRepository;
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
public class InformacionService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    InformacionRepository repository;

    public List<InformacionDto> getAll(){
        try{
            return repository.findAll()
                    .stream()
                    .map(x->modelMapper.map(x, InformacionDto.class))
                    .collect(Collectors.toList());
        }catch(Exception ex){
            return null;
        }
    }

    public InformacionDto getPais(){
        try{
           /* return this.modelMapper.map(
                    repository.findByClientenombreOrClienteapellidos(clientenombre,clienteapellidos),
                    ClienteDto.class);*/
            return null;
        }catch(Exception ex){
            return null;
        }
    }

    public InformacionDto saveInformacion(InformacionDto registro){
        try{
            return  this.modelMapper.map(
                    repository.save(
                            this.modelMapper.map(registro, InformacionEntity.class)
                    ), InformacionDto.class);
        }catch(Exception ex){
            return null;
        }
    }
    public Boolean deleteInformacion(UUID id){
        try{
            Optional<InformacionEntity> registro=
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
