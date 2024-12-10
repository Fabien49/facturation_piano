package net.fabienit.springangulardemo.repository;

import net.fabienit.springangulardemo.entities.Payment;
import net.fabienit.springangulardemo.entities.PaymentStatus;
import net.fabienit.springangulardemo.entities.PaymentType;
import net.fabienit.springangulardemo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findByStudentCode(String code);

    List<Payment> findByStatus(PaymentStatus status);

    List<Payment> findByType(PaymentType type);
}
