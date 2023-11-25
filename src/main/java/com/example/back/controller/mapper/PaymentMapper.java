package com.example.backend_.controller.mapper;

import com.example.backend_.controller.dto.payment.PaymentCreationDto;
import com.example.backend_.controller.dto.payment.PaymentDto;
import com.example.backend_.controller.dto.payment.PaymentUpdateDto;
import com.example.backend_.model.Payment;
import org.mapstruct.*;

@Mapper
public interface PaymentMapper {
    @Mapping(target = "clientId", source = "client.id")
    @Mapping(target = "projectId", source = "project.id")
    PaymentDto toDto(Payment payment);

    Payment toEntity(PaymentCreationDto paymentDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Payment partialUpdate(PaymentUpdateDto paymentDto, @MappingTarget Payment payment);
}
