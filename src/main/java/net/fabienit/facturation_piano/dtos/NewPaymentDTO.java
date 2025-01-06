package net.fabienit.facturation_piano.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.fabienit.facturation_piano.entities.PaymentType;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class NewPaymentDTO {

    private double amount;

    private LocalDate date;

    private String studentCode;

    private PaymentType type;
}
