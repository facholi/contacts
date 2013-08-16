/**
 * 
 */
package br.com.dclick.training.flex.contacts.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.flex.remoting.RemotingDestination;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.dclick.training.flex.contacts.model.Contact;

/**
 * @author Rodrigo Facholi
 *
 */
@Service
@RemotingDestination
@Transactional(readOnly = true)
public class ContactService {
	
	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked")
	public List<Contact> listAll() {
		List<Contact> contacts = new ArrayList<Contact>();
		
		Query query = em.createNamedQuery("listAll");
		contacts = query.getResultList();
		
		return contacts;
	}
	
	@Transactional(propagation=Propagation.REQUIRED)
	public Contact save(Contact contact) {
		
		contact = em.merge(contact);
		
		em.flush();
		
		return contact;
	}
	
	public void makeContactListForTest() {
		Contact c1 = new Contact("Rodrigo", "1797651376");
		em.persist(c1);
		Contact c2 = new Contact("José", "1797651376");
		em.persist(c2);
		Contact c3 = new Contact("João", "1797651376");
		em.persist(c3);
		Contact c4 = new Contact("Maria", "1797651376");
		em.persist(c4);
		Contact c5 = new Contact("Marcos", "1797651376");
		em.persist(c5);
		Contact c6 = new Contact("Carlos", "1797651376");
		em.persist(c6);
	}

}
