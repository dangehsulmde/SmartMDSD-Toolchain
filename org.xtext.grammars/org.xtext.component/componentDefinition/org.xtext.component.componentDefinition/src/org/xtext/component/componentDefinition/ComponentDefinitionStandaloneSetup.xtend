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
package org.xtext.component.componentDefinition

import com.google.inject.Injector
import org.ecore.component.componentDefinition.ComponentDefinitionPackage
import org.eclipse.emf.ecore.EPackage
import org.ecore.component.performanceExtension.PerformanceExtensionPackage
import org.ecore.component.coordinationExtension.CoordinationExtensionPackage

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
class ComponentDefinitionStandaloneSetup extends ComponentDefinitionStandaloneSetupGenerated {

	def static void doSetup() {
		new ComponentDefinitionStandaloneSetup().createInjectorAndDoEMFRegistration()
	}
	
	override register(Injector injector) {
		if(!EPackage.Registry.INSTANCE.containsKey(ComponentDefinitionPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(
				ComponentDefinitionPackage.eNS_URI,
				ComponentDefinitionPackage.eINSTANCE
			)
		}
		if(!EPackage.Registry.INSTANCE.containsKey(PerformanceExtensionPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(
				PerformanceExtensionPackage.eNS_URI,
				PerformanceExtensionPackage.eINSTANCE
			)
		}
		if(!EPackage.Registry.INSTANCE.containsKey(CoordinationExtensionPackage.eNS_URI)) {
			EPackage.Registry.INSTANCE.put(
				CoordinationExtensionPackage.eNS_URI,
				CoordinationExtensionPackage.eINSTANCE
			)
		}
		super.register(injector)
	}
}
