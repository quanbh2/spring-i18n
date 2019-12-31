package net.friend.exception;

import lombok.extern.slf4j.Slf4j;
import net.friend.config.i18n.Translator;
import net.friend.controller.util.ResponseBody;
import net.friend.exception.custom.BadRequestException;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@ControllerAdvice
public class ExHandler extends ResponseEntityExceptionHandler {

  @Autowired private Translator trans;

  @ExceptionHandler(Exception.class)
  protected ResponseEntity<Object> handleUnknownException(Exception ex, WebRequest request) {
    String message = trans.toLocale("exception.message");
    log.error(ExceptionUtils.getStackTrace(ex));

    ResponseBody responseBody = ResponseBody.builder().message(message).build();

    return new ResponseEntity<>(responseBody, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler({BadRequestException.class})
  protected ResponseEntity<Object> handleBadRequest(RuntimeException ex, WebRequest request) {

    ResponseBody responseBody = ResponseBody.builder().message(ex.getMessage()).build();

    return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
  }
}
