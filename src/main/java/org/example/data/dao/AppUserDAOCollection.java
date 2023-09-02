package org.example.data.dao;

import org.example.model.AppUser;

import java.util.HashMap;
import java.util.Map;

public class AppUserDAOCollection implements AppUserDAO {
    private  final Map<String, AppUser> appUsers = new HashMap<>();

    @Override
    public AppUser persist(AppUser appUser) {
        if (appUsers.containsKey(appUser.getUserName())) {
            throw new IllegalArgumentException("Username already exist");
        }
        appUsers.put(appUser.getUserName(), appUser);
        return appUser;
    }

    @Override
    public AppUser findByUsername(String username) {
        return appUsers.get(username);
    }

    @Override
    public Iterable<AppUser> findAll() {
        return appUsers.values();
    }

    @Override
    public void remove(String username) {
        appUsers.remove(username);
    }
}
