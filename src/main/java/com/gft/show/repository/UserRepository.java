package com.gft.show.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.gft.show.model.Usuario;

public interface UserRepository extends JpaRepository <Usuario, String> {
	Usuario findByUsername(String username);

}
