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
 * A representation of the model object '<em><b>Abstraction Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ar.com.fluxit.jqa.context.model.jqa.AbstractionPredicate#getAbstractionType <em>Abstraction Type</em>}</li>
 * </ul>
 * </p>
 *
 * @model kind="class"
 * @generated
 */
public class AbstractionPredicate extends Predicate {
	/**
	 * The default value of the '{@link #getAbstractionType() <em>Abstraction Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractionType()
	 * @generated
	 * @ordered
	 */
	protected static final AbstractionType ABSTRACTION_TYPE_EDEFAULT = AbstractionType.ABSTRACT;

	/**
	 * The cached value of the '{@link #getAbstractionType() <em>Abstraction Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAbstractionType()
	 * @generated
	 * @ordered
	 */
	protected AbstractionType abstractionType = ABSTRACTION_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractionPredicate() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JqaPackage.Literals.ABSTRACTION_PREDICATE;
	}

	/**
	 * Returns the value of the '<em><b>Abstraction Type</b></em>' attribute.
	 * The literals are from the enumeration {@link ar.com.fluxit.jqa.context.model.jqa.AbstractionType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Abstraction Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Abstraction Type</em>' attribute.
	 * @see ar.com.fluxit.jqa.context.model.jqa.AbstractionType
	 * @see #setAbstractionType(AbstractionType)
	 * @model required="true"
	 * @generated
	 */
	public AbstractionType getAbstractionType() {
		return abstractionType;
	}

	/**
	 * Sets the value of the '{@link ar.com.fluxit.jqa.context.model.jqa.AbstractionPredicate#getAbstractionType <em>Abstraction Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Abstraction Type</em>' attribute.
	 * @see ar.com.fluxit.jqa.context.model.jqa.AbstractionType
	 * @see #getAbstractionType()
	 * @generated
	 */
	public void setAbstractionType(AbstractionType newAbstractionType) {
		abstractionType = newAbstractionType == null ? ABSTRACTION_TYPE_EDEFAULT : newAbstractionType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JqaPackage.ABSTRACTION_PREDICATE__ABSTRACTION_TYPE:
				return getAbstractionType();
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
			case JqaPackage.ABSTRACTION_PREDICATE__ABSTRACTION_TYPE:
				setAbstractionType((AbstractionType)newValue);
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
			case JqaPackage.ABSTRACTION_PREDICATE__ABSTRACTION_TYPE:
				setAbstractionType(ABSTRACTION_TYPE_EDEFAULT);
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
			case JqaPackage.ABSTRACTION_PREDICATE__ABSTRACTION_TYPE:
				return abstractionType != ABSTRACTION_TYPE_EDEFAULT;
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
		result.append(" (abstractionType: ");
		result.append(abstractionType);
		result.append(')');
		return result.toString();
	}

} // AbstractionPredicate
