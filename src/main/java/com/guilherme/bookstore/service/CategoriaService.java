package com.guilherme.bookstore.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.guilherme.bookstore.domain.Categoria;
import com.guilherme.bookstore.dtos.CategoriaDTO;
import com.guilherme.bookstore.repositories.CategoriaRepository;
import com.guilherme.bookstore.service.exceptions.ObjectNotFoundException;

import java.util.List;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repository;

	public Categoria findById(Integer id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria create(Categoria obj) {
		obj.setId(null);
		return repository.save(obj);
	}

	public Categoria update(Integer id, CategoriaDTO objDto) {
		Categoria obj = findById(id);
		obj.setNome(objDto.getNome());
		obj.setDescricao(objDto.getDescricao());
		return repository.save(obj);
	}

	public void delete(Integer id) {
		Categoria obj = findById(id);
		try {
			repository.deleteById(id);

		} catch (DataIntegrityViolationException e) {
			throw new com.guilherme.bookstore.service.exceptions.DataIntegrityViolationException(
					"Categoria não pode ser deletada! Categoria " +  obj.getNome() +  " Possui livros associados.");
		}
	}
}
