package com.springauthorization.Services;

import com.springauthorization.Exceptions.UserNotFoundException;
import com.springauthorization.Repository.UserRepository;
import com.springauthorization.User.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

   @Autowired
   private UserRepository userRepo;

   public Iterable<User> getAllUsers() {
      return userRepo.findAll();
   }

   public User getUserByName(String name) {
      return userRepo.findByName(name);
   }

   public User getUserById(Long id) {
      Optional<User> foundUser = userRepo.findById(id);

      if(!foundUser.isPresent()) {
         throw new UserNotFoundException();
      }

      return (foundUser.get());
   }

   public void updateUser(User updateUser) {
      userRepo.save(updateUser);
   }
}
