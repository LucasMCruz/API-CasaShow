package com.gft.show.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.gft.show.model.Usuario;

public interface UserRepository extends JpaRepository <Usuario, Long> {
	Usuario findByUsername(String username);
	//CrudRepository<User, Long>
}
