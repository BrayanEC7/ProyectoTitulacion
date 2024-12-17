package com.monsalve.inmoviliaria.Service.Repository;

import com.monsalve.inmoviliaria.Model.Articulo;
import com.monsalve.inmoviliaria.Model.PaymentEntity;
import com.stripe.model.PaymentIntent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
    PaymentEntity findByStripePaymentId(String stripePaymentId);

    @Query("SELECT py, ct.nombre_cli, ct.apellidos_cli, ct.tipodoc_cli, ct.nrodoc_cli, ct.correo_cli " +
            "FROM PaymentEntity py " +
            "INNER JOIN py.cliente ct ")
    List<Object[]> findAllPaymentCliente();
}
