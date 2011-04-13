/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ar.com.fluxit.jqa.context.model.jqa;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ar.com.fluxit.jqa.context.model.jqa.Rule#getName <em>Name</em>}</li>
 *   <li>{@link ar.com.fluxit.jqa.context.model.jqa.Rule#getFilterPredicate <em>Filter Predicate</em>}</li>
 *   <li>{@link ar.com.fluxit.jqa.context.model.jqa.Rule#getCheckPredicate <em>Check Predicate</em>}</li>
 * </ul>
 * </p>
 *
 * @model kind="class"
 * @generated
 */
public class Rule {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getFilterPredicate() <em>Filter Predicate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFilterPredicate()
	 * @generated
	 * @ordered
	 */
	protected Predicate filterPredicate;

	/**
	 * The cached value of the '{@link #getCheckPredicate() <em>Check Predicate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheckPredicate()
	 * @generated
	 * @ordered
	 */
	protected Predicate checkPredicate;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Rule() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JqaPackage.Literals.RULE;
	}

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the value of the '{@link ar.com.fluxit.jqa.context.model.jqa.Rule#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * Returns the value of the '<em><b>Filter Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Filter Predicate</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Filter Predicate</em>' containment reference.
	 * @see #setFilterPredicate(Predicate)
	 * @model containment="true" required="true"
	 * @generated
	 */
	public Predicate getFilterPredicate() {
		return filterPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFilterPredicate(Predicate newFilterPredicate, NotificationChain msgs) {
		Predicate oldFilterPredicate = filterPredicate;
		filterPredicate = newFilterPredicate;
		return msgs;
	}

	/**
	 * Sets the value of the '{@link ar.com.fluxit.jqa.context.model.jqa.Rule#getFilterPredicate <em>Filter Predicate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Filter Predicate</em>' containment reference.
	 * @see #getFilterPredicate()
	 * @generated
	 */
	public void setFilterPredicate(Predicate newFilterPredicate) {
		if (newFilterPredicate != filterPredicate) {
			NotificationChain msgs = null;
			if (filterPredicate != null)
				msgs = ((InternalEObject)filterPredicate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JqaPackage.RULE__FILTER_PREDICATE, null, msgs);
			if (newFilterPredicate != null)
				msgs = ((InternalEObject)newFilterPredicate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JqaPackage.RULE__FILTER_PREDICATE, null, msgs);
			msgs = basicSetFilterPredicate(newFilterPredicate, msgs);
			if (msgs != null) msgs.dispatch();
		}
	}

	/**
	 * Returns the value of the '<em><b>Check Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Check Predicate</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Check Predicate</em>' containment reference.
	 * @see #setCheckPredicate(Predicate)
	 * @model containment="true" required="true"
	 * @generated
	 */
	public Predicate getCheckPredicate() {
		return checkPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCheckPredicate(Predicate newCheckPredicate, NotificationChain msgs) {
		Predicate oldCheckPredicate = checkPredicate;
		checkPredicate = newCheckPredicate;
		return msgs;
	}

	/**
	 * Sets the value of the '{@link ar.com.fluxit.jqa.context.model.jqa.Rule#getCheckPredicate <em>Check Predicate</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Check Predicate</em>' containment reference.
	 * @see #getCheckPredicate()
	 * @generated
	 */
	public void setCheckPredicate(Predicate newCheckPredicate) {
		if (newCheckPredicate != checkPredicate) {
			NotificationChain msgs = null;
			if (checkPredicate != null)
				msgs = ((InternalEObject)checkPredicate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JqaPackage.RULE__CHECK_PREDICATE, null, msgs);
			if (newCheckPredicate != null)
				msgs = ((InternalEObject)newCheckPredicate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JqaPackage.RULE__CHECK_PREDICATE, null, msgs);
			msgs = basicSetCheckPredicate(newCheckPredicate, msgs);
			if (msgs != null) msgs.dispatch();
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case JqaPackage.RULE__FILTER_PREDICATE:
				return basicSetFilterPredicate(null, msgs);
			case JqaPackage.RULE__CHECK_PREDICATE:
				return basicSetCheckPredicate(null, msgs);
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
			case JqaPackage.RULE__NAME:
				return getName();
			case JqaPackage.RULE__FILTER_PREDICATE:
				return getFilterPredicate();
			case JqaPackage.RULE__CHECK_PREDICATE:
				return getCheckPredicate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case JqaPackage.RULE__NAME:
				setName((String)newValue);
				return;
			case JqaPackage.RULE__FILTER_PREDICATE:
				setFilterPredicate((Predicate)newValue);
				return;
			case JqaPackage.RULE__CHECK_PREDICATE:
				setCheckPredicate((Predicate)newValue);
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
			case JqaPackage.RULE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case JqaPackage.RULE__FILTER_PREDICATE:
				setFilterPredicate((Predicate)null);
				return;
			case JqaPackage.RULE__CHECK_PREDICATE:
				setCheckPredicate((Predicate)null);
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
			case JqaPackage.RULE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case JqaPackage.RULE__FILTER_PREDICATE:
				return filterPredicate != null;
			case JqaPackage.RULE__CHECK_PREDICATE:
				return checkPredicate != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} // Rule
