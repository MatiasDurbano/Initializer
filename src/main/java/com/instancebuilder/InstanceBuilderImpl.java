package com.instancebuilder;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.dependenciesloader.DependenciesLoader;
import com.dependenciesloader.DependenciesLoaderImpl;
import com.interfaces.Network;


public class InstanceBuilderImpl implements InstanceBuilder{
	
	private DependenciesLoader dependenciesLoader;
	
	public InstanceBuilderImpl() {
		dependenciesLoader = new DependenciesLoaderImpl();	
	}

	@Override
	public List<Object> createInstances(Map<File,String> files) {
		List<Object> networkObjects = new ArrayList<Object>();
		
		try {
			ClassLoader classLoader = dependenciesLoader.loadDependency();
			for (Map.Entry<File, String> entry : files.entrySet()) {			
				classLoader = URLClassLoader.newInstance(new URL[]{entry.getKey().toURI().toURL()},
						classLoader);
				Class<?> classToLoad = Class.forName(entry.getValue(), true, classLoader);
				Class<? extends Network> sub = classToLoad.asSubclass(Network.class);
		    	/* Get the default constructor. */
		    	Constructor<? extends Network> defaultConstructor = sub.getConstructor();
				Network networkInstance = defaultConstructor.newInstance();
				
				networkObjects.add(networkInstance);
				
			}
		} catch (MalformedURLException | ClassNotFoundException | NoSuchMethodException
					| SecurityException |InvocationTargetException |IllegalArgumentException
					|IllegalAccessException |InstantiationException e) 
		{
			System.out.println("error al generar instancias : "+ e) ;
		}
		
		return networkObjects;
		
	}
}
