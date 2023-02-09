package com.cogent.Q2;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cogent.Q2.entity.Author;
import com.cogent.Q2.entity.User;
import com.cogent.Q2.repo.AuthorRepo;
import com.cogent.Q2.repo.UserRepo;

@SpringBootApplication
public class SpringAssessmentApplication {
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private AuthorRepo authorRepo;
	
	@PostConstruct
	public void registerUsersAndAuthors(){
		List<User> users = Stream.of(
				new User(101, "will", "password", "will@gmail.com"),
				new User(102, "frank", "password01", "fran@gmail.com"),
				new User(103, "bernard", "password02", "bern@gmail.com")
				).collect(Collectors.toList());
		userRepo.saveAll(users);
		
		List<Author> authors = Stream.of(
				new Author(444, "Tim", "145 Ray Road.", 9086668978L),
				new Author(445, "Mike", "09 Passover St.", 3434355534L),
				new Author(446, "Wendy", "90 Arch Ave.", 3223551234L)
				).collect(Collectors.toList());
		authorRepo.saveAll(authors);
	}
	

	public static void main(String[] args) {
		SpringApplication.run(SpringAssessmentApplication.class, args);
	}

}
