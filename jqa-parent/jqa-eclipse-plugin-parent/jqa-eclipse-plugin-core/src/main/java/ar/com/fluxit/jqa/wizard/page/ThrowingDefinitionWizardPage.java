/*******************************************************************************
 * Copyright (c) 2011 Flux IT.
 * 
 * This file is part of JQA (http://github.com/jbaris/jqa).
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
package ar.com.fluxit.jqa.wizard.page;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeHierarchy;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jdt.ui.dialogs.TypeSelectionExtension;
import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.dialogs.ISelectionStatusValidator;

import ar.com.fluxit.jqa.JQAEclipsePlugin;
import ar.com.fluxit.jqa.descriptor.LayerDescriptor;
import ar.com.fluxit.jqa.viewer.TypeCellEditor;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ThrowingDefinitionWizardPage extends AbstractWizardPage implements
		IPageChangedListener {

	public static final String PAGE_NAME = "ThrowingDefinitionWizardPage";
	private TableViewer layersTable;

	public ThrowingDefinitionWizardPage() {
		super(PAGE_NAME);
		setTitle("Throwing definition");
		setDescription("Define the type of the exceptions of each layer");
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);

		layersTable = new TableViewer(container, SWT.SINGLE | SWT.BORDER
				| SWT.V_SCROLL | SWT.H_SCROLL);
		layersTable.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
		layersTable.setContentProvider(ArrayContentProvider.getInstance());
		layersTable.getTable().setHeaderVisible(true);
		layersTable.getTable().setLinesVisible(true);

		TableViewerColumn layerColumn = new TableViewerColumn(layersTable,
				SWT.NONE);
		layerColumn.getColumn().setText("Layer");
		layerColumn.getColumn().setWidth(300);
		layerColumn.setLabelProvider(new ColumnLabelProvider() {
			@Override
			public String getText(Object element) {
				LayerDescriptor layer = (LayerDescriptor) element;
				return layer.getName();
			}
		});

		TableViewerColumn namePatternColumn = new TableViewerColumn(
				layersTable, SWT.NONE);
		namePatternColumn.getColumn().setWidth(300);
		namePatternColumn.getColumn().setText("Exception super type");
		namePatternColumn.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				LayerDescriptor layer = (LayerDescriptor) element;
				return layer.getExceptionSuperType();
			}

		});
		namePatternColumn.setEditingSupport(new EditingSupport(layersTable) {

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				TypeSelectionExtension extension = new TypeSelectionExtension() {

					@Override
					public ISelectionStatusValidator getSelectionValidator() {
						return new ISelectionStatusValidator() {
							@Override
							public IStatus validate(Object[] selection) {
								if (selection.length == 1) {
									try {
										IType type = (IType) selection[0];
										ITypeHierarchy hierarchy = type
												.newSupertypeHierarchy(new NullProgressMonitor());
										IType curr = type;
										while (curr != null) {
											if ("java.lang.Throwable".equals(curr.getFullyQualifiedName('.'))) { //$NON-NLS-1$
												return Status.OK_STATUS;
											}
											curr = hierarchy
													.getSuperclass(curr);
										}
									} catch (JavaModelException e) {
										Status status = new Status(
												IStatus.ERROR,
												JQAEclipsePlugin.PLUGIN_ID, e
														.getLocalizedMessage(),
												e);
										JQAEclipsePlugin.getDefault().getLog()
												.log(status);
										return Status.CANCEL_STATUS;
									}
								}
								return new Status(IStatus.ERROR,
										JQAEclipsePlugin.PLUGIN_ID,
										"Selected item is not an exception");
							}

						};
					}

				};
				return new TypeCellEditor(layersTable.getTable(),
						ThrowingDefinitionWizardPage.this.getContainer(),
						IJavaSearchConstants.CLASS, "*Exception", extension);
			}

			@Override
			protected Object getValue(Object element) {
				return ((LayerDescriptor) element).getExceptionSuperType();
			}

			@Override
			protected void setValue(Object element, Object value) {
				((LayerDescriptor) element).setExceptionSuperType((String) value);
				layersTable.refresh(element, true);
			}
		});
		layersTable.setInput(getArchitectureDescriptor().getLayers());
		setControl(container);
		((WizardDialog) getContainer()).addPageChangedListener(this);
	}

	@Override
	public void pageChanged(PageChangedEvent event) {
		if (event.getSelectedPage() == this) {
			layersTable.refresh(true);
		}
	}

}
