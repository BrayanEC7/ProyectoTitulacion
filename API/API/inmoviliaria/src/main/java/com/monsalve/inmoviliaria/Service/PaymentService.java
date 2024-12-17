package com.monsalve.inmoviliaria.Service;

import com.monsalve.inmoviliaria.Controller.Dto.PaymentIntentDto;
import com.monsalve.inmoviliaria.Model.ClientesEntity;
import com.monsalve.inmoviliaria.Model.PaymentEntity;
import com.monsalve.inmoviliaria.Service.Repository.ClientesRepository;
import com.monsalve.inmoviliaria.Service.Repository.PaymentRepository;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class PaymentService {
    @Value("${stripe.secret.key}")
    private String secretKey;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ClientesRepository clientesRepository;

    @Transactional(readOnly = true)
    public List<PaymentIntentDto> getAllPayments() {
        List<Object[]> payments = paymentRepository.findAllPaymentCliente();
        List<PaymentIntentDto> responseList = new ArrayList<>();

        for (Object[] payment : payments) {
            PaymentEntity paymentEntity=(PaymentEntity) payment[0];
            String nombreCliente= (String) payment[1];
            String apellidoCliente= (String) payment[2];
            String tipoDocCliente= (String) payment[3];
            String numDocCliente=(String) payment[4];
            String correoCliente=(String) payment[5];
            PaymentIntentDto response = new PaymentIntentDto();

            response.setId(paymentEntity.getId());
            response.setStripePaymentId(paymentEntity.getStripePaymentId());
            response.setDescription(paymentEntity.getDescription());
            response.setAmount(paymentEntity.getAmount());
            response.setCurrency(paymentEntity.getCurrency());
            response.setStatus(paymentEntity.getStatus());
            response.setCreatedAt(paymentEntity.getCreatedAt());
            response.setClienteId(paymentEntity.getCliente().getId());
            response.setNombre_cli(nombreCliente);
            response.setApellidos_cli(apellidoCliente);
            response.setTipodoc_cli(tipoDocCliente);
            response.setNrodoc_cli(numDocCliente);
            response.setCorreo_cli(correoCliente);
            responseList.add(response);
        }
        return responseList;
    }
   public PaymentIntent paymentIntent(PaymentIntentDto paymentIntentDto) throws StripeException {
       Stripe.apiKey = secretKey;
       long amountInCents = Math.round(paymentIntentDto.getAmount() * 100);
       Map<String, Object> params = new HashMap<>();
       params.put("amount", amountInCents);
       params.put("currency", paymentIntentDto.getCurrency());
       params.put("description", paymentIntentDto.getDescription());
       params.put("payment_method_types", Arrays.asList("card"));

       PaymentIntent paymentIntent = PaymentIntent.create(params);

       PaymentEntity payment = new PaymentEntity();
       payment.setStripePaymentId(paymentIntent.getId());
       payment.setDescription(paymentIntentDto.getDescription());
       payment.setAmount(paymentIntentDto.getAmount());
       payment.setCurrency(paymentIntentDto.getCurrency());
       payment.setStatus(paymentIntent.getStatus());
       payment.setCreatedAt(new Date());
       ClientesEntity cliente = clientesRepository.findById(paymentIntentDto.getClienteId())
               .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
       payment.setCliente(cliente);
       paymentRepository.save(payment);

       return paymentIntent;
   }
    public PaymentIntent confirm(String id) throws StripeException {
        Stripe.apiKey = secretKey;
        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
        Map<String, Object> params = new HashMap<>();
        params.put("payment_method", "pm_card_visa");
        paymentIntent = paymentIntent.confirm(params);

        PaymentEntity payment = paymentRepository.findByStripePaymentId(id);
        payment.setStatus(paymentIntent.getStatus());
        paymentRepository.save(payment);

        return paymentIntent;
    }

    public PaymentIntent cancel(String id) throws StripeException {
        Stripe.apiKey = secretKey;
        PaymentIntent paymentIntent = PaymentIntent.retrieve(id);
        paymentIntent.cancel();

        PaymentEntity payment = paymentRepository.findByStripePaymentId(id);
        payment.setStatus(paymentIntent.getStatus());
        paymentRepository.save(payment);

        return paymentIntent;
    }
}
