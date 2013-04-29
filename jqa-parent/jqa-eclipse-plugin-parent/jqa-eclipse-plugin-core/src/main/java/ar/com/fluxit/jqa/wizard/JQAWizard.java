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
package ar.com.fluxit.jqa.wizard;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.IPath;
import org.eclipse.jface.wizard.Wizard;

import ar.com.fluxit.jqa.wizard.page.RulesContextSelectionWizardPage;
import ar.com.fluxit.jqa.wizard.page.TargetProjectsSelectionWizardPage;

public class JQAWizard extends Wizard {

	private IPath rulesContextFile;
	private IProject[] targetProjects;

	public JQAWizard() {
		setForcePreviousAndNextButtons(true);
	}

	@Override
	public void addPages() {
		addPage(new RulesContextSelectionWizardPage());
	}

	@Override
	public boolean canFinish() {
		final String currentPageName = getContainer().getCurrentPage().getName();
		return TargetProjectsSelectionWizardPage.PAGE_NAME.equals(currentPageName) && getTargetProjects() != null && getTargetProjects().length > 0;
	}

	public IPath getRulesContextFile() {
		return rulesContextFile;
	}

	public IProject[] getTargetProjects() {
		return targetProjects;
	}

	@Override
	public boolean performFinish() {
		return false;
	}

	public void setRulesContextFile(IPath rulesContextFile) {
		this.rulesContextFile = rulesContextFile;
		getContainer().updateButtons();
	}

	public void setTargetProjects(IProject[] targetProjects) {
		this.targetProjects = targetProjects;
	}

}
