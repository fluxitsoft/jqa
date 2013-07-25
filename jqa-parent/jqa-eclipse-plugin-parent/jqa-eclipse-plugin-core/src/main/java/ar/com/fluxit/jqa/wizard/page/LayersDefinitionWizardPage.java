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
package ar.com.fluxit.jqa.wizard.page;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.corext.refactoring.reorg.JavaElementTransfer;
import org.eclipse.jdt.ui.JavaElementComparator;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.ToolBar;

import ar.com.fluxit.jqa.actions.EditLayerAction;
import ar.com.fluxit.jqa.actions.NewLayerAction;
import ar.com.fluxit.jqa.actions.RemoveLayerAction;
import ar.com.fluxit.jqa.entities.Layer;
import ar.com.fluxit.jqa.viewer.Holder;
import ar.com.fluxit.jqa.viewer.LayerCellModifier;
import ar.com.fluxit.jqa.viewer.LayersListTableDropListener;
import ar.com.fluxit.jqa.viewer.TargetPackagesDragListener;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class LayersDefinitionWizardPage extends AbstractWizardPage {

	public static final String PAGE_NAME = "LayersDefinitionWizardPage";
	private TableViewer layerPackagesTable;
	private TableViewer targetPackagesTable;
	private final Transfer[] transferTypes;
	private final Holder<Viewer> viewerHolder;
	private final Holder<Collection<IJavaElement>> inputHolder;

	public LayersDefinitionWizardPage() {
		super(PAGE_NAME);
		setTitle("Layers definition");
		setDescription("Define the layers of the target application");
		transferTypes = new Transfer[] { JavaElementTransfer.getInstance() };
		inputHolder = new Holder<Collection<IJavaElement>>();
		viewerHolder = new Holder<Viewer>();
	}

	private List<IJavaElement> collectNonEmptyPackages() {
		try {
			List<IJavaElement> result = new ArrayList<IJavaElement>();
			for (IProject project : getWizard().getTargetProjects()) {
				final IJavaProject javaProject = JavaCore.create(project);
				for (IPackageFragment packageFragment : javaProject
						.getPackageFragments()) {
					if (packageFragment.containsJavaResources()
							&& packageFragment.getKind() == IPackageFragmentRoot.K_SOURCE) {
						result.add(packageFragment);
					}
				}
			}
			return result;
		} catch (JavaModelException e) {
			throw new IllegalStateException(
					"An error has occurred while collection Java packages", e);
		}
	}

	@Override
	public void createControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);
		setControl(container);
		SashForm sash = new SashForm(container, SWT.SMOOTH);
		sash.setOrientation(SWT.HORIZONTAL);
		sash.setLayoutData(new GridData(GridData.FILL_BOTH));
		createTargetPackagesGroup(sash);
		createLayersGroup(sash);
		createLayerPackagesGroup(sash);
	}

	private void createLayerPackagesGroup(SashForm sash) {
		final Group layerPackagesGroup = new Group(sash, SWT.NONE);
		layerPackagesGroup.setText("Layer packages");
		layerPackagesGroup.setLayout(new GridLayout());
		ILabelProvider targetPackagesLabelProvider = new JavaElementLabelProvider(
				JavaElementLabelProvider.SHOW_DEFAULT);
		layerPackagesTable = new TableViewer(layerPackagesGroup, SWT.BORDER
				| SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI);
		layerPackagesTable.setLabelProvider(targetPackagesLabelProvider);
		layerPackagesTable.setContentProvider(ArrayContentProvider
				.getInstance());
		layerPackagesTable.setComparator(new JavaElementComparator());
		layerPackagesTable.setInput(Collections.emptySet());
		layerPackagesTable.getTable().setLayoutData(
				new GridData(GridData.FILL_BOTH));
		layerPackagesTable.addDragSupport(DND.DROP_MOVE, getTransferTypes(),
				new TargetPackagesDragListener(layerPackagesTable,
						getDragViewerHolder(), getDragInputHolder()));
	}

	private void createLayersGroup(SashForm sash) {
		final Group layersGroup = new Group(sash, SWT.NONE);
		final GridLayout layersGroupGridLayout = new GridLayout();
		layersGroupGridLayout.verticalSpacing = -1;
		layersGroup.setLayout(layersGroupGridLayout);
		layersGroup.setText("Layers");
		ViewForm viewForm = new ViewForm(layersGroup, SWT.FLAT | SWT.BORDER);
		viewForm.setLayout(layersGroupGridLayout);
		ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		ToolBar toolBar = toolBarManager.createControl(viewForm);
		toolBar.setBackground(layersGroup.getBackground());
		viewForm.setTopLeft(toolBar);
		viewForm.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		TableViewer layersTable = new TableViewer(layersGroup, SWT.SINGLE
				| SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		layersTable.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
		layersTable.setContentProvider(ArrayContentProvider.getInstance());
		layersTable.setInput(getWizard().getLayers());
		layersTable.setLabelProvider(new ColumnLabelProvider() {

			@Override
			public String getText(Object element) {
				Layer layer = (Layer) element;
				String result = layer.getName();
				if (!layer.getPackages().isEmpty()) {
					result += " (" + layer.getPackages().size() + ")";
				}
				return result;
			}
		});
		layersTable.setCellEditors(new CellEditor[] { new TextCellEditor(
				layersTable.getTable()) });
		layersTable.setCellModifier(new LayerCellModifier(layersTable));
		layersTable.setColumnProperties(new String[] { "layer" });
		toolBarManager.add(new NewLayerAction(getWizard().getLayers(),
				layersTable));
		final EditLayerAction editLayerAction = new EditLayerAction(layersTable);
		editLayerAction.setEnabled(false);
		toolBarManager.add(editLayerAction);
		final RemoveLayerAction removeLayerAction = new RemoveLayerAction(
				getWizard().getLayers(), layersTable, targetPackagesTable,
				getContainer());
		removeLayerAction.setEnabled(false);
		toolBarManager.add(removeLayerAction);
		toolBarManager.update(true);
		layersTable
				.addSelectionChangedListener(new ISelectionChangedListener() {
					@Override
					public void selectionChanged(
							SelectionChangedEvent paramSelectionChangedEvent) {
						layerSelectionChanged(
								paramSelectionChangedEvent.getSelection(),
								editLayerAction, removeLayerAction);
					}
				});
		layersTable.addDropSupport(DND.DROP_MOVE, getTransferTypes(),
				new LayersListTableDropListener(layersTable,
						targetPackagesTable, getDragViewerHolder(),
						getDragInputHolder(), getContainer()));
	}

	private Group createTargetPackagesGroup(SashForm sash) {
		final Group targetPackagesGroup = new Group(sash, SWT.NONE);
		targetPackagesGroup.setLayout(new GridLayout());
		targetPackagesGroup.setText("Target packages");
		ILabelProvider targetPackagesLabelProvider = new JavaElementLabelProvider(
				JavaElementLabelProvider.SHOW_DEFAULT);
		targetPackagesTable = new TableViewer(targetPackagesGroup, SWT.BORDER
				| SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI);
		targetPackagesTable.setLabelProvider(targetPackagesLabelProvider);
		targetPackagesTable.setContentProvider(ArrayContentProvider
				.getInstance());
		targetPackagesTable.setComparator(new JavaElementComparator());
		List<IJavaElement> targetPackages = collectNonEmptyPackages();
		targetPackagesTable.setInput(targetPackages);
		targetPackagesTable.getTable().setLayoutData(
				new GridData(GridData.FILL_BOTH));
		targetPackagesTable.addDragSupport(DND.DROP_MOVE, getTransferTypes(),
				new TargetPackagesDragListener(targetPackagesTable,
						getDragViewerHolder(), getDragInputHolder()));
		// FIXME delete
		targetPackagesTable
				.setSelection(new StructuredSelection(targetPackages));
		return targetPackagesGroup;
	}

	private Holder<Collection<IJavaElement>> getDragInputHolder() {
		return inputHolder;
	}

	private Holder<Viewer> getDragViewerHolder() {
		return viewerHolder;
	}

	public Transfer[] getTransferTypes() {
		return transferTypes;
	}

	@Override
	public boolean isPageComplete() {
		return targetPackagesTable.getTable().getItemCount() == 0;
	}

	private void layerSelectionChanged(ISelection selection,
			EditLayerAction editLayerAction, RemoveLayerAction removeLayerAction) {
		boolean selectionIsNotEmpty = !selection.isEmpty();
		editLayerAction.setEnabled(selectionIsNotEmpty);
		removeLayerAction.setEnabled(selectionIsNotEmpty);
		updateLayerPackagesGroup(selection);
	}

	private void updateLayerPackagesGroup(ISelection selection) {
		Set<IJavaElement> input;
		if (selection.isEmpty()) {
			input = Collections.emptySet();
		} else {
			input = ((Layer) ((StructuredSelection) selection)
					.getFirstElement()).getPackages();
		}
		layerPackagesTable.setInput(input);
	}

}
