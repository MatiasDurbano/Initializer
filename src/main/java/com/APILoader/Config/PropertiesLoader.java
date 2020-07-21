package com.APILoader.Config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



public class PropertiesLoader {
	private PropertiesFileSearch fileSercher;
	private Properties properties;
	private DataConfig data;
	
	public PropertiesLoader() {
		
		this.fileSercher = new AbsolutFileSearch();
		this.properties = new Properties();
		this.data = new DataConfig();
	}
	
	public void readProperties() {
		try {
			FileReader file = fileSercher.getFileAddress();
			properties.load(file);			
			this.readPath();
			this.readFile();
			this.readDependencies();
			}
		catch (IOException e) {
			System.out.println("no se puede leer el archivo properties en initializer");
		}
	}
	
	public void readPath() {
		String path = properties.getProperty("path");
		if(path == null) 	
			System.out.println("Directorio no definido");				
		data.setPath(path);
		
	}
	
	public void readFile() {
		String file = properties.getProperty("archivo");
		if(file == null) 	
			System.out.println("archivo no definido");				
		data.setFile(file);;
		
	}
	
	public void readDependencies() {
		String dependency = properties.getProperty("dependencies");
		if(dependency == null) 	
			System.out.println("archivo no definido");				
		data.setDependencies(dependency);;
		
	}
	 
	public DataConfig getDataConfig() {
		return data;
	}
	
	public void setAddress(String Address) {
		fileSercher.setAddress(Address);
		readProperties();
	}
	
}
