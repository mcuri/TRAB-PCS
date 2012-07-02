package br.com.pcs.curso.service.test;

import java.io.IOException;

import br.com.pcs.curso.model.Curso;
import br.com.pcs.curso.service.ReadDisciplina;
import br.com.pcs.curso.service.RegisterInCurso;
import br.com.pcs.curso.service.XMLInputEncoder;
import br.com.pcs.curso.service.XMLReader;
import br.com.pcs.curso.swing.ChooseFile;

public class TesteSemXML {

	public static void main(String[] args) throws IOException{
		
		try{
			XMLReader reader = new XMLReader();
			Curso curso = (Curso) reader.read();
			
			System.out.println("antes:");
			curso.printCodDisciplinaMap();
			curso.printMatriculaAlunoMap();
			curso.printTurmas();
			
			ChooseFile chooseFile = new ChooseFile();
			
			ReadDisciplina read = new ReadDisciplina(chooseFile.choose());
			RegisterInCurso register = new RegisterInCurso(curso, read.readText());
			
			System.out.println("depois:");
			curso.printCodDisciplinaMap();
			curso.printMatriculaAlunoMap();
			curso.printTurmas();
			
			XMLInputEncoder encoder = new XMLInputEncoder();
			encoder.encode(curso);
		
		}catch(IOException e){
			ChooseFile chooseFile = new ChooseFile();
			
			Curso cursoNovo = new Curso();
			ReadDisciplina read = new ReadDisciplina(chooseFile.choose());
			RegisterInCurso register = new RegisterInCurso(cursoNovo, read.readText());
			
			XMLInputEncoder encoder = new XMLInputEncoder();
			encoder.encode(cursoNovo);
		}
		
		
	}
}
