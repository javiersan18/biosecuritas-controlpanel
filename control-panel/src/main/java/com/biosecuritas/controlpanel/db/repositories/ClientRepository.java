package com.biosecuritas.controlpanel.db.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.biosecuritas.controlpanel.db.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

	@Query(value = "select count(*) from Client c JOIN Hydrolyzer h ON c.client_code = h.client_id_client_code WHERE c.client_code=?0", nativeQuery = true)
	public Integer countHydrosByClientId(Integer id);

	@Query(value = "select c.client_code, count(*) from Client c JOIN Hydrolyzer h ON c.client_code = h.client_id_client_code group by c.client_code", nativeQuery = true)
	public List<Object[]> countHydrosAllClients();

}
