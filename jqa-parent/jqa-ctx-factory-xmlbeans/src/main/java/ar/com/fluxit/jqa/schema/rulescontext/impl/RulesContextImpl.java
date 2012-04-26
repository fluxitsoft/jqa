/*
 * XML Type:  RulesContext
 * Namespace: http://www.fluxit.com.ar/jqa/schema/rulescontext
 * Java type: ar.com.fluxit.jqa.schema.rulescontext.RulesContext
 *
 * Automatically generated - do not modify.
 */
package ar.com.fluxit.jqa.schema.rulescontext.impl;

/**
 * An XML RulesContext(@http://www.fluxit.com.ar/jqa/schema/rulescontext).
 * 
 * This is a complex type.
 */
public class RulesContextImpl extends org.apache.xmlbeans.impl.values.XmlComplexContentImpl implements ar.com.fluxit.jqa.schema.rulescontext.RulesContext {
	private static final long serialVersionUID = 1L;

	private static final javax.xml.namespace.QName RULESCONTEXTIMPORT$0 = new javax.xml.namespace.QName("", "rulesContextImport");

	private static final javax.xml.namespace.QName GLOBALPREDICATE$2 = new javax.xml.namespace.QName("", "globalPredicate");
	private static final javax.xml.namespace.QName RULESET$4 = new javax.xml.namespace.QName("", "ruleSet");
	private static final javax.xml.namespace.QName NAME$6 = new javax.xml.namespace.QName("", "name");

	public RulesContextImpl(org.apache.xmlbeans.SchemaType sType) {
		super(sType);
	}

	/**
	 * Appends and returns a new empty value (as xml) as the last
	 * "globalPredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.Predicate addNewGlobalPredicate() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.Predicate) get_store().add_element_user(GLOBALPREDICATE$2);
			return target;
		}
	}

	/**
	 * Appends and returns a new empty value (as xml) as the last
	 * "rulesContextImport" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport addNewRulesContextImport() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport target = null;
			target = (ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport) get_store().add_element_user(RULESCONTEXTIMPORT$0);
			return target;
		}
	}

	/**
	 * Appends and returns a new empty value (as xml) as the last "ruleSet"
	 * element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.Ruleset addNewRuleSet() {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.Ruleset target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.Ruleset) get_store().add_element_user(RULESET$4);
			return target;
		}
	}

	/**
	 * Gets array of all "globalPredicate" elements
	 * 
	 * @deprecated
	 */
	@Deprecated
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.Predicate[] getGlobalPredicateArray() {
		synchronized (monitor()) {
			check_orphaned();
			final java.util.List<ar.com.fluxit.jqa.schema.ruleset.Predicate> targetList = new java.util.ArrayList<ar.com.fluxit.jqa.schema.ruleset.Predicate>();
			get_store().find_all_element_users(GLOBALPREDICATE$2, targetList);
			final ar.com.fluxit.jqa.schema.ruleset.Predicate[] result = new ar.com.fluxit.jqa.schema.ruleset.Predicate[targetList.size()];
			targetList.toArray(result);
			return result;
		}
	}

	/**
	 * Gets ith "globalPredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.Predicate getGlobalPredicateArray(int i) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.Predicate) get_store().find_element_user(GLOBALPREDICATE$2, i);
			if (target == null) {
				throw new IndexOutOfBoundsException();
			}
			return target;
		}
	}

	/**
	 * Gets a List of "globalPredicate" elements
	 */
	@Override
	public java.util.List<ar.com.fluxit.jqa.schema.ruleset.Predicate> getGlobalPredicateList() {
		final class GlobalPredicateList extends java.util.AbstractList<ar.com.fluxit.jqa.schema.ruleset.Predicate> {
			@Override
			public void add(int i, ar.com.fluxit.jqa.schema.ruleset.Predicate o) {
				insertNewGlobalPredicate(i).set(o);
			}

			@Override
			public ar.com.fluxit.jqa.schema.ruleset.Predicate get(int i) {
				return RulesContextImpl.this.getGlobalPredicateArray(i);
			}

			@Override
			public ar.com.fluxit.jqa.schema.ruleset.Predicate remove(int i) {
				final ar.com.fluxit.jqa.schema.ruleset.Predicate old = RulesContextImpl.this.getGlobalPredicateArray(i);
				removeGlobalPredicate(i);
				return old;
			}

			@Override
			public ar.com.fluxit.jqa.schema.ruleset.Predicate set(int i, ar.com.fluxit.jqa.schema.ruleset.Predicate o) {
				final ar.com.fluxit.jqa.schema.ruleset.Predicate old = RulesContextImpl.this.getGlobalPredicateArray(i);
				RulesContextImpl.this.setGlobalPredicateArray(i, o);
				return old;
			}

			@Override
			public int size() {
				return sizeOfGlobalPredicateArray();
			}

		}

		synchronized (monitor()) {
			check_orphaned();
			return new GlobalPredicateList();
		}
	}

