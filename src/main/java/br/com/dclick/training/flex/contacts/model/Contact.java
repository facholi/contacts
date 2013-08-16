/**
 * 
 */
package br.com.dclick.training.flex.contacts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * @author Rodrigo Facholi
 *
 */
@Entity
@NamedQuery(name = "listAll", query = "from Contact c")
public class Contact {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String name;
	private String phone;
	private String email;
	
	public Contact() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Um contato sempre deve ter ao menos um nome e telefone.
	 * 
	 * @param name
	 * @param phone
	 */
	public Contact(String name, String phone) {
		this.name = name;
		this.phone = phone;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

}
