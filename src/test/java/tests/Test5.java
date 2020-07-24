package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.apiloader.JavaSearcher;
import com.apiloader.JavaSearcherImpl;
import com.instancebuilder.InstanceBuilder;
import com.instancebuilder.InstanceBuilderImpl;
import com.interfaces.Network;

class Test5 {

	@Test
	void test() {
		JavaSearcher searcherDefault = new JavaSearcherImpl();
		InstanceBuilder builder = new InstanceBuilderImpl();
		List<Object> objects = new ArrayList<Object>();
		objects=builder.createInstances(searcherDefault.searchFiles());
		assertTrue(objects.size()==1);
		for( Object obj : objects) {
			assertTrue(obj instanceof Network);
		}
	}

}