	/**
	 * Gets the "name" attribute
	 */
	@Override
	public java.lang.String getName() {
		synchronized (monitor()) {
			check_orphaned();
			org.apache.xmlbeans.SimpleValue target = null;
			target = (org.apache.xmlbeans.SimpleValue) get_store().find_attribute_user(NAME$6);
			if (target == null) {
				return null;
			}
			return target.getStringValue();
		}
	}

	/**
	 * Gets array of all "rulesContextImport" elements
	 * 
	 * @deprecated
	 */
	@Deprecated
	@Override
	public ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport[] getRulesContextImportArray() {
		synchronized (monitor()) {
			check_orphaned();
			final java.util.List<ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport> targetList = new java.util.ArrayList<ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport>();
			get_store().find_all_element_users(RULESCONTEXTIMPORT$0, targetList);
			final ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport[] result = new ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport[targetList
					.size()];
			targetList.toArray(result);
			return result;
		}
	}

	/**
	 * Gets ith "rulesContextImport" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport getRulesContextImportArray(int i) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport target = null;
			target = (ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport) get_store().find_element_user(RULESCONTEXTIMPORT$0, i);
			if (target == null) {
				throw new IndexOutOfBoundsException();
			}
			return target;
		}
	}

	/**
	 * Gets a List of "rulesContextImport" elements
	 */
	@Override
	public java.util.List<ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport> getRulesContextImportList() {
		final class RulesContextImportList extends java.util.AbstractList<ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport> {
			@Override
			public void add(int i, ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport o) {
				insertNewRulesContextImport(i).set(o);
			}

			@Override
			public ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport get(int i) {
				return RulesContextImpl.this.getRulesContextImportArray(i);
			}

			@Override
			public ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport remove(int i) {
				final ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport old = RulesContextImpl.this.getRulesContextImportArray(i);
				removeRulesContextImport(i);
				return old;
			}

			@Override
			public ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport set(int i, ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport o) {
				final ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport old = RulesContextImpl.this.getRulesContextImportArray(i);
				RulesContextImpl.this.setRulesContextImportArray(i, o);
				return old;
			}

			@Override
			public int size() {
				return sizeOfRulesContextImportArray();
			}

		}

		synchronized (monitor()) {
			check_orphaned();
			return new RulesContextImportList();
		}
	}

	/**
	 * Gets array of all "ruleSet" elements
	 * 
	 * @deprecated
	 */
	@Deprecated
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.Ruleset[] getRuleSetArray() {
		synchronized (monitor()) {
			check_orphaned();
			final java.util.List<ar.com.fluxit.jqa.schema.ruleset.Ruleset> targetList = new java.util.ArrayList<ar.com.fluxit.jqa.schema.ruleset.Ruleset>();
			get_store().find_all_element_users(RULESET$4, targetList);
			final ar.com.fluxit.jqa.schema.ruleset.Ruleset[] result = new ar.com.fluxit.jqa.schema.ruleset.Ruleset[targetList.size()];
			targetList.toArray(result);
			return result;
		}
	}

