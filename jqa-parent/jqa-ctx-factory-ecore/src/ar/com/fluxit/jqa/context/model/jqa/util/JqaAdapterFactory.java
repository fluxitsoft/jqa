/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ar.com.fluxit.jqa.context.model.jqa.util;

import ar.com.fluxit.jqa.context.model.jqa.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage
 * @generated
 */
public class JqaAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static JqaPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JqaAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = JqaPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected JqaSwitch<Adapter> modelSwitch =
		new JqaSwitch<Adapter>() {
			@Override
			public Adapter caseRuleset(Ruleset object) {
				return createRulesetAdapter();
			}
			@Override
			public Adapter caseRule(Rule object) {
				return createRuleAdapter();
			}
			@Override
			public Adapter casePredicate(Predicate object) {
				return createPredicateAdapter();
			}
			@Override
			public Adapter caseContextProvidedPredicate(ContextProvidedPredicate object) {
				return createContextProvidedPredicateAdapter();
			}
			@Override
			public Adapter caseFilteredPredicate(FilteredPredicate object) {
				return createFilteredPredicateAdapter();
			}
			@Override
			public Adapter caseAbstractionPredicate(AbstractionPredicate object) {
				return createAbstractionPredicateAdapter();
			}
			@Override
			public Adapter caseAllocationPredicate(AllocationPredicate object) {
				return createAllocationPredicateAdapter();
			}
			@Override
			public Adapter caseNamingPredicate(NamingPredicate object) {
				return createNamingPredicateAdapter();
			}
			@Override
			public Adapter caseThrowingPredicate(ThrowingPredicate object) {
				return createThrowingPredicateAdapter();
			}
			@Override
			public Adapter caseTypingPredicate(TypingPredicate object) {
				return createTypingPredicateAdapter();
			}
			@Override
			public Adapter caseUsagePredicate(UsagePredicate object) {
				return createUsagePredicateAdapter();
			}
			@Override
			public Adapter caseVarArgsLogicPredicate(VarArgsLogicPredicate object) {
				return createVarArgsLogicPredicateAdapter();
			}
			@Override
			public Adapter caseAndPredicate(AndPredicate object) {
				return createAndPredicateAdapter();
			}
			@Override
			public Adapter caseFalsePredicate(FalsePredicate object) {
				return createFalsePredicateAdapter();
			}
			@Override
			public Adapter caseNotPredicate(NotPredicate object) {
				return createNotPredicateAdapter();
			}
			@Override
			public Adapter caseOrPredicate(OrPredicate object) {
				return createOrPredicateAdapter();
			}
			@Override
			public Adapter caseTruePredicate(TruePredicate object) {
				return createTruePredicateAdapter();
			}
			@Override
			public Adapter caseXORPredicate(XORPredicate object) {
				return createXORPredicateAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link ar.com.fluxit.jqa.context.model.jqa.Ruleset <em>Ruleset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ar.com.fluxit.jqa.context.model.jqa.Ruleset
	 * @generated
	 */
	public Adapter createRulesetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ar.com.fluxit.jqa.context.model.jqa.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ar.com.fluxit.jqa.context.model.jqa.Rule
	 * @generated
	 */
	public Adapter createRuleAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ar.com.fluxit.jqa.context.model.jqa.Predicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ar.com.fluxit.jqa.context.model.jqa.Predicate
	 * @generated
	 */
	public Adapter createPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ar.com.fluxit.jqa.context.model.jqa.ContextProvidedPredicate <em>Context Provided Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ar.com.fluxit.jqa.context.model.jqa.ContextProvidedPredicate
	 * @generated
	 */
	public Adapter createContextProvidedPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ar.com.fluxit.jqa.context.model.jqa.FilteredPredicate <em>Filtered Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ar.com.fluxit.jqa.context.model.jqa.FilteredPredicate
	 * @generated
	 */
	public Adapter createFilteredPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ar.com.fluxit.jqa.context.model.jqa.AbstractionPredicate <em>Abstraction Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ar.com.fluxit.jqa.context.model.jqa.AbstractionPredicate
	 * @generated
	 */
	public Adapter createAbstractionPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ar.com.fluxit.jqa.context.model.jqa.AllocationPredicate <em>Allocation Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ar.com.fluxit.jqa.context.model.jqa.AllocationPredicate
	 * @generated
	 */
	public Adapter createAllocationPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ar.com.fluxit.jqa.context.model.jqa.NamingPredicate <em>Naming Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ar.com.fluxit.jqa.context.model.jqa.NamingPredicate
	 * @generated
	 */
	public Adapter createNamingPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ar.com.fluxit.jqa.context.model.jqa.ThrowingPredicate <em>Throwing Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ar.com.fluxit.jqa.context.model.jqa.ThrowingPredicate
	 * @generated
	 */
	public Adapter createThrowingPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ar.com.fluxit.jqa.context.model.jqa.TypingPredicate <em>Typing Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ar.com.fluxit.jqa.context.model.jqa.TypingPredicate
	 * @generated
	 */
	public Adapter createTypingPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ar.com.fluxit.jqa.context.model.jqa.UsagePredicate <em>Usage Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ar.com.fluxit.jqa.context.model.jqa.UsagePredicate
	 * @generated
	 */
	public Adapter createUsagePredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ar.com.fluxit.jqa.context.model.jqa.VarArgsLogicPredicate <em>Var Args Logic Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ar.com.fluxit.jqa.context.model.jqa.VarArgsLogicPredicate
	 * @generated
	 */
	public Adapter createVarArgsLogicPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ar.com.fluxit.jqa.context.model.jqa.AndPredicate <em>And Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ar.com.fluxit.jqa.context.model.jqa.AndPredicate
	 * @generated
	 */
	public Adapter createAndPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ar.com.fluxit.jqa.context.model.jqa.FalsePredicate <em>False Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ar.com.fluxit.jqa.context.model.jqa.FalsePredicate
	 * @generated
	 */
	public Adapter createFalsePredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ar.com.fluxit.jqa.context.model.jqa.NotPredicate <em>Not Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ar.com.fluxit.jqa.context.model.jqa.NotPredicate
	 * @generated
	 */
	public Adapter createNotPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ar.com.fluxit.jqa.context.model.jqa.OrPredicate <em>Or Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ar.com.fluxit.jqa.context.model.jqa.OrPredicate
	 * @generated
	 */
	public Adapter createOrPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ar.com.fluxit.jqa.context.model.jqa.TruePredicate <em>True Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ar.com.fluxit.jqa.context.model.jqa.TruePredicate
	 * @generated
	 */
	public Adapter createTruePredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link ar.com.fluxit.jqa.context.model.jqa.XORPredicate <em>XOR Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see ar.com.fluxit.jqa.context.model.jqa.XORPredicate
	 * @generated
	 */
	public Adapter createXORPredicateAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //JqaAdapterFactory
