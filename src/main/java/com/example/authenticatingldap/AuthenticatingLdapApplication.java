package com.example.authenticatingldap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
 * Quelle: https://spring.io/guides/gs/authenticating-ldap/
 * - Weitere:
 * - https://www.baeldung.com/spring-data-ldap
 * - https://www.baeldung.com/spring-ldap
 */
@SpringBootApplication
public class AuthenticatingLdapApplication
{

  public static void main(String[] args)
  {
    SpringApplication.run(AuthenticatingLdapApplication.class, args);
  }

}
