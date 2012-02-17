/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.framework.workflow.facade.datatype.effect.instantiable;

import org.nabucco.framework.base.facade.exception.service.WorkflowException;
import org.nabucco.framework.workflow.facade.datatype.definition.effect.instantiable.InstantiableEffect;

/**
 * Instantiable
 * <p/>
 * Interface for classes that are instantiated by the {@link InstantiableEffect} and executed.
 * 
 * @author Nicolas Moser, PRODYNA AG
 */
public interface Instantiable {

    /**
     * Called from the workflow engine for a configured {@link InstantiableEffect}.
     * 
     * @param context
     *            the instantiation context holding workflow information
     * 
     * @throws WorkflowException
     *             when the execution fails
     */
    void execute(InstantiationContext context) throws WorkflowException;

}
