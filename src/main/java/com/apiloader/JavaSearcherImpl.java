package com.apiloader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.jar.JarFile;
import java.util.stream.Stream;

import com.configloader.PropertiesLoader;


public class JavaSearcherImpl implements JavaSearcher {

	private PropertiesLoader fileSearch;
	private Map<File,String> files;
	private String path;
	private String fileToFind;
	
	public JavaSearcherImpl() {
		this.fileSearch = PropertiesLoader.getPropertiesLoader();
		this.path = fileSearch.getDataConfig().getPath();
		this.fileToFind = fileSearch.getDataConfig().getFile();
		this.files= new HashMap<File,String>();
	}
	
	public JavaSearcherImpl(PropertiesLoader fileSearch) {
		this.fileSearch = fileSearch;
		this.path = this.fileSearch.getDataConfig().getPath();
		this.fileToFind = this.fileSearch.getDataConfig().getFile();
		this.files= new HashMap<File,String>();
	}
	
	@Override
	public Map<File,String> searchFiles() {
		
		try (Stream<Path> paths = Files.walk(Paths.get(this.path))) {	
		    paths
		        .filter(Files -> Files.getFileName().toString().contains(".jar") )
		        .forEach(Files-> {
		        	this.readJar(Files.getParent().toString()+"\\"+Files.getFileName().toString());
		        });
		    
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.files;	
		
	}
	
	private void readJar(String path) {

		try{   
	         JarFile jarFile = new JarFile(path);  
	         Enumeration enumOfJar = jarFile.entries();   
	         while (enumOfJar.hasMoreElements()) {
	        	String file = enumOfJar.nextElement().toString();
	        	if(file.contains(this.fileToFind)) {
	        		File jar = new File(path);
	        		files.put(jar, stringParse(file));
	        	}  
	         } 
	      }catch(IOException ioe)
	      {
	         System.out.println("IOException: " + ioe);
	      }
		
	}
	
	private String stringParse(String toParse) {
		toParse = toParse.replace('/', '.');
		toParse = toParse.replace(".class", "");
		return toParse;
		
	}
	
	
}
