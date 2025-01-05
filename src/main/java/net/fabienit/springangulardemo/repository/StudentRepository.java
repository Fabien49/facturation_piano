package net.fabienit.springangulardemo.repository;

import net.fabienit.springangulardemo.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface StudentRepository extends JpaRepository<Student, String> {

    Optional<Student> findById(String student_id);
    List<Student> findByProgramId(String programId);
}
