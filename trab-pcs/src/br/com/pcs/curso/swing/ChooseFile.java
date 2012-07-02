package br.com.pcs.curso.swing;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.swing.JFileChooser;

public class ChooseFile {

	public FileReader choose(){
		try{
			JFileChooser fileChooser = new JFileChooser();
			int retorno = fileChooser.showOpenDialog(null);

			if(retorno == JFileChooser.APPROVE_OPTION){
				return new FileReader(fileChooser.getSelectedFile());

			}
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		return null;
	}

}
