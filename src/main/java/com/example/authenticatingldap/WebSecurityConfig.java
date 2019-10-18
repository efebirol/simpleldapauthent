package com.example.authenticatingldap;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;


/*
 * Info: hier konfiguriere ich die "security policy"
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{

  @Override
  protected void configure(HttpSecurity http) throws Exception
  {
    http.authorizeRequests().anyRequest().fullyAuthenticated().and().formLogin();
  }

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception
  {
    // LDAP Server läuft hier auf dem Port 8389
    // lesen Testdaten aus der "test-server.ldif"-Datei (siehe "application.properties"). Testdateien sind gut für Testzwecke, aber nicht im Produktivsystem.
    auth.ldapAuthentication()
        .userDnPatterns("uid={0},ou=people")
        .groupSearchBase("ou=groups")
        .contextSource()
        .url("ldap://localhost:8389/dc=springframework,dc=org")
        .and()
        .passwordCompare()
        .passwordEncoder(new LdapShaPasswordEncoder())
        .passwordAttribute("userPassword");
  }

}