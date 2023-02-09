package com.cogent.Q2.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author: William U. Amaechi
 * @date: 	Feb 9, 2023
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="USER_TBL")
public class User {
	@Id
	private int id;
	private String userName;
	private String password;
	private String email;

}
