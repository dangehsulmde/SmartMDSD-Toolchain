/**
 */
package org.ecore.system.deployment;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.ecore.system.deployment.DeploymentPackage
 * @generated
 */
public interface DeploymentFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DeploymentFactory eINSTANCE = org.ecore.system.deployment.impl.DeploymentFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Model</em>'.
	 * @generated
	 */
	DeploymentModel createDeploymentModel();

	/**
	 * Returns a new object of class '<em>Target Platform Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Platform Reference</em>'.
	 * @generated
	 */
	TargetPlatformReference createTargetPlatformReference();

	/**
	 * Returns a new object of class '<em>Component Artefact</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component Artefact</em>'.
	 * @generated
	 */
	ComponentArtefact createComponentArtefact();

	/**
	 * Returns a new object of class '<em>Naming Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Naming Service</em>'.
	 * @generated
	 */
	NamingService createNamingService();

	/**
	 * Returns a new object of class '<em>Deployment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Deployment</em>'.
	 * @generated
	 */
	Deployment createDeployment();

	/**
	 * Returns a new object of class '<em>Upload Directory</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Upload Directory</em>'.
	 * @generated
	 */
	UploadDirectory createUploadDirectory();

	/**
	 * Returns a new object of class '<em>Target Model Include</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Target Model Include</em>'.
	 * @generated
	 */
	TargetModelInclude createTargetModelInclude();

	/**
	 * Returns a new object of class '<em>Login Account Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Login Account Selection</em>'.
	 * @generated
	 */
	LoginAccountSelection createLoginAccountSelection();

	/**
	 * Returns a new object of class '<em>Network Interface Selection</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Network Interface Selection</em>'.
	 * @generated
	 */
	NetworkInterfaceSelection createNetworkInterfaceSelection();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DeploymentPackage getDeploymentPackage();

} //DeploymentFactory
