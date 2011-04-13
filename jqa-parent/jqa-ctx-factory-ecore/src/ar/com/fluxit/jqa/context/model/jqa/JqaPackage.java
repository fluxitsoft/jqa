/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ar.com.fluxit.jqa.context.model.jqa;

import ar.com.fluxit.jqa.context.model.jqa_ctx.Jqa_ctxPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.eclipse.emf.ecore.xml.type.XMLTypePackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see ar.com.fluxit.jqa.context.model.jqa.JqaFactory
 * @model kind="package"
 * @generated
 */
public class JqaPackage extends EPackageImpl {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "jqa";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http://www.fluxit.com.ar/schema/ruleset";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "jqa";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final JqaPackage eINSTANCE = ar.com.fluxit.jqa.context.model.jqa.JqaPackage.init();

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa.Ruleset <em>Ruleset</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa.Ruleset
	 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getRuleset()
	 * @generated
	 */
	public static final int RULESET = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULESET__NAME = 0;

	/**
	 * The feature id for the '<em><b>Rule</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULESET__RULE = 1;

	/**
	 * The number of structural features of the '<em>Ruleset</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULESET_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa.Rule <em>Rule</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa.Rule
	 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getRule()
	 * @generated
	 */
	public static final int RULE = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Filter Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE__FILTER_PREDICATE = 1;

	/**
	 * The feature id for the '<em><b>Check Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE__CHECK_PREDICATE = 2;

	/**
	 * The number of structural features of the '<em>Rule</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa.Predicate <em>Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa.Predicate
	 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getPredicate()
	 * @generated
	 */
	public static final int PREDICATE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PREDICATE__NAME = 0;

	/**
	 * The number of structural features of the '<em>Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int PREDICATE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa.ContextProvidedPredicate <em>Context Provided Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa.ContextProvidedPredicate
	 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getContextProvidedPredicate()
	 * @generated
	 */
	public static final int CONTEXT_PROVIDED_PREDICATE = 3;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONTEXT_PROVIDED_PREDICATE__NAME = PREDICATE__NAME;

	/**
	 * The feature id for the '<em><b>Provided Predicate Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONTEXT_PROVIDED_PREDICATE__PROVIDED_PREDICATE_NAME = PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Context Provided Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int CONTEXT_PROVIDED_PREDICATE_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa.FilteredPredicate <em>Filtered Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa.FilteredPredicate
	 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getFilteredPredicate()
	 * @generated
	 */
	public static final int FILTERED_PREDICATE = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FILTERED_PREDICATE__NAME = PREDICATE__NAME;

	/**
	 * The feature id for the '<em><b>Filter Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FILTERED_PREDICATE__FILTER_PREDICATE = PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Filtered Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FILTERED_PREDICATE_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa.AbstractionPredicate <em>Abstraction Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa.AbstractionPredicate
	 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getAbstractionPredicate()
	 * @generated
	 */
	public static final int ABSTRACTION_PREDICATE = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ABSTRACTION_PREDICATE__NAME = PREDICATE__NAME;

	/**
	 * The feature id for the '<em><b>Abstraction Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ABSTRACTION_PREDICATE__ABSTRACTION_TYPE = PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Abstraction Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ABSTRACTION_PREDICATE_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa.AllocationPredicate <em>Allocation Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa.AllocationPredicate
	 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getAllocationPredicate()
	 * @generated
	 */
	public static final int ALLOCATION_PREDICATE = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ALLOCATION_PREDICATE__NAME = FILTERED_PREDICATE__NAME;

	/**
	 * The feature id for the '<em><b>Filter Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ALLOCATION_PREDICATE__FILTER_PREDICATE = FILTERED_PREDICATE__FILTER_PREDICATE;

	/**
	 * The number of structural features of the '<em>Allocation Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int ALLOCATION_PREDICATE_FEATURE_COUNT = FILTERED_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa.NamingPredicate <em>Naming Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa.NamingPredicate
	 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getNamingPredicate()
	 * @generated
	 */
	public static final int NAMING_PREDICATE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NAMING_PREDICATE__NAME = PREDICATE__NAME;

