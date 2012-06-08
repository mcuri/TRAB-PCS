package br.com.pcs.curso.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Curso implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 76238739187987L;

	/*Rela��o de alunos matriculados, estruturada na forma de um map String -> Aluno,
	onde a chave � a matr�cula do aluno e o valor de cada entrada � o objeto Aluno
	correspondente a essa matr�cula.*/
	Map<String, Aluno> matriculaAlunoMap;
	
	/*Rela��o de disciplinas, estruturada na forma de um map String -> Disciplina, onde a
	chave � o c�digo da disciplina e o valor de cada entrada � o objeto Disciplina
	correspondente a esse c�digo.*/
	Map<String, Disciplina> codDisciplinaMap;
	
	//Rela��o de turmas, estruturada na forma de um conjunto de turmas.
	Set<Turma> turmas;
	
	
	
	public Curso() {
		matriculaAlunoMap = new HashMap<String, Aluno>();
		codDisciplinaMap = new HashMap<String, Disciplina>();
		turmas = new HashSet<Turma>();
	}

	public Disciplina registrarDisciplina(Disciplina disciplina){
		codDisciplinaMap.put(disciplina.getCodigo(), disciplina);
		return disciplina;
	}
	
	public Turma registrarTurma(Disciplina disciplina, String periodo){
		/*Se j� existir uma turma referente � mesma disciplina/per�odo, a turma existente 
		 deve ser removida do conjunto e a nova turma ser� acrescentada ao conjunto (significando 
		 um reprocessamento do arquivo correspondente a essa turma).*/
		
		Turma turma = new Turma(disciplina, periodo);
		turmas.add(turma);
		return turma;
	}
	
	public Aluno registrarAluno(String matriculaAluno, String nomeAluno){
		/* Essa opera��o deve verificar se existe uma entrada com o c�digo do aluno. 
		Se n�o existir, uma nova entrada deve ser adicionada. Esta opera��o deve retornar 
		a inst�ncia de Aluno criada (se for um aluno novo) ou recuperada da estrutura 
		(se o aluno j� existir).*/
		
		Aluno aluno = new Aluno(matriculaAluno, nomeAluno);
		matriculaAlunoMap.put(aluno.getMatricula(), aluno);
	
		return aluno;
	}
	
	
	
	
}
