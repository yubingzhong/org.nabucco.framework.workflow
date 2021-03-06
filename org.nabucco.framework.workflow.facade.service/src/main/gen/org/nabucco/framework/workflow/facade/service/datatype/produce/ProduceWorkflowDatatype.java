/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.framework.workflow.facade.service.datatype.produce;

import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.framework.workflow.facade.message.datatype.task.TaskMsg;

/**
 * ProduceWorkflowDatatype<p/>Workflow datatype produce service<p/>
 *
 * @version 1.0
 * @author Leonid Agranovskiy, PRODYNA AG, 2012-03-16
 */
public interface ProduceWorkflowDatatype extends Service {

    /**
     * Produces a new task instance
     *
     * @param rq the ServiceRequest<TaskMsg>.
     * @return the ServiceResponse<TaskMsg>.
     * @throws ProduceException
     */
    ServiceResponse<TaskMsg> produceTask(ServiceRequest<TaskMsg> rq) throws ProduceException;
}
