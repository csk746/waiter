package com.daou.waiter.user.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import com.daou.waiter.domain.BaseEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@Table(name="user", indexes = {@Index(columnList="loginId")})
public class User extends BaseEntity {
	
	@Column 
	String name ; 
	
	@Column 
	String loginId ; 
	
	@Column 
	String password ;
	
	@Column 
	int grade ; 
	
	@Column 
	String phone; 
	
	@Column 
	String email ; 
	
}
