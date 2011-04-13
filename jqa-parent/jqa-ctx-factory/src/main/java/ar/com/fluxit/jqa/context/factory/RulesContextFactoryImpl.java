package ar.com.fluxit.jqa.context.factory;

import java.io.File;

import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;
import ar.com.fluxit.jqa.schema.rulescontext.RulesContextDocument;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RulesContextFactoryImpl implements RulesContextFactory {

	@Override
	public RulesContext getRulesContext(Object source)
			throws RulesContextFactoryException {
		if (source instanceof File) {
			try {
				File sourceFile = (File) source;
				RulesContextDocument document = RulesContextDocument.Factory
						.parse(sourceFile);
				System.out.println(document);
				return null;
			} catch (Exception e) {
				throw new RulesContextFactoryException(e);
			}
		} else {
			throw new IllegalArgumentException("Source must be a File object");
		}
	}

}
