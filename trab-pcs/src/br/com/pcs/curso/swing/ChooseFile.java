package br.com.pcs.curso.swing;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

import br.com.pcs.curso.service.InputReader;

public class ChooseFile {
	
	public static void choose(){
		try{
			JFileChooser fileChooser = new JFileChooser();
			int retorno = fileChooser.showOpenDialog(null);
			
			if(retorno == JFileChooser.APPROVE_OPTION){
				FileReader reader = new FileReader(fileChooser.getSelectedFile());
				InputReader input = new InputReader(reader);
				//atualizar XML antigo
				try {
					input.readText();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		choose();
	}

}
