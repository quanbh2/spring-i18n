package net.friend.config.i18n;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class Translator {

  @Autowired ResourceBundleMessageSource resourceBundleMessageSource;

  public String toLocale(String msgCode) {
    Locale locale = LocaleContextHolder.getLocale();
    return resourceBundleMessageSource.getMessage(msgCode, null, locale);
  }

  public String toLocale(String msgCode, Object[] args) {
    Locale locale = LocaleContextHolder.getLocale();
    return resourceBundleMessageSource.getMessage(msgCode, args, locale);
  }
}
