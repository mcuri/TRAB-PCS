package br.com.pcs.curso.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("turma")
public class Turma {

	private Disciplina disciplina;
	private String periodo;
	/*Alunos e suas notas, estruturado na forma de um map Aluno -> List<Integer>, onde a
	chave é um objeto aluno e o valor de cada entrada é a lista de notas obtidas pelo
	aluno naquela disciplina/período.*/
	Map<Aluno, List<Integer>> alunoNotas;
	
	public Turma(Disciplina disciplina, String periodo) {
		this.alunoNotas = new HashMap<Aluno, List<Integer>>();
		this.disciplina = disciplina;
		this.periodo = periodo;
	}
	
	/*List<Integer> readNotas(){
		List<Integer> notas = new ArrayList<Integer>();
		
		//return notas; 
	}*/
	
	public void adicionarAlunoNotas(Aluno aluno, List<Integer> notas){
		alunoNotas.put(aluno, notas);
	}
	
	public void printAlunoNotas(){
		 for (Iterator it = alunoNotas.keySet().iterator(); it.hasNext();) { 
			 Object key = it.next();  
	         Object item = alunoNotas.get(key);
	         System.out.println(item.toString());
		 }
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplia(Disciplina disciplina) {
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
