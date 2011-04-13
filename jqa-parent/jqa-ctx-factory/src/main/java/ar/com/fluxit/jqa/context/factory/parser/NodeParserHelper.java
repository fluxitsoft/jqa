package ar.com.fluxit.jqa.context.factory.parser;

import java.util.ArrayList;
import java.util.Collection;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class NodeParserHelper {

	public static Collection<Node> getChildNodes(Node parentNode, String nodeName) {
		final Collection<Node> result = new ArrayList<Node>();
		final NodeList childNodes = parentNode.getChildNodes();
		for (int i = 0; i < childNodes.getLength(); i++) {
			final Node childNode = childNodes.item(i);
			if (childNode.getNodeName().equals(nodeName)) {
				result.add(childNode);
			}
		}
		return result;
	}

}
