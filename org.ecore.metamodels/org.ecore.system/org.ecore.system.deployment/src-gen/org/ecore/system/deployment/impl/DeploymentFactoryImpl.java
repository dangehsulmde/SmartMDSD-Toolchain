/**
 */
package org.ecore.system.deployment.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.ecore.system.deployment.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DeploymentFactoryImpl extends EFactoryImpl implements DeploymentFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DeploymentFactory init() {
		try {
			DeploymentFactory theDeploymentFactory = (DeploymentFactory) EPackage.Registry.INSTANCE
					.getEFactory(DeploymentPackage.eNS_URI);
			if (theDeploymentFactory != null) {
				return theDeploymentFactory;
			}
		} catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DeploymentFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentFactoryImpl() {
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
		case DeploymentPackage.DEPLOYMENT_MODEL:
			return createDeploymentModel();
		case DeploymentPackage.TARGET_PLATFORM_REFERENCE:
			return createTargetPlatformReference();
		case DeploymentPackage.COMPONENT_ARTEFACT:
			return createComponentArtefact();
		case DeploymentPackage.NAMING_SERVICE:
			return createNamingService();
		case DeploymentPackage.DEPLOYMENT:
			return createDeployment();
		case DeploymentPackage.UPLOAD_DIRECTORY:
			return createUploadDirectory();
		case DeploymentPackage.TARGET_MODEL_INCLUDE:
			return createTargetModelInclude();
		case DeploymentPackage.LOGIN_ACCOUNT_SELECTION:
			return createLoginAccountSelection();
		case DeploymentPackage.NETWORK_INTERFACE_SELECTION:
			return createNetworkInterfaceSelection();
		default:
			throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentModel createDeploymentModel() {
		DeploymentModelImpl deploymentModel = new DeploymentModelImpl();
		return deploymentModel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetPlatformReference createTargetPlatformReference() {
		TargetPlatformReferenceImpl targetPlatformReference = new TargetPlatformReferenceImpl();
		return targetPlatformReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentArtefact createComponentArtefact() {
		ComponentArtefactImpl componentArtefact = new ComponentArtefactImpl();
		return componentArtefact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NamingService createNamingService() {
		NamingServiceImpl namingService = new NamingServiceImpl();
		return namingService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Deployment createDeployment() {
		DeploymentImpl deployment = new DeploymentImpl();
		return deployment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UploadDirectory createUploadDirectory() {
		UploadDirectoryImpl uploadDirectory = new UploadDirectoryImpl();
		return uploadDirectory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TargetModelInclude createTargetModelInclude() {
		TargetModelIncludeImpl targetModelInclude = new TargetModelIncludeImpl();
		return targetModelInclude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LoginAccountSelection createLoginAccountSelection() {
		LoginAccountSelectionImpl loginAccountSelection = new LoginAccountSelectionImpl();
		return loginAccountSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NetworkInterfaceSelection createNetworkInterfaceSelection() {
		NetworkInterfaceSelectionImpl networkInterfaceSelection = new NetworkInterfaceSelectionImpl();
		return networkInterfaceSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeploymentPackage getDeploymentPackage() {
		return (DeploymentPackage) getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DeploymentPackage getPackage() {
		return DeploymentPackage.eINSTANCE;
	}

} //DeploymentFactoryImpl
