package net.fabienit.facturation_piano.web;

import net.fabienit.facturation_piano.dtos.NewPaymentDTO;
import net.fabienit.facturation_piano.entities.*;
import net.fabienit.facturation_piano.repository.BillRepository;
import net.fabienit.facturation_piano.repository.StudentRepository;
import net.fabienit.facturation_piano.services.BillService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class BillRestController {

    private StudentRepository studentRepository;

    private BillRepository billRepository;

    private BillService billService;

    public BillRestController(StudentRepository studentRepository, BillRepository billRepository, BillService billService){
        this.studentRepository = studentRepository;
        this.billRepository = billRepository;
        this.billService = billService;
    }

    @GetMapping(path = "/bills")
    public List<Bill> allBills(){
        return billRepository.findAll();
    }

    @GetMapping(path = "/students/{lastName}/bills")
    public List<Bill> billsByStudent(@PathVariable String lastName){
        return billRepository.findByStudentLastName(lastName);
    }

    @GetMapping(path = "/bills/byStatus")
    public List<Bill> billsByStatus(@RequestParam BillStatus status){
        return billRepository.findByBillStatus(status);
    }

    @GetMapping(path = "/bills/byType")
    public List<Bill> billsByPaymentType(@RequestParam PaymentType type){
        return billRepository.findByPaymentType(type);
    }

    @GetMapping(path = "/bills/byPaymentStatus")
    public List<Bill> billsByPaymentStatus(@RequestParam PaymentStatus status){
        return billRepository.findByPaymentStatus(status);
    }

    @GetMapping(path = "/bills/{id}")
    public Bill getPaymentById(@PathVariable Long id){
        return billRepository.findById(id).orElseThrow();
    }

/*    @GetMapping(path = "/students")
    public List<Student> allStudents(){
        return studentRepository.findAll();
    }*/
/*
    @GetMapping(path = "/students/{student_id}")
    public Optional<Student> getStudentByCode(@PathVariable String student_id){
        return studentRepository.findById(student_id);
    }*/

/*    @GetMapping("/studentsByProgramId")
    public List<Student> getStudentsByProgramId(@RequestParam String programId){
        return studentRepository.findByProgramId(programId);
    }*/

    @PutMapping("/bill/{id}")
    public Bill updatePaymentStatus(@RequestParam BillStatus status, @PathVariable Long id){
        return billService.updateBillStatus(status, id);
    }

/*    @PostMapping(value = "/bills", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Payment savePayment(@RequestParam("file") MultipartFile file, NewPaymentDTO newPaymentDTO) throws IOException {
        return this.paymentService.savePayment(file, newPaymentDTO);
    }

    @GetMapping(path = "/payments/{id}/file", produces = MediaType.APPLICATION_PDF_VALUE)
    public byte[] getPaymentFile(@PathVariable Long id) throws IOException {
        return paymentService.getPaymentFile(id);
    }*/
}
