/**
 */
package org.ecore.system.causeEffectChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Activity Chain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.ecore.system.causeEffectChain.ActivityChain#getName <em>Name</em>}</li>
 *   <li>{@link org.ecore.system.causeEffectChain.ActivityChain#getChainLinks <em>Chain Links</em>}</li>
 *   <li>{@link org.ecore.system.causeEffectChain.ActivityChain#getDesiredMinResponse <em>Desired Min Response</em>}</li>
 *   <li>{@link org.ecore.system.causeEffectChain.ActivityChain#getDesiredMaxResponse <em>Desired Max Response</em>}</li>
 * </ul>
 *
 * @see org.ecore.system.causeEffectChain.CauseEffectChainPackage#getActivityChain()
 * @model
 * @generated
 */
public interface ActivityChain extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.ecore.system.causeEffectChain.CauseEffectChainPackage#getActivityChain_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.ecore.system.causeEffectChain.ActivityChain#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Chain Links</b></em>' containment reference list.
	 * The list contents are of type {@link org.ecore.system.causeEffectChain.AbstractChainLink}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Chain Links</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Chain Links</em>' containment reference list.
	 * @see org.ecore.system.causeEffectChain.CauseEffectChainPackage#getActivityChain_ChainLinks()
	 * @model containment="true"
	 * @generated
	 */
	EList<AbstractChainLink> getChainLinks();

	/**
	 * Returns the value of the '<em><b>Desired Min Response</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Desired Min Response</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Desired Min Response</em>' containment reference.
	 * @see #setDesiredMinResponse(MinResponseTime)
	 * @see org.ecore.system.causeEffectChain.CauseEffectChainPackage#getActivityChain_DesiredMinResponse()
	 * @model containment="true"
	 * @generated
	 */
	MinResponseTime getDesiredMinResponse();

	/**
	 * Sets the value of the '{@link org.ecore.system.causeEffectChain.ActivityChain#getDesiredMinResponse <em>Desired Min Response</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Desired Min Response</em>' containment reference.
	 * @see #getDesiredMinResponse()
	 * @generated
	 */
	void setDesiredMinResponse(MinResponseTime value);

	/**
	 * Returns the value of the '<em><b>Desired Max Response</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Desired Max Response</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Desired Max Response</em>' containment reference.
	 * @see #setDesiredMaxResponse(MaxResponseTime)
	 * @see org.ecore.system.causeEffectChain.CauseEffectChainPackage#getActivityChain_DesiredMaxResponse()
	 * @model containment="true"
	 * @generated
	 */
	MaxResponseTime getDesiredMaxResponse();

	/**
	 * Sets the value of the '{@link org.ecore.system.causeEffectChain.ActivityChain#getDesiredMaxResponse <em>Desired Max Response</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Desired Max Response</em>' containment reference.
	 * @see #getDesiredMaxResponse()
	 * @generated
	 */
	void setDesiredMaxResponse(MaxResponseTime value);

} // ActivityChain
