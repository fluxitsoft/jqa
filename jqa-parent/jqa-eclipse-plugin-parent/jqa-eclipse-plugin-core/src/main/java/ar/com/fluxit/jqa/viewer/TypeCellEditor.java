/*******************************************************************************
 * Copyright (c) 2011 Juan Ignacio Barisich.
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

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.internal.core.search.JavaWorkspaceScope;
import org.eclipse.jdt.internal.ui.dialogs.FilteredTypesSelectionDialog;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class TypeCellEditor extends DialogCellEditor {

	private final IRunnableContext context;

	public TypeCellEditor(Composite parent, IRunnableContext context) {
		super(parent);
		this.context = context;
	}

	private IRunnableContext getContext() {
		return context;
	}

	@Override
	protected Object openDialogBox(Control cellEditorWindow) {
		final FilteredTypesSelectionDialog dialog = new FilteredTypesSelectionDialog(
				cellEditorWindow.getShell(), false, getContext(),
				new JavaWorkspaceScope(),
				IJavaSearchConstants.CLASS_AND_INTERFACE);
		dialog.setBlockOnOpen(true);
		final int returnCode = dialog.open();
		if (returnCode == Window.OK) {
			// TODO improve
			final IJavaElement selectedType = (IJavaElement) dialog
					.getFirstResult();
			final IJavaElement selectedPackage = selectedType.getParent()
					.getParent();
			return selectedPackage.getElementName() + "."
					+ selectedType.getElementName();
		} else {
			return null;
		}
	}

}
