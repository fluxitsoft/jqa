/*******************************************************************************
 * Copyright (c) 2013 Flux IT.
 * 
 * This file is part of JQA (http://github.com/fluxitsoft/jqa).
 * 
 * JQA is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as 
 * published by the Free Software Foundation, either version 3 of 
 * the License, or (at your option) any later version.
 * 
 * JQA is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY 
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General 
 * Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public 
 * License along with JQA. If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package ar.com.fluxit.jqa.viewer;

import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.swt.graphics.Image;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class JavaElementsColumnLabelProvider extends ColumnLabelProvider {

	private final JavaElementLabelProvider wrapped;

	public JavaElementsColumnLabelProvider(
			JavaElementLabelProvider javaElementLabelProvider) {
		this.wrapped = javaElementLabelProvider;
	}

	@Override
	public Image getImage(Object element) {
		return getWrapped().getImage(element);
	}

	@Override
	public String getText(Object element) {
		return getWrapped().getText(element);
	}

	@Override
	public String getToolTipText(Object element) {
		if (element instanceof IPackageFragment) {
			IPackageFragment packageFragment = (IPackageFragment) element;
			try {
				int length = packageFragment.getCompilationUnits().length;
				StringBuffer result = new StringBuffer(length * 20);
				for (int i = 0; i < length; i++) {
					result.append(packageFragment.getCompilationUnits()[i]
							.getElementName());
					if (i + 1 < length) {
						result.append("\n");
					}
				}
				return result.toString();
			} catch (JavaModelException e) {
				return null;
			}
		} else {
			return null;
		}
	}

	public JavaElementLabelProvider getWrapped() {
		return wrapped;
	}

}
