package br.com.pcs.curso.service;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class XMLEncoderToFile {
	
	public void generate(Object object) throws IOException{

		XMLEncoder e = new XMLEncoder(
						new BufferedOutputStream(
			    			new FileOutputStream("Curso.xml")));
		
		e.writeObject(object);
		e.close();
	}
}
