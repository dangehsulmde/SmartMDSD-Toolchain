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

import org.xtend.smartsoft.generator.component.ComponentGeneratorExtension
import org.ecore.component.componentDefinition.ComponentDefinition
import org.ecore.component.seronetExtension.OpcUaDeviceClient
import org.ecore.component.seronetExtension.OpcUaStatusServer
import com.google.inject.Inject
import org.xtend.plainOPCUA.generator.PlainOpcUaDeviceClient
import org.xtend.plainOPCUA.generator.PlainOpcUaStatusServer

class PlainOpcUaComponentGeneratorExtensionImpl implements ComponentGeneratorExtension 
{
	@Inject extension PlainOpcUaDeviceClient
	@Inject extension PlainOpcUaStatusServer

	override getExtensionName(ComponentDefinition component) { "PlainOpcUa"+component.name+"Extension" }
	
	override getHeaderIncludes(ComponentDefinition component) 
	'''
		// include plain OPC UA device clients
		«FOR opcDeviceClient: component.elements.filter(OpcUaDeviceClient)»
		#include "«opcDeviceClient.opcUaDeviceClientHeader»"
		«ENDFOR»
		// include plain OPC UA status servers
		«FOR opcStatusServer: component.elements.filter(OpcUaStatusServer)»
		#include "«opcStatusServer.serverControllerHeaderFileName»"
		«ENDFOR»
	'''
	
	override getSourceIncludes(ComponentDefinition component) ''''''
	
	override getClassMemberDefinition(ComponentDefinition component) 
	'''
		«FOR opcDeviceClient: component.elements.filter(OpcUaDeviceClient)»
		OPCUA::«opcDeviceClient.name.toFirstUpper» *«opcDeviceClient.name.toFirstLower»;
		«ENDFOR»
		«FOR opcStatusServer: component.elements.filter(OpcUaStatusServer)»
		«opcStatusServer.name.toFirstUpper» *«opcStatusServer.name.toFirstLower»;
		«ENDFOR»
	'''
	
	override getIniFileParameters(ComponentDefinition component) 
	'''
		«FOR client: component.elements.filter(OpcUaDeviceClient)»
		[«client.name»]
		deviceURI «client.deviceURI»
		opcuaXmlFile «client.opcuaXmlFile»
		
		«ENDFOR»
	'''
	
	override getCMakeIncludes(ComponentDefinition component) 
	'''
		GET_FILENAME_COMPONENT(PlainOPCUA_DIR "${PROJECT_SOURCE_DIR}/../plainOpcUa" REALPATH)
		IF(EXISTS ${PlainOPCUA_DIR})
		INCLUDE("${PlainOPCUA_DIR}/src-gen/«component.name»PlainOpcUa.cmake")
		LIST(APPEND FURTHER_SRCS ${PLAIN_OPCUA_SRCS})
		ENDIF(EXISTS ${PlainOPCUA_DIR})
		
	'''
	
	override getCMakeTargetConfiguration(ComponentDefinition component) 
	'''
		IF(open62541_FOUND)
		TARGET_LINK_LIBRARIES(${PROJECT_NAME} open62541)
		TARGET_COMPILE_DEFINITIONS(${PROJECT_NAME} PUBLIC HAS_OPCUA)
		ENDIF(open62541_FOUND)
	'''
}