	/**
	 * Gets ith "ruleSet" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.Ruleset getRuleSetArray(int i) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.Ruleset target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.Ruleset) get_store().find_element_user(RULESET$4, i);
			if (target == null) {
				throw new IndexOutOfBoundsException();
			}
			return target;
		}
	}

	/**
	 * Gets a List of "ruleSet" elements
	 */
	@Override
	public java.util.List<ar.com.fluxit.jqa.schema.ruleset.Ruleset> getRuleSetList() {
		final class RuleSetList extends java.util.AbstractList<ar.com.fluxit.jqa.schema.ruleset.Ruleset> {
			@Override
			public void add(int i, ar.com.fluxit.jqa.schema.ruleset.Ruleset o) {
				insertNewRuleSet(i).set(o);
			}

			@Override
			public ar.com.fluxit.jqa.schema.ruleset.Ruleset get(int i) {
				return RulesContextImpl.this.getRuleSetArray(i);
			}

			@Override
			public ar.com.fluxit.jqa.schema.ruleset.Ruleset remove(int i) {
				final ar.com.fluxit.jqa.schema.ruleset.Ruleset old = RulesContextImpl.this.getRuleSetArray(i);
				removeRuleSet(i);
				return old;
			}

			@Override
			public ar.com.fluxit.jqa.schema.ruleset.Ruleset set(int i, ar.com.fluxit.jqa.schema.ruleset.Ruleset o) {
				final ar.com.fluxit.jqa.schema.ruleset.Ruleset old = RulesContextImpl.this.getRuleSetArray(i);
				RulesContextImpl.this.setRuleSetArray(i, o);
				return old;
			}

			@Override
			public int size() {
				return sizeOfRuleSetArray();
			}

		}

		synchronized (monitor()) {
			check_orphaned();
			return new RuleSetList();
		}
	}

