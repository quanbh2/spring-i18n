package net.friend.exception.custom;

import lombok.Data;

@Data
public class BadRequestException extends RuntimeException {

  private String message;

  public BadRequestException(String message) {
    super(message);
    this.message =  message;
  }

}
