//===================================================================================
//
//  Copyright (C) 2017 Alex Lotz, Dennis Stampfer, Matthias Lutz, Christian Schlegel
//
//        lotz@hs-ulm.de
//        stampfer@hs-ulm.de
//        lutz@hs-ulm.de
//        schlegel@hs-ulm.de
//
//        Servicerobotik Ulm
//        Christian Schlegel
//        Ulm University of Applied Sciences
//        Prittwitzstr. 10
//        89075 Ulm
//        Germany
//
//  This file is part of the SmartMDSD Toolchain V3. 
//
//  Redistribution and use in source and binary forms, with or without modification, 
//  are permitted provided that the following conditions are met:
//  
//  1. Redistributions of source code must retain the above copyright notice, 
//     this list of conditions and the following disclaimer.
//  
//  2. Redistributions in binary form must reproduce the above copyright notice, 
//     this list of conditions and the following disclaimer in the documentation 
//     and/or other materials provided with the distribution.
//  
//  3. Neither the name of the copyright holder nor the names of its contributors 
//     may be used to endorse or promote products derived from this software 
//     without specific prior written permission.
//  
//  THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" 
//  AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
//  WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
//  IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
//  INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, 
//  BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, 
//  DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF 
//  LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE 
//  OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED 
//  OF THE POSSIBILITY OF SUCH DAMAGE.
//
//===================================================================================
package org.xtext.component.componentDefinition.validation

import org.eclipse.xtext.validation.Check
import org.ecore.component.componentDefinition.Activity
import org.ecore.component.performanceExtension.ActivationConstraints
import org.ecore.component.componentDefinition.ComponentDefinition
import org.ecore.component.componentDefinition.ComponentDefinitionModelUtility
import org.ecore.component.componentDefinition.ComponentDefinitionPackage
import org.ecore.component.performanceExtension.PerformanceExtensionPackage
import org.ecore.component.componentParameter.ComponentParameterPackage
import org.ecore.component.componentDefinition.ComponentSubNodeObserver
import org.ecore.component.componentParameter.ComponentParametersRef
import org.ecore.component.performanceExtension.DefaultPeriodicTimer
import org.ecore.component.componentDefinition.ComponentPort
import org.ecore.component.seronetExtension.SupportedMiddleware
import org.ecore.component.seronetExtension.SeronetExtensionPackage
import org.ecore.component.performanceExtension.DefaultTrigger
import org.ecore.component.coordinationExtension.OperationModeBinding
import org.ecore.component.coordinationExtension.PrivateOperationMode
import org.ecore.component.coordinationExtension.CoordinationSlavePort
import org.ecore.component.coordinationExtension.PublicOperationMode
import org.ecore.component.coordinationExtension.CoordinationExtensionPackage
import org.ecore.component.componentDefinition.InputHandler
import org.ecore.component.componentDefinition.InputPortLink
import org.ecore.component.coordinationExtension.CommunicationServiceUsageRealization

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
class ComponentDefinitionValidator extends AbstractComponentDefinitionValidator {
	
	protected static val COMP_DEF_ISSUE_PREFIX = "org.xtext.component.componentDefinition."
	public static val DUPLICATE_ACTIVATION_CONSTRAINTS = COMP_DEF_ISSUE_PREFIX + "DuplicateActivationConstraints"
	public static val ACTIVATION_FREQUENCY_CONSTRAINT = COMP_DEF_ISSUE_PREFIX + "ActivationFrequencyConstraint"
	public static val DEFAULT_TIMED_TRIGGER_MIN_FREQUENCY = COMP_DEF_ISSUE_PREFIX + "DefaultTimedTriggerMinFrequency"
	public static val DEFAULT_TIMED_TRIGGER_MAX_FREQUENCY = COMP_DEF_ISSUE_PREFIX + "DefaultTimedTriggerMaxFrequency"
	public static val DUPLICATE_OPERATION_MODE_BINDING = COMP_DEF_ISSUE_PREFIX + "DuplicateOperationModeBinding"
//	public static val DUPLICATE_STATE_AUTOMATON = COMP_DEF_ISSUE_PREFIX + "DuplicateStateAutomaton"
//	public static val STATE_AUTOMATON_MATCHES_BEHAVIOR_SLAVE = COMP_DEF_ISSUE_PREFIX + "StateAutomatonMatchesBehaviorSlave"
//	public static val EXTENSIBLE_MAIN_STATE = COMP_DEF_ISSUE_PREFIX + "ExtensibleMainState"
	public static val ACTIVITY_OBSERVATION_CYLE = COMP_DEF_ISSUE_PREFIX + "ActivityObservationCycle"
	public static val NOT_USED_PRIVATE_OPERATION_MODE = COMP_DEF_ISSUE_PREFIX + "NotUsedPrivateOperationMode"
	public static val PRIVATE_OPERATION_MODE_NAME = COMP_DEF_ISSUE_PREFIX + "PrivateOperationModeName"
	public static val MULTIPLE_DEFAULT_OPERATION_MODES = COMP_DEF_ISSUE_PREFIX + "MultipleDefaultOperationModes"
	public static val DUPLICATE_PARAMETER_STRUCT = COMP_DEF_ISSUE_PREFIX + "DuplicateParameterStruct"
	public static val MATCHING_PARAMETER_STRUCT = COMP_DEF_ISSUE_PREFIX + "MatchingParameterStruct"
	
