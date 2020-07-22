package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.APILoader.JavaSearcher;
import com.APILoader.JavaSearcherImpl;
import com.Config.PropertiesLoader;
import com.InstanceBuilder.InstanceBuilder;
import com.InstanceBuilder.InstanceBuilderImpl;
import com.Interfaces.Network;



class testInstanceBuilder {
	
	@Test
	void instanceBuilderDefault() {
		JavaSearcher searcherDefault = new JavaSearcherImpl();
		InstanceBuilder builder = new InstanceBuilderImpl();
		List<Object> objects = new ArrayList<Object>();
		objects=builder.createInstances(searcherDefault.searchFiles());
		assertTrue(objects.size()>0);
		for( Object obj : objects) {
			assertTrue(obj instanceof Network);
		}
	}

	@Test
	void instanceBuilderNoDefault() {
		PropertiesLoader fileSearch = PropertiesLoader.getPropertiesLoader();
		fileSearch.setAddress("H:\\NoEXISTO");
		JavaSearcher searcher = new JavaSearcherImpl(fileSearch);
		InstanceBuilder builder = new InstanceBuilderImpl();
		assertTrue(builder.createInstances(searcher.searchFiles()).size()==0);
	}
	
	@Test
	void incorrectDictionary() {
		Map<File, String> map = new HashMap<File, String>();
		map.put(new File("h:/noexisto"), "com.noexisto.claseInexsistente");
		
		InstanceBuilder builder = new InstanceBuilderImpl();
		List<Object> objects = new ArrayList<Object>();
		objects=builder.createInstances(map);
		assertTrue(objects.size()==0);
		
	}
}
