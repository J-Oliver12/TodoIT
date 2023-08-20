package org.example.model;

import java.util.Objects;

public class AppUser {

    private String username;
    private String password;
    private AppRole role;


    public AppUser(String username, String password, AppRole role){
        setUserName(username);
        setPassword(password);
        setRole(role);
    }

    public String getUserName() {
        return username;
    }

    public void setUserName(String userName) {
        if (userName == null || userName.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        this.username = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }
        this.password = password;
    }

    public AppRole getRole() {
        return role;
    }

    public void setRole(AppRole role) {
        if (role == null) {
            throw new IllegalArgumentException("Role cannot be null");
        }
        this.role = role;
    }

    @Override
    public  boolean equals(Object obj) {
        if (this == obj) {
            return  true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AppUser appUser = (AppUser) obj;
        return Objects.equals(username, appUser.username) && role == appUser.role;
    }

    @Override
    public int hashCode() {
        return Objects.hash(username,role);
    }


    @Override
    public String toString() {
        return "AppUser{" +
                "username='" + username + '\'' +
                ", role=" + role +
                '}';
    }
}
