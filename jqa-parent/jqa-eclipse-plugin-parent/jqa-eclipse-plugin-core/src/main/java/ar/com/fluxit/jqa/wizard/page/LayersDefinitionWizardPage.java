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

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.resources.IProject;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.ui.JavaElementLabelProvider;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.SashForm;
import org.eclipse.swt.custom.ViewForm;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.dialogs.FilteredList;

import ar.com.fluxit.jqa.actions.NewLayoutAction;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class LayersDefinitionWizardPage extends AbstractWizardPage {

	public static final String PAGE_NAME = "LayersDefinitionWizardPage";

	public LayersDefinitionWizardPage() {
		super(PAGE_NAME);
		setTitle("Layers definition");
		setDescription("Define the layers of the target application");
	}

	private IJavaElement[] collectNonEmptyPackages() {
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
			return result.toArray(new IJavaElement[result.size()]);
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

		Group targetPackagesGroup = new Group(sash, SWT.NONE);
		targetPackagesGroup.setLayout(new GridLayout());
		targetPackagesGroup.setText("Target packages");

		ILabelProvider targetPackagesLabelProvider = new JavaElementLabelProvider(
				JavaElementLabelProvider.SHOW_DEFAULT);
		FilteredList targetPackagesList = new FilteredList(targetPackagesGroup,
				SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL | SWT.MULTI,
				targetPackagesLabelProvider, false, false, true);
		targetPackagesList.setElements(collectNonEmptyPackages());
		targetPackagesList.setLayoutData(new GridData(GridData.FILL_BOTH));

		Group layersGroup = new Group(sash, SWT.NONE);
		layersGroup.setLayout(new GridLayout());
		layersGroup.setText("Layers");

		ViewForm viewForm = new ViewForm(layersGroup, SWT.FLAT | SWT.BORDER);
		viewForm.setLayout(new GridLayout());

		ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		ToolBar toolBar = toolBarManager.createControl(viewForm);
		toolBarManager.add(new NewLayoutAction());
		toolBar.setBackground(layersGroup.getBackground());

		viewForm.setTopLeft(toolBar);
		viewForm.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));

		toolBarManager.update(true);

		Group layerPackagesGroup = new Group(sash, SWT.NONE);
	}

}
