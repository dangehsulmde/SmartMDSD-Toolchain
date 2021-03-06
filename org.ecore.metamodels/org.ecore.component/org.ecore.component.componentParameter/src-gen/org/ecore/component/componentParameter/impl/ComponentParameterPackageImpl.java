/**
 */
package org.ecore.component.componentParameter.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.ecore.base.basicAttributes.BasicAttributesPackage;

import org.ecore.base.stateMachine.StateMachinePackage;

import org.ecore.component.componentDefinition.ComponentDefinitionPackage;

import org.ecore.component.componentParameter.AbstractComponentParameter;
import org.ecore.component.componentParameter.AbstractParameterInstance;
import org.ecore.component.componentParameter.ComponentParamModel;
import org.ecore.component.componentParameter.ComponentParameter;
import org.ecore.component.componentParameter.ComponentParameterBase;
import org.ecore.component.componentParameter.ComponentParameterFactory;
import org.ecore.component.componentParameter.ComponentParameterPackage;
import org.ecore.component.componentParameter.ComponentParametersRef;
import org.ecore.component.componentParameter.ExtendedParameter;
import org.ecore.component.componentParameter.ExtendedTrigger;
import org.ecore.component.componentParameter.InternalParameter;
import org.ecore.component.componentParameter.ParameterInstance;
import org.ecore.component.componentParameter.ParameterSetInstance;
import org.ecore.component.componentParameter.TriggerInstance;

import org.ecore.component.coordinationExtension.CoordinationExtensionPackage;
import org.ecore.service.communicationObject.CommunicationObjectPackage;

import org.ecore.service.communicationPattern.CommunicationPatternPackage;

import org.ecore.service.componentMode.ComponentModePackage;
import org.ecore.service.coordinationPattern.CoordinationPatternPackage;

import org.ecore.service.parameterDefinition.ParameterDefinitionPackage;

