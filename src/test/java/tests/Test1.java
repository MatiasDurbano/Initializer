package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.apiloader.JavaSearcher;
import com.apiloader.JavaSearcherImpl;
import com.configloader.PropertiesLoader;

class Test1 {
	
	@Test()
	void dataConfigNotNull() {
		PropertiesLoader fileSearch = PropertiesLoader.getPropertiesLoader();
		assertEquals("NetworkImpl",fileSearch.getDataConfig().getFile());
		assertEquals("D://programacion//eclipse-workspace//PRUEBAPP2",fileSearch.getDataConfig().getPath());
		assertEquals("D://programacion//eclipse-workspace//PRUEBAPP2//dependencies",fileSearch.getDataConfig().getDependencies());
	}
	

}
