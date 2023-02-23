
package com.example.data.security;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.templateresolver.ITemplateResolver;

import com.example.data.service.UsuarioService;

//usando spring-boot con cualquiera de las dos anotaciones o las dos es suficiente. Dejo las dos por tradición 

@EnableWebSecurity
@Configuration // Indicates that a class declares one or more @Bean methods and may be
				// processed by the Spring container to generate bean definitions and service
				// requests for those beans at runtime
public class SecurityConfigurationNew  extends WebSecurityConfigurerAdapter{// extends WebSecurityConfigurerAdapter (clase deprecated)
										// https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter{

	@Autowired
	private UsuarioService usuarioService;

	  @Bean
	   public BCryptPasswordEncoder passwordEncoder() {
	      
	      return new BCryptPasswordEncoder();
	   }

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {

		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(usuarioService);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}

	 
	   protected void configure(AuthenticationManagerBuilder auth) 
	          throws Exception {
	      
	      auth.authenticationProvider(authenticationProvider());
	   }
	
	   @Override
	    public void configure(WebSecurity web) throws Exception {
	        web
	            .ignoring()
	            .antMatchers("/h2-console/**");
	    }
	   
	protected  void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		
		.antMatchers("/h2-console/**").permitAll()
		.antMatchers("/admin/**").hasRole("ADMIN")
        .antMatchers("/user/**").hasRole("USER")     
        .antMatchers("/addUsuario").hasRole("ADMIN")
             .and()
             .formLogin().loginPage("/login")
               .permitAll().and().logout().invalidateHttpSession
                 (true).clearAuthentication(true)
                    .logoutRequestMatcher
                      (new AntPathRequestMatcher("/logout"))
                        .logoutSuccessUrl("/login?logout")
            .permitAll();
	}
	

 
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
    	System.out.println("\t Creando en memoria Usuario y Admin ");
    	
		UserDetails user = User.withUsername("user")
				.passwordEncoder(passwordEncoder()::encode).password("1234")
				.roles("USER").build();

		UserDetails admin = User.withUsername("admin")
				.passwordEncoder(passwordEncoder()::encode).password("1234")
				.roles("ADMIN","USER").build();

		InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

		userDetailsManager.createUser(user);
		userDetailsManager.createUser(admin);
		
		return userDetailsManager;  			

    }
	

}
