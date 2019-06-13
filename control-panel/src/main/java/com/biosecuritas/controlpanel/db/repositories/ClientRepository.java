package com.biosecuritas.controlpanel.db.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biosecuritas.controlpanel.db.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
