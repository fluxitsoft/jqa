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
package ar.com.fluxit.jqa;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 * 
 * @author Juan Ignacio Barisich
 */
public class JQAEclipsePlugin extends AbstractUIPlugin {

	public static final String PLUGIN_ID = "ar.com.fluxit.jqa";
	public static final String IMG_CHECK = "jqa.image.check";
	public static final String IMG_UNCHECK = "jqa.image.uncheck";
	private static JQAEclipsePlugin plugin;

	public static JQAEclipsePlugin getDefault() {
		return plugin;
	}

	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	public JQAEclipsePlugin() {
	}

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		super.initializeImageRegistry(reg);
		Bundle bundle = Platform.getBundle(PLUGIN_ID);
		ImageDescriptor checkImage = ImageDescriptor.createFromURL(FileLocator
				.find(bundle, new Path("icons/check..gif"), null));
		reg.put(IMG_CHECK, checkImage);
		ImageDescriptor uncheckImage = ImageDescriptor
				.createFromURL(FileLocator.find(bundle, new Path(
						"icons/uncheck..gif"), null));
		reg.put(IMG_UNCHECK, uncheckImage);
	}

	@Override
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}
}
