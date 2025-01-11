package net.fabienit.facturation_piano.repository;

import net.fabienit.facturation_piano.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByStudentLastName(String lastName);

  /*  List<Course> findByBillStatus(BillStatus status);

    List<Course> findByPaymentType (PaymentType type);

    List<Course> findByPaymentStatus (PaymentStatus status);

    List<Course> findBySentDate(LocalDate sentDate);*/

    List<Course> findAllByStudentStudentId(Long studentId);



}