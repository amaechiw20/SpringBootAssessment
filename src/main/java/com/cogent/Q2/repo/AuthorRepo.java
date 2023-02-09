package com.cogent.Q2.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cogent.Q2.entity.Author;
@Repository
public interface AuthorRepo extends CrudRepository<Author,Long> {

}