	/**
	 * Inserts and returns a new empty value (as xml) as the ith
	 * "globalPredicate" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.Predicate insertNewGlobalPredicate(int i) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.Predicate) get_store().insert_element_user(GLOBALPREDICATE$2, i);
			return target;
		}
	}

	/**
	 * Inserts and returns a new empty value (as xml) as the ith
	 * "rulesContextImport" element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport insertNewRulesContextImport(int i) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport target = null;
			target = (ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport) get_store().insert_element_user(RULESCONTEXTIMPORT$0, i);
			return target;
		}
	}

	/**
	 * Inserts and returns a new empty value (as xml) as the ith "ruleSet"
	 * element
	 */
	@Override
	public ar.com.fluxit.jqa.schema.ruleset.Ruleset insertNewRuleSet(int i) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.Ruleset target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.Ruleset) get_store().insert_element_user(RULESET$4, i);
			return target;
		}
	}

	/**
	 * True if has "name" attribute
	 */
	@Override
	public boolean isSetName() {
		synchronized (monitor()) {
			check_orphaned();
			return get_store().find_attribute_user(NAME$6) != null;
		}
	}

	/**
	 * Removes the ith "globalPredicate" element
	 */
	@Override
	public void removeGlobalPredicate(int i) {
		synchronized (monitor()) {
			check_orphaned();
			get_store().remove_element(GLOBALPREDICATE$2, i);
		}
	}

	/**
	 * Removes the ith "rulesContextImport" element
	 */
	@Override
	public void removeRulesContextImport(int i) {
		synchronized (monitor()) {
			check_orphaned();
			get_store().remove_element(RULESCONTEXTIMPORT$0, i);
		}
	}

	/**
	 * Removes the ith "ruleSet" element
	 */
	@Override
	public void removeRuleSet(int i) {
		synchronized (monitor()) {
			check_orphaned();
			get_store().remove_element(RULESET$4, i);
		}
	}

	/**
	 * Sets array of all "globalPredicate" element
	 */
	@Override
	public void setGlobalPredicateArray(ar.com.fluxit.jqa.schema.ruleset.Predicate[] globalPredicateArray) {
		synchronized (monitor()) {
			check_orphaned();
			arraySetterHelper(globalPredicateArray, GLOBALPREDICATE$2);
		}
	}

	/**
	 * Sets ith "globalPredicate" element
	 */
	@Override
	public void setGlobalPredicateArray(int i, ar.com.fluxit.jqa.schema.ruleset.Predicate globalPredicate) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.Predicate target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.Predicate) get_store().find_element_user(GLOBALPREDICATE$2, i);
			if (target == null) {
				throw new IndexOutOfBoundsException();
			}
			target.set(globalPredicate);
		}
	}

	/**
	 * Sets the "name" attribute
	 */
	@Override
	public void setName(java.lang.String name) {
		synchronized (monitor()) {
			check_orphaned();
			org.apache.xmlbeans.SimpleValue target = null;
			target = (org.apache.xmlbeans.SimpleValue) get_store().find_attribute_user(NAME$6);
			if (target == null) {
				target = (org.apache.xmlbeans.SimpleValue) get_store().add_attribute_user(NAME$6);
			}
			target.setStringValue(name);
		}
	}

	/**
	 * Sets array of all "rulesContextImport" element
	 */
	@Override
	public void setRulesContextImportArray(ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport[] rulesContextImportArray) {
		synchronized (monitor()) {
			check_orphaned();
			arraySetterHelper(rulesContextImportArray, RULESCONTEXTIMPORT$0);
		}
	}

	/**
	 * Sets ith "rulesContextImport" element
	 */
	@Override
	public void setRulesContextImportArray(int i, ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport rulesContextImport) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport target = null;
			target = (ar.com.fluxit.jqa.schema.rulescontext.RulesContextImport) get_store().find_element_user(RULESCONTEXTIMPORT$0, i);
			if (target == null) {
				throw new IndexOutOfBoundsException();
			}
			target.set(rulesContextImport);
		}
	}

	/**
	 * Sets array of all "ruleSet" element
	 */
	@Override
	public void setRuleSetArray(ar.com.fluxit.jqa.schema.ruleset.Ruleset[] ruleSetArray) {
		synchronized (monitor()) {
			check_orphaned();
			arraySetterHelper(ruleSetArray, RULESET$4);
		}
	}

	/**
	 * Sets ith "ruleSet" element
	 */
	@Override
	public void setRuleSetArray(int i, ar.com.fluxit.jqa.schema.ruleset.Ruleset ruleSet) {
		synchronized (monitor()) {
			check_orphaned();
			ar.com.fluxit.jqa.schema.ruleset.Ruleset target = null;
			target = (ar.com.fluxit.jqa.schema.ruleset.Ruleset) get_store().find_element_user(RULESET$4, i);
			if (target == null) {
				throw new IndexOutOfBoundsException();
			}
			target.set(ruleSet);
		}
	}

	/**
	 * Returns number of "globalPredicate" element
	 */
	@Override
	public int sizeOfGlobalPredicateArray() {
		synchronized (monitor()) {
			check_orphaned();
			return get_store().count_elements(GLOBALPREDICATE$2);
		}
	}

	/**
	 * Returns number of "rulesContextImport" element
	 */
	@Override
	public int sizeOfRulesContextImportArray() {
		synchronized (monitor()) {
			check_orphaned();
			return get_store().count_elements(RULESCONTEXTIMPORT$0);
		}
	}

	/**
	 * Returns number of "ruleSet" element
	 */
	@Override
	public int sizeOfRuleSetArray() {
		synchronized (monitor()) {
			check_orphaned();
			return get_store().count_elements(RULESET$4);
		}
	}

	/**
	 * Unsets the "name" attribute
	 */
	@Override
	public void unsetName() {
		synchronized (monitor()) {
			check_orphaned();
			get_store().remove_attribute(NAME$6);
		}
	}

	/**
	 * Gets (as xml) the "name" attribute
	 */
	@Override
	public org.apache.xmlbeans.XmlString xgetName() {
		synchronized (monitor()) {
			check_orphaned();
			org.apache.xmlbeans.XmlString target = null;
			target = (org.apache.xmlbeans.XmlString) get_store().find_attribute_user(NAME$6);
			return target;
		}
	}

	/**
	 * Sets (as xml) the "name" attribute
	 */
	@Override
	public void xsetName(org.apache.xmlbeans.XmlString name) {
		synchronized (monitor()) {
			check_orphaned();
			org.apache.xmlbeans.XmlString target = null;
			target = (org.apache.xmlbeans.XmlString) get_store().find_attribute_user(NAME$6);
			if (target == null) {
				target = (org.apache.xmlbeans.XmlString) get_store().add_attribute_user(NAME$6);
			}
			target.set(name);
		}
	}
}
