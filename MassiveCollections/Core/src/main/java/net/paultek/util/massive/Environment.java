/*
 * Copyright 2016 Paul Huynh [paul.viet.huynh@live.com].
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.paultek.util.massive;

import java.util.Properties;

/**
 * This class provides an 'environment' within which {@link MassiveCollection}
 * instances can be created. This environment will be responsible for things
 * such as memory [de-]allocation, and also the management of any files on disk
 * that have been generated. The environment can optionally balance memory usage
 * based on past usage patterns (e.g. a data structure that is accessed
 * frequently may be assigned more memory to reduce overheads in constant
 * [re-]mapping of data, while a data structure rarely accessed could have less
 * memory assigned to it).
 *
 * @author Paul Huynh [paul.viet.huynh@live.com]
 */
public interface Environment {

    /**
     * Prepare the environment by loading properties. Each implementation of
     * {@link Environment} may require different properties; see the appropriate
     * documentation for each to determine what is required. MUST BE CALLED AT
     * LEAST ONCE prior to attempting to create any collections.
     *
     * @param properties The properties to be loaded. Subsequent calls to this
     * will merge properties.
     */
    void load(Properties properties);

    /**
     * Creates a massive list.
     *
     * @param <E> The type of elements stored in the lists that are created by
     * this environment.
     * @param elementClass The class of elements to be stored in the list.
     * @return A new list.
     */
    <E> MassiveList<E> createList(Class<? extends E> elementClass);

    /**
     * Initialises the environment. This usually requires that
     * {@link #load(java.util.Properties)} has been called prior to this.
     */
    void init();

    /**
     * Shuts down the environment, closing any open file handles. Must be called
     * when application is closing.
     */
    void shutdown();
}
