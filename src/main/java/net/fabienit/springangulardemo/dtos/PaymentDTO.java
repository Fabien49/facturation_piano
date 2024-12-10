package net.fabienit.springangulardemo.dtos;

import lombok.*;
import net.fabienit.springangulardemo.entities.PaymentStatus;
import net.fabienit.springangulardemo.entities.PaymentType;

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
