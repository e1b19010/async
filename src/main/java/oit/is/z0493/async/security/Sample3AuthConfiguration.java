package oit.is.z0493.async.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class Sample3AuthConfiguration extends WebSecurityConfigurerAdapter {

  /**
   * 認証処理に関する設定（誰がログインできるか）
   */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    // $ sshrun htpasswd -nbBC 10 customer1 Cust0m
    auth.inMemoryAuthentication().withUser("customer1")
        .password(passwordEncoder().encode("customer1")).roles("CUSTOMER");
    auth.inMemoryAuthentication().withUser("customer2")
        .password(passwordEncoder().encode("customer2")).roles("CUSTOMER");
    auth.inMemoryAuthentication().withUser("seller")
        .password(passwordEncoder().encode("seller")).roles("SELLER");
  }

  @Bean
  PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
