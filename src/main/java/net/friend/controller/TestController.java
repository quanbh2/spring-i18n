package net.friend.controller;

import javax.validation.Valid;
import net.friend.config.i18n.Translator;
import net.friend.controller.util.IController;
import net.friend.dto.request.UserDto;
import net.friend.exception.custom.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController implements IController {

  @Autowired Translator translator;

  @GetMapping("/test-i18n")
  public ResponseEntity testLanguage() {

    return toResponseEntity(null, translator.toLocale("test.hello"), HttpStatus.ACCEPTED);
  }

  @GetMapping("/test-unknown-exception")
  public ResponseEntity testUnknownException() {

    Integer.parseInt("abc");
    return toResponseEntity(null, translator.toLocale("test.hello"), HttpStatus.ACCEPTED);
  }

  @GetMapping("/test-bad-request-exception")
  public ResponseEntity testBadRequestException() {

    throw new BadRequestException("test-bad-request-exception");
  }

  @PostMapping("/test-validate-binding-result")
  public ResponseEntity testBindingResultValidate(
      @RequestBody @Valid UserDto userDto, BindingResult result) {

    if (result.hasErrors()) {
      return toResponseEntity(
          getBindingErrors(result), translator.toLocale("exception.badRequest"), HttpStatus.BAD_REQUEST);
    }

    throw new BadRequestException("test-validate-binding-result-failed");
  }
}
