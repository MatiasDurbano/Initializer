package com.initializer;
import java.util.List;

import com.apiloader.JavaSearcher;
import com.apiloader.JavaSearcherImpl;
import com.instancebuilder.InstanceBuilder;
import com.instancebuilder.InstanceBuilderImpl;



public class InitializerImpl implements Initializer{

	public InitializerImpl() {
	}
	
	public List<Object> getInstance() {
		JavaSearcher searcher = new JavaSearcherImpl();
   	 	InstanceBuilder builder= new InstanceBuilderImpl();
   	 	return builder.createInstances(searcher.searchFiles());
	}
}
