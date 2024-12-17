package com.monsalve.inmoviliaria.Service;

import com.monsalve.inmoviliaria.Model.Articulo;
import com.monsalve.inmoviliaria.Service.Repository.ArticuloRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional()
public class ArticuloService {
    @Autowired
    ArticuloRepository articuloRepository;
    public List<Articulo> lista(){
        List<Articulo> lista=articuloRepository.findAll();
        return lista;
    }
    public Optional<Articulo> getById(long id){
        return articuloRepository.findById(id);
    }
    public boolean existsId(long id){
        return articuloRepository.existsById(id);
    }
}
