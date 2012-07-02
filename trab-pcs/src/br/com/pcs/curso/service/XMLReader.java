package br.com.pcs.curso.service;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

import br.com.pcs.curso.model.Curso;

public class XMLReader {

	public Object read() throws IOException {
		
		XMLDecoder decoder = new XMLDecoder(
							new BufferedInputStream( 
									new FileInputStream("curso.xml")));
		
		Curso curso = (Curso) decoder.readObject(); 
		decoder.close();
		return curso;
	}
}
