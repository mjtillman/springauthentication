package com.springauthorization.Controllers;

import com.springauthorization.Exceptions.InvalidCredentialException;
import com.springauthorization.User.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class InvalidCredentialExceptionController {

   @ExceptionHandler(value = InvalidCredentialException.class)
   public ModelAndView loginError(InvalidCredentialException ex) {

      String errMsg1 = "Invalid user credentials.";
      String errMsg2 = "Please try again.";

      ModelAndView mav = new ModelAndView("home");
      mav.addObject("user", new User());
      mav.addObject("errMsg1", errMsg1);
      mav.addObject("errMsg2", errMsg2);

      return mav;
   }
}