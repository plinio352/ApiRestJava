package br.com.pps.ApiRestJava.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pps.ApiRestJava.modelo.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {

}
