package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.apiloader.JavaSearcher;
import com.apiloader.JavaSearcherImpl;
import com.configloader.PropertiesLoader;
import com.instancebuilder.InstanceBuilder;
import com.instancebuilder.InstanceBuilderImpl;

class Test6 {

	@Test
	void test() {
		PropertiesLoader fileSearch = PropertiesLoader.getPropertiesLoader();
		fileSearch.setAddress("H:\\NoEXISTO");
		JavaSearcher searcher = new JavaSearcherImpl();
		InstanceBuilder builder = new InstanceBuilderImpl();
		assertTrue(builder.createInstances(searcher.searchFiles()).size()==0);
	}

}
