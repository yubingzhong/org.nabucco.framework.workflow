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
package org.nabucco.framework.workflow.facade.service.definition.resolve;

import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.framework.workflow.facade.message.definition.WorkflowDefinitionListMsg;

/**
 * ResolveWorkflowDefinition<p/>Workflow definition resolution service.<p/>
 *
 * @version 1.0
 * @author Silas Schwarz, PRODYNA AG, 2010-04-28
 */
public interface ResolveWorkflowDefinition extends Service {

    /**
     * Missing description at method resolveWorkflowDefinition.
     *
     * @param rq the ServiceRequest<WorkflowDefinitionListMsg>.
     * @return the ServiceResponse<WorkflowDefinitionListMsg>.
     * @throws ResolveException
     */
    ServiceResponse<WorkflowDefinitionListMsg> resolveWorkflowDefinition(ServiceRequest<WorkflowDefinitionListMsg> rq)
            throws ResolveException;
}