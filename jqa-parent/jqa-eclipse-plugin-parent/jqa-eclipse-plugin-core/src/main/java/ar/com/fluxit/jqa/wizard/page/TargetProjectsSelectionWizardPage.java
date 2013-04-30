package ar.com.fluxit.jqa.wizard.page;

import java.util.Arrays;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.jface.viewers.CheckStateChangedEvent;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ICheckStateListener;
import org.eclipse.jface.viewers.IElementComparer;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.model.WorkbenchContentProvider;
import org.eclipse.ui.model.WorkbenchLabelProvider;

public class TargetProjectsSelectionWizardPage extends AbstractWizardPage {

	public static final String PAGE_NAME = "TargetProjectsSelectionWizardPage";

	public TargetProjectsSelectionWizardPage() {
		super(PAGE_NAME);
		setTitle("Target projects selection");
		setDescription("Select the target projects");
	}

	@Override
	public void createControl(Composite paramComposite) {
		Composite container = new Composite(paramComposite, SWT.NULL);
		GridLayout layout = new GridLayout();
		layout.numColumns = 1;
		container.setLayout(layout);
		setControl(container);
		setPageComplete(false);

		final CheckboxTableViewer projectNames = CheckboxTableViewer
				.newCheckList(container, SWT.BORDER);
		projectNames.setContentProvider(new WorkbenchContentProvider());
		projectNames.setLabelProvider(new WorkbenchLabelProvider());
		projectNames.addFilter(new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement,
					Object element) {
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
		projectNames.getControl().setLayoutData(
				new GridData(GridData.FILL_BOTH));
		projectNames.addCheckStateListener(new ICheckStateListener() {
			@Override
			public void checkStateChanged(CheckStateChangedEvent event) {
				TargetProjectsSelectionWizardPage.this
						.updateSelection(projectNames.getCheckedElements());
			}
		});
		projectNames.setComparer(new IElementComparer() {

			@Override
			public boolean equals(Object paramObject1, Object paramObject2) {
				return ((IResource) paramObject1).getName().equals(
						((IResource) paramObject2).getName());
			}

			@Override
			public int hashCode(Object paramObject) {
				return ((IResource) paramObject).getName().hashCode();
			}
		});
		restoreState(projectNames);
	}

	private void restoreState(CheckboxTableViewer projectNames) {
		final IProject[] targetProjects = getWizard().getTargetProjects();
		if (targetProjects != null) {
			projectNames.setSelection(new StructuredSelection(targetProjects));
		}
	}

	protected void updateSelection(Object[] selection) {
		IProject[] projects = Arrays.copyOf(selection, selection.length,
				IProject[].class);
		getWizard().setTargetProjects(projects);
		getWizard().getContainer().updateButtons();
	}

}
