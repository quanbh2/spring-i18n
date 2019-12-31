package net.friend.dto.request;

import io.swagger.annotations.ApiModel;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import net.friend.validation.annotation.CheckPhone;

@Data
public class UserDto {

  @NotNull(message = "{validate.name}")
  String name;

  @NotBlank(message = "{validate.email}")
  String email;

  @CheckPhone(message = "{validate.phone}")
  String phone;
}
