package com.proyecto.reserva.application.exception;

import com.proyecto.reserva.application.lasting.EMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserException extends Exception {

  private final HttpStatus status;
  private final String message;

  public UserException(EMessage eMessage) {
    this.status = eMessage.getStatus();
    this.message = eMessage.getMessage();
  }

}
