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

import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.CheckboxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;

import ar.com.fluxit.jqa.descriptor.CommonDescriptor;
import ar.com.fluxit.jqa.descriptor.LayerDescriptor;
import ar.com.fluxit.jqa.viewer.CommonTypesContentProvider;
import ar.com.fluxit.jqa.viewer.CommonTypesLabelProvider;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class CommonsTypesDefinitionWizardPage extends AbstractWizardPage
		implements IPageChangedListener {

	public static final String PAGE_NAME = "CommonsTypesDefinitionWizardPage";
	private TreeViewer commonTypesTreeViewer;

	public CommonsTypesDefinitionWizardPage() {
		super(PAGE_NAME);
		setTitle("Common types definition");
		setDescription("Define the allowed common types of those layer");
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);

		Tree commonTypesTree = new Tree(container, SWT.BORDER | SWT.H_SCROLL
				| SWT.V_SCROLL);
		commonTypesTree.setHeaderVisible(true);
		commonTypesTree.setLinesVisible(true);
		commonTypesTree.setLayoutData(new GridData(GridData.FILL_BOTH));
		commonTypesTreeViewer = new TreeViewer(commonTypesTree);

		TreeViewerColumn layerColumn = new TreeViewerColumn(
				commonTypesTreeViewer, SWT.LEFT);
		layerColumn.getColumn().setText("Layer/Types");
		layerColumn.getColumn().setWidth(400);

		final CellEditor checkboxCellEditor = new CheckboxCellEditor();
		TreeViewerColumn commonTypeColumn = new TreeViewerColumn(
				commonTypesTreeViewer, SWT.LEFT);
		commonTypeColumn.getColumn().setText("Is common?");
		commonTypeColumn.getColumn().setWidth(50);
		commonTypeColumn.setEditingSupport(new EditingSupport(
				commonTypesTreeViewer) {

			@Override
			protected boolean canEdit(Object arg0) {
				return true;
			}

			@Override
			protected CellEditor getCellEditor(Object arg0) {
				return checkboxCellEditor;
			}

			@Override
			protected Object getValue(Object arg0) {
				return ((CommonDescriptor) arg0).isCommon();
			}

			@Override
			protected void setValue(Object arg0, Object arg1) {
				((CommonDescriptor) arg0).setCommon((Boolean) arg1);
				commonTypesTreeViewer.update(arg0, null);
			}
		});

		commonTypesTreeViewer
				.setContentProvider(new CommonTypesContentProvider());
		commonTypesTreeViewer.setLabelProvider(new CommonTypesLabelProvider());
		commonTypesTreeViewer.setInput(getArchitectureDescriptor().getLayers());
		commonTypesTreeViewer.expandAll();
		commonTypesTreeViewer.addFilter(new ViewerFilter() {

			@Override
			public boolean select(Viewer arg0, Object arg1, Object arg2) {
				if (arg2 instanceof LayerDescriptor) {
					return !((LayerDescriptor) arg2).getCommons().isEmpty();
				} else {
					return true;
				}
			}
		});

		setControl(container);
		((WizardDialog) getContainer()).addPageChangedListener(this);
	}

	@Override
	public void pageChanged(PageChangedEvent event) {
		if (event.getSelectedPage() == this) {
			commonTypesTreeViewer.refresh();
			commonTypesTreeViewer.expandAll();
		}
	}
}
