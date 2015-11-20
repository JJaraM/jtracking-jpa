package com.jjmsoftsolutions.jtracking.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.jjmsoftsolutions.jtracking.specification.Account;

@Entity
@Table(name = "Account")
@Component
@Scope(value = BeanDefinition.SCOPE_PROTOTYPE)
public class AccountEntity implements Account {
	
	@Id
    @TableGenerator( name = "account_generator", table = "generated_keys", pkColumnName = "pk_column", valueColumnName = "value_column", pkColumnValue = "account_id", initialValue = 1, allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.TABLE, generator = "account_generator" )
	private Integer id;
	
	@Column(name = "name", nullable = false, length=100) private String name;
	@Column(name = "token", nullable = false, length=100) private String token;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
