package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.configloader.PropertiesLoader;

class Test2 {

	@Test
	void test() {
		PropertiesLoader fileSearch = PropertiesLoader.getPropertiesLoader();;
		fileSearch.setAddress("H:\\NoEXISTO");
		assertEquals("",fileSearch.getDataConfig().getFile());
		assertEquals("",fileSearch.getDataConfig().getPath());	
		assertEquals("",fileSearch.getDataConfig().getDependencies());	
	}

}
