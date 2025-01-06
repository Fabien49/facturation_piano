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
public class Course {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;

    private LocalDate date;

    private double duration;

    @ManyToOne
    private Student student;

    @ManyToOne
    private StudentChild studentChild;
}
