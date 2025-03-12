package com.academicproject.paymentservice.mapper;

import com.academicproject.paymentservice.domain.entity.StMonthlyFeeOrder;
import com.academicproject.paymentservice.dto.BillingDTO;
import com.academicproject.paymentservice.dto.request.PaymentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface StMonthlyFeeOrderMapper {

    StMonthlyFeeOrderMapper INSTANCE = Mappers.getMapper(StMonthlyFeeOrderMapper.class);

    @Mapping(source = "amount", target = "dueAmount")
    BillingDTO toBillingDTO(StMonthlyFeeOrder order);

    StMonthlyFeeOrder toEntity(PaymentRequest paymentRequest);
}
