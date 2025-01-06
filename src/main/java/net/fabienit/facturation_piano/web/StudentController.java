package net.fabienit.facturation_piano.web;

import net.fabienit.facturation_piano.entities.Student;
import net.fabienit.facturation_piano.services.StudentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/student/{lastName}")
    public Student getStudentByLastName(@PathVariable String lastName){
        return studentService.getStudentByLastName(lastName);
    }
}
