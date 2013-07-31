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

import java.util.Collections;
import java.util.List;

import org.eclipse.jface.dialogs.IPageChangedListener;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.PageChangedEvent;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.zest.core.viewers.EntityConnectionData;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;

import ar.com.fluxit.jqa.entities.Layer;
import ar.com.fluxit.jqa.viewer.LayersGraphContentProvider;
import ar.com.fluxit.jqa.viewer.LayersGraphLabelProvider;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class UsageDefinitionWizardPage extends AbstractWizardPage implements
		IPageChangedListener {

	public static final String PAGE_NAME = "UsageDefinitionWizardPage";
	private GraphViewer viewer;

	public UsageDefinitionWizardPage() {
		super(PAGE_NAME);
		setTitle("Usage definition");
		setDescription("Define the allowed usages of your layers");
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);

		viewer = new GraphViewer(container, SWT.BORDER);
		viewer.setContentProvider(new LayersGraphContentProvider());
		viewer.setLabelProvider(new LayersGraphLabelProvider());
		viewer.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED);
		LayoutAlgorithm graphLayout = new TreeLayoutAlgorithm(
				LayoutStyles.NO_LAYOUT_NODE_RESIZING);
		viewer.setLayoutAlgorithm(graphLayout, true);
		viewer.applyLayout();
		viewer.getGraphControl()
				.setLayoutData(new GridData(GridData.FILL_BOTH));
		viewer.addPostSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				StructuredSelection selection = (StructuredSelection) event
						.getSelection();
				if (!selection.isEmpty()) {
					@SuppressWarnings("unchecked")
					List<Object> selectedObjects = selection.toList();
					EntityConnectionData connection = findConnection(selectedObjects);
					if (connection == null) {
						if (selectedObjects.size() > 1) {
							Layer sourceLayer = (Layer) selectedObjects.get(0);
							Layer destinationLayer = (Layer) selectedObjects
									.get(1);
							sourceLayer.addUsage(destinationLayer);
							viewer.refresh();
							viewer.setSelection(StructuredSelection.EMPTY);
						}
					} else {
						((Layer) connection.source)
								.removeUsage((Layer) connection.dest);
						viewer.refresh();
						viewer.setSelection(StructuredSelection.EMPTY);
					}
				}
			}
		});
		final Menu menu = new Menu(viewer.getGraphControl());
		MenuItem resetMenuItem = new MenuItem(menu, SWT.PUSH);
		resetMenuItem.setText("Reset");
		resetMenuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				boolean openConfirm = MessageDialog.openConfirm(
						menu.getShell(), "Confirm reset", "Are you sure?");
				if (openConfirm) {
					for (Layer layer : getWizard().getLayers()) {
						layer.clearUsages();
						viewer.refresh();
					}
				}
			}
		});
		MenuItem layoutMenuItem = new MenuItem(menu, SWT.PUSH);
		layoutMenuItem.setText("Layout");
		layoutMenuItem.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				viewer.applyLayout();
			}
		});

		viewer.getGraphControl().setMenu(menu);
		setControl(container);
		((WizardDialog) getContainer()).addPageChangedListener(this);
	}

	protected EntityConnectionData findConnection(List<Object> selectedObjects) {
		for (Object object : selectedObjects) {
			if (object instanceof EntityConnectionData) {
				return (EntityConnectionData) object;
			}
		}
		return null;
	}

	@Override
	public void pageChanged(PageChangedEvent event) {
		if (event.getSelectedPage() == this) {
			// FIXME if the input has no changes, then not change it on the
			// viewer. The empty list is for a BUG (NullPointerException) on
			// org.eclipse.zest.core.viewers.internal.AbstractStylingModelFactory:325
			viewer.setInput(Collections.emptyList());
			viewer.setInput(getWizard().getLayers());
		}
	}

}
