package com.APILoader.Config;


public class DataConfig {
	
	private String path;
	private String file;
	
	public DataConfig() {
		this.path = "";
		this.file = "";
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
}
