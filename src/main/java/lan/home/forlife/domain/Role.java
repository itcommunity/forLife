package lan.home.forlife.domain;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by yar on 22.01.15.
 */
public enum Role implements GrantedAuthority {
    ADMIN,
    USER,
    ANONYMOUSE;

    @Override
    public String getAuthority() {
        return "ROLE_"+this;

    }
}
