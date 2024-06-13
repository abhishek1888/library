package com.hexa.library.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hexa.library.dto.LibraryDTO;

@Service
public interface LibraryService {
   public List<LibraryDTO> getAllbooks();
   public LibraryDTO getBookbyId(long iSBN);
   public LibraryDTO createBook(LibraryDTO libraryDTO);
   public LibraryDTO updateBook(LibraryDTO libraryDTO,long iSBN);
   public String deleteBook(long iSBN);
}
