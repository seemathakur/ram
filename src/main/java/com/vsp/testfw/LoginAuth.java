package com.vsp.testfw;

/**
 * Created by carlki on 8/16/2016.
 */
public class LoginAuth {


    private String username;
    private String password;
    private String authorization;

    private LoginAuth(Builder builder){
        this.username = builder.username;
        this.password = builder.password;
        this.authorization = builder.authorization;
    }

    public void setUsername(String _username){
        this.username = _username;
    }
    public void setPassword(String _password){
        this.password = _password;
    }
    public void setAuthorization(String _auth){
        this.authorization = _auth;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getAuthorization(){
        return authorization;
    }

    public static class Builder {
        //required
        private final String username;
        private final String password;
        private final String authorization;

        public Builder(String _username, String _password, String _auth) {
            this.username = _username;
            this.password = _password;
            this.authorization = _auth;
        }

        public LoginAuth build() {
            return new LoginAuth(this);
        }

    }
}
