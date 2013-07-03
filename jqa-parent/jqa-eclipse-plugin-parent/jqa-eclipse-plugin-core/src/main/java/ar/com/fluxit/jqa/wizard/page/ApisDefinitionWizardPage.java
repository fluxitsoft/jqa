/*******************************************************************************
 * Copyright (c) 2011 Juan Ignacio Barisich.
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

import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.TableItem;

import ar.com.fluxit.jqa.entities.Layer;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class ApisDefinitionWizardPage extends AbstractWizardPage {

	public static final String PAGE_NAME = "ApisDefinitionWizardPage";

	public ApisDefinitionWizardPage() {
		super(PAGE_NAME);
		setTitle("APIs definition");
		setDescription("Define which layers must be accessed via API (interfaces)");
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);

		final CheckboxTableViewer layersTable = CheckboxTableViewer
				.newCheckList(container, SWT.SINGLE | SWT.BORDER | SWT.V_SCROLL
						| SWT.H_SCROLL);
		layersTable.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
		layersTable.setContentProvider(ArrayContentProvider.getInstance());
		layersTable.getTable().setHeaderVisible(true);

		TableViewerColumn selectionColumn = new TableViewerColumn(layersTable,
				SWT.NONE);
		selectionColumn.getColumn().setWidth(23);
		selectionColumn.getColumn().setText("Has API");
		selectionColumn.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				return "";
			}

			@Override
			public void update(ViewerCell cell) {
				super.update(cell);
				boolean checked = ((Layer) cell.getElement()).isHasApi();
				((TableItem) cell.getItem()).setChecked(checked);
			}

		});
		layersTable.addCheckStateListener(new ICheckStateListener() {

			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				((Layer) event.getElement()).setHasApi(event.getChecked());
			}
		});

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
		layersTable.setInput(getWizard().getLayers());
		layersTable.getTable().setColumnOrder(new int[] { 1, 0 });
		setControl(container);
	}
}
