package net.friend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class SpringI18nApplication implements CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(SpringI18nApplication.class, args);
  }

  @Override
  public void run(String... args) throws Exception {}
}
