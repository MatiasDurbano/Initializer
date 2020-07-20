package com.Initializer;
import java.util.List;

import com.APILoader.JavaSearcher;
import com.APILoader.JavaSearcherImpl;
import com.InstanceBuilder.InstanceBuilder;
import com.InstanceBuilder.InstanceBuilderImpl;



public class InitializerImpl implements Initializer{

	public InitializerImpl() {
	}
	
	public List<Object> getInstance() {
		JavaSearcher searcher = new JavaSearcherImpl();
   	 	InstanceBuilder builder= new InstanceBuilderImpl();
   	 	return builder.createInstances(searcher.searchFiles());
	}
}
