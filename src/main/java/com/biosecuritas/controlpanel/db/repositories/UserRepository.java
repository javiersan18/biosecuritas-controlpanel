package com.biosecuritas.controlpanel.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biosecuritas.controlpanel.db.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User getUserByUsername(String username);

}
