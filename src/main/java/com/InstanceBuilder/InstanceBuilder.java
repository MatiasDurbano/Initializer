package com.InstanceBuilder;

import java.io.File;
import java.util.List;
import java.util.Map;

public interface InstanceBuilder {
	
	List<Object>createInstances(Map<File,String> toInstances);
	
}
