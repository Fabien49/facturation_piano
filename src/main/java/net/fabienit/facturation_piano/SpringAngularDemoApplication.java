package net.fabienit.facturation_piano;

import net.fabienit.facturation_piano.entities.*;
import net.fabienit.facturation_piano.repository.BillRepository;
import net.fabienit.facturation_piano.repository.PaymentRepository;
import net.fabienit.facturation_piano.repository.StudentRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

@SpringBootApplication
public class SpringAngularDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAngularDemoApplication.class, args);
    }


   /* @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, PaymentRepository paymentRepository, BillRepository billRepository) {
        return args -> {
            studentRepository.save(Student.builder().firstName("François").lastName("Dupond").address("1 rue des dev").zipCode("49000").city("Angers").phoneNumber("0000000000").mail("françois@dupond.net").student(true).build());
            studentRepository.save(Student.builder().firstName("Imane").lastName("Dupont").address("1 rue des dev").zipCode("49000").city("Angers").phoneNumber("0000000000").mail("imane@dupons.net").student(false).build());
            studentRepository.save(Student.builder().firstName("Fabien").lastName("Chapeau").address("1 rue des dev").zipCode("49000").city("Angers").phoneNumber("0000000000").mail("françois@dupond.net").student(true).build());
            studentRepository.save(Student.builder().firstName("Hélène").lastName("Dunom").address("1 rue des dev").zipCode("49000").city("Angers").phoneNumber("0000000000").mail("françois@dupond.net").student(true).build());
            billRepository.save(Bill.builder().billStatus(BillStatus.SENT).paymentStatus(PaymentStatus.CREATED).sentDate(LocalDate.now()).amount(68).paymentType(PaymentType.CASH).student(studentRepository.findByLastName("Chapeau")).build());
            billRepository.save(Bill.builder().billStatus(BillStatus.RELAUNCHED).relaunchedDate(LocalDate.now()).paymentStatus(PaymentStatus.CREATED).sentDate(LocalDate.now()).amount(135).paymentType(PaymentType.TRANSFER).student(studentRepository.findByLastName("Dupond")).build());
            billRepository.save(Bill.builder().billStatus(BillStatus.SET).paymentStatus(PaymentStatus.VALIDATED).sentDate(LocalDate.now()).amount(254).paymentType(PaymentType.CHECK).student(studentRepository.findByLastName("Dupont")).build());

            PaymentType[] paymentTypes = PaymentType.values();
            Random random = new Random();
            studentRepository.findAll().forEach(st -> {
                for (int i = 0; i < 10; i++) {
                    int index = random.nextInt(paymentTypes.length);
                    Payment payment = Payment.builder()
                            .amount(1000 + (int) (Math.random() * 20000))
                            .type(paymentTypes[index])
                            .status(PaymentStatus.CREATED)
                            .date(LocalDate.now())
                            .student(st)
                            .build();
                    paymentRepository.save(payment);
                }
            });
        };

    }*/
}
