package com.example.demo.dto.account;

public class ResetPassRequest {
    private String username;
    private String oldPassword;
    private String password;
    private String confirmPassword;


    public ResetPassRequest() {
    }

    public ResetPassRequest(String username, String oldPassword, String password, String confirmPassword) {
        this.username = username;
        this.oldPassword = oldPassword;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
