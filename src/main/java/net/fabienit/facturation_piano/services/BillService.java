package net.fabienit.facturation_piano.services;

import net.fabienit.facturation_piano.dtos.NewPaymentDTO;
import net.fabienit.facturation_piano.entities.*;
import net.fabienit.facturation_piano.repository.BillRepository;
import net.fabienit.facturation_piano.repository.PaymentRepository;
import net.fabienit.facturation_piano.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Service
@Transactional
public class BillService {
    private StudentRepository studentRepository;
    private BillRepository billRepository;

    public BillService(StudentRepository studentRepository, BillRepository billRepository) {
        this.studentRepository = studentRepository;
        this.billRepository = billRepository;
    }

/*    public Payment savePayment(MultipartFile file, NewPaymentDTO newPaymentDTO) throws IOException {

        Path folderPath = Paths.get(System.getProperty("user.home"), "other-data", "payments");
        if(!Files.exists(folderPath)){
            Files.createDirectories(folderPath);
        }
        String fileName = UUID.randomUUID().toString();
        Path filePath = Paths.get(System.getProperty("user.home"), "other-data", "payments", fileName+".pdf");
        Files.copy(file.getInputStream(),filePath);
        Student student = studentRepository.findByLastName(newPaymentDTO.getStudentCode());
        Payment payment = Payment.builder()
                .date(newPaymentDTO.getDate()).type(newPaymentDTO.getType()).student(student)
                .amount(newPaymentDTO.getAmount())
                .file(filePath.toUri().toString())
                .status(PaymentStatus.CREATED)
                .build();
        return paymentRepository.save(payment);
    }*/

    public Bill updateBillStatus(BillStatus status, @PathVariable Long id){
        Bill bill = billRepository.findById(id).orElseThrow();
        bill.setBillStatus(status);
        return billRepository.save(bill);
    }

/*    public byte[] getPaymentFile(Long id) throws IOException {
        Payment payment = paymentRepository.findById(id).get();
        return Files.readAllBytes(Path.of(URI.create(payment.getFile())));
    }*/
}