	/**
	 * The feature id for the '<em><b>Class Name Pattern</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NAMING_PREDICATE__CLASS_NAME_PATTERN = PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Naming Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NAMING_PREDICATE_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa.ThrowingPredicate <em>Throwing Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa.ThrowingPredicate
	 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getThrowingPredicate()
	 * @generated
	 */
	public static final int THROWING_PREDICATE = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int THROWING_PREDICATE__NAME = FILTERED_PREDICATE__NAME;

	/**
	 * The feature id for the '<em><b>Filter Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int THROWING_PREDICATE__FILTER_PREDICATE = FILTERED_PREDICATE__FILTER_PREDICATE;

	/**
	 * The number of structural features of the '<em>Throwing Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int THROWING_PREDICATE_FEATURE_COUNT = FILTERED_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa.TypingPredicate <em>Typing Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa.TypingPredicate
	 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getTypingPredicate()
	 * @generated
	 */
	public static final int TYPING_PREDICATE = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TYPING_PREDICATE__NAME = PREDICATE__NAME;

	/**
	 * The feature id for the '<em><b>Parent Class Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TYPING_PREDICATE__PARENT_CLASS_NAME = PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typing Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TYPING_PREDICATE_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa.UsagePredicate <em>Usage Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa.UsagePredicate
	 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getUsagePredicate()
	 * @generated
	 */
	public static final int USAGE_PREDICATE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int USAGE_PREDICATE__NAME = FILTERED_PREDICATE__NAME;

	/**
	 * The feature id for the '<em><b>Filter Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int USAGE_PREDICATE__FILTER_PREDICATE = FILTERED_PREDICATE__FILTER_PREDICATE;

	/**
	 * The number of structural features of the '<em>Usage Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int USAGE_PREDICATE_FEATURE_COUNT = FILTERED_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa.VarArgsLogicPredicate <em>Var Args Logic Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa.VarArgsLogicPredicate
	 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getVarArgsLogicPredicate()
	 * @generated
	 */
	public static final int VAR_ARGS_LOGIC_PREDICATE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VAR_ARGS_LOGIC_PREDICATE__NAME = PREDICATE__NAME;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VAR_ARGS_LOGIC_PREDICATE__PREDICATE = PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Var Args Logic Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int VAR_ARGS_LOGIC_PREDICATE_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa.AndPredicate <em>And Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa.AndPredicate
	 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getAndPredicate()
	 * @generated
	 */
	public static final int AND_PREDICATE = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int AND_PREDICATE__NAME = VAR_ARGS_LOGIC_PREDICATE__NAME;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int AND_PREDICATE__PREDICATE = VAR_ARGS_LOGIC_PREDICATE__PREDICATE;

	/**
	 * The number of structural features of the '<em>And Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int AND_PREDICATE_FEATURE_COUNT = VAR_ARGS_LOGIC_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa.FalsePredicate <em>False Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa.FalsePredicate
	 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getFalsePredicate()
	 * @generated
	 */
	public static final int FALSE_PREDICATE = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FALSE_PREDICATE__NAME = PREDICATE__NAME;

	/**
	 * The number of structural features of the '<em>False Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int FALSE_PREDICATE_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa.NotPredicate <em>Not Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa.NotPredicate
	 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getNotPredicate()
	 * @generated
	 */
	public static final int NOT_PREDICATE = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NOT_PREDICATE__NAME = PREDICATE__NAME;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NOT_PREDICATE__PREDICATE = PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Not Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int NOT_PREDICATE_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa.OrPredicate <em>Or Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa.OrPredicate
	 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getOrPredicate()
	 * @generated
	 */
	public static final int OR_PREDICATE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OR_PREDICATE__NAME = VAR_ARGS_LOGIC_PREDICATE__NAME;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OR_PREDICATE__PREDICATE = VAR_ARGS_LOGIC_PREDICATE__PREDICATE;

	/**
	 * The number of structural features of the '<em>Or Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int OR_PREDICATE_FEATURE_COUNT = VAR_ARGS_LOGIC_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa.TruePredicate <em>True Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa.TruePredicate
	 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getTruePredicate()
	 * @generated
	 */
	public static final int TRUE_PREDICATE = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRUE_PREDICATE__NAME = PREDICATE__NAME;

