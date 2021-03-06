/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.shrinkwrap.resolver.api;

import java.io.File;

/**
 * Top-level of a configurable resolver system; subtypes may be passed in as an argument to {@link Resolvers#use(Class)}
 * or {@link Resolvers#use(Class, ClassLoader)} to create a new instance.
 *
 * @param <CONFIGUREDRESOLVERSYSTEMTYPE>
 *            View type of the {@link ResolverSystem} which does not support configuration
 * @author <a href="mailto:alr@jboss.org">Andrew Lee Rubinger</a>
 */
public interface ConfigurableResolverSystem<CONFIGUREDRESOLVERSYSTEMTYPE extends ResolverSystem> extends ResolverSystem {

    /**
     * <i>Optional operation</i>. Configures this {@link ConfigurableResolverSystem} from the specified file
     *
     * @param file
     * @return This configured {@link ResolverSystem}
     * @throws IllegalArgumentException
     *             If the file is not specified, is a directory, or does not exist
     * @throws InvalidConfigurationFileException
     *             If the configuration file contents are not in appropriate format
     * @throws UnsupportedOperationException
     *             If this {@link ConfigurableResolverSystem} does not support configuration by {@link File}
     */
    CONFIGUREDRESOLVERSYSTEMTYPE configureFromFile(File file) throws IllegalArgumentException,
        UnsupportedOperationException, InvalidConfigurationFileException;

    /**
     * <i>Optional operation</i>. Configures this {@link ConfigurableResolverSystem} from the file at the specified path
     *
     * @param pathToFile
     * @return This configured {@link ResolverSystem}
     * @throws IllegalArgumentException
     *             If the file is not specified, is a directory, or does not exist
     * @throws InvalidConfigurationFileException
     *             If the configuration file contents are not in appropriate format
     * @throws UnsupportedOperationException
     *             If this {@link ConfigurableResolverSystem} does not support configuration by {@link File}
     * @throws InvalidConfigurationFileException
     *             If the configuration file contents are not in appropriate format
     */
    CONFIGUREDRESOLVERSYSTEMTYPE configureFromFile(String pathToFile) throws IllegalArgumentException,
        UnsupportedOperationException, InvalidConfigurationFileException;

    /**
     * <i>Optional operation</i>. Configures this {@link ConfigurableResolverSystem} from the result of
     * {@link ClassLoader#getResource(String)} using the current {@link Thread#getContextClassLoader()}
     *
     * @param path
     * @return This configured {@link ResolverSystem}
     * @throws IllegalArgumentException
     *             If the either argument is not specified or if the path can not be found
     * @throws UnsupportedOperationException
     *             If this {@link ConfigurableResolverSystem} does not support configuration by {@link ClassLoader}
     *             resource
     * @throws InvalidConfigurationFileException
     *             If the configuration file contents are not in appropriate format
     */
    CONFIGUREDRESOLVERSYSTEMTYPE configureFromClassloaderResource(String path) throws IllegalArgumentException,
        UnsupportedOperationException, InvalidConfigurationFileException;

    /**
     * <i>Optional operation</i>. Configures this {@link ConfigurableResolverSystem} from the result of
     * {@link ClassLoader#getResource(String)} using the specified {@link ClassLoader}
     *
     * @param path
     * @param cl
     * @return This configured {@link ResolverSystem}
     * @throws IllegalArgumentException
     *             If the either argument is not specified or if the path can not be found
     * @throws UnsupportedOperationException
     *             If this {@link ConfigurableResolverSystem} does not support configuration by {@link ClassLoader}
     *             resource
     * @throws InvalidConfigurationFileException
     *             If the configuration file contents are not in appropriate format
     */
    CONFIGUREDRESOLVERSYSTEMTYPE configureFromClassloaderResource(String path, ClassLoader cl)
        throws IllegalArgumentException, UnsupportedOperationException, InvalidConfigurationFileException;

}
