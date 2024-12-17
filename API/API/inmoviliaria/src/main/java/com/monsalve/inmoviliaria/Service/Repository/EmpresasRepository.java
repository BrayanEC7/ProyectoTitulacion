package com.monsalve.inmoviliaria.Service.Repository;

import com.monsalve.inmoviliaria.Model.EmpresasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface EmpresasRepository extends JpaRepository<EmpresasEntity, UUID> {

}
