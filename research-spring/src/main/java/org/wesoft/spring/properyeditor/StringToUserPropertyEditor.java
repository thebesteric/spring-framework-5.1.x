package org.wesoft.spring.properyeditor;

import java.beans.PropertyEditor;
import java.beans.PropertyEditorSupport;

/**
 * StringToUserPropertyEditor
 *
 * @author Eric Joe
 * @version 1.0
 * @date 2020-10-12 20:45
 * @since 1.0
 */
public class StringToUserPropertyEditor extends PropertyEditorSupport implements PropertyEditor {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		User user = new User();
		user.setName(text);
		this.setValue(user);
	}
}
