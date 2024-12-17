package com.monsalve.inmoviliaria.Service.Repository;

import com.monsalve.inmoviliaria.Model.RolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, UUID> {
  //  @Query("SELECT u FROM RolEntity u WHERE u.user=?1 AND u.password=?2")
    @Query("SELECT rt, ct.nombre_cli " +
            "FROM RolEntity rt " +
            "INNER JOIN rt.cliente ct WHERE rt.user=?1 AND rt.password=?2")
    RolEntity login(String rol_user, String rol_password);
    RolEntity findByUser(String rol_user);
    RolEntity findByUserAndPassword(String rol_user, String rol_password);
    @Query("SELECT rt, ct.nombre_cli " +
            "FROM RolEntity rt " +
            "INNER JOIN rt.cliente ct ")
    List<Object[]> findAllPropiedades();
}
