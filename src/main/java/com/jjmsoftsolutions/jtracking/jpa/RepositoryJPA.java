package com.jjmsoftsolutions.jtracking.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.jjmsoftsolutions.jtracking.specification.Repository;
import com.jjmsoftsolutions.jtracking.specification.enums.RepositoryType;

@Entity
@Table(name = "Repository")
public class RepositoryJPA implements Repository {

	@Id
    @TableGenerator( name = "repository_generator", table = "generated_keys", pkColumnName = "pk_column", valueColumnName = "value_column", pkColumnValue = "repository_id", initialValue = 1, allocationSize = 1 )
    @GeneratedValue( strategy = GenerationType.TABLE, generator = "repository_generator" )
	private Integer id;
	
	@Column(name = "name", nullable = false, length=100) private String name;
	@Column(name = "type", nullable = false, length=10) @Enumerated( EnumType.STRING ) private RepositoryType type;
	
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
	public RepositoryType getType() {
		return type;
	}

	@Override
	public void setType(RepositoryType type) {
		this.type = type;
	}
	
}