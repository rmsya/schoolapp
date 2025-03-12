package com.academicproject.paymentservice.dto.response;

import com.academicproject.paymentservice.dto.BillingDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetStudentBillingResponse {

    private BillingDTO billing;
}
