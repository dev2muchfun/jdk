/*
 * Copyright (c) 2014, 2024, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

package validation.tck;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

/*
 * @test
 * @bug 6970890
 * @library /javax/xml/jaxp/libs /javax/xml/jaxp/unittest
 * @run testng/othervm validation.tck.Bug6970890Test
 * @summary Test Schema allows [-] in regex.
 */
public class Bug6970890Test {
    static final String SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";
    static final String SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";

    @Test
    public void test_RegexTest_1319() {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new StreamSource(Bug6970890Test.class.getResourceAsStream("Bug6970890.xsd")));

        } catch (SAXException e) {
            e.printStackTrace();
            Assert.fail("The - character is a valid character range at the beginning or end of a positive character group");
        }
    }

    @Test
    public void test_reH16() {
        try {
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(new StreamSource(Bug6970890Test.class.getResourceAsStream("Bug6970890_1.xsd")));

        } catch (SAXException e) {
            e.printStackTrace();
            Assert.fail("The - character is a valid character range at the beginning or end of a positive character group");

        }
    }

}
