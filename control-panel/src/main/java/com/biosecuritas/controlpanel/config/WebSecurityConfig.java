package com.biosecuritas.controlpanel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.biosecuritas.controlpanel.service.impl.UserDetailsServiceImpl;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/*
	 * @Bean public UsernamePasswordAuthenticationToken autheticationToken() {
	 * UsernamePasswordAuthenticationToken authentication =
	 * (UsernamePasswordAuthenticationToken) SecurityContextHolder
	 * .getContext().getAuthentication(); return authentication; }
	 */

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService());
		authProvider.setPasswordEncoder(passwordEncoder());
		return authProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) {
		auth.authenticationProvider(authenticationProvider());
	}

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests().antMatchers("/login").permitAll().and().formLogin().
	 * loginPage("/login")
	 * .usernameParameter("username").passwordParameter("password").permitAll()
	 * .loginProcessingUrl("/postLogin").successForwardUrl("/postLogin").failureUrl(
	 * "/loginFailed").and()
	 * .logout().logoutUrl("/logout").logoutSuccessUrl("/logout").permitAll().and().
	 * csrf().disable(); }
	 */

	/*
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * http.authorizeRequests().antMatchers("/").hasAnyRole("ADMIN",
	 * "USER").and().authorizeRequests() .antMatchers("/login", "/webjars/**",
	 * "/static/**").permitAll().and().formLogin().loginPage("/login")
	 * .usernameParameter("username").passwordParameter("password").permitAll()
	 * .loginProcessingUrl("/postLogin").successForwardUrl("/postLogin").failureUrl(
	 * "/loginFailed").and()
	 * .logout().logoutUrl("/doLogout").logoutSuccessUrl("/logout").permitAll().and(
	 * ).csrf().disable(); }
	 */

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/webjars/**", "/static/**").permitAll().antMatchers("/**")
				.hasAnyRole("ADMIN", "USER").and().formLogin().loginPage("/login").usernameParameter("username")
				.passwordParameter("password").permitAll().loginProcessingUrl("/postLogin")
				.successForwardUrl("/postLogin").failureUrl("/loginFailed").and().logout().permitAll()
				.logoutSuccessUrl("/login").and().csrf().disable();

		/*
		 * .and().authorizeRequests() .antMatchers("/login",
		 * "/resource/**").permitAll().and().formLogin().loginPage("/login2")
		 * .usernameParameter("username").passwordParameter("password").permitAll()
		 * .loginProcessingUrl("/postLogin").successForwardUrl("/postLogin").failureUrl(
		 * "/loginFailed").and()
		 * .logout().permitAll().logoutSuccessUrl("/login").and().csrf().disable();
		 */
	}

}