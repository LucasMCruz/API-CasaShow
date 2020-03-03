 package com.gft.show.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gft.show.model.UserPrincipal;
import com.gft.show.model.UserPrincipal2;
import com.gft.show.model.Usuario;
import com.gft.show.repository.UserRepository;




@Service
public class MyUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository repo;
	
	
	
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		
		
		
		Usuario usuarios = repo.findByUsername(username);
		if(usuarios==null) {
			throw new UsernameNotFoundException("Usuario nao encontrado");
		}
		if(usuarios.isAdm()==true){
			//AuthenticationManagerBuilder.class.getName();
			//usuarios = UserPrincipal.class;
			System.out.println("ADM aqui");
			return new UserPrincipal2(usuarios);
		}
			else {
				return new UserPrincipal(usuarios);
			}
		/*if(username.equals("ADMIN")) {
			AuthenticationManagerBuilder.class.getName();
			//usuarios = UserPrincipal.class;
			System.out.println("ADM aqui");
			return new UserPrincipal2(usuarios);
		}
			else {
				return new UserPrincipal(usuarios);
			}
*/
		
			
	}				
	///User (usuarios.getPassword(), usuarios.getUsername(), true, true, true, true, usuarios.getAuthorities());
	//.getUsername(), user.getPassword(), true, true, true, true, user.ge);


}
