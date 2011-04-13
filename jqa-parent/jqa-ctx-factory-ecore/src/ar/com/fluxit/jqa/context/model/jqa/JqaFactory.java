/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ar.com.fluxit.jqa.context.model.jqa;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @generated
 */
public class JqaFactory extends EFactoryImpl {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final JqaFactory eINSTANCE = init();

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final JqaFactory INSTANCE = ar.com.fluxit.jqa.context.model.jqa.JqaFactory.eINSTANCE;

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static JqaFactory init() {
		try {
			JqaFactory theJqaFactory = (JqaFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.fluxit.com.ar/schema/ruleset"); 
			if (theJqaFactory != null) {
				return theJqaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new JqaFactory();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JqaFactory() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case JqaPackage.RULESET: return (EObject)createRuleset();
			case JqaPackage.RULE: return (EObject)createRule();
			case JqaPackage.CONTEXT_PROVIDED_PREDICATE: return (EObject)createContextProvidedPredicate();
			case JqaPackage.ABSTRACTION_PREDICATE: return (EObject)createAbstractionPredicate();
			case JqaPackage.ALLOCATION_PREDICATE: return (EObject)createAllocationPredicate();
			case JqaPackage.NAMING_PREDICATE: return (EObject)createNamingPredicate();
			case JqaPackage.THROWING_PREDICATE: return (EObject)createThrowingPredicate();
			case JqaPackage.TYPING_PREDICATE: return (EObject)createTypingPredicate();
			case JqaPackage.USAGE_PREDICATE: return (EObject)createUsagePredicate();
			case JqaPackage.AND_PREDICATE: return (EObject)createAndPredicate();
			case JqaPackage.FALSE_PREDICATE: return (EObject)createFalsePredicate();
			case JqaPackage.NOT_PREDICATE: return (EObject)createNotPredicate();
			case JqaPackage.OR_PREDICATE: return (EObject)createOrPredicate();
			case JqaPackage.TRUE_PREDICATE: return (EObject)createTruePredicate();
			case JqaPackage.XOR_PREDICATE: return (EObject)createXORPredicate();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case JqaPackage.ABSTRACTION_TYPE:
				return createAbstractionTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case JqaPackage.ABSTRACTION_TYPE:
				return convertAbstractionTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Ruleset createRuleset() {
		Ruleset ruleset = new Ruleset();
		return ruleset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Rule createRule() {
		Rule rule = new Rule();
		return rule;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ContextProvidedPredicate createContextProvidedPredicate() {
		ContextProvidedPredicate contextProvidedPredicate = new ContextProvidedPredicate();
		return contextProvidedPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractionPredicate createAbstractionPredicate() {
		AbstractionPredicate abstractionPredicate = new AbstractionPredicate();
		return abstractionPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AllocationPredicate createAllocationPredicate() {
		AllocationPredicate allocationPredicate = new AllocationPredicate();
		return allocationPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamingPredicate createNamingPredicate() {
		NamingPredicate namingPredicate = new NamingPredicate();
		return namingPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ThrowingPredicate createThrowingPredicate() {
		ThrowingPredicate throwingPredicate = new ThrowingPredicate();
		return throwingPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypingPredicate createTypingPredicate() {
		TypingPredicate typingPredicate = new TypingPredicate();
		return typingPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsagePredicate createUsagePredicate() {
		UsagePredicate usagePredicate = new UsagePredicate();
		return usagePredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AndPredicate createAndPredicate() {
		AndPredicate andPredicate = new AndPredicate();
		return andPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FalsePredicate createFalsePredicate() {
		FalsePredicate falsePredicate = new FalsePredicate();
		return falsePredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotPredicate createNotPredicate() {
		NotPredicate notPredicate = new NotPredicate();
		return notPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OrPredicate createOrPredicate() {
		OrPredicate orPredicate = new OrPredicate();
		return orPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TruePredicate createTruePredicate() {
		TruePredicate truePredicate = new TruePredicate();
		return truePredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public XORPredicate createXORPredicate() {
		XORPredicate xorPredicate = new XORPredicate();
		return xorPredicate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AbstractionType createAbstractionTypeFromString(EDataType eDataType, String initialValue) {
		AbstractionType result = AbstractionType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAbstractionTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public JqaPackage getJqaPackage() {
		return (JqaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static JqaPackage getPackage() {
		return JqaPackage.eINSTANCE;
	}

} //JqaFactory
