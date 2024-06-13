package com.hexa.library.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexa.library.dto.LibraryDTO;
import com.hexa.library.entity.Library;
import com.hexa.library.repository.LibraryRepository;
import com.hexa.library.service.LibraryService;

@Service
public class LibraryServiceImpl implements LibraryService{

	
	@Autowired
	private LibraryRepository libraryRepository;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public List<LibraryDTO> getAllbooks() {
		List<Library> libraryList=libraryRepository.findAll();
		
		return libraryList.stream().map(library->modelMapper.map(library,LibraryDTO.class)).collect(Collectors.toList());
	}

	@Override
	public LibraryDTO getBookbyId(long iSBN) {
		Library book=libraryRepository.findById(iSBN).get();
		
		return modelMapper.map(book, LibraryDTO.class);
	}

	@Override
	public LibraryDTO createBook(LibraryDTO libraryDTO) {
		Library tempbook=modelMapper.map(libraryDTO,Library.class);
		Library book=libraryRepository.save(tempbook);
		return modelMapper.map(book,LibraryDTO.class);
	}

	@Override
	public LibraryDTO updateBook(LibraryDTO libraryDTO, long iSBN) {
		Library book=libraryRepository.findById(iSBN).get();
		if(libraryDTO.getTitle()!=null)
			book.setTitle(libraryDTO.getTitle());
		if(libraryDTO.getAuthor()!=null)
			book.setAuthor(libraryDTO.getAuthor());
		if(libraryDTO.getGenre()!=null)
			book.setGenre(libraryDTO.getGenre());
		if(libraryDTO.getPublicationYear()!=null)
			book.setPublicationYear(libraryDTO.getPublicationYear());
		if(libraryDTO.getPublisher()!=null)
			book.setPublisher(libraryDTO.getPublisher());
		if(libraryDTO.getTotalcopies()!=0)
			book.setTotalcopies(libraryDTO.getTotalcopies());
		Library updatedbook=libraryRepository.save(book);
		return modelMapper.map(updatedbook,LibraryDTO.class);
	}

	@Override
	public String deleteBook(long iSBN) {
		libraryRepository.deleteById(iSBN);
		return "boook deleted";
	}

	

}
