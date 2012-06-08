package br.com.curso.model.application;

import java.beans.XMLEncoder;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class XMLGenerator {

	public static void generate(Object object) throws IOException{

		XMLEncoder e = new XMLEncoder(
			    			new ObjectOutputStream(
			    			new FileOutputStream("Curso.xml")));
		
		e.writeObject(object);
		e.close();
	}
}
