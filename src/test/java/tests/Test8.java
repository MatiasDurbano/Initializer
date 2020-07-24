package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import com.apiloader.JavaSearcher;
import com.apiloader.JavaSearcherImpl;
import com.instancebuilder.InstanceBuilder;
import com.instancebuilder.InstanceBuilderImpl;

class Test8 {

	@Test
	void test() {
		JavaSearcher searcherDefault = new JavaSearcherImpl();
		InstanceBuilder builder = new InstanceBuilderImpl();
		List<Object> objects = new ArrayList<Object>();
		Map<File,String> apis = searcherDefault.searchFiles();
		assertTrue(apis.size() == 1);
		objects=builder.createInstances(apis);
		assertTrue(objects.size() == 0);
	}
}
