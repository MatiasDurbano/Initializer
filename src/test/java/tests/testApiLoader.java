package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.apiloader.JavaSearcher;
import com.apiloader.JavaSearcherImpl;
import com.configloader.PropertiesLoader;

class testApiLoader {
	
	PropertiesLoader fileSearch = PropertiesLoader.getPropertiesLoader();
	
	@Test()
	void dataConfigNotNull() {
		//leo todo desde el path por default
		//path por default
		// por cuestiones de ser un singleton puede traer conflicto en los test 
		// por eso se lo paso como parametro
		fileSearch.setAddress("D:\\programacion\\eclipse-workspace\\PRUEBAPP2\\properties\\initializer.properties");
		assertNotNull(fileSearch.getDataConfig().getFile());
		assertEquals("NetworkImpl",fileSearch.getDataConfig().getFile());
		
		assertNotNull(fileSearch.getDataConfig().getPath());
		assertEquals("D://programacion//eclipse-workspace//PRUEBAPP2",fileSearch.getDataConfig().getPath());
	}
	
	@Test()
	void javaSearcherImplDefault() {
		//path por default
		// por cuestiones de ser un singleton puede traer conflicto en los test 
		// por eso se lo paso como parametro
		fileSearch.setAddress("D:\\programacion\\eclipse-workspace\\PRUEBAPP2\\properties\\initializer.properties");
		JavaSearcher java = new JavaSearcherImpl();
		System.out.println(java.searchFiles().size());
		assertTrue(java.searchFiles().size()>0);
	}
	

	@Test()
	void dataConfigNull() {
		PropertiesLoader fileSearch = PropertiesLoader.getPropertiesLoader();;
		fileSearch.setAddress("H:\\NoEXISTO");
		assertEquals("",fileSearch.getDataConfig().getFile());
		assertEquals("",fileSearch.getDataConfig().getPath());		
	}
	
	@Test()
	void javaSearcherImplNotDefault() {
		//se pasa por parametro un properties con un mal path,
		//no deberia encontrar archivos
		PropertiesLoader fileSearch = PropertiesLoader.getPropertiesLoader();
		fileSearch.setAddress("H:\\NoEXISTO");
		JavaSearcher java = new JavaSearcherImpl(fileSearch);
		assertTrue(java.searchFiles().size()==0);
	}
	

}
