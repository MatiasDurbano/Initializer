package com.configloader;


public class DataConfig {
	
	private String path;
	private String file;
	private String pathDependencies;
	
	public DataConfig() {
		this.path = "";
		this.file = "";
		this.pathDependencies = "";
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
	
	public void setDependencies(String pathDependencies) {
		 this.pathDependencies = pathDependencies;
	}
	
	public String getDependencies() {
		 return this.pathDependencies;
	}

	
}
