package br.com.pcs.curso.service;

import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class XMLInputEncoder {
	
	public void encode(Object object) throws IOException{
		
		XMLEncoder xmlEncoder = new XMLEncoder(
									new BufferedOutputStream(
											new FileOutputStream("curso.xml")));
		
		xmlEncoder.writeObject(object);
		xmlEncoder.close();
	}

}
