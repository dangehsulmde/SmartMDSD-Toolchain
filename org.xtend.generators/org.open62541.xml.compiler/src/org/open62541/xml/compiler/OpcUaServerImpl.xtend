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
package org.open62541.xml.compiler

import com.google.inject.Inject
import org.open62541.xml.compiler.OpcUaXmlParser.SeRoNetENTITY
import org.open62541.xml.compiler.OpcUaXmlParser.SeRoNetMETHOD
import org.open62541.xml.compiler.OpcUaXmlParser.SeRoNetARGUMENT

class OpcUaServerImpl implements  OpcUaServer {
	@Inject extension CopyrightHelpers
	@Inject extension OpcUaObjectInterfaceImpl
	@Inject extension Open62541GenericServerImpl
	@Inject extension OpcUaXmlParser
	
	override getOpcUaDevice_Server_HeaderFileName(String objectName) { "OpcUa"+objectName + ".hh" }
	override getOpcUaDevice_Server_SourceFileName(String objectName) { "OpcUa"+objectName + ".cc" }
	
	////////////////////////////////////////////////////////////////// MVC Server Header
	////////////////////////////////////////////////////////////////////////////////////	
	override CharSequence compileOpcUaDevice_Server_HeaderFileContent(String objectName, Iterable<SeRoNetENTITY> entityList, Iterable<SeRoNetMETHOD> methodList) '''
	«getCopyright()»
	
	#ifndef _«objectName.toUpperCase»_HH
	#define _«objectName.toUpperCase»_HH
	
	#include <«opcUa_GenericServer_HeaderFileName»>
	
	#include "«objectName.getOpcUaDevice_Interface_HeaderFileName()»"
	
	namespace OPCUA {
	
	class «objectName» : public OPCUA::GenericServer
	{
	private:
		«objectName»Interface *controller;
		
		/** this method implements the server space for «objectName»
		 *
		 *  Please use the methods addVariableNode() and addMethodNode() to define the server space.
		 *  This method is automatically called from within the method run()
		 *
		 *  @return true on success or false if something went wrong during initialization
		 *
		 *  @sa addVariableNode()
		 *  @sa addMethodNode()
		 */
		virtual bool createServerSpace() override;
		
		/** overload this method to get notified about read requests from a remote client for the provided variable name
		 *
		 *  This upcall handler is triggered each time the OPC UA variable (identified by the browseName) is read from a remote client.
		 *  In case the variable is read internally from within the server, this method is not called as this might easily
		 *  cause infinite loops. You can overload this method in derived classes to implement a specific behavior for
		 *  incoming read requests.
		 *
		 *  @param browseName the browse name of the OPC UA variable
		 *  @param value output argument receives the new value of the OPC UA variable
		 *
		 */
		virtual void handleOnRead(const std::string &browseName, ValueType &value) override;
	
		/** this method notifies about write requests from a remote client for the provided variable name
		 *
		 *  This upcall handler is triggered each time the OPC UA variable (identified by the browseName) is written from a remote client.
		 *  You can overload this method in derived classes to implement a specific behavior for incoming write requests.
		 *
		 *  @param browseName the browse name of the OPC UA variable
		 *  @param value the new value of the OPC UA variable
		 *
		 */
		virtual void handleOnWrite(const std::string &browseName, const ValueType &value) override;
	
		/** this method notifies about remote method calls from a remote client for the provided OPC UA Method name
		 *
		 *  This upcall handler is triggered each time the OPC UA Method (identified by the browseName) is called from a remote client.
		 *  You can overload this method in derived classes to implement a specific behavior for incoming method calls.
		 *
		 *  @param browseName the browse name of the OPC UA variable
		 *  @param inputs a vector of input-argument-values
		 *  @param outputs a reference to a vector to store the resulting output-argument-values
		 *
		 */
		virtual void handleMethodCall(const std::string &browseName, const std::vector<ValueType> &inputs, std::vector<ValueType> &outputs) override;
		
	public:
		«objectName»(«objectName»Interface *controller);
		virtual ~«objectName»();
	};
	
	} /* namespace OPCUA */

	#endif /* _«objectName.toUpperCase»_HH */
	'''
	////////////////////////////////////////////////////////////////// MVC Server Source
	////////////////////////////////////////////////////////////////////////////////////	
	override CharSequence compileOpcUaDevice_Server_SourceFileContent(String objectName, Iterable<SeRoNetENTITY> entityList, Iterable<SeRoNetMETHOD> methodList) '''
	«getCopyright()»
	
	#include "«objectName.getOpcUaDevice_Server_HeaderFileName()»"
		
	namespace OPCUA {
	
	«objectName»::«objectName»(«objectName»Interface *controller)
	:	OPCUA::GenericServer("«objectName»")
	,	controller(controller)
	{
		
	}
	«objectName»::~«objectName»()
	{  }
	
	bool «objectName»::createServerSpace() 
	{
		«FOR entity: entityList»
		// add variable «entity.name»
		«IF (entity.userAccessLevel == 2)||(entity.userAccessLevel == 3) »
		bool «entity.name»ReadOnly = false;
		«ELSE»
		bool «entity.name»ReadOnly = true;
		«ENDIF»
		«entity.type.cppType» «entity.name»Value = «entity.type.cppDefaultValue»;
		if(addVariableNode("«entity.name»", «entity.name»Value, «entity.name»ReadOnly) != true) {
			std::cout << "failed adding «entity.name»" << std::endl;
			return false;
		}
		
		«ENDFOR»
		
		«FOR method: methodList»
		// add the method «method.name»
		std::map<std::string, OPCUA::ValueType> «method.name»InputArguments;
		«FOR input: method.inputArguments»
		«method.name»InputArguments["«input.name»"] = «input.UADataTypeDefaultValues»;
		«ENDFOR»
		
		std::map<std::string, OPCUA::ValueType> «method.name»OutputArguments;
		«FOR output: method.outputArguments»
		«method.name»OutputArguments["«output.name»"] = «output.UADataTypeDefaultValues»;
		«ENDFOR»
		
		if(addMethodNode("«method.name»", «method.name»InputArguments, «method.name»OutputArguments) != true) {
			std::cout << "failed adding «method.name»" << std::endl;
			return false;
		}
		
		«ENDFOR»
		return true;
	}
	
	void «objectName»::handleOnRead(const std::string &browseName, ValueType &value)
	{
		«FOR entity: entityList»
		«IF entity!=entityList.head»} else «ENDIF»if(browseName == "«entity.name»") {
			«entity.type.cppType» «entity.name»;
			if(controller->get«entity.name.toFirstUpper»(«entity.name») == OPCUA::StatusCode::ALL_OK) {
				value = «entity.name»;
			}
		«IF entity==entityList.last»}«ENDIF»
		«ENDFOR»
	}
	
	void «objectName»::handleOnWrite(const std::string &browseName, const ValueType &value)
	{
		// propagate the write calls to respective upcalls (only if write access is activated)
		«FOR entity: entityList.filterWritableEntities»
			«IF entity!=entityList.filterWritableEntities.head»} else «ENDIF»if(browseName == "«entity.name»") {
				controller->set«entity.name.toFirstUpper»(value);
			«IF entity==entityList.filterWritableEntities.last»}«ENDIF»
		«ENDFOR»
	}
	
	void «objectName»::handleMethodCall(const std::string &browseName, const std::vector<ValueType> &inputs, std::vector<ValueType> &outputs)
	{
		«FOR method: methodList»
		«IF method!=methodList.head»} else «ENDIF»if(browseName == "«method.name»") {
			// expecting an input vector of size «method.inputArguments.size»
			if(inputs.size() == «method.inputArguments.size») {
				// input variables
				«var count=-1»
				«FOR input: method.inputArguments»
				«IF input.DataTypeIdentifier == SeRoNetARGUMENT.UA_TYPES_STRING»
				«input.DataTypeString» «input.name» = static_cast<const char*>(inputs[«count=count+1»]);
				«ELSE»
				«input.DataTypeString» «input.name» = inputs[«count=count+1»];
				«ENDIF»
				«ENDFOR»
				// output variables
				«FOR output: method.outputArguments»
				«output.DataTypeString» «output.name»;
				«ENDFOR»
				// method call propagation
				controller->call«method.name.toFirstUpper»(«method.cppMethodArgumentsCall»);
				// fill output vector
				outputs.resize(«method.outputArguments.size»);
				«var count2=-1»
				«FOR output: method.outputArguments»
				outputs[«count2=count2+1»] = «output.name»;
				«ENDFOR»
			}
		«IF method==methodList.last»}«ENDIF»
		«ENDFOR»
	}
	
	} /* namespace OPCUA */
	'''
	
	def Iterable<SeRoNetENTITY> filterWritableEntities(Iterable<SeRoNetENTITY> entities) {
		return entities.filter[userAccessLevel==2||userAccessLevel==3]
	}
}