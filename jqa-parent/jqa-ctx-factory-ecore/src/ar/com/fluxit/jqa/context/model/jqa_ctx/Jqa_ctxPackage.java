/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ar.com.fluxit.jqa.context.model.jqa_ctx;

import ar.com.fluxit.jqa.context.model.jqa.JqaPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see ar.com.fluxit.jqa.context.model.jqa_ctx.Jqa_ctxFactory
 * @model kind="package"
 * @generated
 */
public class Jqa_ctxPackage extends EPackageImpl {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNAME = "jqa_ctx";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_URI = "http://www.fluxit.com.ar/schema/rulescontext";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String eNS_PREFIX = "jqa_ctx";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final Jqa_ctxPackage eINSTANCE = ar.com.fluxit.jqa.context.model.jqa_ctx.Jqa_ctxPackage.init();

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa_ctx.RulesContext <em>Rules Context</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa_ctx.RulesContext
	 * @see ar.com.fluxit.jqa.context.model.jqa_ctx.Jqa_ctxPackage#getRulesContext()
	 * @generated
	 */
	public static final int RULES_CONTEXT = 0;

	/**
	 * The feature id for the '<em><b>Rule Set Import</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULES_CONTEXT__RULE_SET_IMPORT = 0;

	/**
	 * The feature id for the '<em><b>Global Predicate</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULES_CONTEXT__GLOBAL_PREDICATE = 1;

	/**
	 * The number of structural features of the '<em>Rules Context</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULES_CONTEXT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link ar.com.fluxit.jqa.context.model.jqa_ctx.RuleSetImport <em>Rule Set Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see ar.com.fluxit.jqa.context.model.jqa_ctx.RuleSetImport
	 * @see ar.com.fluxit.jqa.context.model.jqa_ctx.Jqa_ctxPackage#getRuleSetImport()
	 * @generated
	 */
	public static final int RULE_SET_IMPORT = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_SET_IMPORT__NAME = 0;

	/**
	 * The feature id for the '<em><b>File Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_SET_IMPORT__FILE_NAME = 1;

	/**
	 * The number of structural features of the '<em>Rule Set Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	public static final int RULE_SET_IMPORT_FEATURE_COUNT = 2;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rulesContextEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass ruleSetImportEClass = null;

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
	 * @see ar.com.fluxit.jqa.context.model.jqa_ctx.Jqa_ctxPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private Jqa_ctxPackage() {
		super(eNS_URI, Jqa_ctxFactory.INSTANCE);
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
	 * <p>This method is used to initialize {@link Jqa_ctxPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static Jqa_ctxPackage init() {
		if (isInited) return (Jqa_ctxPackage)EPackage.Registry.INSTANCE.getEPackage(Jqa_ctxPackage.eNS_URI);

		// Obtain or create and register package
		Jqa_ctxPackage theJqa_ctxPackage = (Jqa_ctxPackage)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof Jqa_ctxPackage ? EPackage.Registry.INSTANCE.get(eNS_URI) : new Jqa_ctxPackage());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Obtain or create and register interdependencies
		JqaPackage theJqaPackage = (JqaPackage)(EPackage.Registry.INSTANCE.getEPackage(JqaPackage.eNS_URI) instanceof JqaPackage ? EPackage.Registry.INSTANCE.getEPackage(JqaPackage.eNS_URI) : JqaPackage.eINSTANCE);

		// Create package meta-data objects
		theJqa_ctxPackage.createPackageContents();
		theJqaPackage.createPackageContents();

		// Initialize created meta-data
		theJqa_ctxPackage.initializePackageContents();
		theJqaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theJqa_ctxPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(Jqa_ctxPackage.eNS_URI, theJqa_ctxPackage);
		return theJqa_ctxPackage;
	}


	/**
	 * Returns the meta object for class '{@link ar.com.fluxit.jqa.context.model.jqa_ctx.RulesContext <em>Rules Context</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rules Context</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa_ctx.RulesContext
	 * @generated
	 */
	public EClass getRulesContext() {
		return rulesContextEClass;
	}

