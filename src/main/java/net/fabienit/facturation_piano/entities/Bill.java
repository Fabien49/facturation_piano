package net.fabienit.facturation_piano.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Bill {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long billNumber;

    private double amount;

    private LocalDate sentDate;

    private LocalDate relaunchedDate;

    private BillStatus billStatus;

    private PaymentType paymentType;

    private PaymentStatus paymentStatus;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;
}
