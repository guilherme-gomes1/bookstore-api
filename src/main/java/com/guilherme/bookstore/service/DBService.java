package com.guilherme.bookstore.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilherme.bookstore.domain.Categoria;
import com.guilherme.bookstore.domain.Livro;
import com.guilherme.bookstore.repositories.CategoriaRepository;
import com.guilherme.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;
	
	public void instanciaBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
		Categoria cat2 = new Categoria(null, "Ciências", "Livros de ciências");
		Categoria cat3 = new Categoria(null, "História", "Livros de história");
		Categoria cat4 = new Categoria(null, "Matemática", "Livros de matemática");
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum", cat1);
		Livro l2 = new Livro(null, "Ciências biologicas", "Ramon Dino", "Lorem ipsum", cat2);
		Livro l3 = new Livro(null, "A história do Brasil", "Theo Afonso", "Lorem ipsum", cat3);
		
		cat1.getLivros().addAll(Arrays.asList(l1));
		cat2.getLivros().addAll(Arrays.asList(l2));
		cat3.getLivros().addAll(Arrays.asList(l3));
		cat4.getLivros().addAll(Arrays.asList());
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3));
		
	}

}
