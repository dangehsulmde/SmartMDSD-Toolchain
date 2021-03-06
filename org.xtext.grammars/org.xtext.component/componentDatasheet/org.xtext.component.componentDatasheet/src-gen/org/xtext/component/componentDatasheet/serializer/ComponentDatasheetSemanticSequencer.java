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
package org.xtext.component.componentDatasheet.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.ecore.base.genericDatasheet.GenericDatasheetPackage;
import org.ecore.base.genericDatasheet.ProprietaryLicense;
import org.ecore.base.genericDatasheet.SpdxLicense;
import org.ecore.component.componentDatasheet.ComponentDatasheet;
import org.ecore.component.componentDatasheet.ComponentDatasheetPackage;
import org.xtext.base.genericDatasheet.serializer.GenericDatasheetSemanticSequencer;
import org.xtext.component.componentDatasheet.services.ComponentDatasheetGrammarAccess;

@SuppressWarnings("all")
public class ComponentDatasheetSemanticSequencer extends GenericDatasheetSemanticSequencer {

	@Inject
	private ComponentDatasheetGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == ComponentDatasheetPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case ComponentDatasheetPackage.COMPONENT_DATASHEET:
				sequence_ComponentDatasheet_GenericDatasheet(context, (ComponentDatasheet) semanticObject); 
				return; 
			}
		else if (epackage == GenericDatasheetPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case GenericDatasheetPackage.PROPRIETARY_LICENSE:
				sequence_ProprietaryLicense(context, (ProprietaryLicense) semanticObject); 
				return; 
			case GenericDatasheetPackage.SPDX_LICENSE:
				sequence_SpdxLicense(context, (SpdxLicense) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     ComponentDatasheet returns ComponentDatasheet
	 *
	 * Constraint:
	 *     (
	 *         component=[ComponentDefinition|ID] 
	 *         (
	 *             baseURI=EString | 
	 *             shortDescrition=EString | 
	 *             longDescription=TEXT_BLOCK | 
	 *             supplierDescription=EString | 
	 *             homepage=EString | 
	 *             trl=TRL | 
	 *             license=AbstractLicense
	 *         )* 
	 *         purposeDescription=EString? 
	 *         (hardwareRequirementDescription=EString? purposeDescription=EString?)*
	 *     )
	 */
	protected void sequence_ComponentDatasheet_GenericDatasheet(ISerializationContext context, ComponentDatasheet semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
