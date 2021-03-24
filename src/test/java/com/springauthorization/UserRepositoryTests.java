package com.springauthorization;

import com.springauthorization.Repository.UserRepository;
import com.springauthorization.User.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
class UserRepositoryTests {

   @Autowired
   private TestEntityManager entityManager;

   @Autowired
   private UserRepository userRepository;

   @Test
   void whenFindByName_thenReturnUser() {
      User dummyUser = new User();
      dummyUser.setUsername("Dummy");
      dummyUser.setEmail("test@test.com");
      dummyUser.setPassword("password");
      entityManager.persist(dummyUser);
      entityManager.flush();

      User found = userRepository.findByUsername(dummyUser.getUsername());

      assertEquals(found.getUsername(), dummyUser.getUsername());
   }

}
