/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ar.com.fluxit.jqa.context.model.jqa.util;

import ar.com.fluxit.jqa.context.model.jqa.*;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage
 * @generated
 */
public class JqaSwitch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static JqaPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JqaSwitch() {
		if (modelPackage == null) {
			modelPackage = JqaPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public T doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List<EClass> eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch(eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case JqaPackage.RULESET: {
				Ruleset ruleset = (Ruleset)theEObject;
				T result = caseRuleset(ruleset);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JqaPackage.RULE: {
				Rule rule = (Rule)theEObject;
				T result = caseRule(rule);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JqaPackage.PREDICATE: {
				Predicate predicate = (Predicate)theEObject;
				T result = casePredicate(predicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JqaPackage.CONTEXT_PROVIDED_PREDICATE: {
				ContextProvidedPredicate contextProvidedPredicate = (ContextProvidedPredicate)theEObject;
				T result = caseContextProvidedPredicate(contextProvidedPredicate);
				if (result == null) result = casePredicate(contextProvidedPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JqaPackage.FILTERED_PREDICATE: {
				FilteredPredicate filteredPredicate = (FilteredPredicate)theEObject;
				T result = caseFilteredPredicate(filteredPredicate);
				if (result == null) result = casePredicate(filteredPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JqaPackage.ABSTRACTION_PREDICATE: {
				AbstractionPredicate abstractionPredicate = (AbstractionPredicate)theEObject;
				T result = caseAbstractionPredicate(abstractionPredicate);
				if (result == null) result = casePredicate(abstractionPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JqaPackage.ALLOCATION_PREDICATE: {
				AllocationPredicate allocationPredicate = (AllocationPredicate)theEObject;
				T result = caseAllocationPredicate(allocationPredicate);
				if (result == null) result = caseFilteredPredicate(allocationPredicate);
				if (result == null) result = casePredicate(allocationPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JqaPackage.NAMING_PREDICATE: {
				NamingPredicate namingPredicate = (NamingPredicate)theEObject;
				T result = caseNamingPredicate(namingPredicate);
				if (result == null) result = casePredicate(namingPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JqaPackage.THROWING_PREDICATE: {
				ThrowingPredicate throwingPredicate = (ThrowingPredicate)theEObject;
				T result = caseThrowingPredicate(throwingPredicate);
				if (result == null) result = caseFilteredPredicate(throwingPredicate);
				if (result == null) result = casePredicate(throwingPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JqaPackage.TYPING_PREDICATE: {
				TypingPredicate typingPredicate = (TypingPredicate)theEObject;
				T result = caseTypingPredicate(typingPredicate);
				if (result == null) result = casePredicate(typingPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JqaPackage.USAGE_PREDICATE: {
				UsagePredicate usagePredicate = (UsagePredicate)theEObject;
				T result = caseUsagePredicate(usagePredicate);
				if (result == null) result = caseFilteredPredicate(usagePredicate);
				if (result == null) result = casePredicate(usagePredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JqaPackage.VAR_ARGS_LOGIC_PREDICATE: {
				VarArgsLogicPredicate varArgsLogicPredicate = (VarArgsLogicPredicate)theEObject;
				T result = caseVarArgsLogicPredicate(varArgsLogicPredicate);
				if (result == null) result = casePredicate(varArgsLogicPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JqaPackage.AND_PREDICATE: {
				AndPredicate andPredicate = (AndPredicate)theEObject;
				T result = caseAndPredicate(andPredicate);
				if (result == null) result = caseVarArgsLogicPredicate(andPredicate);
				if (result == null) result = casePredicate(andPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JqaPackage.FALSE_PREDICATE: {
				FalsePredicate falsePredicate = (FalsePredicate)theEObject;
				T result = caseFalsePredicate(falsePredicate);
				if (result == null) result = casePredicate(falsePredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JqaPackage.NOT_PREDICATE: {
				NotPredicate notPredicate = (NotPredicate)theEObject;
				T result = caseNotPredicate(notPredicate);
				if (result == null) result = casePredicate(notPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JqaPackage.OR_PREDICATE: {
				OrPredicate orPredicate = (OrPredicate)theEObject;
				T result = caseOrPredicate(orPredicate);
				if (result == null) result = caseVarArgsLogicPredicate(orPredicate);
				if (result == null) result = casePredicate(orPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JqaPackage.TRUE_PREDICATE: {
				TruePredicate truePredicate = (TruePredicate)theEObject;
				T result = caseTruePredicate(truePredicate);
				if (result == null) result = casePredicate(truePredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case JqaPackage.XOR_PREDICATE: {
				XORPredicate xorPredicate = (XORPredicate)theEObject;
				T result = caseXORPredicate(xorPredicate);
				if (result == null) result = caseVarArgsLogicPredicate(xorPredicate);
				if (result == null) result = casePredicate(xorPredicate);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ruleset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ruleset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRuleset(Ruleset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Rule</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRule(Rule object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePredicate(Predicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Context Provided Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Context Provided Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseContextProvidedPredicate(ContextProvidedPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Filtered Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filtered Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFilteredPredicate(FilteredPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Abstraction Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Abstraction Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAbstractionPredicate(AbstractionPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Allocation Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Allocation Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAllocationPredicate(AllocationPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Naming Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Naming Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamingPredicate(NamingPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Throwing Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Throwing Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThrowingPredicate(ThrowingPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typing Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typing Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypingPredicate(TypingPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Usage Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Usage Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUsagePredicate(UsagePredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Var Args Logic Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Var Args Logic Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVarArgsLogicPredicate(VarArgsLogicPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>And Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>And Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAndPredicate(AndPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>False Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>False Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFalsePredicate(FalsePredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Not Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Not Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNotPredicate(NotPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Or Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Or Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOrPredicate(OrPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>True Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>True Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTruePredicate(TruePredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>XOR Predicate</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>XOR Predicate</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseXORPredicate(XORPredicate object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public T defaultCase(EObject object) {
		return null;
	}

} //JqaSwitch
