package com.cogent.Q2.service;

import java.util.List;

import com.cogent.Q2.entity.Author;

public interface AuthorService {
	public Author saveOrUpdateAuthor(Author author);
	public Author findAuthorById(Long authorId);
	public List<Author> findAllAuthors();
	public void deleteAuthorById(Long authorId);
}
