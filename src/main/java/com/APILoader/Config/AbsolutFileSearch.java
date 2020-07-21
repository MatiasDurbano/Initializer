package com.APILoader.Config;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class AbsolutFileSearch implements PropertiesFileSearch {
	
	private String path = "D:\\programacion\\eclipse-workspace\\PRUEBAPP2\\properties\\initializer.properties";
	 
	public AbsolutFileSearch() {
	}			
	
	public FileReader getFileAddress() throws FileNotFoundException	{
		FileReader fileReader = new FileReader(path);
		return fileReader;
	}	
	
	public void setAddress(String newPath) {
		this.path = newPath;
	}

}
