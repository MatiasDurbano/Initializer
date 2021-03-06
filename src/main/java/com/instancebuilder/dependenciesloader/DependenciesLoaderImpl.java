package com.instancebuilder.dependenciesloader;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import com.configloader.PropertiesLoader;

public class DependenciesLoaderImpl implements DependenciesLoader {
	
	private PropertiesLoader fileSearch;
	private String pathDependencies ;
	private ClassLoader classLoader;
	
	public DependenciesLoaderImpl() {
		fileSearch = PropertiesLoader.getPropertiesLoader();
		this.pathDependencies = fileSearch.getDataConfig().getDependencies();
		classLoader = ClassLoader.getSystemClassLoader();
		
	}
	
	@Override
	public ClassLoader loadDependencies() {
		try (Stream<Path> paths = Files.walk(Paths.get(this.pathDependencies))) {	
		    paths
		        .filter(Files -> Files.getFileName().toString().contains(".jar") )
		        .forEach(Files-> {
		        	File jar = new File(Files.getParent().toString()+"\\"+Files.getFileName().toString());
		        	
		        	try {
						this.classLoader = URLClassLoader.newInstance(new URL[]{jar.toURI().toURL()},
								ClassLoader.getSystemClassLoader());
					} catch (MalformedURLException e) {
						System.out.println("Error al cargar las dependencias" + e);
					}
		        	
		        });
		    
		} catch (IOException e) {
			System.out.println("Error al cargar las dependencias" + e);
		}
		
		return this.classLoader;
	}

}
