package ar.com.fluxit.jqa.context;

import java.util.Collection;

import ar.com.fluxit.jqa.rule.RuleSet;

public interface JQAContext {

	Collection<RuleSet> getRuleSets();

}