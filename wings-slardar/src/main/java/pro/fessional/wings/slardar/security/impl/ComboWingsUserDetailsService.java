package pro.fessional.wings.slardar.security.impl;

import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.core.Ordered;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pro.fessional.mirana.func.Dcl;
import pro.fessional.wings.slardar.security.WingsUserDetailsService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * @author trydofor
 * @since 2021-02-17
 */
@Slf4j
public class ComboWingsUserDetailsService implements WingsUserDetailsService {

    private final List<Combo<?>> combos = new ArrayList<>();
    private final Dcl dclCombos = Dcl.of(() -> combos.sort(Comparator.comparingInt(Combo::getOrder)));

    @Override
    public @NotNull UserDetails loadUserByUsername(String username, @NotNull Enum<?> authType, @Nullable Object authDetail) throws UsernameNotFoundException {
        dclCombos.runIfDirty();
        for (Combo<?> combo : combos) {
            final UserDetails ud = combo.loadOrNull(username, authType, authDetail);
            if (ud != null) {
                log.info("loadUserByUsername by combo={}", combo.getClass());
                return ud;
            }
        }

        throw new UsernameNotFoundException("failed load user-details, username=" + username + ", auth-type=" + authType);
    }


    public void add(Combo<?> source) {
        if (source == null) return;
        combos.add(source);
        dclCombos.setDirty();
    }

    public void addAll(Collection<? extends Combo<?>> source) {
        if (source == null) return;
        combos.addAll(source);
        dclCombos.setDirty();
    }

    public interface Combo<T extends UserDetails> extends Ordered {
        /**
         * 不接受或无法构造返回null
         *
         * @param username   type下身份唯一辨识，用户名，手机号，邮箱，userId等
         * @param authType   验证类型，默认null
         * @param authDetail Authentication.getDetails
         * @return UserDetails
         * @throws UsernameNotFoundException UsernameNotFound
         * @see Authentication#getDetails
         */
        @Nullable
        T loadOrNull(String username, @NotNull Enum<?> authType, @Nullable Object authDetail);
    }
}
