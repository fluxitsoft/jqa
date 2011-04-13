/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package ar.com.fluxit.jqa.context.model.jqa_ctx;

import org.eclipse.emf.ecore.EClass;
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
public class Jqa_ctxFactory extends EFactoryImpl {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final Jqa_ctxFactory eINSTANCE = init();

	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final Jqa_ctxFactory INSTANCE = ar.com.fluxit.jqa.context.model.jqa_ctx.Jqa_ctxFactory.eINSTANCE;

	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static Jqa_ctxFactory init() {
		try {
			Jqa_ctxFactory theJqa_ctxFactory = (Jqa_ctxFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.fluxit.com.ar/schema/rulescontext"); 
			if (theJqa_ctxFactory != null) {
				return theJqa_ctxFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new Jqa_ctxFactory();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Jqa_ctxFactory() {
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
			case Jqa_ctxPackage.RULES_CONTEXT: return (EObject)createRulesContext();
			case Jqa_ctxPackage.RULE_SET_IMPORT: return (EObject)createRuleSetImport();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RulesContext createRulesContext() {
		RulesContext rulesContext = new RulesContext();
		return rulesContext;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RuleSetImport createRuleSetImport() {
		RuleSetImport ruleSetImport = new RuleSetImport();
		return ruleSetImport;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Jqa_ctxPackage getJqa_ctxPackage() {
		return (Jqa_ctxPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static Jqa_ctxPackage getPackage() {
		return Jqa_ctxPackage.eINSTANCE;
	}

} //Jqa_ctxFactory
