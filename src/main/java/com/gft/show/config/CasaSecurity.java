package com.gft.show.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;


@Configuration
@EnableWebSecurity
public class CasaSecurity extends WebSecurityConfigurerAdapter {
	
	
	//private MyUserDetailsService userDetailsService;
	@Autowired
	private UserDetailsService userDetailsService;
	

	
	
	
	/*protected UserDetailsService userDetailsService() {
		List<UserDetails> users = new ArrayList<>();
		users.add(User.withDefaultPasswordEncoder().username("navin").password("1234").roles("USER").build());
	
	return new InMemoryUserDetailsManager(users);
	}
	
}*/
	
	
	
	/*@Autowired
	private UserDetailsService userDetailsService;
	
	@Bean
	public AuthenticationProvider autoProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}*/
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			
				.antMatchers("/registrar").permitAll()
				.antMatchers("/registrar/adm").permitAll()
				.antMatchers("/historico").hasAuthority("ADMIN")
				.antMatchers("/casas").hasAuthority("ADMIN")
				//.antMatchers("/{codigo}").hasAnyRole("USER2")
				.antMatchers("/eventos").hasAuthority("ADMIN")
				.antMatchers("/").hasAnyAuthority("USER","ADMIN")
				.antMatchers("/entrar").permitAll()
				.antMatchers("/api/**").permitAll()
				.antMatchers("/swagger-ui.html").hasAnyAuthority("USER","ADMIN")
				.anyRequest()
				.authenticated()
			
			.and()
				.formLogin()
				.loginPage("/entrar")
				.permitAll()
				.defaultSuccessUrl("/",true)
			.and()
				.logout()
				.invalidateHttpSession(true)
				.clearAuthentication(true);
		
				//.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				//.logoutSuccessUrl("/logout-success").permitAll();
			
		}
	@Bean
	public AuthenticationProvider authProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}
	
	@Override
	public void configure(WebSecurity config) throws Exception{
		config.ignoring()
		.antMatchers("/css/**")
		.antMatchers("/js/**")
		.antMatchers("/images/**")
		.antMatchers("/fontawesome-free-5.12.0-web/**")
		.antMatchers("/META-INF/resources/webjars/**")
		.antMatchers("/csrf/**");
	}
	
	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
		builder.userDetailsService(userDetailsService);
		
	}*/

	//salvar em memoria
	 /* @Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
		builder
			.inMemoryAuthentication()
			.withUser("carlos").password("{noop}123").roles("ADM1", "ADM2", "USER1", "USER2")
			.and()
			.withUser("flavio").password("{noop}123").roles("PG_HISTORICO","PG_VENDA");
	}*/
	
	
}
	
	
	

