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
package ar.com.fluxit.jqa;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaModelException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ar.com.fluxit.jqa.bce.BCERepositoryLocator;
import ar.com.fluxit.jqa.result.CheckingResult;
import ar.com.fluxit.jqa.result.RuleCheckFailed;
import ar.com.fluxit.jqa.utils.Utils;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class JQAEclipseMarker {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(JQAEclipseMarker.class);
	private static final Map<Integer, Integer> SEVERITY_MAP;
	public static final String MARKER_ID = "ar.com.fluxit.jqa.JQAMarker";

	static {
		SEVERITY_MAP = new HashMap<Integer, Integer>();
		SEVERITY_MAP.put(1, IMarker.SEVERITY_ERROR);
		SEVERITY_MAP.put(2, IMarker.SEVERITY_WARNING);
		SEVERITY_MAP.put(3, IMarker.SEVERITY_WARNING);
		SEVERITY_MAP.put(4, IMarker.SEVERITY_WARNING);
		SEVERITY_MAP.put(5, IMarker.SEVERITY_INFO);
	}

	public static JQAEclipseMarker INSTANCE = new JQAEclipseMarker();

	private JQAEclipseMarker() {
		// hide constructor
	}

	private void deleteCurrentMarks(IJavaProject javaProject) {
		try {
			IMarker[] problems = javaProject.getResource().findMarkers(
					MARKER_ID, true, IResource.DEPTH_INFINITE);
			for (IMarker iMarker : problems) {
				iMarker.delete();
			}
		} catch (CoreException e) {
			throw new IllegalStateException("Can not delete current marks", e);
		}

	}

	private int getSeverity(int rulePriority) {
		final Integer result = SEVERITY_MAP.get(rulePriority);
		if (result == null) {
			throw new IllegalArgumentException(
					"Priority must be a numerical value between 1 and 5");
		}
		return result;
	}

	private void mark(File violatedFile, Integer lineId,
			RuleCheckFailed ruleCheckFailed) {
		final IFile[] files = ResourcesPlugin.getWorkspace().getRoot()
				.findFilesForLocationURI(violatedFile.toURI());
		if (files.length == 1) {
			IFile file = files[0];
			try {
				IMarker marker = file.createMarker(MARKER_ID);
				marker.setAttribute(IMarker.MESSAGE,
						ruleCheckFailed.getRuleMessage());
				marker.setAttribute(IMarker.SEVERITY,
						getSeverity(ruleCheckFailed.getRulePriority()));
				marker.setAttribute(IMarker.LINE_NUMBER, lineId);
			} catch (CoreException e) {
				Status status = new Status(IStatus.ERROR,
						JQAEclipsePlugin.PLUGIN_ID, e.getLocalizedMessage(), e);
				JQAEclipsePlugin.getDefault().getLog().log(status);
				LOGGER.error("An error occured while marking rule check fail of rule ["
						+ ruleCheckFailed.getRuleName()
						+ "] on class ["
						+ ruleCheckFailed.getTargetClassName()
						+ "] on line ["
						+ lineId + "]");
			}
		} else {
			throw new IllegalStateException(files.length
					+ " resources found for source file " + violatedFile);
		}
	}

	public void mark(IJavaProject javaProject, CheckingResult checkResult) {
		deleteCurrentMarks(javaProject);
		final List<RuleCheckFailed> ruleChecksFailed = checkResult
				.getRuleChecksFailed();
		for (RuleCheckFailed ruleCheckFailed : ruleChecksFailed) {
			mark(javaProject, ruleCheckFailed);
		}
	}

	private void mark(IJavaProject targetProject,
			RuleCheckFailed ruleCheckFailed) {
		try {
			File violatedPath = BCERepositoryLocator.getRepository()
					.getSourceFile(ruleCheckFailed.getTargetClassName(),
							Utils.getSourcesDirs(targetProject));
			for (Integer lineId : ruleCheckFailed.getLineIds()) {
				mark(violatedPath, lineId, ruleCheckFailed);
			}
		} catch (FileNotFoundException e) {
			throw new IllegalStateException(
					"Can not found sources of project: "
							+ targetProject.getElementName(), e);
		} catch (JavaModelException e) {
			throw new IllegalStateException("Can not parse Java project: "
					+ targetProject.getElementName()
					+ " while finding a source file", e);
		}
	}

}