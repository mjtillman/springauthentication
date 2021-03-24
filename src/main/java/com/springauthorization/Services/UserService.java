package com.springauthorization.Services;

import com.springauthorization.Exceptions.InvalidCredentialException;
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

   public User getUserByName(String name) throws InvalidCredentialException {
      Optional<User> foundUser = Optional.ofNullable(userRepo.findByUsername(name));

      if (!foundUser.isPresent()) {
         throw new InvalidCredentialException(name);
      }

      return foundUser.get();
   }

   public User updateUser(User updateUser) {
      return userRepo.save(updateUser);
   }
}
