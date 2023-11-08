package com.rest.SpringRest.exceptions;

import jakarta.ws.rs.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundEx extends NotFoundException {
}
