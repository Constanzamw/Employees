package com.gestion.empleados.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//ESTA ES UNA CLASE DE EXCEPCIONES PERSONALIZADAS!!!!!

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

   
    private static final long serialVersionID= 1L;

    public ResourceNotFoundException(String mensaje) {
        super(mensaje);
}
}

//SI NO EXISTE UN EMPLEADO, VOY A LLAMAR A ESTA CLASE.