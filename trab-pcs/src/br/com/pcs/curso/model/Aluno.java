package br.com.pcs.curso.model;

import java.util.HashSet;
import java.util.Set;

public class Aluno {

	private String matricula;
	private String nome;
	//turmas que o aluno cursou, na forma de um conjunto (Set) de objetos da classe Turma
	Set<Turma> turmas;
	
	public Aluno(String matricula, String nome) {
		turmas = new HashSet<Turma>();
		this.matricula = matricula;
		this.nome = nome;
	}
	
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void addTurma(Turma turma){
		turmas.add(turma);
	}
	
	
}
