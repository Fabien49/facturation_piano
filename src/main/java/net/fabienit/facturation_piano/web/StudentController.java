package net.fabienit.facturation_piano.web;

import net.fabienit.facturation_piano.entities.Student;
import net.fabienit.facturation_piano.services.StudentService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/student-details/{studentId}")
    public Student getStudentByStudentId(@PathVariable Long studentId){
        return studentService.getStudentByStudentId(studentId);
    }

    @PostMapping("/student")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
}