	public static val MULTIPLE_DEFAULT_MIDDLEWARES = COMP_DEF_ISSUE_PREFIX + "MultipleDefaultMiddlewares"
	public static val MULTIPLE_DEFAULT_TRIGGERS = COMP_DEF_ISSUE_PREFIX + "MultipleDefaultTriggers"
	
	public static val INPUT_HANDLER_LINK = COMP_DEF_ISSUE_PREFIX + "InputHandlerLink"
	
	public static val INCOMPLETE_COORDINATION_SLAVE_PORT = COMP_DEF_ISSUE_PREFIX + "IncompleteCoordinationSlavePort"
	public static val DUPLICATE_REALIZATIONS_COORDINATION_SLAVE_PORT = COMP_DEF_ISSUE_PREFIX + "DuplicateRealizationsCoordinationSlavePort"
	
	@Check
	def checkDuplicateActivationConstraints(ActivationConstraints act) {
		val parent = act.eContainer
		if(parent instanceof Activity) {
			if(parent.extensions.filter(ActivationConstraints).size > 1) {
				error("Multiple ActivationConstraints-elements found, but (at most) one per Activity is allowed.",
					null, DUPLICATE_ACTIVATION_CONSTRAINTS
				)
			}
		}
	}
	
	@Check
	def checkMinActFreqSmallerMaxActFreq(ActivationConstraints ac) {
		if(ac.maxActFreq > 0.0 && ac.minActFreq > ac.maxActFreq) {
			warning("Activation minimal-frequency should be smaller or equal to the maximal-frequency", 
				PerformanceExtensionPackage.Literals.ACTIVATION_CONSTRAINTS__MIN_ACT_FREQ,
				ACTIVATION_FREQUENCY_CONSTRAINT
			)
		}
	}
	
	@Check
	def checkDefaultTimedTriggerFrequencyWithinActConstraints(DefaultPeriodicTimer timer) {
		val parent = timer.eContainer
		if(parent instanceof Activity) {
			for(act: parent.extensions.filter(ActivationConstraints)) {
				if(act.minActFreq > 0.0) {
					if(timer.periodicActFreq < act.minActFreq) {
						warning(
							"Chosen periodic activation-frequency is smaller than minimum frequency "+act.minActFreq.toString+" defined in ActivationConstraints",
							PerformanceExtensionPackage.Literals.DEFAULT_PERIODIC_TIMER__PERIODIC_ACT_FREQ,
							DEFAULT_TIMED_TRIGGER_MIN_FREQUENCY,
							act.minActFreq.toString
						)
					}
				}
				if(act.maxActFreq > 0.0) {
					if(timer.periodicActFreq > act.maxActFreq) {
						warning(
							"Chosen periodic activation-frequency is higher than maximum frequency "+act.maxActFreq.toString+" defined in ActivationConstraints",
							PerformanceExtensionPackage.Literals.DEFAULT_PERIODIC_TIMER__PERIODIC_ACT_FREQ,
							DEFAULT_TIMED_TRIGGER_MAX_FREQUENCY,
							act.maxActFreq.toString
						)
					}
				}
			}
		}
	}
	
	@Check
	def checkDuplicateOperationModeBinding(OperationModeBinding state) {
		val parent = state.eContainer
		if(parent instanceof Activity) {
			if(parent.extensions.filter(OperationModeBinding).size > 1) {
				error("Multiple OperationModeBinding-elements found, but (at most) one per Activity is allowed.",
					null, DUPLICATE_OPERATION_MODE_BINDING
				)
			}
		}
	}
	
	@Check
	def checkNoActivityObserverCycle(ComponentSubNodeObserver observer) {
		val parent = observer.eContainer
		val subject = observer.subject
		if(subject instanceof Activity) {
			if(ComponentDefinitionModelUtility.getActivityObservationHierarchy(subject).contains(parent)){
				error("Cycle in ActivityObservation of observed Activity "+subject.name+".",
					ComponentDefinitionPackage.Literals.COMPONENT_SUB_NODE_OBSERVER__SUBJECT,
					ACTIVITY_OBSERVATION_CYLE
				)
			}
		}
	}
	
	@Check
	def checkPrivateOperationModeReferencedFromPublicOperationMode(PrivateOperationMode mode) {
		val parent = mode.eContainer
		if(parent instanceof CoordinationSlavePort) {
			if(!parent.elements.filter(PublicOperationMode).exists[it.activates.exists[it==mode]]) {
				warning("PrivateOperationMode "+mode.name+" is not used by any PublicOperationMode.",
					CoordinationExtensionPackage.Literals.PRIVATE_OPERATION_MODE__NAME,
					NOT_USED_PRIVATE_OPERATION_MODE,
					mode.name
				)
			}
		}
	}
	
