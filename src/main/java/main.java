import java.io.File;
import java.util.Map;

import com.APILoader.JavaSearcher;
import com.APILoader.JavaSearcherImpl;
import com.DependencyLoader.DependencyLoader;
import com.DependencyLoader.DependencyLoaderImpl;
import com.InstanceBuilder.InstanceBuilder;
import com.InstanceBuilder.InstanceBuilderImpl;

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
