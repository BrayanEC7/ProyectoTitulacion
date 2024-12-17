package com.monsalve.inmoviliaria.Service.Repository;

import com.monsalve.inmoviliaria.Model.MenuEntity;
import jakarta.persistence.Tuple;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

public interface MenuRepository extends JpaRepository<MenuEntity, UUID> {
    @Query("SELECT m.menu_idllave_pk as menu_idllave_pk, m.nombre as nombre, m.url as url, " +
            "m.icono as icono, m.orden as orden, " +
            "m.codigoPadre as codigoPadre, " +
            "mp.nombre as nombrePadre " +
            "FROM MenuEntity m LEFT JOIN " +
            "MenuEntity mp ON m.codigoPadre=mp.menu_idllave_pk")
    List<Tuple> finAllMenuPadres();
}
