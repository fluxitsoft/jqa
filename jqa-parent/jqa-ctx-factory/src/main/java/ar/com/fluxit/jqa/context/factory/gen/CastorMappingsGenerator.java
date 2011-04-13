package ar.com.fluxit.jqa.context.factory.gen;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import org.exolab.castor.tools.MappingTool;
import org.exolab.castor.xml.XMLContext;

import ar.com.fluxit.jqa.predicate.AbstractPredicate;
import ar.com.fluxit.jqa.predicate.ContextProvidedPredicate;
import ar.com.fluxit.jqa.predicate.lang.AllocationPredicate;
import ar.com.fluxit.jqa.predicate.lang.NamingPredicate;
import ar.com.fluxit.jqa.predicate.lang.ThrowingPredicate;
import ar.com.fluxit.jqa.predicate.lang.TypingPredicate;
import ar.com.fluxit.jqa.predicate.lang.UsagePredicate;
import ar.com.fluxit.jqa.predicate.logic.AndPredicate;
import ar.com.fluxit.jqa.predicate.logic.FalsePredicate;
import ar.com.fluxit.jqa.predicate.logic.NotPredicate;
import ar.com.fluxit.jqa.predicate.logic.OrPredicate;
import ar.com.fluxit.jqa.predicate.logic.TruePredicate;
import ar.com.fluxit.jqa.predicate.logic.XorPredicate;

public class CastorMappingsGenerator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
		XMLContext context = new XMLContext();
		MappingTool tool = context.createMappingTool();
		//tool.addClass();
		tool.addClass(ContextProvidedPredicate.class);
		// Lang Predicates
		tool.addClass(AbstractPredicate.class);
		tool.addClass(AllocationPredicate.class);
		tool.addClass(NamingPredicate.class);
		tool.addClass(ThrowingPredicate.class);
		tool.addClass(TypingPredicate.class);
		tool.addClass(UsagePredicate.class);
		// Logic Predicates
		tool.addClass(AndPredicate.class);
		tool.addClass(NotPredicate.class);
		tool.addClass(OrPredicate.class);
		tool.addClass(XorPredicate.class);
		tool.addClass(TruePredicate.class);
		tool.addClass(FalsePredicate.class);
		
		OutputStream file = new FileOutputStream("/home/jbarisich/works/jqa/jqa-parent/jqa-ctx-factory/src/main/resources/mapping.xml" );
		Writer writer = new OutputStreamWriter(file);
//			tool.write(writer);
		} catch (Exception e) {
			e.printStackTrace();
		} 

	}

}
