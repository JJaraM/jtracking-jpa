package com.jjmsoftsolutions.jtracking.jpa;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import com.jjmsoftsolutions.jtracking.specification.Account;
import com.jjmsoftsolutions.jtracking.specification.Membership;
import com.jjmsoftsolutions.jtracking.specification.User;

@Entity
@Table(name = "Account")
public class AccountJPA implements Account {
	
	@Id
    @TableGenerator( name = "account_generator", table = "generated_keys", pkColumnName = "pk_column", valueColumnName = "value_column", pkColumnValue = "account_id", initialValue = 1, allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.TABLE, generator = "account_generator" )
	private Integer id;
	
	@OneToOne(targetEntity=UserJPA.class) @JoinColumn(name="uzer_id", unique=true, nullable=false) private User user;
	@Column(name = "token", nullable = false, length=100) private String token;
	@OneToMany(mappedBy="account", targetEntity=MembershipJPA.class) private Set<Membership> memberships;
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}	
	
	@Override
	public String getToken() {
		return token;
	}

	@Override
	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public Set<Membership> getMembership() {
		if (memberships == null) {
			memberships = new HashSet<>();
		}
		return memberships;
	}

	@Override
	public void setMembership(Set<Membership> memberships) {
		this.memberships = memberships;
	}

	@Override
	public Membership addMembership(Membership membership) {
		getMembership().add(membership);
		membership.setAccount(this);
		return membership;
	}

	@Override
	public Membership removeMembership(Membership membership) {
		getMembership().remove(membership);
		membership.setAccount(null);
		return membership;
	}
	
}