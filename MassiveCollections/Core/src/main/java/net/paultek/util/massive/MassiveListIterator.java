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

import java.util.ListIterator;

/**
 * An iterator that allows forward and backward iteration through a
 * {@link MassiveList}.
 *
 * @author Paul Huynh [paul.viet.huynh@live.com]
 */
public interface MassiveListIterator<E> extends ListIterator<E> {

    /**
     * Gets the index of the element that would be returned by a call to
     * {@link #next()}. Returns {@link MassiveList#massiveSize()} if at the end
     * of the list.
     *
     * @return The index of the next element.
     */
    long massiveNextIndex();

    /**
     * Gets the index of the element that would be returned by a call to
     * {@link #previous()}. Returns -1 if at the beginning of the list.
     *
     * @return The index of the previous element.
     */
    long massivePreviousIndex();
}
