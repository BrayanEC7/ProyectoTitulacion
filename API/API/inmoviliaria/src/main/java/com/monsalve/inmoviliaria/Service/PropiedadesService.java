package com.monsalve.inmoviliaria.Service;
import com.monsalve.inmoviliaria.Controller.Dto.PropiedadesDto;
import com.monsalve.inmoviliaria.Model.PropiedadesEntity;
import com.monsalve.inmoviliaria.Service.Repository.PropiedadesRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class PropiedadesService {
    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PropiedadesRepository repository;
    private static final int MIN_RANDOM_CODE = 1000;
    private static final int MAX_RANDOM_CODE = 9999;

    public List<PropiedadesDto> getAll(){
        try{
            return repository.findAll()
                    .stream()
                    .map(x->modelMapper.map(x, PropiedadesDto.class))
                    .collect(Collectors.toList());
        }catch(Exception ex){
            return null;
        }
    }
    public PropiedadesDto getPropiedadesPorId(UUID id){
        try{
            return this.modelMapper.map(
                    repository.listar(id),
                    PropiedadesDto.class);
        }catch(Exception ex){
            return null;
        }
    }

    public List<PropiedadesDto> listarPropiedadesConCliente(UUID id) {

        List<Object[]> resultados = repository.findAllClientes(id);
        List<PropiedadesDto> propiedadesDtoList = new ArrayList<>();
        for (Object[] resultado : resultados) {
            PropiedadesEntity propiedadesEntity = (PropiedadesEntity) resultado[0];
            String nombreCliente = (String) resultado[1];
            String telefonoCliente = (String) resultado[2];
            String correoCliente = (String) resultado[3];
            String tipoDoc =(String) resultado[4];
            String numDoc =(String) resultado[5];

            PropiedadesDto propiedadesDto = new PropiedadesDto();
            propiedadesDto.setId(propiedadesEntity.getId());
            propiedadesDto.setActivar_prop(propiedadesEntity.getActivar_prop());
            //codigo recién agregado
            propiedadesDto.setCodigo_prop(propiedadesEntity.getCodigo_prop());
            propiedadesDto.setArea_total_prop(propiedadesEntity.getArea_total_prop());
            propiedadesDto.setCategoria_prop(propiedadesEntity.getCategoria_prop());
            propiedadesDto.setCoordenadas_prop(propiedadesEntity.getCoordenadas_prop());
            propiedadesDto.setDescripcion_prop(propiedadesEntity.getDescripcion_prop());
            propiedadesDto.setEstado_venta_prop(propiedadesEntity.getEstado_venta_prop());
            propiedadesDto.setFecha_publicacion_prop(propiedadesEntity.getFecha_publicacion_prop());
            propiedadesDto.setFoto_principal_prop(propiedadesEntity.getFoto_principal_prop());
            propiedadesDto.setFoto_secundaria_prop(propiedadesEntity.getFoto_secundaria_prop());
            propiedadesDto.setLote_prop(propiedadesEntity.getLote_prop());
            propiedadesDto.setManzana_prop(propiedadesEntity.getManzana_prop());
            propiedadesDto.setPrecio_prop(propiedadesEntity.getPrecio_prop());
            propiedadesDto.setProvincia_prop(propiedadesEntity.getProvincia_prop());
            propiedadesDto.setTitulo_prop(propiedadesEntity.getTitulo_prop());
            propiedadesDto.setClienteId(propiedadesEntity.getCliente().getId());
            propiedadesDto.setNombre_cli(nombreCliente);
            propiedadesDto.setTelefono_cli(telefonoCliente);
            propiedadesDto.setCorreo_cli(correoCliente);
            propiedadesDto.setTipodoc_cli(tipoDoc);
            propiedadesDto.setNrodoc_cli(numDoc);
            propiedadesDtoList.add(propiedadesDto);
        }
        return propiedadesDtoList;
    }
    public List<PropiedadesDto> getPropiedadesConCliente() {

        List<Object[]> resultados = repository.findAllPropiedades();
        List<PropiedadesDto> propiedadesDtoList = new ArrayList<>();
        for (Object[] resultado : resultados) {
            PropiedadesEntity propiedadesEntity = (PropiedadesEntity) resultado[0];
            String nombreCliente = (String) resultado[1];
            String telefonoCliente = (String) resultado[2];
            String correoCliente = (String) resultado[3];

            PropiedadesDto propiedadesDto = new PropiedadesDto();
            propiedadesDto.setId(propiedadesEntity.getId());
            propiedadesDto.setActivar_prop(propiedadesEntity.getActivar_prop());
            propiedadesDto.setArea_total_prop(propiedadesEntity.getArea_total_prop());
            //codigo recién agregado
            propiedadesDto.setCodigo_prop(propiedadesEntity.getCodigo_prop());
            propiedadesDto.setCategoria_prop(propiedadesEntity.getCategoria_prop());
            propiedadesDto.setCoordenadas_prop(propiedadesEntity.getCoordenadas_prop());
            propiedadesDto.setDescripcion_prop(propiedadesEntity.getDescripcion_prop());
            propiedadesDto.setEstado_venta_prop(propiedadesEntity.getEstado_venta_prop());
            propiedadesDto.setFecha_publicacion_prop(propiedadesEntity.getFecha_publicacion_prop());
            propiedadesDto.setFoto_principal_prop(propiedadesEntity.getFoto_principal_prop());
            propiedadesDto.setFoto_secundaria_prop(propiedadesEntity.getFoto_secundaria_prop());
            propiedadesDto.setLote_prop(propiedadesEntity.getLote_prop());
            propiedadesDto.setManzana_prop(propiedadesEntity.getManzana_prop());
            propiedadesDto.setPrecio_prop(propiedadesEntity.getPrecio_prop());
            propiedadesDto.setProvincia_prop(propiedadesEntity.getProvincia_prop());
            propiedadesDto.setTitulo_prop(propiedadesEntity.getTitulo_prop());
           // propiedadesDto.setClienteId(propiedadesEntity.getClienteId());
            propiedadesDto.setClienteId(propiedadesEntity.getCliente().getId());
            propiedadesDto.setNombre_cli(nombreCliente);
            propiedadesDto.setCorreo_cli(correoCliente);
            propiedadesDto.setTelefono_cli(telefonoCliente);

            propiedadesDtoList.add(propiedadesDto);
        }
        return propiedadesDtoList;
    }
    public PropiedadesDto savePropiedades(PropiedadesDto registro){
        try{
            PropiedadesEntity propiedadesEntity = modelMapper.map(registro, PropiedadesEntity.class);

            int randomCode = generateUniqueRandomCode();
            propiedadesEntity.setCodigo_prop(randomCode);

            PropiedadesEntity savedEntity = repository.save(propiedadesEntity);

            return modelMapper.map(savedEntity, PropiedadesDto.class);
        }catch(Exception ex){
            return null;
        }
    }
    private int generateUniqueRandomCode() {
        Random random = new Random();
        int codigo_prop;
        boolean exists;

        do {
            codigo_prop = random.nextInt((MAX_RANDOM_CODE - MIN_RANDOM_CODE) + 1) + MIN_RANDOM_CODE;
            exists = repository.existsByCodigo(codigo_prop);
        } while (exists);

        return codigo_prop;
    }
    public Boolean deletePropiedades(UUID id){
        try{
            Optional<PropiedadesEntity> registro=
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
