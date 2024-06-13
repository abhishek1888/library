package com.hexa.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hexa.library.dto.LibraryDTO;
import com.hexa.library.service.LibraryService;


@RestController
@RequestMapping("/api/books")
@CrossOrigin(origins ="*")
public class LibraryController {
        
	@Autowired
	LibraryService libraryService;
	
	
	@GetMapping("/getAllbooks")
	public ResponseEntity<List<LibraryDTO>> getAllbooks()
	{
		 return ResponseEntity.ok().body(libraryService.getAllbooks());
	}
	
	@GetMapping("/getbookbyid")
	public ResponseEntity<LibraryDTO> getBooksByid(@RequestParam long iSBN)
	{
		return ResponseEntity.ok().body(libraryService.getBookbyId(iSBN));
	}
	
	@PostMapping("/createbook")
	public ResponseEntity<LibraryDTO> createbook(@RequestBody LibraryDTO libraryDTO)
	{
		return ResponseEntity.ok().body(libraryService.createBook(libraryDTO));
	}
	
	@PutMapping("/updatebook")
	public ResponseEntity<LibraryDTO> updatebook(@RequestBody LibraryDTO libraryDTO,@RequestParam long iSBN)
	{
		return ResponseEntity.ok().body(libraryService.updateBook(libraryDTO, iSBN));
	}
	
	@DeleteMapping("/deletebook")
	public ResponseEntity<String> deleteBookById(@RequestParam long iSBN)
	{
		 return ResponseEntity.ok().body(libraryService.deleteBook(iSBN));
	}
	
}
