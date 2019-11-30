package com.biosecuritas.controlpanel.db.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biosecuritas.controlpanel.db.entities.Farm;

public interface FarmRepository extends JpaRepository<Farm, Integer> {

}