	@Check
	def checkPrivateOperationModeNameBeginsWithSmallLetter(PrivateOperationMode mode) {
		if(!Character.isLowerCase(mode.name.charAt(0))) {
			warning("PrivateOperationMode name should begin with a small letter.",
				CoordinationExtensionPackage.Literals.PRIVATE_OPERATION_MODE__NAME,
				PRIVATE_OPERATION_MODE_NAME,
				mode.name
			)
		}
	}
	
	@Check
	def checkSingleDefaultOperationMode(PublicOperationMode mode) {
		val parent = mode.eContainer
		if(parent instanceof CoordinationSlavePort) {
			if(parent.elements.filter(PublicOperationMode).filter[it.isIsDefaultInit==true].size > 1) {
				warning("Multiple default PublicOperationModes are detected, but at most one is allowed.",
					CoordinationExtensionPackage.Literals.PUBLIC_OPERATION_MODE__IS_DEFAULT_INIT,
					MULTIPLE_DEFAULT_OPERATION_MODES
				)
			}
		}
	}

	@Check
	def checkSingleParamStruct(ComponentParametersRef param) {
		val parent = param.eContainer
		if(parent instanceof ComponentDefinition) {
			if(parent.elements.filter(ComponentParametersRef).size > 1) {
				error("Multiple ParameterStructs defined, but at most one is allowed.",
					ComponentParameterPackage.Literals.COMPONENT_PARAMETERS_REF__PARAMETER,
					DUPLICATE_PARAMETER_STRUCT
				)
			}
		}
	}
	
	@Check
	def checkMatchingParamStruct(ComponentParametersRef param) {
		val component = param.eContainer
		if(component instanceof ComponentDefinition) {
			if(!param.parameter.component.equals(component)) {
				warning("ParameterStruct is not using this component.",
					ComponentParameterPackage.Literals.COMPONENT_PARAMETERS_REF__PARAMETER,
					MATCHING_PARAMETER_STRUCT
				)
			}
		}
	}
	
	@Check
	def checkSingleDefaultMiddleware(SupportedMiddleware mw) {
		if(mw.isDefault) {
			val parent = mw.eContainer
			if(parent instanceof ComponentPort) {
				for(other: parent.extensions.filter(SupportedMiddleware)) {
					if(other!=mw && other.isDefault) {
						error("Multiple default middlewares are specified", 
							SeronetExtensionPackage.Literals.SUPPORTED_MIDDLEWARE__DEFAULT, 
							MULTIPLE_DEFAULT_MIDDLEWARES, 
							mw.eClass.name
						)
					}
				}
			}
		}
	}
	
	@Check
	def checkSingleDefaultTrigger(DefaultTrigger trigger) {
		val parent = trigger.eContainer
		if(parent instanceof Activity) {
			if(parent.extensions.filter(DefaultTrigger).size>1) {
				error("Multiple default triggers are specified", 
//					PerformanceExtensionPackage.Literals.DEFAULT_TRIGGER,
					null, 
					MULTIPLE_DEFAULT_TRIGGERS
				)
			}
		}
	}
	
	@Check
	def checkInputHandlerLink(InputPortLink link) {
		val parent = link.eContainer
		if(parent instanceof InputHandler) {
			if(link.inputPort==parent.inputPort) {
				error("InputLink cannot be the same as the InputHandler's input-trigger",
					ComponentDefinitionPackage.Literals.INPUT_PORT_LINK__INPUT_PORT,
					INPUT_HANDLER_LINK
				)
			}	
		}
	}
	
	@Check
	def checkForMissingOptionalCoordinationSlaveRealization(CoordinationSlavePort slavePort){
		if(slavePort.service.services.size != slavePort.elements.filter(CommunicationServiceUsageRealization).size){
			warning("CoordinationSlavePort needs to realize all CommunicationServiceUsages.",
				CoordinationExtensionPackage.Literals.COORDINATION_SLAVE_PORT__ELEMENTS,
				INCOMPLETE_COORDINATION_SLAVE_PORT
			)
		}	
	}
	
	@Check
	def checkDuplicateOptionalCoordinationSlaveRealization(CommunicationServiceUsageRealization cServiceRealization) {
		val parent = cServiceRealization.eContainer
		if(parent instanceof CoordinationSlavePort) {
			if(parent.elements.filter(CommunicationServiceUsageRealization).filter[it.serviceUsage.equals(cServiceRealization.serviceUsage)].size > 1) {
				error("Duplicate realization of a CommunicationServiceUsage found, but exactly one realization is required.",
					CoordinationExtensionPackage.Literals.COMMUNICATION_SERVICE_USAGE_REALIZATION__SERVICE_USAGE, 
					DUPLICATE_REALIZATIONS_COORDINATION_SLAVE_PORT
				)
			}
		}
	}
}
