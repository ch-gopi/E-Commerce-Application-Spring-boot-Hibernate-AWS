package com.scaler.productservice.controllerAdvices;

import com.scaler.productservice.dtos.ArithmeticExceptionDto;
import com.scaler.productservice.dtos.ArrayIndexOutOfBoundsExceptionDto;
import com.scaler.productservice.dtos.ExceptionDto;
import com.scaler.productservice.exceptions.ProductNotExistsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlers {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ArithmeticExceptionDto> handleException() {
        ArithmeticExceptionDto arithmeticExceptionDto = new ArithmeticExceptionDto();
        arithmeticExceptionDto.setMessage("It is an arithmetic exception");
       return new ResponseEntity<>(arithmeticExceptionDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler
    public ResponseEntity<ArrayIndexOutOfBoundsExceptionDto> handleAnotherException(){
        ArrayIndexOutOfBoundsExceptionDto arrayIndexOutOfBoundsExceptionDto = new ArrayIndexOutOfBoundsExceptionDto();
        arrayIndexOutOfBoundsExceptionDto.setMessage("Number of elements exceeded");
        return new ResponseEntity<>(arrayIndexOutOfBoundsExceptionDto,HttpStatus.INSUFFICIENT_STORAGE);
    }

    public ResponseEntity<ExceptionDto> productNotExistsException(ProductNotExistsException productNotExistsException){
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage(productNotExistsException.getMessage());
        return new ResponseEntity<>(dto, HttpStatus.OK);
  }

}
