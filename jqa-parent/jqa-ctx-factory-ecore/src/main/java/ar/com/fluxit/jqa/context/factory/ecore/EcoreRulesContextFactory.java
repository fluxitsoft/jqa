package ar.com.fluxit.jqa.context.factory.ecore;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.xsd.ecore.XSDEcoreBuilder;

import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.factory.RulesContextFactory;
import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class EcoreRulesContextFactory implements RulesContextFactory {

	@Override
	public RulesContext getRulesContext(Object source)
			throws RulesContextFactoryException {
		try {
			if (!(source instanceof File)) {
				throw new IllegalArgumentException("Source must be a file");
			}
			final File sourceFile = (File) source;
			final XSDEcoreBuilder xsdEcoreBuilder = new XSDEcoreBuilder();
			final ResourceSet resourceSet = new ResourceSetImpl();
			final Collection<EObject> eCorePackages = xsdEcoreBuilder
					.generate(URI.createFileURI("D:/model/example.xsd"));
			for (final EObject eObject : eCorePackages) {
				final EPackage element = (EPackage) eObject;
				resourceSet.getPackageRegistry().put(element.getNsURI(),
						element);
			}
			final HashMap<String, Object> options = new HashMap<String, Object>();
			options.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
			final Resource resource = resourceSet.createResource(URI
					.createFileURI(sourceFile.getPath()));
			resource.load(options);
			return null;
		} catch (final IOException e) {
			throw new RulesContextFactoryException(e);
		}
	}

}
