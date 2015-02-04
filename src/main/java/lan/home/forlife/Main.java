package lan.home.forlife;

import lan.home.forlife.domain.Role;

/**
 * Created by yar on 22.01.15.
 */
public class Main {
    public static void main(String[] args) {
        Role admin = Role.ADMIN;
        System.out.println(admin.getAuthority());
    }
}
