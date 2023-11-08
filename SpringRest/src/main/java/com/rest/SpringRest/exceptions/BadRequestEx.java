package com.rest.SpringRest.exceptions;

import jakarta.ws.rs.BadRequestException;
import javassist.tools.web.BadHttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestEx  extends BadRequestException {
}
