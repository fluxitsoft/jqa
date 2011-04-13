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
 * A representation of the model object '<em><b>Typing Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ar.com.fluxit.jqa.context.model.jqa.TypingPredicate#getParentClassName <em>Parent Class Name</em>}</li>
 * </ul>
 * </p>
 *
 * @model kind="class"
 * @generated
 */
public class TypingPredicate extends Predicate {
	/**
	 * The default value of the '{@link #getParentClassName() <em>Parent Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentClassName()
	 * @generated
	 * @ordered
	 */
	protected static final String PARENT_CLASS_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getParentClassName() <em>Parent Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParentClassName()
	 * @generated
	 * @ordered
	 */
	protected String parentClassName = PARENT_CLASS_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypingPredicate() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JqaPackage.Literals.TYPING_PREDICATE;
	}

	/**
	 * Returns the value of the '<em><b>Parent Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parent Class Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parent Class Name</em>' attribute.
	 * @see #setParentClassName(String)
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 * @generated
	 */
	public String getParentClassName() {
		return parentClassName;
	}

	/**
	 * Sets the value of the '{@link ar.com.fluxit.jqa.context.model.jqa.TypingPredicate#getParentClassName <em>Parent Class Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Parent Class Name</em>' attribute.
	 * @see #getParentClassName()
	 * @generated
	 */
	public void setParentClassName(String newParentClassName) {
		parentClassName = newParentClassName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JqaPackage.TYPING_PREDICATE__PARENT_CLASS_NAME:
				return getParentClassName();
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
			case JqaPackage.TYPING_PREDICATE__PARENT_CLASS_NAME:
				setParentClassName((String)newValue);
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
			case JqaPackage.TYPING_PREDICATE__PARENT_CLASS_NAME:
				setParentClassName(PARENT_CLASS_NAME_EDEFAULT);
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
			case JqaPackage.TYPING_PREDICATE__PARENT_CLASS_NAME:
				return PARENT_CLASS_NAME_EDEFAULT == null ? parentClassName != null : !PARENT_CLASS_NAME_EDEFAULT.equals(parentClassName);
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
		result.append(" (parentClassName: ");
		result.append(parentClassName);
		result.append(')');
		return result.toString();
	}

} // TypingPredicate
