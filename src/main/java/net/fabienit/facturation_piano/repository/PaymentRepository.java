package net.fabienit.facturation_piano.repository;

import net.fabienit.facturation_piano.entities.Payment;
import net.fabienit.facturation_piano.entities.PaymentStatus;
import net.fabienit.facturation_piano.entities.PaymentType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {



    List<Payment> findByStatus(PaymentStatus status);

    List<Payment> findByType(PaymentType type);
}
