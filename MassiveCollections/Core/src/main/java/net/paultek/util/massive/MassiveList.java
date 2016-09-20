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
 * Extension of the List interface that allows indexing by long instead of int.
 *
 * @author Paul Huynh [paul.viet.huynh@live.com]
 * @param <E> The type of elements in this list
 */
public interface MassiveList<E> extends MassiveCollection<E> {

    /**
     * Add item to the list at the index specified. All items after this index
     * will be shifted up.
     *
     * @param index The index at which to add the item.
     * @param element The element to add.
     */
    void add(long index, E element);

    /**
     * Removes the item at the index specified. All items after this index are
     * shifted down.
     *
     * @param index The index at which to remove the item.
     * @return The item that was removed.
     */
    E remove(long index);

    /**
     * Adds all the items in the collection at the index specified. Any items
     * after this index will be shifted up.
     *
     * @param index The index at which to add the collection of items.
     * @param c The collection of items to add.
     */
    void addAll(long index, Collection<? extends E> c);
}
