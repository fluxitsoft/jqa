package ar.com.fluxit.jqa.wizard.page;

import java.util.Arrays;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.jface.wizard.IWizard;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

import ar.com.fluxit.jqa.wizard.JQAWizard;

public class TargetProjectsSelectionWizardPage extends WizardPage {

	public static final String PAGE_NAME = "TargetProjectsSelectionWizardPage";

	protected TargetProjectsSelectionWizardPage(IWizard iWizard) {
		super(PAGE_NAME);
		setTitle("Target projects selection");
		setDescription("Select the target projects");
		setWizard(iWizard);
	}

	@Override
	public void createControl(Composite paramComposite) {
		Composite container = new Composite(paramComposite, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);
		setControl(container);
		setPageComplete(false);

		final CheckboxTableViewer projectNames = CheckboxTableViewer.newCheckList(container, SWT.BORDER);
		projectNames.setContentProvider(new WorkbenchContentProvider());
		projectNames.setLabelProvider(new WorkbenchLabelProvider());
		projectNames.addFilter(new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (!(element instanceof IProject)) {
					return false;
				}
				IProject project = (IProject) element;
				if (!project.isAccessible()) {
					return false;
				}
				return true;
			}
		});
		projectNames.setInput(ResourcesPlugin.getWorkspace().getRoot());
		projectNames.getControl().setLayoutData(new GridData(GridData.FILL_BOTH));
		projectNames.addCheckStateListener(new ICheckStateListener() {
			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				TargetProjectsSelectionWizardPage.this.updateSelection(projectNames.getCheckedElements());
			}
		});
	}

	protected void updateSelection(Object[] selection) {
		IProject[] projects = Arrays.copyOf(selection, selection.length, IProject[].class);
		((JQAWizard) getWizard()).setTargetProjects(projects);
		getWizard().getContainer().updateButtons();
	}

}