	/**
	 * The number of structural features of the '<em>True Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int TRUE_PREDICATE_FEATURE_COUNT = PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa.XORPredicate <em>XOR Predicate</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa.XORPredicate
	 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getXORPredicate()
	 * @generated
	 */
	public static final int XOR_PREDICATE = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XOR_PREDICATE__NAME = VAR_ARGS_LOGIC_PREDICATE__NAME;

	/**
	 * The feature id for the '<em><b>Predicate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XOR_PREDICATE__PREDICATE = VAR_ARGS_LOGIC_PREDICATE__PREDICATE;

	/**
	 * The number of structural features of the '<em>XOR Predicate</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int XOR_PREDICATE_FEATURE_COUNT = VAR_ARGS_LOGIC_PREDICATE_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa.AbstractionType <em>Abstraction Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa.AbstractionType
	 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getAbstractionType()
	 * @generated
	 */
	public static final int ABSTRACTION_TYPE = 18;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rulesetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass predicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contextProvidedPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filteredPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractionPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass allocationPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namingPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass throwingPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typingPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass usagePredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass varArgsLogicPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass andPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass falsePredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass notPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass orPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass truePredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass xorPredicateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum abstractionTypeEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private JqaPackage() {
		super(eNS_URI, JqaFactory.INSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link JqaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static JqaPackage init() {
		if (isInited) return (JqaPackage)EPackage.Registry.INSTANCE.getEPackage(JqaPackage.eNS_URI);

		// Obtain or create and register package
		JqaPackage theJqaPackage = (JqaPackage)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof JqaPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new JqaPackage());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		Jqa_ctxPackage theJqa_ctxPackage = (Jqa_ctxPackage)(EPackage.Registry.INSTANCE.getEPackage(Jqa_ctxPackage.eNS_URI) instanceof Jqa_ctxPackage ? EPackage.Registry.INSTANCE.getEPackage(Jqa_ctxPackage.eNS_URI) : Jqa_ctxPackage.eINSTANCE);

		// Create package meta-data objects
		theJqaPackage.createPackageContents();
		theJqa_ctxPackage.createPackageContents();

		// Initialize created meta-data
		theJqaPackage.initializePackageContents();
		theJqa_ctxPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJqaPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(JqaPackage.eNS_URI, theJqaPackage);
		return theJqaPackage;
	}


	/**
	 * Returns the meta object for class '{@link ar.com.fluxit.jqa.context.model.jqa.Ruleset <em>Ruleset</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Ruleset</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.Ruleset
	 * @generated
	 */
	public EClass getRuleset() {
		return rulesetEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link ar.com.fluxit.jqa.context.model.jqa.Ruleset#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.Ruleset#getName()
	 * @see #getRuleset()
	 * @generated
	 */
	public EAttribute getRuleset_Name() {
		return (EAttribute)rulesetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link ar.com.fluxit.jqa.context.model.jqa.Ruleset#getRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rule</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.Ruleset#getRule()
	 * @see #getRuleset()
	 * @generated
	 */
	public EReference getRuleset_Rule() {
		return (EReference)rulesetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link ar.com.fluxit.jqa.context.model.jqa.Rule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.Rule
	 * @generated
	 */
	public EClass getRule() {
		return ruleEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link ar.com.fluxit.jqa.context.model.jqa.Rule#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.Rule#getName()
	 * @see #getRule()
	 * @generated
	 */
	public EAttribute getRule_Name() {
		return (EAttribute)ruleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference '{@link ar.com.fluxit.jqa.context.model.jqa.Rule#getFilterPredicate <em>Filter Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Filter Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.Rule#getFilterPredicate()
	 * @see #getRule()
	 * @generated
	 */
	public EReference getRule_FilterPredicate() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for the containment reference '{@link ar.com.fluxit.jqa.context.model.jqa.Rule#getCheckPredicate <em>Check Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Check Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.Rule#getCheckPredicate()
	 * @see #getRule()
	 * @generated
	 */
	public EReference getRule_CheckPredicate() {
		return (EReference)ruleEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * Returns the meta object for class '{@link ar.com.fluxit.jqa.context.model.jqa.Predicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.Predicate
	 * @generated
	 */
	public EClass getPredicate() {
		return predicateEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link ar.com.fluxit.jqa.context.model.jqa.Predicate#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.Predicate#getName()
	 * @see #getPredicate()
	 * @generated
	 */
	public EAttribute getPredicate_Name() {
		return (EAttribute)predicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link ar.com.fluxit.jqa.context.model.jqa.ContextProvidedPredicate <em>Context Provided Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Context Provided Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.ContextProvidedPredicate
	 * @generated
	 */
	public EClass getContextProvidedPredicate() {
		return contextProvidedPredicateEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link ar.com.fluxit.jqa.context.model.jqa.ContextProvidedPredicate#getProvidedPredicateName <em>Provided Predicate Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Provided Predicate Name</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.ContextProvidedPredicate#getProvidedPredicateName()
	 * @see #getContextProvidedPredicate()
	 * @generated
	 */
	public EAttribute getContextProvidedPredicate_ProvidedPredicateName() {
		return (EAttribute)contextProvidedPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link ar.com.fluxit.jqa.context.model.jqa.FilteredPredicate <em>Filtered Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Filtered Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.FilteredPredicate
	 * @generated
	 */
	public EClass getFilteredPredicate() {
		return filteredPredicateEClass;
	}

	/**
	 * Returns the meta object for the containment reference '{@link ar.com.fluxit.jqa.context.model.jqa.FilteredPredicate#getFilterPredicate <em>Filter Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Filter Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.FilteredPredicate#getFilterPredicate()
	 * @see #getFilteredPredicate()
	 * @generated
	 */
	public EReference getFilteredPredicate_FilterPredicate() {
		return (EReference)filteredPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link ar.com.fluxit.jqa.context.model.jqa.AbstractionPredicate <em>Abstraction Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Abstraction Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.AbstractionPredicate
	 * @generated
	 */
	public EClass getAbstractionPredicate() {
		return abstractionPredicateEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link ar.com.fluxit.jqa.context.model.jqa.AbstractionPredicate#getAbstractionType <em>Abstraction Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Abstraction Type</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.AbstractionPredicate#getAbstractionType()
	 * @see #getAbstractionPredicate()
	 * @generated
	 */
	public EAttribute getAbstractionPredicate_AbstractionType() {
		return (EAttribute)abstractionPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link ar.com.fluxit.jqa.context.model.jqa.AllocationPredicate <em>Allocation Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Allocation Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.AllocationPredicate
	 * @generated
	 */
	public EClass getAllocationPredicate() {
		return allocationPredicateEClass;
	}

	/**
	 * Returns the meta object for class '{@link ar.com.fluxit.jqa.context.model.jqa.NamingPredicate <em>Naming Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Naming Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.NamingPredicate
	 * @generated
	 */
	public EClass getNamingPredicate() {
		return namingPredicateEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link ar.com.fluxit.jqa.context.model.jqa.NamingPredicate#getClassNamePattern <em>Class Name Pattern</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Class Name Pattern</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.NamingPredicate#getClassNamePattern()
	 * @see #getNamingPredicate()
	 * @generated
	 */
	public EAttribute getNamingPredicate_ClassNamePattern() {
		return (EAttribute)namingPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link ar.com.fluxit.jqa.context.model.jqa.ThrowingPredicate <em>Throwing Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Throwing Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.ThrowingPredicate
	 * @generated
	 */
	public EClass getThrowingPredicate() {
		return throwingPredicateEClass;
	}

	/**
	 * Returns the meta object for class '{@link ar.com.fluxit.jqa.context.model.jqa.TypingPredicate <em>Typing Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typing Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.TypingPredicate
	 * @generated
	 */
	public EClass getTypingPredicate() {
		return typingPredicateEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link ar.com.fluxit.jqa.context.model.jqa.TypingPredicate#getParentClassName <em>Parent Class Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Parent Class Name</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.TypingPredicate#getParentClassName()
	 * @see #getTypingPredicate()
	 * @generated
	 */
	public EAttribute getTypingPredicate_ParentClassName() {
		return (EAttribute)typingPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link ar.com.fluxit.jqa.context.model.jqa.UsagePredicate <em>Usage Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Usage Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.UsagePredicate
	 * @generated
	 */
	public EClass getUsagePredicate() {
		return usagePredicateEClass;
	}

	/**
	 * Returns the meta object for class '{@link ar.com.fluxit.jqa.context.model.jqa.VarArgsLogicPredicate <em>Var Args Logic Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var Args Logic Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.VarArgsLogicPredicate
	 * @generated
	 */
	public EClass getVarArgsLogicPredicate() {
		return varArgsLogicPredicateEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link ar.com.fluxit.jqa.context.model.jqa.VarArgsLogicPredicate#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.VarArgsLogicPredicate#getPredicate()
	 * @see #getVarArgsLogicPredicate()
	 * @generated
	 */
	public EReference getVarArgsLogicPredicate_Predicate() {
		return (EReference)varArgsLogicPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link ar.com.fluxit.jqa.context.model.jqa.AndPredicate <em>And Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>And Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.AndPredicate
	 * @generated
	 */
	public EClass getAndPredicate() {
		return andPredicateEClass;
	}

	/**
	 * Returns the meta object for class '{@link ar.com.fluxit.jqa.context.model.jqa.FalsePredicate <em>False Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>False Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.FalsePredicate
	 * @generated
	 */
	public EClass getFalsePredicate() {
		return falsePredicateEClass;
	}

	/**
	 * Returns the meta object for class '{@link ar.com.fluxit.jqa.context.model.jqa.NotPredicate <em>Not Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Not Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.NotPredicate
	 * @generated
	 */
	public EClass getNotPredicate() {
		return notPredicateEClass;
	}

	/**
	 * Returns the meta object for the containment reference '{@link ar.com.fluxit.jqa.context.model.jqa.NotPredicate#getPredicate <em>Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.NotPredicate#getPredicate()
	 * @see #getNotPredicate()
	 * @generated
	 */
	public EReference getNotPredicate_Predicate() {
		return (EReference)notPredicateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for class '{@link ar.com.fluxit.jqa.context.model.jqa.OrPredicate <em>Or Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Or Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.OrPredicate
	 * @generated
	 */
	public EClass getOrPredicate() {
		return orPredicateEClass;
	}

	/**
	 * Returns the meta object for class '{@link ar.com.fluxit.jqa.context.model.jqa.TruePredicate <em>True Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>True Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.TruePredicate
	 * @generated
	 */
	public EClass getTruePredicate() {
		return truePredicateEClass;
	}

	/**
	 * Returns the meta object for class '{@link ar.com.fluxit.jqa.context.model.jqa.XORPredicate <em>XOR Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>XOR Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.XORPredicate
	 * @generated
	 */
	public EClass getXORPredicate() {
		return xorPredicateEClass;
	}

	/**
	 * Returns the meta object for enum '{@link ar.com.fluxit.jqa.context.model.jqa.AbstractionType <em>Abstraction Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Abstraction Type</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa.AbstractionType
	 * @generated
	 */
	public EEnum getAbstractionType() {
		return abstractionTypeEEnum;
	}

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public JqaFactory getJqaFactory() {
		return (JqaFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		rulesetEClass = createEClass(RULESET);
		createEAttribute(rulesetEClass, RULESET__NAME);
		createEReference(rulesetEClass, RULESET__RULE);

		ruleEClass = createEClass(RULE);
		createEAttribute(ruleEClass, RULE__NAME);
		createEReference(ruleEClass, RULE__FILTER_PREDICATE);
		createEReference(ruleEClass, RULE__CHECK_PREDICATE);

		predicateEClass = createEClass(PREDICATE);
		createEAttribute(predicateEClass, PREDICATE__NAME);

		contextProvidedPredicateEClass = createEClass(CONTEXT_PROVIDED_PREDICATE);
		createEAttribute(contextProvidedPredicateEClass, CONTEXT_PROVIDED_PREDICATE__PROVIDED_PREDICATE_NAME);

		filteredPredicateEClass = createEClass(FILTERED_PREDICATE);
		createEReference(filteredPredicateEClass, FILTERED_PREDICATE__FILTER_PREDICATE);

		abstractionPredicateEClass = createEClass(ABSTRACTION_PREDICATE);
		createEAttribute(abstractionPredicateEClass, ABSTRACTION_PREDICATE__ABSTRACTION_TYPE);

		allocationPredicateEClass = createEClass(ALLOCATION_PREDICATE);

		namingPredicateEClass = createEClass(NAMING_PREDICATE);
		createEAttribute(namingPredicateEClass, NAMING_PREDICATE__CLASS_NAME_PATTERN);

		throwingPredicateEClass = createEClass(THROWING_PREDICATE);

		typingPredicateEClass = createEClass(TYPING_PREDICATE);
		createEAttribute(typingPredicateEClass, TYPING_PREDICATE__PARENT_CLASS_NAME);

		usagePredicateEClass = createEClass(USAGE_PREDICATE);

		varArgsLogicPredicateEClass = createEClass(VAR_ARGS_LOGIC_PREDICATE);
		createEReference(varArgsLogicPredicateEClass, VAR_ARGS_LOGIC_PREDICATE__PREDICATE);

		andPredicateEClass = createEClass(AND_PREDICATE);

		falsePredicateEClass = createEClass(FALSE_PREDICATE);

		notPredicateEClass = createEClass(NOT_PREDICATE);
		createEReference(notPredicateEClass, NOT_PREDICATE__PREDICATE);

		orPredicateEClass = createEClass(OR_PREDICATE);

		truePredicateEClass = createEClass(TRUE_PREDICATE);

		xorPredicateEClass = createEClass(XOR_PREDICATE);

		// Create enums
		abstractionTypeEEnum = createEEnum(ABSTRACTION_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		contextProvidedPredicateEClass.getESuperTypes().add(this.getPredicate());
		filteredPredicateEClass.getESuperTypes().add(this.getPredicate());
		abstractionPredicateEClass.getESuperTypes().add(this.getPredicate());
		allocationPredicateEClass.getESuperTypes().add(this.getFilteredPredicate());
		namingPredicateEClass.getESuperTypes().add(this.getPredicate());
		throwingPredicateEClass.getESuperTypes().add(this.getFilteredPredicate());
		typingPredicateEClass.getESuperTypes().add(this.getPredicate());
		usagePredicateEClass.getESuperTypes().add(this.getFilteredPredicate());
		varArgsLogicPredicateEClass.getESuperTypes().add(this.getPredicate());
		andPredicateEClass.getESuperTypes().add(this.getVarArgsLogicPredicate());
		falsePredicateEClass.getESuperTypes().add(this.getPredicate());
		notPredicateEClass.getESuperTypes().add(this.getPredicate());
		orPredicateEClass.getESuperTypes().add(this.getVarArgsLogicPredicate());
		truePredicateEClass.getESuperTypes().add(this.getPredicate());
		xorPredicateEClass.getESuperTypes().add(this.getVarArgsLogicPredicate());

		// Initialize classes and features; add operations and parameters
		initEClass(rulesetEClass, Ruleset.class, "Ruleset", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRuleset_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, Ruleset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRuleset_Rule(), this.getRule(), null, "rule", null, 1, -1, Ruleset.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleEClass, Rule.class, "Rule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRule_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_FilterPredicate(), this.getPredicate(), null, "filterPredicate", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRule_CheckPredicate(), this.getPredicate(), null, "checkPredicate", null, 1, 1, Rule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(predicateEClass, Predicate.class, "Predicate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPredicate_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, Predicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contextProvidedPredicateEClass, ContextProvidedPredicate.class, "ContextProvidedPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getContextProvidedPredicate_ProvidedPredicateName(), theXMLTypePackage.getString(), "providedPredicateName", null, 1, 1, ContextProvidedPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(filteredPredicateEClass, FilteredPredicate.class, "FilteredPredicate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFilteredPredicate_FilterPredicate(), this.getPredicate(), null, "filterPredicate", null, 1, 1, FilteredPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(abstractionPredicateEClass, AbstractionPredicate.class, "AbstractionPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAbstractionPredicate_AbstractionType(), this.getAbstractionType(), "abstractionType", null, 1, 1, AbstractionPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(allocationPredicateEClass, AllocationPredicate.class, "AllocationPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(namingPredicateEClass, NamingPredicate.class, "NamingPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNamingPredicate_ClassNamePattern(), theXMLTypePackage.getString(), "classNamePattern", null, 1, 1, NamingPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(throwingPredicateEClass, ThrowingPredicate.class, "ThrowingPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(typingPredicateEClass, TypingPredicate.class, "TypingPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTypingPredicate_ParentClassName(), theXMLTypePackage.getString(), "parentClassName", null, 1, 1, TypingPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(usagePredicateEClass, UsagePredicate.class, "UsagePredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(varArgsLogicPredicateEClass, VarArgsLogicPredicate.class, "VarArgsLogicPredicate", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getVarArgsLogicPredicate_Predicate(), this.getPredicate(), null, "predicate", null, 1, -1, VarArgsLogicPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(andPredicateEClass, AndPredicate.class, "AndPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(falsePredicateEClass, FalsePredicate.class, "FalsePredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(notPredicateEClass, NotPredicate.class, "NotPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNotPredicate_Predicate(), this.getPredicate(), null, "predicate", null, 1, 1, NotPredicate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(orPredicateEClass, OrPredicate.class, "OrPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(truePredicateEClass, TruePredicate.class, "TruePredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(xorPredicateEClass, XORPredicate.class, "XORPredicate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Initialize enums and add enum literals
		initEEnum(abstractionTypeEEnum, AbstractionType.class, "AbstractionType");
		addEEnumLiteral(abstractionTypeEEnum, AbstractionType.ABSTRACT);
		addEEnumLiteral(abstractionTypeEEnum, AbstractionType.INTERFACE);
		addEEnumLiteral(abstractionTypeEEnum, AbstractionType.CONCRETE);

		// Create resource
		createResource(eNS_URI);
	}

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public interface Literals {
		/**
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa.Ruleset <em>Ruleset</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa.Ruleset
		 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getRuleset()
		 * @generated
		 */
		public static final EClass RULESET = eINSTANCE.getRuleset();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute RULESET__NAME = eINSTANCE.getRuleset_Name();

		/**
		 * The meta object literal for the '<em><b>Rule</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference RULESET__RULE = eINSTANCE.getRuleset_Rule();

		/**
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa.Rule <em>Rule</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa.Rule
		 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getRule()
		 * @generated
		 */
		public static final EClass RULE = eINSTANCE.getRule();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute RULE__NAME = eINSTANCE.getRule_Name();

		/**
		 * The meta object literal for the '<em><b>Filter Predicate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference RULE__FILTER_PREDICATE = eINSTANCE.getRule_FilterPredicate();

		/**
		 * The meta object literal for the '<em><b>Check Predicate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference RULE__CHECK_PREDICATE = eINSTANCE.getRule_CheckPredicate();

		/**
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa.Predicate <em>Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa.Predicate
		 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getPredicate()
		 * @generated
		 */
		public static final EClass PREDICATE = eINSTANCE.getPredicate();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute PREDICATE__NAME = eINSTANCE.getPredicate_Name();

		/**
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa.ContextProvidedPredicate <em>Context Provided Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa.ContextProvidedPredicate
		 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getContextProvidedPredicate()
		 * @generated
		 */
		public static final EClass CONTEXT_PROVIDED_PREDICATE = eINSTANCE.getContextProvidedPredicate();

		/**
		 * The meta object literal for the '<em><b>Provided Predicate Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute CONTEXT_PROVIDED_PREDICATE__PROVIDED_PREDICATE_NAME = eINSTANCE.getContextProvidedPredicate_ProvidedPredicateName();

		/**
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa.FilteredPredicate <em>Filtered Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa.FilteredPredicate
		 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getFilteredPredicate()
		 * @generated
		 */
		public static final EClass FILTERED_PREDICATE = eINSTANCE.getFilteredPredicate();

		/**
		 * The meta object literal for the '<em><b>Filter Predicate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference FILTERED_PREDICATE__FILTER_PREDICATE = eINSTANCE.getFilteredPredicate_FilterPredicate();

		/**
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa.AbstractionPredicate <em>Abstraction Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa.AbstractionPredicate
		 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getAbstractionPredicate()
		 * @generated
		 */
		public static final EClass ABSTRACTION_PREDICATE = eINSTANCE.getAbstractionPredicate();

		/**
		 * The meta object literal for the '<em><b>Abstraction Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute ABSTRACTION_PREDICATE__ABSTRACTION_TYPE = eINSTANCE.getAbstractionPredicate_AbstractionType();

		/**
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa.AllocationPredicate <em>Allocation Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa.AllocationPredicate
		 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getAllocationPredicate()
		 * @generated
		 */
		public static final EClass ALLOCATION_PREDICATE = eINSTANCE.getAllocationPredicate();

		/**
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa.NamingPredicate <em>Naming Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa.NamingPredicate
		 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getNamingPredicate()
		 * @generated
		 */
		public static final EClass NAMING_PREDICATE = eINSTANCE.getNamingPredicate();

		/**
		 * The meta object literal for the '<em><b>Class Name Pattern</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute NAMING_PREDICATE__CLASS_NAME_PATTERN = eINSTANCE.getNamingPredicate_ClassNamePattern();

		/**
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa.ThrowingPredicate <em>Throwing Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa.ThrowingPredicate
		 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getThrowingPredicate()
		 * @generated
		 */
		public static final EClass THROWING_PREDICATE = eINSTANCE.getThrowingPredicate();

		/**
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa.TypingPredicate <em>Typing Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa.TypingPredicate
		 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getTypingPredicate()
		 * @generated
		 */
		public static final EClass TYPING_PREDICATE = eINSTANCE.getTypingPredicate();

		/**
		 * The meta object literal for the '<em><b>Parent Class Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute TYPING_PREDICATE__PARENT_CLASS_NAME = eINSTANCE.getTypingPredicate_ParentClassName();

		/**
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa.UsagePredicate <em>Usage Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa.UsagePredicate
		 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getUsagePredicate()
		 * @generated
		 */
		public static final EClass USAGE_PREDICATE = eINSTANCE.getUsagePredicate();

		/**
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa.VarArgsLogicPredicate <em>Var Args Logic Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa.VarArgsLogicPredicate
		 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getVarArgsLogicPredicate()
		 * @generated
		 */
		public static final EClass VAR_ARGS_LOGIC_PREDICATE = eINSTANCE.getVarArgsLogicPredicate();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference VAR_ARGS_LOGIC_PREDICATE__PREDICATE = eINSTANCE.getVarArgsLogicPredicate_Predicate();

		/**
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa.AndPredicate <em>And Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa.AndPredicate
		 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getAndPredicate()
		 * @generated
		 */
		public static final EClass AND_PREDICATE = eINSTANCE.getAndPredicate();

		/**
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa.FalsePredicate <em>False Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa.FalsePredicate
		 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getFalsePredicate()
		 * @generated
		 */
		public static final EClass FALSE_PREDICATE = eINSTANCE.getFalsePredicate();

		/**
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa.NotPredicate <em>Not Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa.NotPredicate
		 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getNotPredicate()
		 * @generated
		 */
		public static final EClass NOT_PREDICATE = eINSTANCE.getNotPredicate();

		/**
		 * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference NOT_PREDICATE__PREDICATE = eINSTANCE.getNotPredicate_Predicate();

		/**
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa.OrPredicate <em>Or Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa.OrPredicate
		 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getOrPredicate()
		 * @generated
		 */
		public static final EClass OR_PREDICATE = eINSTANCE.getOrPredicate();

		/**
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa.TruePredicate <em>True Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa.TruePredicate
		 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getTruePredicate()
		 * @generated
		 */
		public static final EClass TRUE_PREDICATE = eINSTANCE.getTruePredicate();

		/**
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa.XORPredicate <em>XOR Predicate</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa.XORPredicate
		 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getXORPredicate()
		 * @generated
		 */
		public static final EClass XOR_PREDICATE = eINSTANCE.getXORPredicate();

		/**
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa.AbstractionType <em>Abstraction Type</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa.AbstractionType
		 * @see ar.com.fluxit.jqa.context.model.jqa.JqaPackage#getAbstractionType()
		 * @generated
		 */
		public static final EEnum ABSTRACTION_TYPE = eINSTANCE.getAbstractionType();

	}

} //JqaPackage
