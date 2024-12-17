package com.monsalve.inmoviliaria.Controller;

import com.monsalve.inmoviliaria.Controller.Dto.ClientesDto;
import com.monsalve.inmoviliaria.Service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/clientes/")
@CrossOrigin(origins = "*")
public class ClientesController {
    @Autowired
    ClienteService servicio;

    @GetMapping()
    public ResponseEntity<List<ClientesDto>> getAll(){
        try{
            return  new ResponseEntity<>(servicio.getAll(), HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/rol")
    public ResponseEntity<List<ClientesDto>> getClienteConRol (){
        try {
            return new ResponseEntity<>(servicio.getAllClienteRol(), HttpStatus.OK);
        } catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/valores")
    public ResponseEntity<List<ClientesDto>> getClienteRolNull(){
        try{
            return new ResponseEntity<>(servicio.getAllClienteRolNull(),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/notrabajadores")
    public ResponseEntity<List<ClientesDto>> getClienteNotTrabajador(){
        try{
            return new ResponseEntity<>(servicio.getAllClienteNotTrabajador(),HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping()
    public ResponseEntity<ClientesDto> save(@RequestBody ClientesDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveCliente(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<ClientesDto> update(@RequestBody ClientesDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveCliente(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        try{
            String mensaje=Boolean.TRUE.equals(servicio.deleteCliente(id))?"Registro Eliminado":"Error Al Eliminar Registro";
            return  new ResponseEntity<>(mensaje,HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
