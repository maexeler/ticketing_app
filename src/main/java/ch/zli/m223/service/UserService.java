package ch.zli.m223.service;

import java.util.List;

import ch.zli.m223.model.AppUser;

public interface UserService {

    List<AppUser> getUserList();

    AppUser getUser(Long id);

    AppUser addUser(
        String firstName, String shureName, 
        String email, String password
    );

    void deleteUser(Long id);

    AppUser updateUser(
        Long id,
        String firstName, String shureName,
        String email, String password,
        String role
    );

    AppUser setUserRole(Long id, String role);
    
}
