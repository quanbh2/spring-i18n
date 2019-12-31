package net.friend.config.i18n;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;

@Configuration
public class LocaleConfiguration {

  // Configuration for LocaleResolver ( message converted by Translator )
  @Bean
  public LocaleResolver localeResolver() {
    return new CustomLocaleResolver();
  }

  @Bean
  public ResourceBundleMessageSource messageSource() {
    ResourceBundleMessageSource rs = new ResourceBundleMessageSource();
    rs.setBasename("messages"); // name of properties_message_file in resources bundle message
    rs.setDefaultEncoding("UTF-8"); // need for Vietnamese
    rs.setUseCodeAsDefaultMessage(true);
    return rs;
  }


  // Configuration for LocalValidatorFactoryBean ( message in model for validate )
  @Bean
  public LocalValidatorFactoryBean getValidator() {
    LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
    bean.setValidationMessageSource(validateMessageSource());
    return bean;
  }

  private MessageSource validateMessageSource() {
    ResourceBundleMessageSource bundle = new ResourceBundleMessageSource();
    bundle.setBasenames("validator_messages"); // name of properties_validator_file in resources
    bundle.setDefaultEncoding("UTF-8"); // need for Vietnamese
    return bundle;
  }

}
