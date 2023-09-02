package model;

import org.example.data.dao.AppUserDAO;
import org.example.data.dao.AppUserDAOCollection;
import org.example.model.AppRole;
import org.example.model.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class AppUserTest {

    private AppUser appUser;                            //Initialize this field
    private AppUserDAO appUserDAO;                      //Initialize this field

    @BeforeEach
    void setup() {
        appUserDAO = new AppUserDAOCollection();                                                      //Initialize appUserDAO
        appUser = new AppUser("testUser", "testPassword", AppRole.ROLE_APP_USER);  //Initialize appUser
    }

    @Test
    void getUsername() {
        assertEquals("testUser", appUser.getUserName(), "Test getUsername");
    }
    
    @Test
    void testGetNonExistingUsername() {
        assertNull(appUserDAO.findByUsername("nonExistingUsername"), "Test getNonExistingUsername");
    }

    @Test
    void testSetUsername() {
        appUser.setUserName("newUsername");
        assertEquals("newUsername", appUser.getUserName(),"Test getUsername");
    }

    @Test
    void testSetNullUsername () {
        assertThrows(IllegalArgumentException.class, () -> appUser.setUserName(null));
    }

    @Test
    void testGetPassword() {
        assertEquals("testPassword", appUser.getPassword(), "Test getPassword");
    }

    @Test
    void testGetNonExistingPassword() {
        assertNull(null, "Test getNonExistingPassword");
    }

    @Test
    void testSetPassword() {
        appUser.setPassword("newPassword");
        assertEquals("newPassword", appUser.getPassword(),"Test setNewPassword");
    }

    @Test
    void testSetNullPassword () {
        assertThrows(IllegalArgumentException.class, () -> appUser.setPassword(null));
    }

    @Test
    void testGetAppRoll() {
        assertEquals(AppRole.ROLE_APP_USER, appUser.getRole(), "Test getAppRole");
    }

    @Test
    void testGetNonExistingAppRoll() {
        assertNull(null, "Test getNonExistingAppRole");
    }

    @Test
    void testSetRole() {
        appUser.setRole(AppRole.ROLE_APP_ADMIN);
        assertEquals(AppRole.ROLE_APP_ADMIN, appUser.getRole(),"Test setRole");
    }


    @Test
    void testSetNullRoll () {
        assertThrows(IllegalArgumentException.class, () -> appUser.setRole(null));
    }

    @Test
    void testEquals() {
        AppUser sameUser = new AppUser("testUser", "testPassword", AppRole.ROLE_APP_USER);
        assertEquals(appUser, sameUser, "Test equals");
    }

    @Test
    void testNotEquals() {
        Object diffrentObject = new Object();
        assertNotEquals(appUser, diffrentObject, "Test equals with different object");
    }

    @Test
    void testHashCode() {
        AppUser sameUser = new AppUser("testUser", "testPassword", AppRole.ROLE_APP_USER);
        assertEquals(appUser.hashCode(), sameUser.hashCode(), "Test hashCode");
    }

    @Test
    void testNotEqualHashCode() {
        AppUser differentUser = new AppUser("testUser1", "testPassword1", AppRole.ROLE_APP_USER);
        assertNotEquals(appUser.hashCode(), differentUser.hashCode(), "Test Not Equal hashCode");
    }

    @Test
    void testToString() {
        String expectedToString = "AppUser{" +
                "username='testUser', role=ROLE_APP_USER" +
                '}';
        assertEquals(expectedToString, appUser.toString(), "Test toString");
    }

}



