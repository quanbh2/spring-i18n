package net.friend.validation.logic;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import lombok.extern.slf4j.Slf4j;
import net.friend.validation.annotation.CheckPhone;

@Slf4j
public class CheckPhoneLogic implements ConstraintValidator<CheckPhone, String> {

  @Override
  public void initialize(CheckPhone constraintAnnotation) {
  }

  @Override
  public boolean isValid(String phone, ConstraintValidatorContext context) {
    if (phone != null) {
      return phone.matches("[0-9]{8,15}+");
    } else {
      return false;
    }
  }
}
