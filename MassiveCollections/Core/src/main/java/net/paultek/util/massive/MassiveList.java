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
import java.util.List;

/**
 * Extension of the List interface that allows indexing by long instead of int.
 *
 * @author Paul Huynh [paul.viet.huynh@live.com]
 * @param <E> The type of elements in this list
 */
public interface MassiveList<E> extends MassiveCollection<E>, List<E> {

    /**
     * Add item to the list at the index specified. All items after this index
     * will be shifted up.
     *
     * @param index The index at which to add the item.
     * @param element The element to add.
     */
    void add(long index, E element);

    /**
     * Adds all the items in the collection at the index specified. Any items
     * after this index will be shifted up.
     *
     * @param index The index at which to add the collection of items.
     * @param c The collection of items to add.
     */
    void addAll(long index, Collection<? extends E> c);

    /**
     * Gets the element at the index specified.
     *
     * @param i The index of the element to get.
     * @return The element at the index.
     */
    E get(long i);

    /**
     * Return the index of the first occurrence of the object,. Returns -1 if
     * the object does not exist in the list.
     *
     * @param o The object to search for. Throws {@link NullPointerException} if
     * the object is null.
     * @return Index of the object, or -1 if the object does not exist in the
     * list.
     */
    long massiveIndexOf(Object o);

    /**
     * Returns the index of the last occurrence of the object. Returns -1 if the
     * object does not exist in the list.
     *
     * @param o The Object to search for. Throws {@link  NullPointerException} if
     * the object is null.
     * @return Index of the object, or -1 if the object does not exist in the
     * list.
     */
    long massiveLastIndexOf(Object o);

    /**
     * Returns a list iterator over the elements in the list.
     *
     * @return A list iterator.
     */
    MassiveListIterator<E> massiveListIterator();

    /**
     * Returns a list iterator over the elements in the list, starting from the
     * specified index. If the first call to the iterator is
     * {@link MassiveListIterator#next()} it will return the element at that
     * index. If the first call to the iterator is
     * {@link MassiveListIterator#previous()} it will return the element at the
     * specified index minus one.
     *
     * @param index The index at which to start this iterator.
     * @return A list iterator positioned at the index specified.
     */
    MassiveListIterator<E> massiveListIterator(long index);

    /**
     * Removes the item at the index specified. All items after this index are
     * shifted down.
     *
     * @param index The index at which to remove the item.
     * @return The item that was removed.
     */
    E remove(long index);

    /**
     * Set the element at the specified index to be the element passed in. Does
     * NOT shift the surrounding elements.
     *
     * @param index The index of the element that will be set.
     * @param element The set to set at the index specified.
     */
    void set(long index, E element);

    /**
     * Gets the true number of elements in the list. This is 'true' compared
     * with the regular {@link #size()} method, with maxes out at
     * {@link Integer#MAX_VALUE}. Note that we could try to fill a list with
     * more than {@link Long#MAX_VALUE}, but that is a LOOOOOOT of elements (9
     * quintillion, that's 9 billion billion elements).
     *
     * @return The number of elements in the list. May be 0 if empty.
     */
    long massiveSize();

    /**
     * Gets a sublist of the elements. The 'zero'th element in the sublist will
     * be the element at fromIndex in the parent list.
     *
     * @param fromIndex The index to start the sublist (inclusive).
     * @param toIndex The index to end the sublist (exclusive).
     * @return A list of the elements in between the two indices. Depending on
     * the implementation, modifications to the sublist may result in the same
     * changes being passed through to the parent list, and vice-versa.
     */
    MassiveList<E> massiveSubList(long fromIndex, long toIndex);
}
