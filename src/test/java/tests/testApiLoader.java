package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.APILoader.JavaSearcher;
import com.APILoader.JavaSearcherImpl;
import com.APILoader.Config.PropertiesLoader;

class testApiLoader {
	
	
	@Test()
	void dataConfigNull() {
		PropertiesLoader fileSearch = new PropertiesLoader();
		fileSearch.setAddress("H:\\NoEXISTO");
		assertEquals("",fileSearch.getDataConfig().getFile());
		assertEquals("",fileSearch.getDataConfig().getPath());		
	}
	
	@Test()
	void dataConfigNotNull() {
		//leo todo desde el path por default
		PropertiesLoader fileSearch = new PropertiesLoader();
		fileSearch.readProperties();
		assertNotNull(fileSearch.getDataConfig().getFile());
		assertEquals("NetworkImpl",fileSearch.getDataConfig().getFile());
		
		assertNotNull(fileSearch.getDataConfig().getPath());
		assertEquals("D://programacion//eclipse-workspace//PRUEBAPP2",fileSearch.getDataConfig().getPath());
	}
	
	@Test()
	void javaSearcherImplDefault() {
		JavaSearcher java = new JavaSearcherImpl();
		assertTrue(java.searchFiles().size()>0);
	}
	
	@Test()
	void javaSearcherImplNotDefault() {
		//se pasa por parametro un properties con un mal path,
		//no deberia encontrar archivos
		PropertiesLoader fileSearch = new PropertiesLoader();
		fileSearch.setAddress("H:\\NoEXISTO");
		JavaSearcher java = new JavaSearcherImpl(fileSearch);
		assertTrue(java.searchFiles().size()==0);
	}
	

}
