/**
 */
package org.ecore.system.componentArchitecture;

import org.ecore.component.componentDefinition.Activity;

import org.ecore.system.activityArchitecture.ActivityNode;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity Configuration Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.ecore.system.componentArchitecture.ActivityConfigurationMapping#getName <em>Name</em>}</li>
 *   <li>{@link org.ecore.system.componentArchitecture.ActivityConfigurationMapping#getActivity <em>Activity</em>}</li>
 *   <li>{@link org.ecore.system.componentArchitecture.ActivityConfigurationMapping#getConfig <em>Config</em>}</li>
 * </ul>
 *
 * @see org.ecore.system.componentArchitecture.ComponentArchitecturePackage#getActivityConfigurationMapping()
 * @model
 * @generated
 */
public interface ActivityConfigurationMapping extends ComponentInstanceConfigurationElement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #isSetName()
	 * @see org.ecore.system.componentArchitecture.ComponentArchitecturePackage#getActivityConfigurationMapping_Name()
	 * @model unsettable="true" required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getName();

	/**
	 * Returns whether the value of the '{@link org.ecore.system.componentArchitecture.ActivityConfigurationMapping#getName <em>Name</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Name</em>' attribute is set.
	 * @see #getName()
	 * @generated
	 */
	boolean isSetName();

	/**
	 * Returns the value of the '<em><b>Activity</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Activity</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Activity</em>' reference.
	 * @see #setActivity(Activity)
	 * @see org.ecore.system.componentArchitecture.ComponentArchitecturePackage#getActivityConfigurationMapping_Activity()
	 * @model required="true"
	 * @generated
	 */
	Activity getActivity();

	/**
	 * Sets the value of the '{@link org.ecore.system.componentArchitecture.ActivityConfigurationMapping#getActivity <em>Activity</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Activity</em>' reference.
	 * @see #getActivity()
	 * @generated
	 */
	void setActivity(Activity value);

	/**
	 * Returns the value of the '<em><b>Config</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Config</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Config</em>' reference.
	 * @see #setConfig(ActivityNode)
	 * @see org.ecore.system.componentArchitecture.ComponentArchitecturePackage#getActivityConfigurationMapping_Config()
	 * @model required="true"
	 * @generated
	 */
	ActivityNode getConfig();

	/**
	 * Sets the value of the '{@link org.ecore.system.componentArchitecture.ActivityConfigurationMapping#getConfig <em>Config</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Config</em>' reference.
	 * @see #getConfig()
	 * @generated
	 */
	void setConfig(ActivityNode value);

} // ActivityConfigurationMapping
