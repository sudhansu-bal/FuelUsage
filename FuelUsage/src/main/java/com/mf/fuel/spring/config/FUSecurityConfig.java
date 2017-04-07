/**
 * 
 */
package com.mf.fuel.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.mf.fuel.spring.security.MySavedRequestAwareAuthenticationSuccessHandler;
import com.mf.fuel.spring.security.RestAuthenticationEntryPoint;

/**
 * @author sudhansub
 *
 */

@Configuration
@EnableWebSecurity
@ComponentScan("com.mf.fuel.spring.security")
public class FUSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
    private RestAuthenticationEntryPoint restAuthenticationEntryPoint;
 
    @Autowired
    private MySavedRequestAwareAuthenticationSuccessHandler
      authenticationSuccessHandler;
	
    @Bean
    public MySavedRequestAwareAuthenticationSuccessHandler mySuccessHandler(){
        return new MySavedRequestAwareAuthenticationSuccessHandler();
    }
    @Bean
    public SimpleUrlAuthenticationFailureHandler myFailureHandler(){
        return new SimpleUrlAuthenticationFailureHandler();
    }
    
	@Override
    protected void configure(AuthenticationManagerBuilder auth)
      throws Exception {
  
//        auth.inMemoryAuthentication()
//          .withUser("admin").password("adminpass").roles("ADMIN")
//          .and()
//          .withUser("user").password("userpass").roles("USER");
		
		auth.inMemoryAuthentication()
        .withUser("user").password("password")
        .authorities("ROLE_USER");
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception { 
//        http
//        .csrf().disable()
//        .exceptionHandling()
//        .authenticationEntryPoint(restAuthenticationEntryPoint)
//        .and()
//        .authorizeRequests()
//        .antMatchers("/api/").authenticated()
//        .and()
//        .formLogin()
//        .successHandler(authenticationSuccessHandler)
//        .failureHandler(new SimpleUrlAuthenticationFailureHandler())
//        .and()
//        .logout();csrf().disable().
		
		http.authorizeRequests()
        .antMatchers("/api").permitAll()
        .anyRequest().authenticated()
        .and()
        .httpBasic()
        .authenticationEntryPoint(restAuthenticationEntryPoint);

//      http.addFilterAfter(new CustomFilter(),
//        BasicAuthenticationFilter.class);
		
    }
 
    
	
}
