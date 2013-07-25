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
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import ar.com.fluxit.jqa.entities.Layer;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class NamingDefinitionWizardPage extends AbstractWizardPage implements
		IPageChangedListener {

	public static final String PAGE_NAME = "NamingDefinitionWizardPage";
	private TableViewer layersTable;
	private Text implPackageText;
	private Text classPackageText;

	public NamingDefinitionWizardPage() {
		super(PAGE_NAME);
		setTitle("Naming definition");
		setDescription("Define the naming pattern of your types");
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 2;
		container.setLayout(layout);

		Label implPackageLabel = new Label(container, SWT.NONE);
		implPackageLabel.setText("Implementations package naming suffix");

		implPackageText = new Text(container, SWT.BORDER);
		implPackageText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				getWizard().setImplPackageText(implPackageText.getText());
			}
		});
		implPackageText.setLayoutData(new GridData(50, SWT.DEFAULT));

		Label implClassLabel = new Label(container, SWT.NONE);
		implClassLabel.setText("Implementations classess name suffix");

		classPackageText = new Text(container, SWT.BORDER);
		classPackageText.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				getWizard().setClassPackageText(classPackageText.getText());
			}
		});
		classPackageText.setLayoutData(new GridData(50, SWT.DEFAULT));

		Label layersLabel = new Label(container, SWT.NONE);
		layersLabel.setText("Layers naming pattern");
		layersLabel.setLayoutData(new GridData(
				GridData.VERTICAL_ALIGN_BEGINNING));

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
		namePatternColumn.getColumn().setText("Naming pattern");
		namePatternColumn.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				Layer layer = (Layer) element;
				return layer.getNamingPattern();
			}

		});
		namePatternColumn.setEditingSupport(new EditingSupport(layersTable) {

			@Override
			protected boolean canEdit(Object element) {
				return true;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				return new TextCellEditor(layersTable.getTable());
			}

			@Override
			protected Object getValue(Object element) {
				return ((Layer) element).getNamingPattern();
			}

			@Override
			protected void setValue(Object element, Object value) {
				((Layer) element).setNamingPattern(((String) value).trim());
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
			implPackageText.setText(getWizard().getImplPackageText());
			classPackageText.setText(getWizard().getClassPackageText());
		}
	}

}
