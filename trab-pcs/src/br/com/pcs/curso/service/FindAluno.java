package br.com.pcs.curso.service;

import java.util.Map;
import java.util.Set;

import br.com.pcs.curso.model.Aluno;
import br.com.pcs.curso.model.Curso;
import br.com.pcs.curso.model.Turma;

public class FindAluno {
	
	public Aluno find(Curso curso, String matricula) {
		Map<String, Aluno> alunos = curso.getMatriculaAlunoMap();
		
		/*� Nome do aluno
		  � N�mero total de disciplinas cursadas
		  � N�mero de aprova��es (disciplinas onde ele tenha ficado com m�dia >= 50)
		  � N�mero de reprova��es (disciplinas onde ele tenha ficado com m�dia < 50)
		  � M�dia geral do aluno nas disciplinas em que ele cursou.*/
		Aluno aluno = null;
		
		if(!alunos.get(matricula).equals(null)){
			aluno = alunos.get(matricula);
			aluno.getNome();
			
			Set<Turma> turmas = aluno.getTurmas();
			
			
		} else {
			System.out.println("Aluno n�o encontrado");
		}
		return aluno;
		
		
	}
	
	public static void main(String[] args) {
		
		
	}
	
}
