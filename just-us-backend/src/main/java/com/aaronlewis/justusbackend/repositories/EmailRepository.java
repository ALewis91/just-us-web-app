package com.aaronlewis.justusbackend.repositories;

import com.aaronlewis.justusbackend.entities.EmailId;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class EmailRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<EmailId> findAll() {
		TypedQuery<EmailId> namedQuery = entityManager.createNamedQuery("find_all_email_ids", EmailId.class);
		return namedQuery.getResultList();
	}
	
	public EmailId findByEmail(String email) {
		return entityManager.find(EmailId.class, email);
	}
	
	public EmailId update(EmailId emailId) {
		return entityManager.merge(emailId);
	}
	
	public void deleteByEmail(String email) {
		EmailId emailId = findByEmail(email);
		entityManager.remove(emailId);
	}
}