package net.friend.validation.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import net.friend.validation.logic.CheckPhoneLogic;

@Documented
@Constraint(validatedBy = CheckPhoneLogic.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckPhone {
  String message() default "Validate error PhoneNumber";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
