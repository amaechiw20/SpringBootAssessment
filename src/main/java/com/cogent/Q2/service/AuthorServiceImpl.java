package com.cogent.Q2.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cogent.Q2.entity.Author;
import com.cogent.Q2.repo.AuthorRepo;

@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepo authorRepo;
	
	@Override
	//Saves or Updates Author to H2 DB
	public Author saveOrUpdateAuthor(Author author) {
		return authorRepo.save(author);
	}

	@Override
	//Finds Author by Author ID
	public Author findAuthorById(Long authorId) {
		 return authorRepo.findById(authorId).get();
	}

	@Override
	//Finds all Authors in H2 DB
	public List<Author> findAllAuthors() {
		List<Author> authors = new ArrayList<Author>();
		for(Author author : authorRepo.findAll()) {
			authors.add(author);
		}
		return authors;
	}

	@Override
	//Deletes Author in H2 DB by Author ID
	public void deleteAuthorById(Long authorId) {
		authorRepo.deleteById(authorId);
	}
}
