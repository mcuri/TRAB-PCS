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

	/*Relação de alunos matriculados, estruturada na forma de um map String -> Aluno,
	onde a chave é a matrícula do aluno e o valor de cada entrada é o objeto Aluno
	correspondente a essa matrícula.*/
	Map<String, Aluno> matriculaAlunoMap;
	
	/*Relação de disciplinas, estruturada na forma de um map String -> Disciplina, onde a
	chave é o código da disciplina e o valor de cada entrada é o objeto Disciplina
	correspondente a esse código.*/
	Map<String, Disciplina> codDisciplinaMap;
	
	//Relação de turmas, estruturada na forma de um conjunto de turmas.
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
		/*Se já existir uma turma referente à mesma disciplina/período, a turma existente 
		 deve ser removida do conjunto e a nova turma será acrescentada ao conjunto (significando 
		 um reprocessamento do arquivo correspondente a essa turma).*/
		
		Turma turma = new Turma(disciplina, periodo);
		turmas.add(turma);
		return turma;
	}
	
	public Aluno registrarAluno(String matriculaAluno, String nomeAluno){
		/* Essa operação deve verificar se existe uma entrada com o código do aluno. 
		Se não existir, uma nova entrada deve ser adicionada. Esta operação deve retornar 
		a instância de Aluno criada (se for um aluno novo) ou recuperada da estrutura 
		(se o aluno já existir).*/
		
		Aluno aluno = new Aluno(matriculaAluno, nomeAluno);
		matriculaAlunoMap.put(aluno.getMatricula(), aluno);
	
		return aluno;
	}
	
	
	
	
}
