package net.fabienit.facturation_piano.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Student {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    private String firstName;

    private String lastName;

    private String address;

    private String zipCode;

    private String city;

    private String phoneNumber;

    private String mail;

    private boolean student;
}
