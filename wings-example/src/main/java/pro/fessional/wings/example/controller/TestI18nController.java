package pro.fessional.wings.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.fessional.mirana.time.DateFormatter;
import pro.fessional.wings.silencer.context.WingsI18nContext;
import pro.fessional.wings.slardar.security.SecurityContextUtil;
import pro.fessional.wings.slardar.security.WingsTerminalContext;

import javax.servlet.http.HttpServletRequest;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Locale;

/**
 * @author trydofor
 * @since 2019-06-30
 */

@Controller
@Slf4j
@RequiredArgsConstructor
public class TestI18nController {

    private final MessageSource messageSource;

    @RequestMapping({"/", "index.html"})
    public String index(HttpServletRequest request, Model model) {
        ZonedDateTime now = ZonedDateTime.now();
        ZoneId systemZoneId = ZoneId.systemDefault();
        WingsTerminalContext.Context sct = SecurityContextUtil.getTerminalContext();
        WingsI18nContext ctx = sct.getI18nContext();
        @NotNull Locale locale = ctx.getLocaleOrDefault();
        @NotNull ZoneId zoneId = ctx.getZoneIdOrDefault();
        String userDatetime = DateFormatter.full19(now, zoneId);
        //
        model.addAttribute("userLocale", locale);
        model.addAttribute("userZoneId", zoneId);
        model.addAttribute("userDatetime", userDatetime);
        //
        log.debug("user.hello=" + messageSource.getMessage("user.hello", new Object[]{}, locale));
        log.debug("userLocale=" + locale);
        log.debug("userZoneId=" + zoneId);
        log.debug("userDatetime=" + userDatetime);


        model.addAttribute("systemZoneId", systemZoneId);
        String systemDatetime = DateFormatter.full19(now);
        model.addAttribute("systemDatetime", systemDatetime);

        log.debug("systemZoneId=" + systemZoneId);
        log.debug("systemDatetime=" + systemDatetime);

        return "index";
    }
}
