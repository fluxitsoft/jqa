package ar.com.fluxit.jqa.context.factory.parser;

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;
/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class NodeParserLocator {

	private NodeParserLocator() {
		super();
		nodeParsers = new HashMap<String, NodeParser>();
		nodeParsers.put("jqa_ctx:RulesContext", new RulesContextNodeParser());
	}

	public static NodeParserLocator INSTANCE = new NodeParserLocator();
	private Map<String, NodeParser> nodeParsers;

	public NodeParser getNodeParser(Node node) {
		return nodeParsers.get(node.getNodeName());
	}

}
