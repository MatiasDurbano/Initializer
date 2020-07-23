package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.apiloader.JavaSearcher;
import com.apiloader.JavaSearcherImpl;


class Test3 {

	@Test
	void test() {
		JavaSearcher java = new JavaSearcherImpl();
		Map<File,String> ret = java.searchFiles();
		
		File file = new File("D://programacion//eclipse-workspace//PRUEBAPP2//twitter.jar");
		assertTrue(ret.size()==1);
		assertTrue(ret.containsKey(file));
		assertTrue(ret.get(file).equals("com.twitter.TwitterNetworkImpl"));
		
	
	}

}
