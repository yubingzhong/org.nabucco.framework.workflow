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
package org.nabucco.framework.workflow.ui.rcp.communication;

import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateFactorySupport;
import org.nabucco.framework.workflow.facade.component.WorkflowComponent;
import org.nabucco.framework.workflow.facade.component.WorkflowComponentLocator;
import org.nabucco.framework.workflow.ui.rcp.communication.datatype.maintain.MaintainWorkflowDatatypeDelegate;
import org.nabucco.framework.workflow.ui.rcp.communication.datatype.produce.ProduceWorkflowDatatypeDelegate;
import org.nabucco.framework.workflow.ui.rcp.communication.datatype.resolve.ResolveWorkflowDatatypeDelegate;
import org.nabucco.framework.workflow.ui.rcp.communication.datatype.search.SearchWorkflowDatatypeDelegate;
import org.nabucco.framework.workflow.ui.rcp.communication.definition.maintain.MaintainWorkflowDefinitionDelegate;
import org.nabucco.framework.workflow.ui.rcp.communication.definition.produce.ProduceWorkflowDefinitionDelegate;
import org.nabucco.framework.workflow.ui.rcp.communication.definition.resolve.ResolveWorkflowDefinitionDelegate;
import org.nabucco.framework.workflow.ui.rcp.communication.definition.search.SearchWorkflowDefinitionDelegate;
import org.nabucco.framework.workflow.ui.rcp.communication.engine.WorkflowEngineServiceDelegate;
import org.nabucco.framework.workflow.ui.rcp.communication.instance.maintain.MaintainWorkflowInstanceDelegate;
import org.nabucco.framework.workflow.ui.rcp.communication.instance.produce.ProduceWorkflowInstanceDelegate;
import org.nabucco.framework.workflow.ui.rcp.communication.instance.resolve.ResolveWorkflowInstanceDelegate;
import org.nabucco.framework.workflow.ui.rcp.communication.instance.search.SearchWorkflowInstanceDelegate;

/**
 * ServiceDelegateFactoryTemplate<p/>Component for defining workflows.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2010-02-18
 */
public class WorkflowComponentServiceDelegateFactory extends ServiceDelegateFactorySupport<WorkflowComponent> {

    private static WorkflowComponentServiceDelegateFactory instance = new WorkflowComponentServiceDelegateFactory();

    private MaintainWorkflowDefinitionDelegate maintainWorkflowDefinitionDelegate;

    private SearchWorkflowDefinitionDelegate searchWorkflowDefinitionDelegate;

    private ProduceWorkflowDefinitionDelegate produceWorkflowDefinitionDelegate;

    private ResolveWorkflowDefinitionDelegate resolveWorkflowDefinitionDelegate;

    private MaintainWorkflowInstanceDelegate maintainWorkflowInstanceDelegate;

    private SearchWorkflowInstanceDelegate searchWorkflowInstanceDelegate;

    private ProduceWorkflowInstanceDelegate produceWorkflowInstanceDelegate;

    private ResolveWorkflowInstanceDelegate resolveWorkflowInstanceDelegate;

    private WorkflowEngineServiceDelegate workflowEngineServiceDelegate;

    private SearchWorkflowDatatypeDelegate searchWorkflowDatatypeDelegate;

    private ResolveWorkflowDatatypeDelegate resolveWorkflowDatatypeDelegate;

    private ProduceWorkflowDatatypeDelegate produceWorkflowDatatypeDelegate;

    private MaintainWorkflowDatatypeDelegate maintainWorkflowDatatypeDelegate;

    /** Constructs a new WorkflowComponentServiceDelegateFactory instance. */
    private WorkflowComponentServiceDelegateFactory() {
        super(WorkflowComponentLocator.getInstance());
    }

    /**
     * Getter for the MaintainWorkflowDefinition.
     *
     * @return the MaintainWorkflowDefinitionDelegate.
     * @throws ClientException
     */
    public MaintainWorkflowDefinitionDelegate getMaintainWorkflowDefinition() throws ClientException {
        try {
            if ((this.maintainWorkflowDefinitionDelegate == null)) {
                this.maintainWorkflowDefinitionDelegate = new MaintainWorkflowDefinitionDelegate(this.getComponent()
                        .getMaintainWorkflowDefinition());
            }
            return this.maintainWorkflowDefinitionDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: WorkflowComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: MaintainWorkflowDefinition", e);
        }
    }

