/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ar.com.fluxit.jqa.context.model.jqa_ctx;

import ar.com.fluxit.jqa.context.model.jqa.Predicate;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rules Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ar.com.fluxit.jqa.context.model.jqa_ctx.RulesContext#getRuleSetImport <em>Rule Set Import</em>}</li>
 *   <li>{@link ar.com.fluxit.jqa.context.model.jqa_ctx.RulesContext#getGlobalPredicate <em>Global Predicate</em>}</li>
 * </ul>
 * </p>
 *
 * @model kind="class"
 * @generated
 */
public class RulesContext {
	/**
	 * The cached value of the '{@link #getRuleSetImport() <em>Rule Set Import</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRuleSetImport()
	 * @generated
	 * @ordered
	 */
	protected EList<RuleSetImport> ruleSetImport;

	/**
	 * The cached value of the '{@link #getGlobalPredicate() <em>Global Predicate</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGlobalPredicate()
	 * @generated
	 * @ordered
	 */
	protected EList<Predicate> globalPredicate;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RulesContext() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return Jqa_ctxPackage.Literals.RULES_CONTEXT;
	}

	/**
	 * Returns the value of the '<em><b>Rule Set Import</b></em>' containment reference list.
	 * The list contents are of type {@link ar.com.fluxit.jqa.context.model.jqa_ctx.RuleSetImport}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Rule Set Import</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Set Import</em>' containment reference list.
	 * @model containment="true" required="true"
	 * @generated
	 */
	public List<RuleSetImport> getRuleSetImport() {
		if (ruleSetImport == null) {
			ruleSetImport = new BasicInternalEList<RuleSetImport>(RuleSetImport.class);
		}
		return ruleSetImport;
	}

	/**
	 * Returns the value of the '<em><b>Global Predicate</b></em>' containment reference list.
	 * The list contents are of type {@link ar.com.fluxit.jqa.context.model.jqa.Predicate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Global Predicate</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Global Predicate</em>' containment reference list.
	 * @model containment="true"
	 * @generated
	 */
	public List<Predicate> getGlobalPredicate() {
		if (globalPredicate == null) {
			globalPredicate = new BasicInternalEList<Predicate>(Predicate.class);
		}
		return globalPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case Jqa_ctxPackage.RULES_CONTEXT__RULE_SET_IMPORT:
				return ((InternalEList<?>)getRuleSetImport()).basicRemove(otherEnd, msgs);
			case Jqa_ctxPackage.RULES_CONTEXT__GLOBAL_PREDICATE:
				return ((InternalEList<?>)getGlobalPredicate()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case Jqa_ctxPackage.RULES_CONTEXT__RULE_SET_IMPORT:
				return getRuleSetImport();
			case Jqa_ctxPackage.RULES_CONTEXT__GLOBAL_PREDICATE:
				return getGlobalPredicate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case Jqa_ctxPackage.RULES_CONTEXT__RULE_SET_IMPORT:
				getRuleSetImport().clear();
				getRuleSetImport().addAll((Collection<? extends RuleSetImport>)newValue);
				return;
			case Jqa_ctxPackage.RULES_CONTEXT__GLOBAL_PREDICATE:
				getGlobalPredicate().clear();
				getGlobalPredicate().addAll((Collection<? extends Predicate>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case Jqa_ctxPackage.RULES_CONTEXT__RULE_SET_IMPORT:
				getRuleSetImport().clear();
				return;
			case Jqa_ctxPackage.RULES_CONTEXT__GLOBAL_PREDICATE:
				getGlobalPredicate().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case Jqa_ctxPackage.RULES_CONTEXT__RULE_SET_IMPORT:
				return ruleSetImport != null && !ruleSetImport.isEmpty();
			case Jqa_ctxPackage.RULES_CONTEXT__GLOBAL_PREDICATE:
				return globalPredicate != null && !globalPredicate.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // RulesContext
