package com.biosecuritas.controlpanel.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biosecuritas.controlpanel.db.entities.Installation;

public interface InstallationRepository extends JpaRepository<Installation, Integer> {

}
