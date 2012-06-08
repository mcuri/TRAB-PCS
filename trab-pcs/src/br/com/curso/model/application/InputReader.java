package br.com.curso.model.application;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.pcs.curso.model.Aluno;
import br.com.pcs.curso.model.Curso;
import br.com.pcs.curso.model.Disciplina;
import br.com.pcs.curso.model.Turma;

public class InputReader {

	String readFile() throws IOException {
		System.out.println("Reading from file.");
		StringBuffer text = new StringBuffer();
		Scanner scanner = new Scanner(new FileInputStream("input.txt"));
		try {
			while (scanner.hasNextLine()){
				text.append(scanner.nextLine() + "_");
			}
		}
		finally{
			scanner.close();
		}
		System.out.println(text);
		return text.toString();
	}
	
	Disciplina readDisciplina(String disciplinaLine) throws IOException {
		String disciplina[] = disciplinaLine.split(";");
		return new Disciplina(disciplina[0], disciplina[1]);	
	}
	
	Turma readTurma(String turmaLine, Disciplina d) throws IOException {
		String turma[] = turmaLine.split(";");
		return new Turma(d, turma[2]);
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
	
	public static void main(String[] args) throws IOException {
		
		InputReader input = new InputReader(); 
		String buffer = input.readFile();
		String lines[] = buffer.split("_");
		
		Curso curso = new Curso();
		//reading disciplina line
		Disciplina disciplina = input.readDisciplina(lines[0]);
		curso.registrarDisciplina(disciplina);
	
		Turma turma = input.readTurma(lines[0], disciplina);
		curso.registrarTurma(disciplina, turma.getPeriodo());

		//reading alunos lines
		for(int i = 1; i < lines.length; i++){
			System.out.println(lines[i]);
			Aluno a = input.readAluno(lines[i]);
			curso.registrarAluno(a.getMatricula(), a.getNome());
	
			List<Integer> notas = input.readNotas(lines[i]);
	
			turma.adicionarAlunoNotas(a, notas);
			
			a.addTurma(turma);
		}
		
		System.out.println(turma.getDisciplina().getCodigo() + " " + turma.getPeriodo());
		turma.printAlunoNotas();
		XMLGenerator.generate(curso);
		
			
	}
}	










