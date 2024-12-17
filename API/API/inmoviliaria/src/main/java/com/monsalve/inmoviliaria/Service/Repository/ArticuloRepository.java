package com.monsalve.inmoviliaria.Service.Repository;

import com.monsalve.inmoviliaria.Model.Articulo;
import com.monsalve.inmoviliaria.Model.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ArticuloRepository extends JpaRepository<Articulo, Long> {
}