	/**
	 * Returns the meta object for the containment reference list '{@link ar.com.fluxit.jqa.context.model.jqa_ctx.RulesContext#getRuleSetImport <em>Rule Set Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rule Set Import</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa_ctx.RulesContext#getRuleSetImport()
	 * @see #getRulesContext()
	 * @generated
	 */
	public EReference getRulesContext_RuleSetImport() {
		return (EReference)rulesContextEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the containment reference list '{@link ar.com.fluxit.jqa.context.model.jqa_ctx.RulesContext#getGlobalPredicate <em>Global Predicate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Global Predicate</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa_ctx.RulesContext#getGlobalPredicate()
	 * @see #getRulesContext()
	 * @generated
	 */
	public EReference getRulesContext_GlobalPredicate() {
		return (EReference)rulesContextEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the meta object for class '{@link ar.com.fluxit.jqa.context.model.jqa_ctx.RuleSetImport <em>Rule Set Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Rule Set Import</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa_ctx.RuleSetImport
	 * @generated
	 */
	public EClass getRuleSetImport() {
		return ruleSetImportEClass;
	}

	/**
	 * Returns the meta object for the attribute '{@link ar.com.fluxit.jqa.context.model.jqa_ctx.RuleSetImport#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa_ctx.RuleSetImport#getName()
	 * @see #getRuleSetImport()
	 * @generated
	 */
	public EAttribute getRuleSetImport_Name() {
		return (EAttribute)ruleSetImportEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * Returns the meta object for the attribute '{@link ar.com.fluxit.jqa.context.model.jqa_ctx.RuleSetImport#getFileName <em>File Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>File Name</em>'.
	 * @see ar.com.fluxit.jqa.context.model.jqa_ctx.RuleSetImport#getFileName()
	 * @see #getRuleSetImport()
	 * @generated
	 */
	public EAttribute getRuleSetImport_FileName() {
		return (EAttribute)ruleSetImportEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	public Jqa_ctxFactory getJqa_ctxFactory() {
		return (Jqa_ctxFactory)getEFactoryInstance();
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
		rulesContextEClass = createEClass(RULES_CONTEXT);
		createEReference(rulesContextEClass, RULES_CONTEXT__RULE_SET_IMPORT);
		createEReference(rulesContextEClass, RULES_CONTEXT__GLOBAL_PREDICATE);

		ruleSetImportEClass = createEClass(RULE_SET_IMPORT);
		createEAttribute(ruleSetImportEClass, RULE_SET_IMPORT__NAME);
		createEAttribute(ruleSetImportEClass, RULE_SET_IMPORT__FILE_NAME);
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
		JqaPackage theJqaPackage = (JqaPackage)EPackage.Registry.INSTANCE.getEPackage(JqaPackage.eNS_URI);
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(rulesContextEClass, RulesContext.class, "RulesContext", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRulesContext_RuleSetImport(), this.getRuleSetImport(), null, "ruleSetImport", null, 1, -1, RulesContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRulesContext_GlobalPredicate(), theJqaPackage.getPredicate(), null, "globalPredicate", null, 0, -1, RulesContext.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(ruleSetImportEClass, RuleSetImport.class, "RuleSetImport", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRuleSetImport_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, RuleSetImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRuleSetImport_FileName(), theXMLTypePackage.getString(), "fileName", null, 0, 1, RuleSetImport.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

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
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa_ctx.RulesContext <em>Rules Context</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa_ctx.RulesContext
		 * @see ar.com.fluxit.jqa.context.model.jqa_ctx.Jqa_ctxPackage#getRulesContext()
		 * @generated
		 */
		public static final EClass RULES_CONTEXT = eINSTANCE.getRulesContext();

		/**
		 * The meta object literal for the '<em><b>Rule Set Import</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference RULES_CONTEXT__RULE_SET_IMPORT = eINSTANCE.getRulesContext_RuleSetImport();

		/**
		 * The meta object literal for the '<em><b>Global Predicate</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EReference RULES_CONTEXT__GLOBAL_PREDICATE = eINSTANCE.getRulesContext_GlobalPredicate();

		/**
		 * The meta object literal for the '{@link ar.com.fluxit.jqa.context.model.jqa_ctx.RuleSetImport <em>Rule Set Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see ar.com.fluxit.jqa.context.model.jqa_ctx.RuleSetImport
		 * @see ar.com.fluxit.jqa.context.model.jqa_ctx.Jqa_ctxPackage#getRuleSetImport()
		 * @generated
		 */
		public static final EClass RULE_SET_IMPORT = eINSTANCE.getRuleSetImport();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute RULE_SET_IMPORT__NAME = eINSTANCE.getRuleSetImport_Name();

		/**
		 * The meta object literal for the '<em><b>File Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		public static final EAttribute RULE_SET_IMPORT__FILE_NAME = eINSTANCE.getRuleSetImport_FileName();

	}

} //Jqa_ctxPackage
