/*
 * $Id: FromParentFunction.java,v 1.3 2003/03/05 21:59:47 jeremias Exp $
 * ============================================================================
 *                    The Apache Software License, Version 1.1
 * ============================================================================
 *
 * Copyright (C) 1999-2003 The Apache Software Foundation. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modifica-
 * tion, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 *
 * 3. The end-user documentation included with the redistribution, if any, must
 *    include the following acknowledgment: "This product includes software
 *    developed by the Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgment may appear in the software itself, if
 *    and wherever such third-party acknowledgments normally appear.
 *
 * 4. The names "FOP" and "Apache Software Foundation" must not be used to
 *    endorse or promote products derived from this software without prior
 *    written permission. For written permission, please contact
 *    apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache", nor may
 *    "Apache" appear in their name, without prior written permission of the
 *    Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES,
 * INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * APACHE SOFTWARE FOUNDATION OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLU-
 * DING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS
 * OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON
 * ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 * ============================================================================
 *
 * This software consists of voluntary contributions made by many individuals
 * on behalf of the Apache Software Foundation and was originally created by
 * James Tauber <jtauber@jtauber.com>. For more information on the Apache
 * Software Foundation, please see <http://www.apache.org/>.
 */
package org.apache.fop.fo.expr;

import org.apache.fop.fo.Property;

/**
 * Class modelling the from-parent Property Value function. See Sec. 5.10.4 of
 * the XSL-FO spec.
 */
public class FromParentFunction extends FunctionBase {

    /**
     * @return 1 (maximum arguments for the from-parent function)
     */
    public int nbArgs() {
        return 1;
    }

    /**
     * @param args array of arguments, which should either be empty, or the
     * first of which should contain an NCName corresponding to property name
     * @param pInfo PropertyInfo object to be evaluated
     * @return property containing the computed value
     * @throws PropertyException if the arguments are incorrect
     */
    public Property eval(Property[] args,
                         PropertyInfo pInfo) throws PropertyException {
        String propName = args[0].getString();
        if (propName == null) {
            throw new PropertyException("Incorrect parameter to from-parent function");
        }
        // NOTE: special cases for shorthand property
        // Should return COMPUTED VALUE
        /*
         * For now, this is the same as inherited-property-value(propName)
         * (The only difference I can see is that this could work for
         * non-inherited properties too. Perhaps the result is different for
         * a property line line-height which "inherits specified"???
         */
        return pInfo.getPropertyList().getFromParent(propName);
    }

}
