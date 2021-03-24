package com.springauthorization;

import com.springauthorization.Services.UserService;
import com.springauthorization.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class UserServiceTests {

   @Autowired
   private TestEntityManager testEM;

   @Autowired
   private UserService userService;

   @BeforeEach
   void addTestData() {
      testEM.persist(new User("user1", "user1@hcl.com", "password1"));
      testEM.persist(new User("user2", "user2@hcl.com", "password2"));
      testEM.persist(new User("user3", "user3@hcl.com", "password3"));
      testEM.persist(new User("user4", "user4@hcl.com", "password4"));
      testEM.persist(new User("user5", "user5@hcl.com", "password5"));
      testEM.flush();
   }

   @Test
   void getAllUsersTest() {
      Iterable<User> userIter = userService.getAllUsers();

      List<User> users = new ArrayList<>();
      userIter.forEach(users::add);

      assertEquals(5, users.size());
   }

   @Test
   void getUserbyNameTest() {
      assertEquals("user1", userService.getUserByName("user1").getUsername());
   }

   @Test
   void updateUserTest() {

      User userToSave = new User("user6", "user6@hcl.com", "password6");

      userService.updateUser(userToSave);

      assertEquals("user6", userService.getUserByName("user6").getUsername());
   }
}
