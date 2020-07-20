package com.APILoader.Config;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class AbsolutFileSearch implements PropertiesFileSearch {
	
	private String path = "D:\\programacion\\eclipse-workspace\\Initializer\\src\\main\\java\\com"
			+ "\\APILoader\\Config\\file.properties";
	 
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
