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
package org.nabucco.framework.workflow.facade.datatype.definition.condition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.nabucco.framework.base.facade.datatype.Basetype;
import org.nabucco.framework.base.facade.datatype.NString;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;

/**
 * Expression<p/>Simple expression to express boolean conditions.<p/>
 *
 * @version 1.0
 * @author Nicolas Moser, PRODYNA AG, 2011-02-20
 */
public class Expression extends NString implements Basetype {

    private static final long serialVersionUID = 1L;

    public static final String PROPERTY_NAME = "value";

    private static final String PROPERTY_CONSTRAINTS = "l0,n;u0,n;";

    /** Constructs a new Expression instance. */
    public Expression() {
        super();
    }

    /**
     * Constructs a new Expression instance.
     *
     * @param value the String.
     */
    public Expression(String value) {
        super(value);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.put(PROPERTY_NAME,
                PropertyDescriptorSupport.createSimpletype(PROPERTY_NAME, String.class, PROPERTY_CONSTRAINTS));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public Set<NabuccoProperty> getProperties() {
        Set<NabuccoProperty> properties = super.getProperties();
        properties.add(Expression.getPropertyDescriptor(PROPERTY_NAME).createProperty(this, this.getValue(), null));
        return properties;
    }

    @Override
    public Expression cloneObject() {
        Expression clone = new Expression();
        super.cloneObject(clone);
        return clone;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(Expression.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(Expression.class).getAllProperties();
    }
}