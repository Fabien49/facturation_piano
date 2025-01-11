package net.fabienit.facturation_piano.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "studentchild")
public class StudentChild {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "student_child_id")
    private Long studentChildId;

    @Column (name = "last_name")
    private String lastName;

    @Column (name = "first_name")
    private String firstName;

    @ManyToOne
    @JoinColumn (name = "student_id")
    private Student student;
}
