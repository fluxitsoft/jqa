/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ar.com.fluxit.jqa.context.model.jqa;

import org.eclipse.emf.ecore.EClass;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Provided Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ar.com.fluxit.jqa.context.model.jqa.ContextProvidedPredicate#getProvidedPredicateName <em>Provided Predicate Name</em>}</li>
 * </ul>
 * </p>
 *
 * @model kind="class"
 * @generated
 */
public class ContextProvidedPredicate extends Predicate {
	/**
	 * The default value of the '{@link #getProvidedPredicateName() <em>Provided Predicate Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedPredicateName()
	 * @generated
	 * @ordered
	 */
	protected static final String PROVIDED_PREDICATE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProvidedPredicateName() <em>Provided Predicate Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProvidedPredicateName()
	 * @generated
	 * @ordered
	 */
	protected String providedPredicateName = PROVIDED_PREDICATE_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContextProvidedPredicate() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JqaPackage.Literals.CONTEXT_PROVIDED_PREDICATE;
	}

	/**
	 * Returns the value of the '<em><b>Provided Predicate Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Provided Predicate Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Provided Predicate Name</em>' attribute.
	 * @see #setProvidedPredicateName(String)
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 * @generated
	 */
	public String getProvidedPredicateName() {
		return providedPredicateName;
	}

	/**
	 * Sets the value of the '{@link ar.com.fluxit.jqa.context.model.jqa.ContextProvidedPredicate#getProvidedPredicateName <em>Provided Predicate Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Provided Predicate Name</em>' attribute.
	 * @see #getProvidedPredicateName()
	 * @generated
	 */
	public void setProvidedPredicateName(String newProvidedPredicateName) {
		providedPredicateName = newProvidedPredicateName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JqaPackage.CONTEXT_PROVIDED_PREDICATE__PROVIDED_PREDICATE_NAME:
				return getProvidedPredicateName();
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
			case JqaPackage.CONTEXT_PROVIDED_PREDICATE__PROVIDED_PREDICATE_NAME:
				setProvidedPredicateName((String)newValue);
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
			case JqaPackage.CONTEXT_PROVIDED_PREDICATE__PROVIDED_PREDICATE_NAME:
				setProvidedPredicateName(PROVIDED_PREDICATE_NAME_EDEFAULT);
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
			case JqaPackage.CONTEXT_PROVIDED_PREDICATE__PROVIDED_PREDICATE_NAME:
				return PROVIDED_PREDICATE_NAME_EDEFAULT == null ? providedPredicateName != null : !PROVIDED_PREDICATE_NAME_EDEFAULT.equals(providedPredicateName);
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
		result.append(" (providedPredicateName: ");
		result.append(providedPredicateName);
		result.append(')');
		return result.toString();
	}

} // ContextProvidedPredicate
