package com.config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;



public class PropertiesLoader {
	private PropertiesFileSearch fileSercher;
	private Properties properties;
	private DataConfig data;
	
	private static PropertiesLoader propertiesLoader;
	
	public  static PropertiesLoader getPropertiesLoader() {
		 
		 if (propertiesLoader==null) {
			 propertiesLoader=new PropertiesLoader();
		 }
		 
		 return propertiesLoader;
		 }
	
	private  PropertiesLoader() {
		
		this.fileSercher = new AbsolutFileSearch();
		this.properties = new Properties();
		this.data = new DataConfig();
		this.readProperties();
	}
	
	private void readProperties() {
		try {
			this.data = new DataConfig();
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
	
	private void readPath() {
		String path = properties.getProperty("path");
		if(path == null) 	
			System.out.println("Directorio no definido");				
		data.setPath(path);
		
	}
	
	private void readFile() {
		String file = properties.getProperty("archivo");
		if(file == null) 	
			System.out.println("archivo no definido");				
		data.setFile(file);;
		
	}
	
	private void readDependencies() {
		String dependency = properties.getProperty("dependencies");
		if(dependency == null) 	
			System.out.println("archivo no definido");				
		data.setDependencies(dependency);;
		
	}
	 
	public DataConfig getDataConfig() {
		return data;
	}
	
	public void setAddress(String Address) {
		this.fileSercher.setAddress(Address);
		this.readProperties();
	}
	
}
