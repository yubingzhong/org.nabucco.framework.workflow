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
package org.nabucco.framework.workflow.impl.service.definition.resolve;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.ResolveException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;
import org.nabucco.framework.workflow.facade.message.definition.WorkflowDefinitionListMsg;
import org.nabucco.framework.workflow.facade.service.definition.resolve.ResolveWorkflowDefinition;

/**
 * ResolveWorkflowDefinitionImpl<p/>Workflow definition resolution service.<p/>
 *
 * @version 1.0
 * @author Silas Schwarz, PRODYNA AG, 2010-04-28
 */
public class ResolveWorkflowDefinitionImpl extends ServiceSupport implements ResolveWorkflowDefinition {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ResolveWorkflowDefinition";

    private static Map<String, String[]> ASPECTS;

    private ResolveWorkflowDefinitionServiceHandler resolveWorkflowDefinitionServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new ResolveWorkflowDefinitionImpl instance. */
    public ResolveWorkflowDefinitionImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.resolveWorkflowDefinitionServiceHandler = injector.inject(ResolveWorkflowDefinitionServiceHandler.getId());
        if ((this.resolveWorkflowDefinitionServiceHandler != null)) {
            this.resolveWorkflowDefinitionServiceHandler.setPersistenceManager(persistenceManager);
            this.resolveWorkflowDefinitionServiceHandler.setLogger(super.getLogger());
        }
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
    }

    @Override
    public String[] getAspects(String operationName) {
        if ((ASPECTS == null)) {
            ASPECTS = new HashMap<String, String[]>();
            ASPECTS.put("resolveWorkflowDefinition", new String[] { "org.nabucco.aspect.caching" });
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<WorkflowDefinitionListMsg> resolveWorkflowDefinition(
            ServiceRequest<WorkflowDefinitionListMsg> rq) throws ResolveException {
        if ((this.resolveWorkflowDefinitionServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for resolveWorkflowDefinition().");
            throw new InjectionException("No service implementation configured for resolveWorkflowDefinition().");
        }
        ServiceResponse<WorkflowDefinitionListMsg> rs;
        this.resolveWorkflowDefinitionServiceHandler.init();
        rs = this.resolveWorkflowDefinitionServiceHandler.invoke(rq);
        this.resolveWorkflowDefinitionServiceHandler.finish();
        return rs;
    }
}
