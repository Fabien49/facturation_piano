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
@Table(name = "bill")
public class Bill {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private Long billNumber;

    @Column (name = "amount")
    private double amount;

    @Column (name = "sent_date")
    private LocalDate sentDate;

    @Column (name = "relaunched_date")
    private LocalDate relaunchedDate;

    @Enumerated(EnumType.STRING)
    @Column (name = "bill_status")
    private BillStatus billStatus;

    @Enumerated(EnumType.STRING)
    @Column (name = "payment_type")
    private PaymentType paymentType;

    @Enumerated(EnumType.STRING)
    @Column (name = "payment_status")
    private PaymentStatus paymentStatus;

    @ManyToOne
    @JoinColumn (name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn (name = "course_id")
    private Course course;
}
