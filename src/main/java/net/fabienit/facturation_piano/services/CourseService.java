package net.fabienit.facturation_piano.services;

import net.fabienit.facturation_piano.entities.Bill;
import net.fabienit.facturation_piano.entities.BillStatus;
import net.fabienit.facturation_piano.entities.Course;
import net.fabienit.facturation_piano.repository.BillRepository;
import net.fabienit.facturation_piano.repository.CourseRepository;
import net.fabienit.facturation_piano.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
@Transactional
public class CourseService {
    private final CourseRepository courseRepository;
    private BillRepository billRepository;

    public CourseService(BillRepository billRepository, CourseRepository courseRepository) {
        this.billRepository = billRepository;
        this.courseRepository = courseRepository;
    }



    public Bill updateBillStatus(BillStatus status, @PathVariable Long id){
        Bill bill = billRepository.findById(id).orElseThrow();
        bill.setBillStatus(status);
        return billRepository.save(bill);
    }

    public List<Course> getCoursesByStudentId(Long studentId) {
        if (studentId == null) {
            throw new IllegalArgumentException("Student ID cannot be null");
        }
        return courseRepository.findAllByStudentStudentId(studentId);
    }

}
