package com.InstanceBuilder;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.DependencyLoader.DependencyLoader;
import com.DependencyLoader.DependencyLoaderImpl;
import com.Interfaces.Network;


public class InstanceBuilderImpl implements InstanceBuilder{
	
	public InstanceBuilderImpl() {}

	@Override
	public List<Object> createInstances(Map<File,String> files) {
		List<Object> networkObjects = new ArrayList<Object>();
		DependencyLoader dependencyLoader = new DependencyLoaderImpl();	
		
		try {
			ClassLoader classLoader = dependencyLoader.loadDependency();
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
