package com.rafaelsantos.tcc.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rafaelsantos.tcc.entidades.Aluno;

public interface RepositorioAlunos extends JpaRepository<Aluno, Integer> {

}
