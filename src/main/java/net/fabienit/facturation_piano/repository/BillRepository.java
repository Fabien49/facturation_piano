package net.fabienit.facturation_piano.repository;

import net.fabienit.facturation_piano.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface BillRepository extends JpaRepository<Bill, Long> {

    List<Bill> findByStudentLastName(String lastName);

    List<Bill> findByBillStatus(BillStatus status);

    List<Bill> findByPaymentType (PaymentType type);

    List<Bill> findByPaymentStatus (PaymentStatus status);

    List<Bill> findBySentDate(LocalDate sentDate);

    List<Bill> findAllByStudentStudentId(Long studentId);



}