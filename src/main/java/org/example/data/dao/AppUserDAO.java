package org.example.data.dao;

import org.example.model.AppUser;

public interface AppUserDAO {

    AppUser persist(AppUser appUser);
    AppUser findByUsername(String username);
    Iterable<AppUser> findAll();
    void remove(String username);
}
