package com.springauthorization.Repository;

import com.springauthorization.User.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

   User findByUsername(String username);
}
