package net.fabienit.facturation_piano.repository;

import net.fabienit.facturation_piano.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, String> {

    Student findByLastName(String lastName);
}
