package com.aaronlewis.justusbackend.repositories;

import com.aaronlewis.justusbackend.entities.AccountOwner;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class AccountOwnerRepository {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public List<AccountOwner> findAll() {
		TypedQuery<AccountOwner> namedQuery =
				entityManager.createNamedQuery("find_all_account_owners", AccountOwner.class);
		return namedQuery.getResultList();
	}
	
	public AccountOwner findById(Long id) {
		return entityManager.find(AccountOwner.class, id);
	}
	
	public AccountOwner insert(AccountOwner accountOwner) {
		return entityManager.merge(accountOwner);
	}	
	
	public void deleteById(Long id) {
		AccountOwner person = findById(id);
		entityManager.remove(person);
	}
}