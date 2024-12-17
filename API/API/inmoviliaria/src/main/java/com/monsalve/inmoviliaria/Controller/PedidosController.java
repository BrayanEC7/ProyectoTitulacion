package com.monsalve.inmoviliaria.Controller;

import com.monsalve.inmoviliaria.Controller.Dto.PedidosDto;
import com.monsalve.inmoviliaria.Service.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController()
@RequestMapping("/v1/pedidos/")
@CrossOrigin(origins = "*")
public class PedidosController {
    @Autowired
    PedidosService servicio;

    @GetMapping()
    public ResponseEntity<List<PedidosDto>> getAll(){
        try{
            return  new ResponseEntity<>(servicio.getAll(), HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @PostMapping()
    public ResponseEntity<PedidosDto> save(@RequestBody PedidosDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveDepartamento(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping()
    public ResponseEntity<PedidosDto> update(@RequestBody PedidosDto dto){
        try{
            return  new ResponseEntity<>(servicio.saveDepartamento(dto),HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable UUID id){
        try{
            String mensaje=Boolean.TRUE.equals(servicio.deleteDepartamento(id))?"Registro Eliminado":"Error Al Eliminar Registro";
            return  new ResponseEntity<>(mensaje,HttpStatus.OK);
        }catch(Exception ex){
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
