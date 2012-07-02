package br.com.pcs.curso.service;

import java.util.Set;

import br.com.pcs.curso.model.Aluno;
import br.com.pcs.curso.model.Curso;
import br.com.pcs.curso.model.Turma;

public class RegisterInCurso {

	public RegisterInCurso(Curso curso, Turma turma){
		curso.registrarTurma(turma.getDisciplina(), turma.getPeriodo());
		curso.registrarDisciplina(turma.getDisciplina());
		
		Set<Aluno> alunos = turma.getAlunoNotas().keySet();
		for(Aluno aluno: alunos){
			curso.registrarAluno(aluno.getMatricula(), aluno.getNome());
		}
		
	}
	
}