    /**
     * Getter for the SearchWorkflowDefinition.
     *
     * @return the SearchWorkflowDefinitionDelegate.
     * @throws ClientException
     */
    public SearchWorkflowDefinitionDelegate getSearchWorkflowDefinition() throws ClientException {
        try {
            if ((this.searchWorkflowDefinitionDelegate == null)) {
                this.searchWorkflowDefinitionDelegate = new SearchWorkflowDefinitionDelegate(this.getComponent()
                        .getSearchWorkflowDefinition());
            }
            return this.searchWorkflowDefinitionDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: WorkflowComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: SearchWorkflowDefinition", e);
        }
    }

    /**
     * Getter for the ProduceWorkflowDefinition.
     *
     * @return the ProduceWorkflowDefinitionDelegate.
     * @throws ClientException
     */
    public ProduceWorkflowDefinitionDelegate getProduceWorkflowDefinition() throws ClientException {
        try {
            if ((this.produceWorkflowDefinitionDelegate == null)) {
                this.produceWorkflowDefinitionDelegate = new ProduceWorkflowDefinitionDelegate(this.getComponent()
                        .getProduceWorkflowDefinition());
            }
            return this.produceWorkflowDefinitionDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: WorkflowComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ProduceWorkflowDefinition", e);
        }
    }

    /**
     * Getter for the ResolveWorkflowDefinition.
     *
     * @return the ResolveWorkflowDefinitionDelegate.
     * @throws ClientException
     */
    public ResolveWorkflowDefinitionDelegate getResolveWorkflowDefinition() throws ClientException {
        try {
            if ((this.resolveWorkflowDefinitionDelegate == null)) {
                this.resolveWorkflowDefinitionDelegate = new ResolveWorkflowDefinitionDelegate(this.getComponent()
                        .getResolveWorkflowDefinition());
            }
            return this.resolveWorkflowDefinitionDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: WorkflowComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ResolveWorkflowDefinition", e);
        }
    }

    /**
     * Getter for the MaintainWorkflowInstance.
     *
     * @return the MaintainWorkflowInstanceDelegate.
     * @throws ClientException
     */
    public MaintainWorkflowInstanceDelegate getMaintainWorkflowInstance() throws ClientException {
        try {
            if ((this.maintainWorkflowInstanceDelegate == null)) {
                this.maintainWorkflowInstanceDelegate = new MaintainWorkflowInstanceDelegate(this.getComponent()
                        .getMaintainWorkflowInstance());
            }
            return this.maintainWorkflowInstanceDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: WorkflowComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: MaintainWorkflowInstance", e);
        }
    }

    /**
     * Getter for the SearchWorkflowInstance.
     *
     * @return the SearchWorkflowInstanceDelegate.
     * @throws ClientException
     */
    public SearchWorkflowInstanceDelegate getSearchWorkflowInstance() throws ClientException {
        try {
            if ((this.searchWorkflowInstanceDelegate == null)) {
                this.searchWorkflowInstanceDelegate = new SearchWorkflowInstanceDelegate(this.getComponent()
                        .getSearchWorkflowInstance());
            }
            return this.searchWorkflowInstanceDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: WorkflowComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: SearchWorkflowInstance", e);
        }
    }

    /**
     * Getter for the ProduceWorkflowInstance.
     *
     * @return the ProduceWorkflowInstanceDelegate.
     * @throws ClientException
     */
    public ProduceWorkflowInstanceDelegate getProduceWorkflowInstance() throws ClientException {
        try {
            if ((this.produceWorkflowInstanceDelegate == null)) {
                this.produceWorkflowInstanceDelegate = new ProduceWorkflowInstanceDelegate(this.getComponent()
                        .getProduceWorkflowInstance());
            }
            return this.produceWorkflowInstanceDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: WorkflowComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ProduceWorkflowInstance", e);
        }
    }

