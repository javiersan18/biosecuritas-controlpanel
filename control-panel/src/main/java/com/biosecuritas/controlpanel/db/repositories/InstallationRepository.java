package com.biosecuritas.controlpanel.db.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biosecuritas.controlpanel.db.entities.Installation;
import com.biosecuritas.controlpanel.utils.InstallationStatus;

public interface InstallationRepository extends JpaRepository<Installation, Integer> {

	public List<Installation> findByStatus(InstallationStatus status);

}
