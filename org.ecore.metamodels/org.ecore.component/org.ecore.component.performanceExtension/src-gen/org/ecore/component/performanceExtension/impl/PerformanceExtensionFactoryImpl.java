/**
 */
package org.ecore.component.performanceExtension.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.ecore.component.performanceExtension.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class PerformanceExtensionFactoryImpl extends EFactoryImpl implements PerformanceExtensionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static PerformanceExtensionFactory init() {
		try {
			PerformanceExtensionFactory thePerformanceExtensionFactory = (PerformanceExtensionFactory) EPackage.Registry.INSTANCE
					.getEFactory(PerformanceExtensionPackage.eNS_URI);
			if (thePerformanceExtensionFactory != null) {
				return thePerformanceExtensionFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new PerformanceExtensionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerformanceExtensionFactoryImpl() {
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
		case PerformanceExtensionPackage.ACTIVATION_CONSTRAINTS:
			return createActivationConstraints();
		case PerformanceExtensionPackage.INPUT_LINK_EXTENSION:
			return createInputLinkExtension();
		case PerformanceExtensionPackage.DEFAULT_INPUT_TRIGGER:
			return createDefaultInputTrigger();
		case PerformanceExtensionPackage.DEFAULT_PERIODIC_TIMER:
			return createDefaultPeriodicTimer();
		case PerformanceExtensionPackage.DEFAULT_OBSERVED_ELEMENT_TRIGGER:
			return createDefaultObservedElementTrigger();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ActivationConstraints createActivationConstraints() {
		ActivationConstraintsImpl activationConstraints = new ActivationConstraintsImpl();
		return activationConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public InputLinkExtension createInputLinkExtension() {
		InputLinkExtensionImpl inputLinkExtension = new InputLinkExtensionImpl();
		return inputLinkExtension;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultInputTrigger createDefaultInputTrigger() {
		DefaultInputTriggerImpl defaultInputTrigger = new DefaultInputTriggerImpl();
		return defaultInputTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultPeriodicTimer createDefaultPeriodicTimer() {
		DefaultPeriodicTimerImpl defaultPeriodicTimer = new DefaultPeriodicTimerImpl();
		return defaultPeriodicTimer;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DefaultObservedElementTrigger createDefaultObservedElementTrigger() {
		DefaultObservedElementTriggerImpl defaultObservedElementTrigger = new DefaultObservedElementTriggerImpl();
		return defaultObservedElementTrigger;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PerformanceExtensionPackage getPerformanceExtensionPackage() {
		return (PerformanceExtensionPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static PerformanceExtensionPackage getPackage() {
		return PerformanceExtensionPackage.eINSTANCE;
	}

} //PerformanceExtensionFactoryImpl
