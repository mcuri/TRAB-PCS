package br.com.pcs.curso.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Curso{

	/*Rela��o de alunos matriculados, estruturada na forma de um map String -> Aluno,
	onde a chave � a matr�cula do aluno e o valor de cada entrada � o objeto Aluno
	correspondente a essa matr�cula.*/
	private Map<String, Aluno> matriculaAlunoMap;
	
	/*Rela��o de disciplinas, estruturada na forma de um map String -> Disciplina, onde a
	chave � o c�digo da disciplina e o valor de cada entrada � o objeto Disciplina
	correspondente a esse c�digo.*/
	private Map<String, Disciplina> codDisciplinaMap;
	
	//Rela��o de turmas, estruturada na forma de um conjunto de turmas.
	private Set<Turma> turmas;
	
	public Curso() {
		matriculaAlunoMap = new HashMap<String, Aluno>();
		codDisciplinaMap = new HashMap<String, Disciplina>();
		turmas = new HashSet<Turma>();
	}

	public Disciplina registrarDisciplina(String codigoDisciplina, String nomeDisciplina){
		Disciplina disciplina = new Disciplina(codigoDisciplina, nomeDisciplina);
		codDisciplinaMap.put(codigoDisciplina, disciplina);
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

	public Map<String, Aluno> getMatriculaAlunoMap() {
		return matriculaAlunoMap;
	}

	public Map<String, Disciplina> getCodDisciplinaMap() {
		return codDisciplinaMap;
	}

	public Set<Turma> getTurmas() {
		return turmas;
	}

	public void setMatriculaAlunoMap(Map<String, Aluno> matriculaAlunoMap) {
		this.matriculaAlunoMap = matriculaAlunoMap;
	}

	public void setCodDisciplinaMap(Map<String, Disciplina> codDisciplinaMap) {
		this.codDisciplinaMap = codDisciplinaMap;
	}

	public void setTurmas(Set<Turma> turmas) {
		this.turmas = turmas;
	}
	
	public void printCodDisciplinaMap() {
		for(String cod: this.codDisciplinaMap.keySet()){
			System.out.println("Codigo: " + cod + " Disciplina: " + this.codDisciplinaMap.get(cod).getNome());
		}
	}
	
	public void printMatriculaAlunoMap() {
		for(String cod: this.matriculaAlunoMap.keySet()){
			System.out.println("MATRICULA: " + cod + " ALUNO: " + this.matriculaAlunoMap.get(cod).getNome());
		}
	}
	
	public void printTurmas() {
		for(Turma turma: turmas) {
			System.out.println("Turmas: " + turma.getPeriodo());
			System.out.println("Alunos: ");
			turma.printAlunoNotas();
		}
	}
	
	
	
	
	
}
