/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.messaging;

import static org.jboss.as.messaging.CommonAttributes.ROLE;
import static org.jboss.as.messaging.MessagingMessages.MESSAGES;

import java.util.Collections;
import java.util.Set;

import org.jboss.as.controller.PathAddress;
import org.jboss.as.controller.PathElement;
import org.jboss.as.controller.registry.Resource;
import org.jboss.dmr.ModelNode;

public class SecurityRoleResource implements Resource {

    public static final SecurityRoleResource INSTANCE = new SecurityRoleResource();

    private SecurityRoleResource() {
    }

    @Override
    public ModelNode getModel() {
        return new ModelNode();
    }

    @Override
    public void writeModel(ModelNode newModel) {
        throw MESSAGES.immutableResource();
    }

    @Override
    public boolean isModelDefined() {
        return false;
    }

    @Override
    public boolean hasChild(PathElement element) {
        return false;
    }

    @Override
    public Resource getChild(PathElement element) {
        return null;
    }

    @Override
    public Resource requireChild(PathElement element) {
        throw new NoSuchResourceException(element);
    }

    @Override
    public boolean hasChildren(String childType) {
        return false;
    }

    @Override
    public Resource navigate(PathAddress address) {
        return Resource.Tools.navigate(this, address);
    }

    @Override
    public Set<String> getChildTypes() {
        return Collections.emptySet();
    }

    @Override
    public Set<String> getChildrenNames(String childType) {
        return Collections.emptySet();
    }

    @Override
    public Set<ResourceEntry> getChildren(String childType) {
        return Collections.emptySet();
    }

    @Override
    public void registerChild(PathElement address, Resource resource) {
        throw MESSAGES.immutableResource();
    }

    @Override
    public Resource removeChild(PathElement address) {
        throw MESSAGES.immutableResource();
    }

    @Override
    public boolean isRuntime() {
        return true;
    }

    @Override
    public boolean isProxy() {
        return false;
    }

    @Override
    public Resource clone() {
        return new SecurityRoleResource();
    }

    public static class SecuriyRoleResourceEntry extends SecurityRoleResource implements ResourceEntry {

        final PathElement path;

        public SecuriyRoleResourceEntry(String name) {
            path = PathElement.pathElement(ROLE, name);
        }

        @Override
        public String getName() {
            return path.getValue();
        }

        @Override
        public PathElement getPathElement() {
            return path;
        }

        @Override
        public SecuriyRoleResourceEntry clone() {
            return new SecuriyRoleResourceEntry(path.getValue());
        }
    }
}
