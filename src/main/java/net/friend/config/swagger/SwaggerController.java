package net.friend.config.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/** Redirection to swagger api documentation */
@Controller
public class SwaggerController {

  @RequestMapping(value = "/swagger")
  public String index() {
    System.out.println("swagger-ui.html");
    return "redirect:swagger-ui.html";
  }
}
