package net.fabienit.springangulardemo.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class StudentChild {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentChildId;

    private String lasName;

    private String firstName;

    @ManyToOne
    private Student student;
}
