package net.fabienit.facturation_piano.dtos;

import lombok.*;
import net.fabienit.facturation_piano.entities.PaymentStatus;
import net.fabienit.facturation_piano.entities.PaymentType;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PaymentDTO {
    private Long id;
    private LocalDate date;
    private double amount;
    private PaymentType type;
    private PaymentStatus status;
}
