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

import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.internal.core.search.JavaWorkspaceScope;
import org.eclipse.jdt.internal.ui.dialogs.FilteredTypesSelectionDialog;
import org.eclipse.jdt.ui.dialogs.TypeSelectionExtension;
import org.eclipse.jface.operation.IRunnableContext;
import org.eclipse.jface.viewers.DialogCellEditor;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;

/**
 * TODO javadoc
 * TODO see restrictions
 * @author Juan Ignacio Barisich
 */
@SuppressWarnings("restriction")
public class TypeCellEditor extends DialogCellEditor {

	private final IRunnableContext context;
	private final int elementKinds;
	private final String initialPattern;
	private final TypeSelectionExtension extension;

	public TypeCellEditor(Composite parent, IRunnableContext context) {
		this(parent, context, IJavaSearchConstants.CLASS_AND_INTERFACE, "",
				null);
	}

	public TypeCellEditor(Composite parent, IRunnableContext context,
			int elementKinds, String initialPattern,
			TypeSelectionExtension extension) {
		super(parent);
		this.context = context;
		this.elementKinds = elementKinds;
		this.initialPattern = initialPattern;
		this.extension = extension;
	}

	private IRunnableContext getContext() {
		return context;
	}

	@Override
	protected Object openDialogBox(Control cellEditorWindow) {
		final FilteredTypesSelectionDialog dialog;
		if (this.extension == null) {
			dialog = new FilteredTypesSelectionDialog(
					cellEditorWindow.getShell(), false, getContext(),
					new JavaWorkspaceScope(), elementKinds);
		} else {
			dialog = new FilteredTypesSelectionDialog(
					cellEditorWindow.getShell(), false, getContext(),
					new JavaWorkspaceScope(), this.elementKinds, this.extension);
		}
		dialog.setBlockOnOpen(true);
		dialog.setInitialPattern(this.initialPattern);
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
