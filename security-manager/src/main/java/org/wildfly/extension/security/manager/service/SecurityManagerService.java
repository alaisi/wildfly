/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2013, Red Hat, Inc., and individual contributors
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

package org.wildfly.extension.security.manager.service;

import org.jboss.msc.service.Service;
import org.jboss.msc.service.ServiceName;
import org.jboss.msc.service.StartContext;
import org.jboss.msc.service.StartException;
import org.jboss.msc.service.StopContext;
import org.wildfly.extension.security.manager.Constants;
import org.wildfly.extension.security.manager.logging.SecurityManagerLogger;
import org.wildfly.security.manager.WildFlySecurityManager;

/**
 * This class implements a {@link Service} that install the {@link WildFlySecurityManager}.
 *
 * @author <a href="sguilhen@jboss.com">Stefan Guilhen</a>
 */
public class SecurityManagerService implements Service<Void>  {

    public static final ServiceName SERVICE_NAME = ServiceName.JBOSS.append(Constants.SUBSYSTEM_NAME, Constants.SECURITY_MANAGER_SERVICE);

    @Override
    public void stop(final StopContext stopContext) {
        // we should uninstall the WildFlySecurityManager and restore the previous context if any.
    }

    @Override
    public void start(final StartContext startContext) throws StartException {
        SecurityManagerLogger.ROOT_LOGGER.installingWildFlySecurityManager();
        // install the WildFlySecurityManager.
        WildFlySecurityManager.install();
    }

    @Override
    public Void getValue() throws IllegalStateException, IllegalArgumentException {
        return null;
    }
}
