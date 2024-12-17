package com.monsalve.inmoviliaria.Service.Repository;

import com.monsalve.inmoviliaria.Model.PropiedadesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface PropiedadesRepository extends JpaRepository<PropiedadesEntity, UUID> {
    @Query("SELECT u FROM PropiedadesEntity u WHERE u.id=?1")
    PropiedadesEntity listar(UUID id);

    @Query("SELECT dt, pv.nombre_cli, pv.telefono_cli, pv.correo_cli, pv.tipodoc_cli, pv.nrodoc_cli " +
            "FROM PropiedadesEntity dt " +
            "INNER JOIN dt.cliente pv " +
            "WHERE dt.id=?1")
    List<Object[]> findAllClientes(UUID id);
   @Query("SELECT pd, ct.nombre_cli, ct.telefono_cli, ct.correo_cli " +
            "FROM PropiedadesEntity pd " +
            "INNER JOIN pd.cliente ct ")
    List<Object[]> findAllPropiedades();

    @Query("SELECT COUNT(pd) > 0 FROM PropiedadesEntity pd WHERE pd.codigo_prop = ?1")
    boolean existsByCodigo(int codigo_prop);


}
