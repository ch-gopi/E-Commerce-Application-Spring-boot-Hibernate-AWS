package com.scaler.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ExceptionDto {
    private String message;
    private String detail;
}
