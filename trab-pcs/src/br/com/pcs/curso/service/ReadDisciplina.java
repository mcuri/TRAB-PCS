package br.com.pcs.curso.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.com.pcs.curso.model.Aluno;
import br.com.pcs.curso.model.Curso;
import br.com.pcs.curso.model.Disciplina;
import br.com.pcs.curso.model.Turma;

public class ReadDisciplina {

	BufferedReader buffer = null;
	public ReadDisciplina(FileReader file) {
		buffer = new BufferedReader(file);
	}
	
	public Turma readText() throws IOException{
		StringBuffer text = new StringBuffer();
		String str;
		while((str = buffer.readLine()) != null) {
			text.append(str + "_");
		}
		
		String lines[] = text.toString().split("_");

		for(String s: lines){
			System.out.println(s);
		}
		
		//reading disciplina line
		Disciplina disciplina = readDisciplina(lines[0]);
		
		Turma turma = readTurma(lines[0], disciplina);
		turma.setDisciplina(disciplina);
		
		//reading alunos lines
		for(int i = 1; i < lines.length; i++){
			Aluno aluno = readAluno(lines[i]);
			System.out.println("LENDO:     Aluno: " + aluno.getNome() + " Matricula: " + aluno.getMatricula());
	
			turma.adicionarAlunoNotas(aluno, readNotas(lines[i]));
			aluno.addTurma(turma);
		
			System.out.println("Turmas: ");
			aluno.printTurmas();
		}
		
		//System.out.println(turma.getDisciplina().getCodigo() + " " + turma.getPeriodo());
		turma.printAlunoNotas();
	
		return turma;
	}
	
	Disciplina readDisciplina(String disciplinaLine) throws IOException {
		String disciplina[] = disciplinaLine.split(";");
		return new Disciplina(disciplina[0], disciplina[1]);	
	}
	
	Turma readTurma(String turmaLine, Disciplina disciplina) throws IOException {
		String turma[] = turmaLine.split(";");
		return new Turma(disciplina, turma[2]);
	}
	
	Aluno readAluno(String alunoLine) throws IOException {
		String aluno[] = alunoLine.split(";");
		return new Aluno(aluno[0], aluno[1]);
	}
	
	List<Integer> readNotas(String notasLine) throws IOException {
		String notas[] = notasLine.split(";");
		List<Integer> notasList = new ArrayList<Integer>();
		notasList.add(Integer.parseInt(notas[2]));
		notasList.add(Integer.parseInt(notas[3]));
		notasList.add(Integer.parseInt(notas[4]));
		return notasList;
	}
}
