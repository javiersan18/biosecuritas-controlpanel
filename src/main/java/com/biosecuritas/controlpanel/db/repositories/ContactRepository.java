package com.biosecuritas.controlpanel.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biosecuritas.controlpanel.db.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
