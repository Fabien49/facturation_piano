package net.fabienit.springangulardemo;

import net.fabienit.springangulardemo.entities.Payment;
import net.fabienit.springangulardemo.entities.PaymentStatus;
import net.fabienit.springangulardemo.entities.PaymentType;
import net.fabienit.springangulardemo.entities.Student;
import net.fabienit.springangulardemo.repository.PaymentRepository;
import net.fabienit.springangulardemo.repository.StudentRepository;
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


    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository, PaymentRepository paymentRepository) {
        return args -> {
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstName("François").code("112233").programId("SDIA").build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstName("Imane").code("223344").programId("SDIA").build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstName("Fabien").code("334455").programId("GLSID").build());
            studentRepository.save(Student.builder().id(UUID.randomUUID().toString()).firstName("Hélène").code("445566").programId("BDCC").build());

            PaymentType[] paymentTypes = PaymentType.values();
            Random random = new Random();
            studentRepository.findAll().forEach(st -> {
                for (int i = 0; i < 10; i++) {
                    int index = random.nextInt(paymentTypes.length);
                    Payment payment = Payment.builder()
                            .amount(1000 + (int) (Math.random() + 20000))
                            .type(paymentTypes[index])
                            .status(PaymentStatus.CREATED)
                            .date(LocalDate.now())
                            .student(st)
                            .build();
                    paymentRepository.save(payment);
                }
            });
        };

    }
}
