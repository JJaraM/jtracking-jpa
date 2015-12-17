/*
 * Copyright (c) 2015, 2015 JJMSoftSolutions and/or its affiliates. All rights reserved.
 * JJMSOFTSOLUTIONS PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.jjmsoftsolutions.jtracking.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import com.jjmsoftsolutions.jtracking.specification.Account;
import com.jjmsoftsolutions.jtracking.specification.SingularId;
import com.jjmsoftsolutions.jtracking.specification.User;
/**
 * 
 *
 * Implementation of the {@link User} specification using JPA framework
 * <p>
 * 
 * @author Jonathan Jara Morales
 * @see User
 * @see SingularId
 * @since 0.0.1
 * @version 0.0.1
 *
 */
@Entity
@Table(name = "Uzer")
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class UserJPA implements User {

	@Id
    @TableGenerator( name = "uzer_generator", table = "generated_keys", pkColumnName = "pk_column", valueColumnName = "value_column", pkColumnValue = "uzer_id", initialValue = 1, allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.TABLE, generator = "uzer_generator" )
	private Integer id;
	
	@Column(name = "user_name", length = 20, nullable = false, unique = true) private String userName;
	@Column(name = "email", length = 60, nullable = false, unique= true) private String email;
	@Column(name = "password", length = 20, nullable = false) private String password;
	@Column(name = "name", length = 40) private String name;
	@Column(name = "last_name", length = 40) private String lastName;
	@Column(name = "authorization_Token", length = 100) private String authorizationToken;
	@OneToOne(targetEntity=AccountJPA.class) @JoinColumn(name="account_id", unique=true, nullable=false) private Account account;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAuthorizationToken() {
		return authorizationToken;
	}

	public void setAutuhorizationToken(String authorizationToken) {
		this.authorizationToken = authorizationToken;
	}

	@Override
	public Account getAccount() {
		return account;
	}

	@Override
	public void setAccount(Account account) {
		this.account = account;
	}	
}