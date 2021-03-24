package com.springauthorization;

import com.springauthorization.Controllers.InvalidCredentialExceptionController;
import com.springauthorization.Controllers.LoginController;
import com.springauthorization.Exceptions.InvalidCredentialException;
import com.springauthorization.Services.UserService;
import com.springauthorization.User.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({
      LoginController.class,
      InvalidCredentialExceptionController.class,
      UserService.class,
      User.class,
      ServletInitializer.class,
      InvalidCredentialException.class
})
public class AuthorizationApplication {

   public static void main(String[] args) {
      SpringApplication.run(AuthorizationApplication.class, args);
   }

}
