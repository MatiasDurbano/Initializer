package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.apiloader.JavaSearcher;
import com.apiloader.JavaSearcherImpl;
import com.configloader.PropertiesLoader;

class Test4 {

	@Test
	void test() {
		PropertiesLoader fileSearch = PropertiesLoader.getPropertiesLoader();
		fileSearch.setAddress("H:\\NoEXISTO");
		JavaSearcher java = new JavaSearcherImpl();
		assertTrue(java.searchFiles().size()==0);
	}

}
