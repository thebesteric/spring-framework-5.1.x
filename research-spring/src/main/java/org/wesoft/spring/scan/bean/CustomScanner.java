package org.wesoft.spring.scan.bean;

import org.springframework.beans.factory.annotation.AnnotatedBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.TypeFilter;

import java.io.IOException;

/**
 * CustomScanner
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-05-24 21:29
 * @since 1.0
 */
public class CustomScanner extends ClassPathBeanDefinitionScanner {

	public CustomScanner(BeanDefinitionRegistry registry) {
		super(registry);
	}

	// @Override
	// protected boolean isCandidateComponent(AnnotatedBeanDefinition beanDefinition) {
	// 	addIncludeFilter(new TypeFilter() {
	// 		@Override
	// 		public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
	// 			return true;
	// 		}
	// 	});
	// 	return beanDefinition.getMetadata().isInterface();
	// }
}
