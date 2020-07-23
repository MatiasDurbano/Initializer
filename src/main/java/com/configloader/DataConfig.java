package com.configloader;


public class DataConfig {
	
	private String path;
	private String file;
	private String dependenciesPath;
	
	public DataConfig() {
		this.path = "";
		this.file = "";
		this.dependenciesPath = "";
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	
	public String getFile() {
		return file;
	}

	public void setFile(String filePath) {
		this.file = filePath;
	}
	
	public void setDependencies(String dependenciespath) {
		 this.dependenciesPath = dependenciespath;
	}
	
	public String getDependencies() {
		 return this.dependenciesPath;
	}

	
}
