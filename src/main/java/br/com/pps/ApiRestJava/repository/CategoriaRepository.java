package br.com.pps.ApiRestJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pps.ApiRestJava.modelo.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
