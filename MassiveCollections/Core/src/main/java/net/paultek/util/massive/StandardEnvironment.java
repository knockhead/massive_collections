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
 * An environment for generation of {@link MassiveCollection}, which performs
 * relatively 'dumb' load balancing of memory based on the number of
 * {@link MassiveCollection} currently open.
 *
 * @author Paul Huynh [paul.viet.huynh@live.com]
 */
public class StandardEnvironment implements Environment {

    public static final String MEMORY_MAX = "net.paultek.util.massive.StandardEnvironment.memoryMax";
    public static final String CLASSES = "net.paultek.util.massive.StandardEnvironment.classes";

    private final Properties properties;

    public StandardEnvironment() {
        this.properties = new Properties();
    }

    @Override
    public void load(Properties properties) {
        this.properties.putAll(properties);
    }

    @Override
    public <E> MassiveList<E> createList(Class<? extends E> elementClass) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
