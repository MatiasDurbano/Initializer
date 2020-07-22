import java.io.File;
import java.util.Map;

import com.apiloader.JavaSearcher;
import com.apiloader.JavaSearcherImpl;
import com.dependencyloader.DependencyLoader;
import com.dependencyloader.DependencyLoaderImpl;
import com.instancebuilder.InstanceBuilder;
import com.instancebuilder.InstanceBuilderImpl;

public class main {

	public static void main(String[] args) {

//		PropertiesLoader fileSearch = new PropertiesLoader();
//		//System.out.println(fileSearch.getDataConfig().getFile());
//		//System.out.println(fileSearch.getDataConfig().getPath());
//		
		JavaSearcher java = new JavaSearcherImpl();
		InstanceBuilder builder = new InstanceBuilderImpl();
//		
//		builder.createInstances(java.searchFiles());
		System.out.println(builder.createInstances(java.searchFiles()).size());
//		Initializer init = new InitializerImpl();
//		System.out.println(init.getInstance().size());
		
	}

}
