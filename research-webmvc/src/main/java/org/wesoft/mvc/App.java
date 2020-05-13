package org.wesoft.mvc;

import org.apache.catalina.*;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.swing.*;
import java.io.File;

public class App {

	public static void main(String[] args) throws Exception {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8080);

		// Context context = tomcat.addContext("/", System.getProperty("java.io.tmpdir"));
		// context.addLifecycleListener((LifecycleListener) Class.forName(tomcat.getHost().getConfigClass()).newInstance());

		String sourcePath = App.class.getResource("/").getPath();
		Context ctx = tomcat.addWebapp("/", new File("research-webmvc/src/webapp").getAbsolutePath());
		WebResourceRoot resources = new StandardRoot(ctx);
		resources.addPreResources(new DirResourceSet(resources, "/production/classes", sourcePath, "/"));
		ctx.setResources(resources);

		tomcat.start();
		tomcat.getServer().await();
	}

}
