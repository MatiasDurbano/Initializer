package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.apiloader.JavaSearcher;
import com.apiloader.JavaSearcherImpl;
import com.configloader.PropertiesLoader;
import com.instancebuilder.InstanceBuilder;
import com.instancebuilder.InstanceBuilderImpl;
import com.interfaces.Network;



class Test7 {
	
	
	@Test
	void test() {
		Map<File, String> map = new HashMap<File, String>();
		map.put(new File("h:/noexisto"), "com.noexisto.claseInexsistente");
		
		InstanceBuilder builder = new InstanceBuilderImpl();
		List<Object> objects = new ArrayList<Object>();
		objects=builder.createInstances(map);
		assertTrue(objects.size()==0);
		
	}
}
