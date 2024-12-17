package com.monsalve.inmoviliaria.Service.Repository;

import com.monsalve.inmoviliaria.Model.ClientesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ClientesRepository extends JpaRepository<ClientesEntity, UUID> {
    @Query("SELECT ct, rl.nombre_rol " +
            "FROM ClientesEntity ct " +
            "INNER JOIN RolEntity rl ON ct.id = rl.cliente.id")
    List<Object[]> findAllCliente();

    @Query("SELECT cl FROM ClientesEntity cl LEFT JOIN RolEntity rl ON cl.id = rl.cliente.id " +
            "WHERE rl.cliente.id IS NULL")
    List<Object[]> findAllClienteRolNull();

    @Query("SELECT cl FROM ClientesEntity cl LEFT JOIN RolEntity rl ON cl.id = rl.cliente.id " +
            "WHERE rl.cliente.id IS NULL OR rl.nombre_rol != 'TRABAJADOR'")
    List<Object[]> findAllClienteNotTrabajador();
}
