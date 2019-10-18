package com.example.authenticatingldap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HomeController
{

  /*
   * @RestController schreibt Response (über SpringMVC) gleich in den ResponeBody (auf die Webseite), weil keine View existiert
   */
  @GetMapping("/")
  public String index()
  {
    return "-- \\HomeController.java - index() - Welcome to the home page! Sicheres Login mit LDAP";
  }
}
