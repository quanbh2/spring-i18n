package net.friend.controller.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public interface IController {

  default ResponseEntity toResponseEntity(Object o, String message, HttpStatus httpStatus) {
     ResponseBody responseBody = ResponseBody.builder().data(o).message(message).build();

     return new ResponseEntity(responseBody, httpStatus);
  }

  default Map<String, Object> getBindingErrors(BindingResult bindingResult) {

    List<FieldError> errors = bindingResult.getFieldErrors();
    Map<String, Object> map = new HashMap<>();
    for (FieldError error : errors) {
      map.put(error.getField(), error.getDefaultMessage());
    }
    return map;
  }

}
