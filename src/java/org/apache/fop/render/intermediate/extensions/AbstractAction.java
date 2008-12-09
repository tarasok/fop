/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* $Id$ */

package org.apache.fop.render.intermediate.extensions;

import org.apache.xmlgraphics.util.XMLizable;

/**
 * Abstract base class for document actions, like "go-to" actions with absolute page coordinates.
 */
public abstract class AbstractAction implements XMLizable {

    private String id;

    /**
     * Sets an ID to make the action referencable.
     * @param id the ID
     */
    public void setID(String id) {
        this.id = id;
    }

    /**
     * Returns an optional ID for this action.
     * @return the ID or null
     */
    public String getID() {
        return this.id;
    }

    /**
     * Indicates whether the action has an ID and is therefore referencable.
     * @return true if the action has an ID
     */
    public boolean hasID() {
        return this.id != null;
    }

    /**
     * Indicates whether two action are equal. Note: this is not the same as
     * {@link Object#equals(Object)}!
     * @param other the other action to compare to
     * @return true if the actions are equal
     */
    public abstract boolean isSame(AbstractAction other);

    /**
     * Indicates whether this action is a reference.
     * @return true if this action is a reference, false for a normal action
     */
    public boolean isReference() {
        return false;
    }

    /**
     * Creates a reference to this action.
     * @return the reference
     */
    public AbstractAction createReference() {
        return new ReferencedAction(getID());
    }

    /**
     * Returns a string that is used to prefix a generated ID to make it unique.
     * @return the prefix string
     */
    public String getIDPrefix() {
        return null;
    }

}
