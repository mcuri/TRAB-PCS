package br.com.pcs.curso.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Turma {

	private Disciplina disciplina;
	private String periodo;
	/*Alunos e suas notas, estruturado na forma de um map Aluno -> List<Integer>, onde a
	chave é um objeto aluno e o valor de cada entrada é a lista de notas obtidas pelo
	aluno naquela disciplina/período.*/
	private Map<Aluno, List<Integer>> alunoNotas;
	
	public Turma() {
		super();
	}

	public Turma(Disciplina disciplina, String periodo) {
		this.alunoNotas = new HashMap<Aluno, List<Integer>>();
		this.disciplina = disciplina;
		this.periodo = periodo;
	}
	
	public void adicionarAlunoNotas(Aluno aluno, List<Integer> notas){
		alunoNotas.put(aluno, notas);
	}
	
	public void printAlunoNotas(){
		for(Aluno aluno: this.alunoNotas.keySet()){
			System.out.println("ALUNO: " + aluno.getNome());
			System.out.println("NOTAS:" );
			for(Integer nota: alunoNotas.get(aluno)){
				System.out.println(nota);
			}
		}
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public String getPeriodo() {
		return periodo;
	}
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	public Map<Aluno, List<Integer>> getAlunoNotas() {
		return alunoNotas;
	}
	public void setAlunoNotas(Map<Aluno, List<Integer>> alunoNotas) {
		this.alunoNotas = alunoNotas;
	}
	
	
	
}
