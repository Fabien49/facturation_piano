package net.fabienit.springangulardemo.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.fabienit.springangulardemo.entities.PaymentType;

import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class NewPaymentDTO {

    private double amount;

    private LocalDate date;

    private String studentCode;

    private PaymentType type;
}
