package com.rafaelsantos.tcc.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelsantos.tcc.entidades.Pagamento;

public interface RepositorioPagamentos extends JpaRepository<Pagamento, Integer> {

}
