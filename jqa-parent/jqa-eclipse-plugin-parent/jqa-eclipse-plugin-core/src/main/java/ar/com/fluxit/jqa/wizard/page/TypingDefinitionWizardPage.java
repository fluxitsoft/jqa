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
package ar.com.fluxit.jqa.wizard.page;

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

import ar.com.fluxit.jqa.entities.Layer;
import ar.com.fluxit.jqa.viewer.TypeCellEditor;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class TypingDefinitionWizardPage extends AbstractWizardPage implements
		IPageChangedListener {

	public static final String PAGE_NAME = "TypingDefinitionWizardPage";
	private TableViewer layersTable;

	public TypingDefinitionWizardPage() {
		super(PAGE_NAME);
		setTitle("Typing definition");
		setDescription("Define the typing of your layers");
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
				Layer layer = (Layer) element;
				return layer.getName();
			}
		});

		TableViewerColumn namePatternColumn = new TableViewerColumn(
				layersTable, SWT.NONE);
		namePatternColumn.getColumn().setWidth(300);
		namePatternColumn.getColumn().setText("Super type");
		namePatternColumn.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				Layer layer = (Layer) element;
				return layer.getSuperType();
			}

		});
		namePatternColumn.setEditingSupport(new EditingSupport(layersTable) {

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				return new TypeCellEditor(layersTable.getTable(),
						TypingDefinitionWizardPage.this.getContainer());
			}

			@Override
			protected Object getValue(Object element) {
				return ((Layer) element).getSuperType();
			}

			@Override
			protected void setValue(Object element, Object value) {
				((Layer) element).setSuperType((String) value);
				layersTable.refresh(element, true);
			}
		});
		layersTable.setInput(getWizard().getLayers());
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
