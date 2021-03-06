//--------------------------------------------------------------------------
//
//  Copyright (C) 2018 Alex Lotz, Vineet Nagrath, Dennis Stampfer, Matthias Lutz
//
//        lotz@hs-ulm.de
//        nagrath@hs-ulm.de
//        stampfer@hs-ulm.de
//        lutz@hs-ulm.de
//
//        Servicerobotics Ulm
//        Christian Schlegel
//        University of Applied Sciences
//        Prittwitzstr. 10
//        89075 Ulm
//        Germany
//
//  This file is part of the SmartSoft MDSD Toolchain. 
//
// Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
//
// 1. Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
// 
// 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the 
//    documentation and/or other materials provided with the distribution.
// 
// 3. Neither the name of the copyright holder nor the names of its contributors may be used to endorse or promote products derived from this 
//    software without specific prior written permission.
// 
// THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, 
// THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS 
// BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF 
// SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN 
// CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
// POSSIBILITY OF SUCH DAMAGE.
//
//--------------------------------------------------------------------------
package org.xtend.plainOPCUA.generator.ext

import org.xtend.smartsoft.generator.component.ActivityGeneratorExtension
import org.ecore.component.componentDefinition.Activity
import com.google.inject.Inject
import org.xtend.plainOPCUA.generator.PlainOpcUaDeviceClient
import org.ecore.component.componentDefinition.ComponentDefinition
import org.ecore.component.seronetExtension.OpcUaClientLink

class PlainOpcUaActivityGeneratorExtensionImpl implements ActivityGeneratorExtension {
	@Inject extension PlainOpcUaDeviceClient
	
	override getExtensionName() {
		"PlainOpcUaActivityGeneratorExtension"
	}
	
	override getHeaderIncludes(Activity activity) 
	'''
		«FOR link: activity.links.filter(OpcUaClientLink)»
		#include "«link.client.opcUaDeviceClientHeader»"
		«ENDFOR»
	'''
	
	override getClassMemberProtectedDefinition(Activity activity) 
	'''
	«FOR link: activity.links.filter(OpcUaClientLink)»
	OPCUA::«link.client.name.toFirstUpper» *«link.client.name.toFirstLower»;
	«ENDFOR»
	'''
	
	override getClassMemberConstruction(Activity activity) 
	'''
	«FOR link: activity.links.filter(OpcUaClientLink)»
	«link.client.name.toFirstLower» = COMP->«link.client.name.toFirstLower»;
	«ENDFOR»
	'''
	
	def getComponent(Activity activity) {
		return (activity.eContainer as ComponentDefinition)
	}
}