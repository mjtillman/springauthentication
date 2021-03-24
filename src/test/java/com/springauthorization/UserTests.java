package com.springauthorization;

import com.springauthorization.Services.UserService;
import com.springauthorization.User.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class UserTests {

   @Autowired
   private TestEntityManager testEM;

   @Autowired
   private UserService userService;

   private static User testUser88;

      @BeforeEach
      void addTestData() {
         testEM.persist(new User("user88", "user88@hcl.com", "password88"));
         testEM.flush();
         testUser88 = userService.getUserByName("user88");
      }

      @Test
      void whenUsingConstructor_checkFields() {
         assertEquals("user88", testUser88.getUsername());
         assertEquals("user88@hcl.com", testUser88.getEmail());
         assertEquals("password88", testUser88.getPassword());
      }

      @Test
      void checkGetUserId() {
         Long id = testUser88.getId();
         assertEquals(id.getClass(), Long.class);
      }

      @Test
      void testGetUsername() {
         assertEquals("user88", testUser88.getUsername());
      }

      @Test
      void whenSetUsername_checkGetUsername() {
         User testUser = new User();
         testUser.setUsername("user1");
         assertEquals("user1", testUser.getUsername());
      }

      @Test
      void testGetEmail() {
         assertEquals("user88@hcl.com", testUser88.getEmail());
      }

      @Test
      void whenSetEmail_checkGetEmail() {
         User testUser = new User();
         testUser.setEmail("user1@email.com");
         assertEquals("user1@email.com", testUser.getEmail());
      }

      @Test
      void testGetPassword() {
         assertEquals("password88", testUser88.getPassword());
      }

      @Test
      void whenSetPassword_checkGetPassword() {
         User testUser = new User();
         testUser.setPassword("password");
         assertEquals("password", testUser.getPassword());
      }
}
