package br.com.pcs.curso.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.pcs.curso.model.Aluno;
import br.com.pcs.curso.model.Curso;
import br.com.pcs.curso.model.Disciplina;
import br.com.pcs.curso.model.Turma;

public class InputReader {
		
	BufferedReader buffer = null;
	public InputReader(FileReader file) {
		buffer = new BufferedReader(file);
	}
	
	public InputReader() {
		super();
	}

	public Object readText() throws IOException{
		StringBuffer text = new StringBuffer();
		String str;
		while((str = buffer.readLine()) != null) {
			text.append(str + "_");
		}
		
		String lines[] = text.toString().split("_");

		Curso curso = new Curso();
		
		//reading disciplina line
		Disciplina disciplina = readDisciplina(lines[0]);
		curso.registrarDisciplina(disciplina);
		
		Turma turma = readTurma(lines[0], disciplina);
		curso.registrarTurma(disciplina, turma.getPeriodo());

		//reading alunos lines
		for(int i = 1; i < lines.length; i++){
			Aluno aluno = readAluno(lines[i]);
			System.out.println("Aluno: " + aluno.getNome() + "Matricula: " + aluno.getMatricula());
			curso.registrarAluno(aluno.getMatricula(), aluno.getNome());
	
			List<Integer> notas = readNotas(lines[i]);
			turma.adicionarAlunoNotas(aluno, notas);
			aluno.addTurma(turma);
		}
		
		System.out.println(turma.getDisciplina().getCodigo() + " " + turma.getPeriodo());
		turma.printAlunoNotas();
	
		return curso;
	}
	
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
		//System.out.println(text);
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
	
	public static void main(String[] args) throws IOException, JAXBException {
		
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
			Aluno aluno = input.readAluno(lines[i]);
			System.out.println("Aluno: " + aluno.getNome() + "Matricula: " + aluno.getMatricula());
			curso.registrarAluno(aluno.getMatricula(), aluno.getNome());
	
			List<Integer> notas = input.readNotas(lines[i]);
	
			turma.adicionarAlunoNotas(aluno, notas);
			
			aluno.addTurma(turma);
		}
		
		System.out.println(turma.getDisciplina().getCodigo() + " " + turma.getPeriodo());
		turma.printAlunoNotas();
		
		XStreamXMLEncoder encoder = new XStreamXMLEncoder();
		encoder.encode(curso, "curso.xml");
			
	}
}	










