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

import java.util.Collections;

import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.wizard.IWizardPage;
import org.eclipse.ui.dialogs.WizardNewFileCreationPage;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class NewRulesContextFileWizardPage extends WizardNewFileCreationPage {

	public static final String PAGE_NAME = "NewRulesContextFileWizardPage";

	public NewRulesContextFileWizardPage() {
		super(PAGE_NAME, new StructuredSelection(Collections.emptyList()));
		setTitle("Rules context file creation");
		setDescription("Creates a new rules context tu run");
		setFileExtension("xml");
		setFileName("a");// FIXME remove

	}

	@Override
	public IWizardPage getNextPage() {
		return getWizard().getPage(TargetProjectsSelectionWizardPage.PAGE_NAME);
	}
}
