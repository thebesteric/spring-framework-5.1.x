package org.wesoft.spring.aop;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * SyntheticTest
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-05-30 17:36
 * @since 1.0
 */
public class SyntheticTest {

	public void showName() {
		SyntheticTestInner syntheticTestInner = new SyntheticTestInner();
		System.out.println(syntheticTestInner.name);
	}


	class SyntheticTestInner {
		private String name = "SyntheticTestInner";

		private SyntheticTestInner() {

		}

	}

	public static void main(String[] args) {
		new SyntheticTest().showName();

		for (Method declaredMethod : SyntheticTestInner.class.getDeclaredMethods()) {
			System.out.println(declaredMethod.getName() + ", Synthetic = " + declaredMethod.isSynthetic());
		}

		for (Constructor<?> declaredConstructor : SyntheticTestInner.class.getDeclaredConstructors()) {

			String parameters = "";
			for (Class<?> parameterType : declaredConstructor.getParameterTypes()) {
				parameters += parameterType.getName() + ", ";
			}
			parameters = parameters.trim();
			if (parameters.lastIndexOf(",") == parameters.length() - 1) {
				parameters = parameters.substring(0, parameters.length() - 1);
			}
			System.out.println(declaredConstructor.getName() + "(" + parameters + "), Synthetic = " + declaredConstructor.isSynthetic());
		}

	}

}
