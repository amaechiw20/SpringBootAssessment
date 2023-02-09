package com.cogent.Q2.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Authors")
public class Author{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	long authorId;
	String authorName;
	String authorAddress;
	long authorPhone;

}
