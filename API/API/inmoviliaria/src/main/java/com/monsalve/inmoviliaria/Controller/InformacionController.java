package com.monsalve.inmoviliaria.Controller;

import com.monsalve.inmoviliaria.Controller.Dto.InformacionDto;
import com.monsalve.inmoviliaria.Service.InformacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/v1/informacion/")
@CrossOrigin(origins = "*")
public class InformacionController {
    @Autowired
    InformacionService servicio;

    @GetMapping()
    public ResponseEntity<List<InformacionDto>> getAll(){
        try{
            return  new ResponseEntity<>(servicio.getAll(), HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<InformacionDto> save(@RequestBody InformacionDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveInformacion(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<InformacionDto> update(@RequestBody InformacionDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveInformacion(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        try{
            String mensaje=Boolean.TRUE.equals(servicio.deleteInformacion(id))?"Registro Eliminado":"Error Al Eliminar Registro";
            return  new ResponseEntity<>(mensaje,HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
