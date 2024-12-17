package com.monsalve.inmoviliaria.Service.Repository;

import com.monsalve.inmoviliaria.Model.InformacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface InformacionRepository extends JpaRepository<InformacionEntity, UUID> {
}
