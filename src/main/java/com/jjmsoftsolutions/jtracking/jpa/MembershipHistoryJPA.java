package com.jjmsoftsolutions.jtracking.jpa;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.jjmsoftsolutions.jtracking.specification.Membership;
import com.jjmsoftsolutions.jtracking.specification.MembershipHistory;

@Entity
@Table(name = "MembershipHistory")
public class MembershipHistoryJPA implements MembershipHistory {
	
	@Id
    @TableGenerator( name = "membership_generator", table = "generated_keys", pkColumnName = "pk_column", valueColumnName = "value_column", pkColumnValue = "membership_id", initialValue = 1, allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.TABLE, generator = "membership_generator" )
	private Integer id;
	
	@ManyToOne(targetEntity=MembershipJPA.class) @JoinColumn(name="membership_id") private Membership membership;
	@Column(name = "message", nullable = false, length=100) private String message;
	@Temporal(TemporalType.TIMESTAMP) @Column(name = "date", nullable = false) private Date date;
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public Membership getMembership() {
		return membership;
	}

	@Override
	public void setMembership(Membership membership) {
		this.membership = membership;
		
	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public void setDate(Date date) {
		this.date = date;
	}

	

}
