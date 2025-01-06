package net.fabienit.facturation_piano.services;

import net.fabienit.facturation_piano.entities.Student;
import net.fabienit.facturation_piano.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentService {
    private StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentByLastName(String lastName){
        return studentRepository.findByLastName(lastName);
    }

}
