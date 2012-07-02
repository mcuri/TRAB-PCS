package br.com.pcs.curso.service;

import java.util.Set;

import br.com.pcs.curso.model.Aluno;
import br.com.pcs.curso.model.Curso;
import br.com.pcs.curso.model.Turma;

public class RegisterInCurso {

	public RegisterInCurso(Curso curso, Turma turma){
		
		System.out.println("TURMA NA CLASSE DE REGISTRO:  ");
		turma.printAlunoNotas();
		System.out.println("Disciplina: " + turma.getDisciplina().getNome());
		System.out.println("Periodo: " + turma.getPeriodo());
		System.out.println("END");
		
		curso.registrarDisciplina(turma.getDisciplina().getCodigo(), turma.getDisciplina().getNome());
		
		curso.registrarTurma(turma.getDisciplina(), turma.getPeriodo());
		
		Set<Aluno> alunos = turma.getAlunoNotas().keySet();
		
		for(Aluno aluno: alunos){
			System.out.println("Registering: " + aluno.getNome());
			curso.registrarAluno(aluno.getMatricula(), aluno.getNome());
		}
		
	}
	
}
