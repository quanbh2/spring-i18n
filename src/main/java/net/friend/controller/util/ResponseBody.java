package net.friend.controller.util;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ResponseBody<T> {

  @JsonProperty("data")
  T data;

  String message = "OK";
}
