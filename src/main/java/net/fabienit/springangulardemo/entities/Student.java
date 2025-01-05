package net.fabienit.springangulardemo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Student {
    @Id
    private String student_id;

    private String firstName;

    private String lastName;

    private String address;

    private String zipCode;

    private String city;

    private String phoneNumber;

    private String mail;

    private boolean student;
}
