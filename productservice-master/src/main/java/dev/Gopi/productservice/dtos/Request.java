package dev.Gopi.productservice.dtos;

import dev.Gopi.productservice.security.JwtObject;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Request<T> {
    T userPayload;
    JwtObject authPayload;
}
