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
 * A representation of the model object '<em><b>Naming Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ar.com.fluxit.jqa.context.model.jqa.NamingPredicate#getClassNamePattern <em>Class Name Pattern</em>}</li>
 * </ul>
 * </p>
 *
 * @model kind="class"
 * @generated
 */
public class NamingPredicate extends Predicate {
	/**
	 * The default value of the '{@link #getClassNamePattern() <em>Class Name Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassNamePattern()
	 * @generated
	 * @ordered
	 */
	protected static final String CLASS_NAME_PATTERN_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getClassNamePattern() <em>Class Name Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getClassNamePattern()
	 * @generated
	 * @ordered
	 */
	protected String classNamePattern = CLASS_NAME_PATTERN_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamingPredicate() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JqaPackage.Literals.NAMING_PREDICATE;
	}

	/**
	 * Returns the value of the '<em><b>Class Name Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Class Name Pattern</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Class Name Pattern</em>' attribute.
	 * @see #setClassNamePattern(String)
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 * @generated
	 */
	public String getClassNamePattern() {
		return classNamePattern;
	}

	/**
	 * Sets the value of the '{@link ar.com.fluxit.jqa.context.model.jqa.NamingPredicate#getClassNamePattern <em>Class Name Pattern</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Class Name Pattern</em>' attribute.
	 * @see #getClassNamePattern()
	 * @generated
	 */
	public void setClassNamePattern(String newClassNamePattern) {
		classNamePattern = newClassNamePattern;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case JqaPackage.NAMING_PREDICATE__CLASS_NAME_PATTERN:
				return getClassNamePattern();
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
			case JqaPackage.NAMING_PREDICATE__CLASS_NAME_PATTERN:
				setClassNamePattern((String)newValue);
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
			case JqaPackage.NAMING_PREDICATE__CLASS_NAME_PATTERN:
				setClassNamePattern(CLASS_NAME_PATTERN_EDEFAULT);
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
			case JqaPackage.NAMING_PREDICATE__CLASS_NAME_PATTERN:
				return CLASS_NAME_PATTERN_EDEFAULT == null ? classNamePattern != null : !CLASS_NAME_PATTERN_EDEFAULT.equals(classNamePattern);
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
		result.append(" (classNamePattern: ");
		result.append(classNamePattern);
		result.append(')');
		return result.toString();
	}

} // NamingPredicate
