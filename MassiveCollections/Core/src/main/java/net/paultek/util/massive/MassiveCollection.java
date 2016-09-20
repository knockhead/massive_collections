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

import java.util.Collection;

/**
 * A massive collection. Massive collections operate the same as their 'regular'
 * collection counterparts, but allow sizes beyond {@link Integer#MAX_VALUE}
 * because a long is used as the indexer instead.
 *
 * @author Paul Huynh [paul.viet.huynh@live.com]
 * <E> The type of elements in this collection.
 */
public interface MassiveCollection<E> extends Collection<E> {

    /**
     * Returns the number of elements in this collection. Unlike the
     * {@link #size()}, this will return the real size of the collection if
     * there are more elements than {@link Integer#MAX_VALUE}.
     *
     * @return Number of elements in this collection.
     */
    long massiveSize();
}
