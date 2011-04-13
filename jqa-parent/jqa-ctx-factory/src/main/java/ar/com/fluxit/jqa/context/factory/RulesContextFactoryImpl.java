package ar.com.fluxit.jqa.context.factory;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import ar.com.fluxit.jqa.context.RulesContext;
import ar.com.fluxit.jqa.context.factory.exception.RulesContextFactoryException;
import ar.com.fluxit.jqa.context.factory.parser.NodeParser;
import ar.com.fluxit.jqa.context.factory.parser.NodeParserLocator;
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
				DocumentBuilderFactory factory = DocumentBuilderFactory
						.newInstance();
				factory.setValidating(true);

				DocumentBuilder builder = factory.newDocumentBuilder();
				Document document = builder.parse(sourceFile);
				return parse(document);
			} catch (Exception e) {
				throw new RulesContextFactoryException(e);
			}
		} else {
			throw new IllegalArgumentException("Source must be a File object");
		}
	}

	private RulesContext parse(Document document) {
		NodeList nodeList = document.getChildNodes();
		if (nodeList.getLength() != 1) {
			throw new IllegalArgumentException(
					"XML rules context file must have only one root element");
		} else {
			return (RulesContext) parse(nodeList.item(0));
		}
	}

	private Object parse(Node node) {
		NodeParser nodeParser = NodeParserLocator.INSTANCE.getNodeParser(node);
		return nodeParser.parse(node);
	}

}
