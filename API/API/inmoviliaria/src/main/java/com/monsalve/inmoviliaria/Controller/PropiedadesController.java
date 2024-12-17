package com.monsalve.inmoviliaria.Controller;

import com.monsalve.inmoviliaria.Controller.Dto.PropiedadesDto;
import com.monsalve.inmoviliaria.Service.PropiedadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/v1/propiedades/")
@CrossOrigin(origins = "*")
public class PropiedadesController {
    @Autowired
    PropiedadesService servicio;

    @GetMapping()
    public ResponseEntity<List<PropiedadesDto>> getAll(){
        try{
            return  new ResponseEntity<>(servicio.getAll(), HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

   @GetMapping("/{id}")
    public ResponseEntity<PropiedadesDto> getPropiedadesPorId(@PathVariable("id") UUID id){
        try{
            return  new ResponseEntity<>(servicio.getPropiedadesPorId(id),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/cliente/{id}")
    public ResponseEntity<List<PropiedadesDto>> getPropiedadesClientes (@PathVariable("id") UUID id){
        try {
            return new ResponseEntity<>(servicio.listarPropiedadesConCliente(id), HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
   @GetMapping("/cliente/")
    public ResponseEntity<List<PropiedadesDto>> getPropiedadesConCliente (){
        try {
            return new ResponseEntity<>(servicio.getPropiedadesConCliente(), HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<PropiedadesDto> save(@RequestBody PropiedadesDto dto){
        try{
            return  new ResponseEntity<>(servicio.savePropiedades(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<PropiedadesDto> update(@RequestBody PropiedadesDto dto){
        try{
            return  new ResponseEntity<>(servicio.savePropiedades(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        try{
            String mensaje=Boolean.TRUE.equals(servicio.deletePropiedades(id))?"Registro Eliminado":"Error Al Eliminar Registro";
            return  new ResponseEntity<>(mensaje,HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
