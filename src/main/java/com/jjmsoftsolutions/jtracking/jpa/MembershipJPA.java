package com.jjmsoftsolutions.jtracking.jpa;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import com.jjmsoftsolutions.jtracking.specification.Account;
import com.jjmsoftsolutions.jtracking.specification.MembershipHistory;
import com.jjmsoftsolutions.jtracking.specification.Membership;
import com.jjmsoftsolutions.jtracking.specification.Role;
import com.jjmsoftsolutions.jtracking.specification.enums.MembershipType;

@Entity
@Table(name = "Membership")
public class MembershipJPA implements Membership {

	@Id
    @TableGenerator( name = "membership_generator", table = "generated_keys", pkColumnName = "pk_column", valueColumnName = "value_column", pkColumnValue = "membership_id", initialValue = 1, allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.TABLE, generator = "membership_generator" )
	private Integer id;
	
	@Column(name = "name", nullable = false, length=100) private String name;
	@Column(name = "token", nullable = false, length=100) private String token;
	@OneToMany(mappedBy="membership", targetEntity=MembershipHistoryJPA.class) private Set<MembershipHistory> history;
	@Column(name = "active", nullable = false) private Boolean active;
	@ManyToOne(targetEntity=AccountJPA.class) @JoinColumn(name="account_id") private Account account;
	@Column( name = "type" ) @Enumerated( EnumType.STRING ) private MembershipType type;
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Set<Role> getRoles() {
		return null;
	}

	@Override
	public void setRoles(Set<Role> roles) {
	}

	@Override
	public Account getAccount() {
		return account;
	}

	@Override
	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public Set<MembershipHistory> getHistory() {
		if (history == null) {
			history = new HashSet<>();
		}
		return history;
	}

	@Override
	public void setHistory(Set<MembershipHistory> history) {
		this.history = history;
	}

	@Override
	public Boolean isActive() {
		return active;
	}

	@Override
	public void setActive(Boolean active) {
		this.active = active;
	}

	@Override
	public MembershipHistory addHistoryRecord(MembershipHistory record) {
		getHistory().add(record);
		record.setMembership(this);
		return record;
	}

	@Override
	public MembershipHistory removeHistoryRecord(MembershipHistory record) {
		getHistory().remove(record);
		record.setMembership(null);
		return record;
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
	public MembershipType getType() {
		return type;
	}

	@Override
	public void setType(MembershipType type) {
		this.type = type;
	}

}