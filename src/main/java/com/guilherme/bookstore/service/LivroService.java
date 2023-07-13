package com.guilherme.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.bookstore.domain.Livro;
import com.guilherme.bookstore.dtos.LivroDTO;
import com.guilherme.bookstore.repositories.LivroRepository;
import com.guilherme.bookstore.service.exceptions.ObjectNotFoundException;

import java.util.List;

@Service
public class LivroService {

	@Autowired
	private LivroRepository repository;
	
	@Autowired
	private CategoriaService categoriaService;

	public Livro findById(Integer id) {
		Optional<Livro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Livro não encontrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
	}
	
	public List<Livro> findAll() {
		return repository.findAll();
	}
	
	public List<Livro> findAllByCategory(Integer id_cat) {
		categoriaService.findById(id_cat);
		return repository.findAllByCategory(id_cat);
	}
	
	public Livro update(Integer id, LivroDTO objDto) {
		Livro obj = findById(id);
		obj.setTitulo(objDto.getTitulo());
		return repository.save(obj);
	}
	
	public Livro create(Livro obj) {
		obj.setId(null);
		return repository.save(obj);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
}
