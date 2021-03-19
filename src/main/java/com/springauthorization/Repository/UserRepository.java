package com.springauthorization.Repository;

import com.springauthorization.User.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

   User findByUsername(String username);
}
