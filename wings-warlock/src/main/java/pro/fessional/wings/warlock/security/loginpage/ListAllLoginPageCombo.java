package pro.fessional.wings.warlock.security.loginpage;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import pro.fessional.mirana.data.R;
import pro.fessional.wings.slardar.security.impl.ComboWingsAuthPageHandler;
import pro.fessional.wings.warlock.constants.WarlockOrderConst;
import pro.fessional.wings.warlock.spring.prop.WarlockSecurityProp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author trydofor
 * @since 2021-02-19
 */
public class ListAllLoginPageCombo implements ComboWingsAuthPageHandler.Combo {

    public static final int ORDER = WarlockOrderConst.AuthPageCombo + 10_000;

    @Setter(onMethod_ = {@Autowired})
    private WarlockSecurityProp warlockSecurityProp;
    @Setter
    @Getter
    private int order = ORDER;

    @Override
    public ResponseEntity<?> response(@NotNull Enum<?> authType, @Nullable MediaType mediaType, @NotNull HttpServletRequest request, @NotNull HttpServletResponse response) {
        return ResponseEntity
                .status(HttpStatus.UNAUTHORIZED)
                .contentType(MediaType.APPLICATION_JSON)
                .body(R.okData(warlockSecurityProp.getAuthType().keySet()));
    }
}