import org.ecore.service.serviceDefinition.ServiceDefinitionPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ComponentParameterPackageImpl extends EPackageImpl implements ComponentParameterPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractComponentParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentParameterBaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass internalParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendedParameterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass extendedTriggerEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterSetInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass abstractParameterInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass triggerInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass parameterInstanceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentParamModelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentParametersRefEClass = null;

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
	 * @see org.ecore.component.componentParameter.ComponentParameterPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ComponentParameterPackageImpl() {
		super(eNS_URI, ComponentParameterFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ComponentParameterPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ComponentParameterPackage init() {
		if (isInited)
			return (ComponentParameterPackage) EPackage.Registry.INSTANCE
					.getEPackage(ComponentParameterPackage.eNS_URI);

		// Obtain or create and register package
		ComponentParameterPackageImpl theComponentParameterPackage = (ComponentParameterPackageImpl) (EPackage.Registry.INSTANCE
				.get(eNS_URI) instanceof ComponentParameterPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI)
						: new ComponentParameterPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		BasicAttributesPackage.eINSTANCE.eClass();
		CommunicationObjectPackage.eINSTANCE.eClass();
		CommunicationPatternPackage.eINSTANCE.eClass();
		ComponentDefinitionPackage.eINSTANCE.eClass();
		ComponentModePackage.eINSTANCE.eClass();
		CoordinationExtensionPackage.eINSTANCE.eClass();
		CoordinationPatternPackage.eINSTANCE.eClass();
		ParameterDefinitionPackage.eINSTANCE.eClass();
		ServiceDefinitionPackage.eINSTANCE.eClass();
		StateMachinePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theComponentParameterPackage.createPackageContents();

		// Initialize created meta-data
		theComponentParameterPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theComponentParameterPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ComponentParameterPackage.eNS_URI, theComponentParameterPackage);
		return theComponentParameterPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentParameter() {
		return componentParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentParameter_Parameters() {
		return (EReference) componentParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentParameter_Component() {
		return (EReference) componentParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponentParameter_Name() {
		return (EAttribute) componentParameterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractComponentParameter() {
		return abstractComponentParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentParameterBase() {
		return componentParameterBaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getInternalParameter() {
		return internalParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getInternalParameter_Name() {
		return (EAttribute) internalParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getInternalParameter_Attributes() {
		return (EReference) internalParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendedParameter() {
		return extendedParameterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedParameter_Name() {
		return (EAttribute) extendedParameterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedParameter_Attributes() {
		return (EReference) extendedParameterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExtendedTrigger() {
		return extendedTriggerEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedTrigger_Name() {
		return (EAttribute) extendedTriggerEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getExtendedTrigger_Active() {
		return (EAttribute) extendedTriggerEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExtendedTrigger_Attributes() {
		return (EReference) extendedTriggerEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterSetInstance() {
		return parameterSetInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterSetInstance_ParameterInstances() {
		return (EReference) parameterSetInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterSetInstance_ParamSet() {
		return (EReference) parameterSetInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterSetInstance_Name() {
		return (EAttribute) parameterSetInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAbstractParameterInstance() {
		return abstractParameterInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTriggerInstance() {
		return triggerInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getTriggerInstance_TriggerDef() {
		return (EReference) triggerInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTriggerInstance_Active() {
		return (EAttribute) triggerInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getParameterInstance() {
		return parameterInstanceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterInstance_ParameterDef() {
		return (EReference) parameterInstanceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getParameterInstance_Attributes() {
		return (EReference) parameterInstanceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getParameterInstance_Name() {
		return (EAttribute) parameterInstanceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentParamModel() {
		return componentParamModelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentParamModel_Parametrization() {
		return (EReference) componentParamModelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentParamModel_Imports() {
		return (EReference) componentParamModelEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponentParametersRef() {
		return componentParametersRefEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentParametersRef_Parameter() {
		return (EReference) componentParametersRefEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponentParametersRef_Slave() {
		return (EReference) componentParametersRefEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentParameterFactory getComponentParameterFactory() {
		return (ComponentParameterFactory) getEFactoryInstance();
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
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		componentParameterEClass = createEClass(COMPONENT_PARAMETER);
		createEReference(componentParameterEClass, COMPONENT_PARAMETER__PARAMETERS);
		createEReference(componentParameterEClass, COMPONENT_PARAMETER__COMPONENT);
		createEAttribute(componentParameterEClass, COMPONENT_PARAMETER__NAME);

		abstractComponentParameterEClass = createEClass(ABSTRACT_COMPONENT_PARAMETER);

		componentParameterBaseEClass = createEClass(COMPONENT_PARAMETER_BASE);

		internalParameterEClass = createEClass(INTERNAL_PARAMETER);
		createEAttribute(internalParameterEClass, INTERNAL_PARAMETER__NAME);
		createEReference(internalParameterEClass, INTERNAL_PARAMETER__ATTRIBUTES);

		extendedParameterEClass = createEClass(EXTENDED_PARAMETER);
		createEAttribute(extendedParameterEClass, EXTENDED_PARAMETER__NAME);
		createEReference(extendedParameterEClass, EXTENDED_PARAMETER__ATTRIBUTES);

		extendedTriggerEClass = createEClass(EXTENDED_TRIGGER);
		createEAttribute(extendedTriggerEClass, EXTENDED_TRIGGER__NAME);
		createEAttribute(extendedTriggerEClass, EXTENDED_TRIGGER__ACTIVE);
		createEReference(extendedTriggerEClass, EXTENDED_TRIGGER__ATTRIBUTES);

		parameterSetInstanceEClass = createEClass(PARAMETER_SET_INSTANCE);
		createEReference(parameterSetInstanceEClass, PARAMETER_SET_INSTANCE__PARAMETER_INSTANCES);
		createEReference(parameterSetInstanceEClass, PARAMETER_SET_INSTANCE__PARAM_SET);
		createEAttribute(parameterSetInstanceEClass, PARAMETER_SET_INSTANCE__NAME);

		abstractParameterInstanceEClass = createEClass(ABSTRACT_PARAMETER_INSTANCE);

		triggerInstanceEClass = createEClass(TRIGGER_INSTANCE);
		createEReference(triggerInstanceEClass, TRIGGER_INSTANCE__TRIGGER_DEF);
		createEAttribute(triggerInstanceEClass, TRIGGER_INSTANCE__ACTIVE);

		parameterInstanceEClass = createEClass(PARAMETER_INSTANCE);
		createEReference(parameterInstanceEClass, PARAMETER_INSTANCE__PARAMETER_DEF);
		createEReference(parameterInstanceEClass, PARAMETER_INSTANCE__ATTRIBUTES);
		createEAttribute(parameterInstanceEClass, PARAMETER_INSTANCE__NAME);

		componentParamModelEClass = createEClass(COMPONENT_PARAM_MODEL);
		createEReference(componentParamModelEClass, COMPONENT_PARAM_MODEL__PARAMETRIZATION);
		createEReference(componentParamModelEClass, COMPONENT_PARAM_MODEL__IMPORTS);

		componentParametersRefEClass = createEClass(COMPONENT_PARAMETERS_REF);
		createEReference(componentParametersRefEClass, COMPONENT_PARAMETERS_REF__PARAMETER);
		createEReference(componentParametersRefEClass, COMPONENT_PARAMETERS_REF__SLAVE);
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
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		ComponentDefinitionPackage theComponentDefinitionPackage = (ComponentDefinitionPackage) EPackage.Registry.INSTANCE
				.getEPackage(ComponentDefinitionPackage.eNS_URI);
		BasicAttributesPackage theBasicAttributesPackage = (BasicAttributesPackage) EPackage.Registry.INSTANCE
				.getEPackage(BasicAttributesPackage.eNS_URI);
		ParameterDefinitionPackage theParameterDefinitionPackage = (ParameterDefinitionPackage) EPackage.Registry.INSTANCE
				.getEPackage(ParameterDefinitionPackage.eNS_URI);
		CoordinationExtensionPackage theCoordinationExtensionPackage = (CoordinationExtensionPackage) EPackage.Registry.INSTANCE
				.getEPackage(CoordinationExtensionPackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		internalParameterEClass.getESuperTypes().add(this.getAbstractComponentParameter());
		internalParameterEClass.getESuperTypes().add(this.getComponentParameterBase());
		extendedParameterEClass.getESuperTypes().add(this.getAbstractComponentParameter());
		extendedParameterEClass.getESuperTypes().add(this.getComponentParameterBase());
		extendedTriggerEClass.getESuperTypes().add(this.getAbstractComponentParameter());
		parameterSetInstanceEClass.getESuperTypes().add(this.getAbstractComponentParameter());
		triggerInstanceEClass.getESuperTypes().add(this.getAbstractParameterInstance());
		parameterInstanceEClass.getESuperTypes().add(this.getAbstractParameterInstance());
		parameterInstanceEClass.getESuperTypes().add(this.getComponentParameterBase());
		componentParametersRefEClass.getESuperTypes().add(theComponentDefinitionPackage.getDerivedComponentElement());

		// Initialize classes and features; add operations and parameters
		initEClass(componentParameterEClass, ComponentParameter.class, "ComponentParameter", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentParameter_Parameters(), this.getAbstractComponentParameter(), null, "parameters",
				null, 0, -1, ComponentParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentParameter_Component(), theComponentDefinitionPackage.getComponentDefinition(), null,
				"component", null, 0, 1, ComponentParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponentParameter_Name(), ecorePackage.getEString(), "name", null, 1, 1,
				ComponentParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(abstractComponentParameterEClass, AbstractComponentParameter.class, "AbstractComponentParameter",
				IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(componentParameterBaseEClass, ComponentParameterBase.class, "ComponentParameterBase", IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(internalParameterEClass, InternalParameter.class, "InternalParameter", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getInternalParameter_Name(), ecorePackage.getEString(), "name", null, 1, 1,
				InternalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getInternalParameter_Attributes(), theBasicAttributesPackage.getAttributeDefinition(), null,
				"attributes", null, 0, -1, InternalParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extendedParameterEClass, ExtendedParameter.class, "ExtendedParameter", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtendedParameter_Name(), ecorePackage.getEString(), "name", null, 1, 1,
				ExtendedParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getExtendedParameter_Attributes(), theBasicAttributesPackage.getAttributeDefinition(), null,
				"attributes", null, 0, -1, ExtendedParameter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(extendedTriggerEClass, ExtendedTrigger.class, "ExtendedTrigger", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExtendedTrigger_Name(), ecorePackage.getEString(), "name", null, 1, 1, ExtendedTrigger.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExtendedTrigger_Active(), ecorePackage.getEBoolean(), "active", null, 1, 1,
				ExtendedTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getExtendedTrigger_Attributes(), theBasicAttributesPackage.getAttributeDefinition(), null,
				"attributes", null, 0, -1, ExtendedTrigger.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(parameterSetInstanceEClass, ParameterSetInstance.class, "ParameterSetInstance", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterSetInstance_ParameterInstances(), this.getAbstractParameterInstance(), null,
				"parameterInstances", null, 0, -1, ParameterSetInstance.class, !IS_TRANSIENT, !IS_VOLATILE,
				IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameterSetInstance_ParamSet(), theParameterDefinitionPackage.getParameterSetDefinition(),
				null, "paramSet", null, 1, 1, ParameterSetInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameterSetInstance_Name(), ecorePackage.getEString(), "name", null, 1, 1,
				ParameterSetInstance.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				IS_DERIVED, IS_ORDERED);

		initEClass(abstractParameterInstanceEClass, AbstractParameterInstance.class, "AbstractParameterInstance",
				IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(triggerInstanceEClass, TriggerInstance.class, "TriggerInstance", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getTriggerInstance_TriggerDef(), theParameterDefinitionPackage.getTriggerDefinition(), null,
				"triggerDef", null, 1, 1, TriggerInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTriggerInstance_Active(), ecorePackage.getEBoolean(), "active", null, 1, 1,
				TriggerInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(parameterInstanceEClass, ParameterInstance.class, "ParameterInstance", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getParameterInstance_ParameterDef(), theParameterDefinitionPackage.getParameterDefinition(),
				null, "parameterDef", null, 1, 1, ParameterInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getParameterInstance_Attributes(), theBasicAttributesPackage.getAttributeRefinement(), null,
				"attributes", null, 0, -1, ParameterInstance.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getParameterInstance_Name(), ecorePackage.getEString(), "name", null, 1, 1,
				ParameterInstance.class, IS_TRANSIENT, IS_VOLATILE, !IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				IS_DERIVED, IS_ORDERED);

		initEClass(componentParamModelEClass, ComponentParamModel.class, "ComponentParamModel", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentParamModel_Parametrization(), this.getComponentParameter(), null, "parametrization",
				null, 0, 1, ComponentParamModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentParamModel_Imports(), theParameterDefinitionPackage.getParamDefRepoImport(), null,
				"imports", null, 0, -1, ComponentParamModel.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(componentParametersRefEClass, ComponentParametersRef.class, "ComponentParametersRef", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponentParametersRef_Parameter(), this.getComponentParameter(), null, "parameter", null, 1,
				1, ComponentParametersRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponentParametersRef_Slave(), theCoordinationExtensionPackage.getCoordinationSlavePort(),
				null, "slave", null, 0, 1, ComponentParametersRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				!IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ComponentParameterPackageImpl
