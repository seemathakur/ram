package com.vsp.testfw;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by carlki on 8/16/2016.
 */

public class LoginAuthPool {
    private static final Logger log = LoggerFactory.getLogger(LoginAuthPool.class);
    private static LinkedBlockingDeque<LoginAuth> drLoginDeque = new LinkedBlockingDeque<>();
    private static ArrayList<LoginAuth> drlogins = new ArrayList<>();

    static {
        drlogins.add(new LoginAuth.Builder("9498314144","4314","10410721").build());
        //drlogins.add(new LoginAuth.Builder("9168515050","Myeyes12","10629212").build());
        drLoginDeque.addAll(drlogins);
    }

    public static LoginAuth getNextLogin() {
        LoginAuth login = drLoginDeque.removeFirst();
        drLoginDeque.addLast(login);
        log.trace("Fetching dr login from pool: " + login.getUsername());
        return login;
    }

}
