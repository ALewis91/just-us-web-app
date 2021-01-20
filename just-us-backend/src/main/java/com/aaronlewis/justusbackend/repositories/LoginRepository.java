package com.aaronlewis.justusbackend.repositories;

import com.aaronlewis.justusbackend.entities.Login;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class LoginRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<Login> findAll() {
		TypedQuery<Login> namedQuery = entityManager.createNamedQuery("find_all_logins", Login.class);
		return namedQuery.getResultList();
	}
	
	public Login findById(int id) {
		return entityManager.find(Login.class, id);
	}
	
	public Login update(Login person) {
		return entityManager.merge(person);
	}
	
	public void deleteById(int id) {
		Login person = findById(id);
		entityManager.remove(person);
	}
}