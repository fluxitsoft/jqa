package ar.com.fluxit.jqa.context.factory;

import java.io.File;
import java.io.FileReader;

import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.XMLContext;

import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.RulesContextImpl;
import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;

public class RulesContextFactoryImpl implements RulesContextFactory {

	@Override
	public RulesContext getRulesContext(Object source)
			throws RulesContextFactoryException {
		if (source instanceof File) {
			try {
				File sourceFile = (File) source;
				// Load Mapping
				Mapping mapping = new Mapping();
				mapping.loadMapping(getClass().getResource("/rulescontext.map.xml"));
				//mapping.loadMapping(getClass().getResource("/predicates_mapping.xml"));
				// Initialize and configure XMLContext
				XMLContext context = new XMLContext();
				context.addMapping(mapping);
				// Create a Reader to the file to unmarshal from
				FileReader reader = new FileReader(sourceFile);
				// Create a new Unmarshaller
				Unmarshaller unmarshaller = context.createUnmarshaller();
				unmarshaller.setClass(RulesContextImpl.class);
				// Unmarshal the object
				RulesContext result = (RulesContext) unmarshaller
						.unmarshal(reader);
				return result;
			} catch (Exception e) {
				throw new RulesContextFactoryException(e);
			}
		} else {
			throw new IllegalArgumentException("Source must be a File object");
		}
	}

	// @Override
	// public RulesContext getRulesContext(Object source)
	// throws RulesContextFactoryException {
	// if (source instanceof File) {
	// RulesContext result = new RulesContextImpl();
	// File sourceFile = (File) source;
	// final XSDEcoreBuilder xsdEcoreBuilder = new XSDEcoreBuilder();
	// final ResourceSet resourceSet = new ResourceSetImpl();
	// final Collection<EObject> eCorePackages = xsdEcoreBuilder
	// .generate(URI.createFileURI(getClass().getResource(
	// "/rulescontext.xsd").getFile()));
	// for (final EObject eObject : eCorePackages) {
	// final EPackage element = (EPackage) eObject;
	// resourceSet.getPackageRegistry().put(element.getNsURI(),
	// element);
	// }
	// final HashMap<String, Object> options = new HashMap<String, Object>();
	// options.put(XMLResource.OPTION_EXTENDED_META_DATA, Boolean.TRUE);
	// URI createFileURI = URI
	// .createFileURI(sourceFile.getPath());
	// final Resource resource = resourceSet.createResource(createFileURI);
	// try {
	// resource.load(options);
	// } catch (IOException e) {
	// throw new RulesContextFactoryException(e);
	// }
	// return result;
	// } else {
	// throw new IllegalArgumentException("Source must be a File object");
	// }
	// }

}
