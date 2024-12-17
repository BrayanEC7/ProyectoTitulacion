package com.monsalve.inmoviliaria.Controller;

import com.monsalve.inmoviliaria.Controller.Dto.PagoDto;
import com.monsalve.inmoviliaria.Model.Articulo;
import com.monsalve.inmoviliaria.Service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/articulo")
@CrossOrigin(origins = "*")
public class ArticuloController {
    @Autowired
    ArticuloService articuloService;



    @GetMapping("/lista")
    public ResponseEntity<List<Articulo>>lista(){
    List<Articulo>lista=articuloService.lista();
    return new ResponseEntity<List<Articulo>>(lista, HttpStatus.OK);
    }

    @GetMapping("/detalle/{id}")
    public ResponseEntity<Articulo>detalle(@PathVariable("id") long id){
      //  String mensaje=Boolean.TRUE.equals(articuloService.existsId(id))?"Registro Eliminado":"Error Al Eliminar Registro";
        if(!articuloService.existsId(id))
            return null;
        Articulo articulo=articuloService.getById(id).get();
        return new ResponseEntity<Articulo>(articulo,HttpStatus.OK);
    }
}