    /**
     * Getter for the ResolveWorkflowInstance.
     *
     * @return the ResolveWorkflowInstanceDelegate.
     * @throws ClientException
     */
    public ResolveWorkflowInstanceDelegate getResolveWorkflowInstance() throws ClientException {
        try {
            if ((this.resolveWorkflowInstanceDelegate == null)) {
                this.resolveWorkflowInstanceDelegate = new ResolveWorkflowInstanceDelegate(this.getComponent()
                        .getResolveWorkflowInstance());
            }
            return this.resolveWorkflowInstanceDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: WorkflowComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ResolveWorkflowInstance", e);
        }
    }

    /**
     * Getter for the WorkflowEngineService.
     *
     * @return the WorkflowEngineServiceDelegate.
     * @throws ClientException
     */
    public WorkflowEngineServiceDelegate getWorkflowEngineService() throws ClientException {
        try {
            if ((this.workflowEngineServiceDelegate == null)) {
                this.workflowEngineServiceDelegate = new WorkflowEngineServiceDelegate(this.getComponent()
                        .getWorkflowEngineService());
            }
            return this.workflowEngineServiceDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: WorkflowComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: WorkflowEngineService", e);
        }
    }

    /**
     * Getter for the SearchWorkflowDatatype.
     *
     * @return the SearchWorkflowDatatypeDelegate.
     * @throws ClientException
     */
    public SearchWorkflowDatatypeDelegate getSearchWorkflowDatatype() throws ClientException {
        try {
            if ((this.searchWorkflowDatatypeDelegate == null)) {
                this.searchWorkflowDatatypeDelegate = new SearchWorkflowDatatypeDelegate(this.getComponent()
                        .getSearchWorkflowDatatype());
            }
            return this.searchWorkflowDatatypeDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: WorkflowComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: SearchWorkflowDatatype", e);
        }
    }

    /**
     * Getter for the ResolveWorkflowDatatype.
     *
     * @return the ResolveWorkflowDatatypeDelegate.
     * @throws ClientException
     */
    public ResolveWorkflowDatatypeDelegate getResolveWorkflowDatatype() throws ClientException {
        try {
            if ((this.resolveWorkflowDatatypeDelegate == null)) {
                this.resolveWorkflowDatatypeDelegate = new ResolveWorkflowDatatypeDelegate(this.getComponent()
                        .getResolveWorkflowDatatype());
            }
            return this.resolveWorkflowDatatypeDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: WorkflowComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ResolveWorkflowDatatype", e);
        }
    }

    /**
     * Getter for the ProduceWorkflowDatatype.
     *
     * @return the ProduceWorkflowDatatypeDelegate.
     * @throws ClientException
     */
    public ProduceWorkflowDatatypeDelegate getProduceWorkflowDatatype() throws ClientException {
        try {
            if ((this.produceWorkflowDatatypeDelegate == null)) {
                this.produceWorkflowDatatypeDelegate = new ProduceWorkflowDatatypeDelegate(this.getComponent()
                        .getProduceWorkflowDatatype());
            }
            return this.produceWorkflowDatatypeDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: WorkflowComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ProduceWorkflowDatatype", e);
        }
    }

    /**
     * Getter for the MaintainWorkflowDatatype.
     *
     * @return the MaintainWorkflowDatatypeDelegate.
     * @throws ClientException
     */
    public MaintainWorkflowDatatypeDelegate getMaintainWorkflowDatatype() throws ClientException {
        try {
            if ((this.maintainWorkflowDatatypeDelegate == null)) {
                this.maintainWorkflowDatatypeDelegate = new MaintainWorkflowDatatypeDelegate(this.getComponent()
                        .getMaintainWorkflowDatatype());
            }
            return this.maintainWorkflowDatatypeDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: WorkflowComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: MaintainWorkflowDatatype", e);
        }
    }

    /**
     * Getter for the Instance.
     *
     * @return the WorkflowComponentServiceDelegateFactory.
     */
    public static WorkflowComponentServiceDelegateFactory getInstance() {
        return instance;
    }
}
