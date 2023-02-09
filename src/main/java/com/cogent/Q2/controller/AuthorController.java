package com.cogent.Q2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cogent.Q2.entity.AuthRequest;
import com.cogent.Q2.entity.Author;
import com.cogent.Q2.service.AuthorServiceImpl;
import com.cogent.Q2.util.JwtUtil;
/**
 * 
 * @author: William U. Amaechi
 * @date: 	Feb 9, 2023
 */
@RestController
@RequestMapping("/api")
public class AuthorController {

	@Autowired
	AuthorServiceImpl authorService;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;


	//Default Screen
	@GetMapping("/")
	public String welcome() {
		return "Spring Boot Assessment Q2";
	}

	//Get All Authors
	@GetMapping(value= {"/authors"})
	public List<Author> findAll(){
		List<Author> authors = authorService.findAllAuthors();
		System.out.println("Number of Authors: "+ authors.size());
		return authors;
	}
	//Get An Author
	@GetMapping("/authors/{id}")
	public Author findAuthor(@PathVariable("id") Long id) {
		return authorService.findAuthorById(id);
	}
	//Insert An Author
	@PostMapping("/authors")
	public Author add(@Validated @RequestBody Author author) {
		return authorService.saveOrUpdateAuthor(author);
	}
	//Update An Author
	@PutMapping("/authors")
	public Author update(@Validated @RequestBody Author author) {
		return authorService.saveOrUpdateAuthor(author);
	}
	//Delete An Author
	@DeleteMapping("/authors/{id}")
	public String delete(@PathVariable("id") Long id) {
		authorService.deleteAuthorById(id);
		return "Author ID:" + id + " has been deleted";
	}

	//Converts valid username and password into an authentication token
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid username/password");
        }
        return jwtUtil.generateToken(authRequest.getUserName());
    }

}
