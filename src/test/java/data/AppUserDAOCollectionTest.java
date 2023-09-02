package data;

import org.example.data.dao.AppUserDAO;
import org.example.data.dao.AppUserDAOCollection;
import org.example.model.AppRole;
import org.example.model.AppUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AppUserDAOCollectionTest {

    private AppUserDAO appUserDAO;

    @BeforeEach
    void setUp() {
        appUserDAO = new AppUserDAOCollection();
    }

    //test persist
    @Test
    void testPersist() {
        AppUser user = new AppUser("testUser", "testPassword", AppRole.ROLE_APP_USER);
        AppUser persistedUser = appUserDAO.persist(user);

        assertEquals(user, persistedUser, "Test persist");
    }

    //test duplicate
    @Test
    void testPersistDuplicateUsername() {
        AppUser user1 = new AppUser("testUser", "password1", AppRole.ROLE_APP_USER);
        AppUser user2 = new AppUser("testUser", "password2", AppRole.ROLE_APP_USER);

        appUserDAO.persist(user1);

        assertThrows(IllegalArgumentException.class, () -> {
            appUserDAO.persist(user2);
        }, "Test persist - Duplicate username");
    }

    //test findByUsername
    @Test
    void testFindByUserName() {
        AppUser user = new AppUser("testUser", "testPassword", AppRole.ROLE_APP_USER);
        appUserDAO.persist(user);

        AppUser retrievedUser = appUserDAO.findByUsername("testUser");

        assertNotNull(retrievedUser, "Test findByUserName - User found");
        assertEquals(user, retrievedUser, "Test findByUserName - User matches");
    }

    //test finByNonExistingUsername
    @Test
    void testFindByNonExistingUsername() {
        AppUser retrievedUser = appUserDAO.findByUsername("nonExistingUser");

        assertNull(retrievedUser, "Test findByNonExistingUsername");
    }



    //test findAllExisting
    @Test
    void TestFindAll() {
        AppUser user1 = new AppUser("user1", "password1", AppRole.ROLE_APP_USER);
        AppUser user2 = new AppUser("user2", "password2", AppRole.ROLE_APP_USER);
        appUserDAO.persist(user1);
        appUserDAO.persist(user2);
        Iterable<AppUser> allUsers = appUserDAO.findAll();

        assertTrue(hasUser(allUsers, user1) && hasUser(allUsers, user2),"Test findAll - All users present");
    }

    private boolean hasUser(Iterable<AppUser> users, AppUser userToFind) {
        for (AppUser user : users) {
            if (user.equals(userToFind)) {
                return true;
            }
        }
        return false;
    }


    //test findAllEmpty
    @Test
    void testFindAllEmpty() {
        AppUserDAO appUserDAO = new AppUserDAOCollection();

        Iterable<AppUser> allUsers = appUserDAO.findAll();
        assertFalse(allUsers.iterator().hasNext(), "Test findAll - Empty collection");
    }

    //test remove
    @Test
    void testRemove() {
        AppUser user = new AppUser("testUser", "testPassword", AppRole.ROLE_APP_USER);
        appUserDAO.persist(user);

        appUserDAO.remove("testUser");
        AppUser retrievedUser = appUserDAO.findByUsername("testUser");

        assertNull(retrievedUser, "Test remove");
    }


    //test removeNonExistingUser
    @Test
    void testRemoveNonExistingUser() {
        assertDoesNotThrow( () -> {
            appUserDAO.remove("nonExistingUser");
        }, "Test remove - Non-existing user");
    }
}
