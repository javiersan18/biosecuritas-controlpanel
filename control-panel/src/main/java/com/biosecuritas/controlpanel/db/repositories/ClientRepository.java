package com.biosecuritas.controlpanel.db.repositories;

import org.springframework.data.repository.CrudRepository;

import com.biosecuritas.controlpanel.db.entities.Client;

public interface ClientRepository extends CrudRepository<Client, Integer> {

}
