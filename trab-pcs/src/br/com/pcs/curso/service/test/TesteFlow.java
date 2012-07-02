package br.com.pcs.curso.service.test;

import java.io.IOException;

import br.com.pcs.curso.model.Curso;
import br.com.pcs.curso.service.ReadDisciplina;
import br.com.pcs.curso.service.RegisterInCurso;
import br.com.pcs.curso.service.XMLInputEncoder;
import br.com.pcs.curso.service.XMLReader;
import br.com.pcs.curso.swing.ChooseFile;

public class TesteFlow {

	public static void main(String[] args) throws IOException{
		
		XMLReader reader = new XMLReader();
		Curso curso = (Curso) reader.read();
		
		ChooseFile chooseFile = new ChooseFile();
	
		ReadDisciplina read = new ReadDisciplina(chooseFile.choose());
		RegisterInCurso register = new RegisterInCurso(curso, read.readText());
		
		XMLInputEncoder encoder = new XMLInputEncoder();
		encoder.encode(curso);
		
		
	}
}
