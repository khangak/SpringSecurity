package web.initialize.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import web.initialize.service.UserDetailsSeriviceImpl;
@EnableWebSecurity
public class SpringSecurity extends WebSecurityConfigurerAdapter {
	public final static String ADMIN = "ADMIN";
	public final static String USER = "USER";
	@Autowired
	UserDetailsSeriviceImpl UserDetailsSerivice;
	@Autowired
    private AuthenticationEntryPoint authEntryPoint;
	//Require
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Autowired
	LogoutHandler logoutHandler;
	@Autowired
	LogoutSuccessHandler logoutSuccessHandler;
	//Option
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("khang").password("$2a$10$uFAVHkhq5M1No03U9J0btexq0.ACgo3HhAl0WY3vFYAZ.kwImGmwe").roles("ADMIN");
//		auth.inMemoryAuthentication().withUser("user").password("$2a$10$yKNKIb7nin/RWD1.0wWmsuP0FmbR6H4SkYqKO0STcSOgP8In90/oW").roles("USER");
		auth.userDetailsService(UserDetailsSerivice).passwordEncoder(passwordEncoder());
	}
	// Require
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.cors().disable();
		
		http.authorizeRequests().antMatchers("/").permitAll()
		.antMatchers("/login").permitAll()
		.anyRequest().authenticated();
//		.and()
//        //
//        // Add Filter 1 - JWTLoginFilter
//        //
//        .addFilterBefore(new JWTLoginFilter("/login", authenticationManager()),
//                UsernamePasswordAuthenticationFilter.class)
//        //
//        // Add Filter 2 - JWTAuthenticationFilter
//        //
//        .addFilterBefore(new JWTAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
		
		
		//http.authorizeRequests().and().formLogin();
		
		
		
		// Anyone can access
		// http.httpBasic();
		//.authenticationEntryPoint(authEntryPoint);
//		http.authorizeRequests().antMatchers("/login","logout","/").permitAll();
//		http.authorizeRequests().antMatchers("/admin**","/admin").hasRole("ADMIN");
//		http.authorizeRequests().antMatchers("/user**","/user").hasAnyRole("ADMIN","USER");
		
		//		http.authorizeRequests().and()
//		.formLogin().loginProcessingUrl("/check").defaultSuccessUrl("/success").failureUrl("/failed").and().
		// http.logout().logoutUrl("/logout").logoutSuccessUrl("/logoutsuccess");
		//.invalidateHttpSession(true).deleteCookies("JSESSIONID");
		//.logoutSuccessHandler(logoutSuccessHandler).addLogoutHandler(logoutHandler);
//		http.exceptionHandling().accessDeniedPage("/errorPage");
		
		
	}

}
