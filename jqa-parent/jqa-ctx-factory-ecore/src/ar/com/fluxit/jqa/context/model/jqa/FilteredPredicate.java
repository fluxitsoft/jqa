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
 * A representation of the model object '<em><b>Filtered Predicate</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link ar.com.fluxit.jqa.context.model.jqa.FilteredPredicate#getFilterPredicate <em>Filter Predicate</em>}</li>
 * </ul>
 * </p>
 *
 * @model kind="class" abstract="true"
 * @generated
 */
public abstract class FilteredPredicate extends Predicate {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FilteredPredicate() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return JqaPackage.Literals.FILTERED_PREDICATE;
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
	 * Sets the value of the '{@link ar.com.fluxit.jqa.context.model.jqa.FilteredPredicate#getFilterPredicate <em>Filter Predicate</em>}' containment reference.
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
				msgs = ((InternalEObject)filterPredicate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - JqaPackage.FILTERED_PREDICATE__FILTER_PREDICATE, null, msgs);
			if (newFilterPredicate != null)
				msgs = ((InternalEObject)newFilterPredicate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - JqaPackage.FILTERED_PREDICATE__FILTER_PREDICATE, null, msgs);
			msgs = basicSetFilterPredicate(newFilterPredicate, msgs);
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
			case JqaPackage.FILTERED_PREDICATE__FILTER_PREDICATE:
				return basicSetFilterPredicate(null, msgs);
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
			case JqaPackage.FILTERED_PREDICATE__FILTER_PREDICATE:
				return getFilterPredicate();
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
			case JqaPackage.FILTERED_PREDICATE__FILTER_PREDICATE:
				setFilterPredicate((Predicate)newValue);
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
			case JqaPackage.FILTERED_PREDICATE__FILTER_PREDICATE:
				setFilterPredicate((Predicate)null);
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
			case JqaPackage.FILTERED_PREDICATE__FILTER_PREDICATE:
				return filterPredicate != null;
		}
		return super.eIsSet(featureID);
	}

} // FilteredPredicate
