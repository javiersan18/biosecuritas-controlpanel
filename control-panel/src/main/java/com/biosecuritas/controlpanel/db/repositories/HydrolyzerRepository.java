package com.biosecuritas.controlpanel.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biosecuritas.controlpanel.db.entities.Client;
import com.biosecuritas.controlpanel.db.entities.Hydrolyzer;

public interface HydrolyzerRepository extends JpaRepository<Hydrolyzer, Integer> {

}
