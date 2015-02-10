package lan.home.forlife.dto;

/**
 * Created by yar on 22.01.15.
 */
public class LoginResponse {
    private String username;
    private boolean authenticated;
    private String error;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
