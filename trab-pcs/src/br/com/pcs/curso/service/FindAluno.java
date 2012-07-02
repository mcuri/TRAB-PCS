package br.com.pcs.curso.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import br.com.pcs.curso.model.Aluno;
import br.com.pcs.curso.model.Curso;
import br.com.pcs.curso.model.Turma;

public class FindAluno {
	
	public Aluno find(String matricula, Curso curso) {
		
		/*· Nome do aluno
		  · Número total de disciplinas cursadas
		  · Número de aprovações (disciplinas onde ele tenha ficado com média >= 50)
		  · Número de reprovações (disciplinas onde ele tenha ficado com média < 50)
		  · Média geral do aluno nas disciplinas em que ele cursou.*/
		
		Map<String, Aluno> alunos = curso.getMatriculaAlunoMap();
		Aluno aluno = null;
		
		if(!alunos.get(matricula).equals(null)){
			aluno = alunos.get(matricula);
		} else {
			System.out.println("Aluno não encontrado");
		}
		return aluno;
	}
	
	public String getNomeAluno(Aluno aluno){
		return aluno.getNome();
	}
	
	public int getTotalDisciplinasCursadas(Aluno aluno) {
		return aluno.getTurmas().size();
	}
	
	public int getNumeroDeAprovacoes(Aluno aluno) {
		int totalAprovacoes = 0;
		Set<Turma> turmas = aluno.getTurmas();
		for(Turma turma: turmas){
			List<Integer> notas= turma.getAlunoNotas().get(aluno.getMatricula());
			int sumNotas = 0;
			for(Integer nota: notas){
				sumNotas += nota;
			}
			if((sumNotas/3) >= 5){
				totalAprovacoes += 1;
			}
		}
		return totalAprovacoes;
	}
	
	public int getNumeroDeReprovacoes(Aluno aluno) {
		int totalReprovacoes = 0;
		Set<Turma> turmas = aluno.getTurmas();
		for(Turma turma: turmas){
			List<Integer> notas= turma.getAlunoNotas().get(aluno.getMatricula());
			int sumNotas = 0;
			for(Integer nota: notas){
				sumNotas += nota;
			}
			if((sumNotas/3) <= 5){
				totalReprovacoes += 1;
			}
		}
		return totalReprovacoes;
	}
	
	public int getMediaGeral(Aluno aluno) {
		Set<Turma> turmas = aluno.getTurmas();
		int sumNotas = 0;
		int qtdNotas = 0;
		for(Turma turma: turmas){
			List<Integer> notas= turma.getAlunoNotas().get(aluno.getMatricula());

			for(Integer nota: notas){
				qtdNotas += 1;
				sumNotas += nota;
			}
		}
		return sumNotas/qtdNotas;
	}
	
	
}
