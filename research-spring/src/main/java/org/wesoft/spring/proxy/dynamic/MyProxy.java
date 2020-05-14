package org.wesoft.spring.proxy.dynamic;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * TODO
 *
 * @author Eric Joe
 * @version Ver 1.0
 * @build 2020-05-14 15:38
 */
public class MyProxy {

	public static final String LINE = "\n";
	public static final String TAB = "\t";

	@SuppressWarnings("unchecked")
	public static <T> T getInstance(Object target, MyInvocationHandler handler) {

		Class<?> clazz = target.getClass().getInterfaces()[0];

		String interfaceName = clazz.getSimpleName();

		String packageContent = "package org.eric.proxy;" + LINE;
		String importContent = "import " + clazz.getName() + ";" + LINE;
		importContent += "import " + MyInvocationHandler.class.getName() + ";" + LINE;

		String clazzFirstLineContent = "public class $Proxy implements " + interfaceName + " {" + LINE;
		String fieldContent = TAB + "private " + interfaceName + " target;" + LINE;
		fieldContent += TAB + "private MyInvocationHandler handler;" + LINE;

		String constructorContent = TAB + "public $Proxy(" + interfaceName + " target, MyInvocationHandler handler) {" + LINE;
		constructorContent += TAB + TAB + "this.target = target;" + LINE;
		constructorContent += TAB + TAB + "this.handler = handler;" + LINE;
		constructorContent += TAB + "}" + LINE;

		String methodContent = "";
		Method[] methods = clazz.getDeclaredMethods();
		for (Method method : methods) {
			Class<?>[] args = method.getParameterTypes();
			String argsContent = "";
			String paramsContent = "";
			int flag = 0;
			for (Class<?> arg : args) {
				String temp = arg.getSimpleName();
				// String p0, String p1,
				argsContent += temp + " p" + flag + ", ";
				// p0, p1,
				paramsContent += "p" + flag + ", ";
				flag++;
			}
			if (args.length > 0) {
				argsContent = argsContent.substring(0, argsContent.lastIndexOf(","));
				paramsContent = paramsContent.substring(0, paramsContent.lastIndexOf(","));
			}

			String returnTypeName = method.getReturnType().getSimpleName();
			String methodName = method.getName();

			methodContent += TAB + "public " + returnTypeName + " " + methodName + "(" + argsContent + ") {" + LINE;
			methodContent += TAB + TAB + "handler.invoke();" + LINE;
			methodContent += TAB + TAB + "target." + methodName + "(" + paramsContent + ");" + LINE;
			methodContent += TAB + "}" + LINE;
		}

		String content = packageContent + importContent + clazzFirstLineContent + fieldContent + constructorContent + methodContent + "}";

		try {
			File file = new File("d:\\org\\eric\\proxy\\$Proxy.java");
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			if (!file.exists()) {
				file.createNewFile();
			}
			FileWriter fw = new FileWriter(file);
			fw.write(content);
			fw.flush();
			fw.close();

			JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
			StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
			Iterable<? extends JavaFileObject> javaFileObjects = fileManager.getJavaFileObjects(file);
			JavaCompiler.CompilationTask t = compiler.getTask(null, fileManager, null, null, null, javaFileObjects);
			t.call();
			fileManager.close();

			URL[] urls = new URL[]{new URL("file:D:\\\\")};
			URLClassLoader urlClassLoader = new URLClassLoader(urls);
			Class<?> aClass = urlClassLoader.loadClass("org.eric.proxy.$Proxy");
			Constructor<?> constructor = aClass.getConstructor(clazz, MyInvocationHandler.class);
			return (T) constructor.newInstance(target, handler);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

}
