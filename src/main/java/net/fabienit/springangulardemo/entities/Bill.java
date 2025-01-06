package net.fabienit.springangulardemo.entities;

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

    private boolean sent;

    private LocalDate relaunchedDate;

    private boolean relaunched;

    private boolean unpaid;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Course course;
}
