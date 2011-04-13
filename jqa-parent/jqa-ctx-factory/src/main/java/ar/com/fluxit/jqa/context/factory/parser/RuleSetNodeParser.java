package ar.com.fluxit.jqa.context.factory.parser;

import org.w3c.dom.Node;

import ar.com.fluxit.jqa.context.RulesContextImpl;
import ar.com.fluxit.jqa.predicate.Predicate;
import ar.com.fluxit.jqa.rule.RuleSet;

/**
 * TODO javadoc
 * 
 * @author Juan Ignacio Barisich
 */
public class RuleSetNodeParser implements NodeParser {

	RuleSetNodeParser() {
		super();
	}

	@Override
	public Object parse(Node node) {
		RulesContextImpl result = new RulesContextImpl();
		for (Node globalPredicate : NodeParserHelper.getChildNodes(node,
				"globalPredicates")) {
			result.add((Predicate) NodeParserLocator.INSTANCE.getNodeParser(
					globalPredicate).parse(globalPredicate));
		}
		for (Node ruleSetImport : NodeParserHelper.getChildNodes(node,
				"ruleSetImport")) {
			result.add((RuleSet) NodeParserLocator.INSTANCE.getNodeParser(
					ruleSetImport).parse(ruleSetImport));
		}
		return result;
	}

}
