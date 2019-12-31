package net.friend.config.i18n;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Slf4j
public class CustomLocaleResolver extends AcceptHeaderLocaleResolver implements LocaleResolver {

  private List<String> listSupportedLanguage = Arrays.asList("en", "th", "vi");

  List<Locale> LOCALES =
      listSupportedLanguage.stream().map(Locale::new).collect(Collectors.toList());

  private Locale customDefaultLocale = new Locale("vi");

  @Override
  public Locale resolveLocale(HttpServletRequest request) {
    String headerLang = request.getHeader("Accept-Language");

    if (headerLang == null || headerLang.isEmpty() || !listSupportedLanguage.contains(headerLang))
      return customDefaultLocale;
    return Locale.lookup(Locale.LanguageRange.parse(headerLang), LOCALES);
  }
}
