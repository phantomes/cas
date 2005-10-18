/*
 * Copyright 2004 The JA-SIG Collaborative. All rights reserved. See license
 * distributed with this file and available online at
 * http://www.uportal.org/license.html
 */
package org.jasig.cas.authentication.principal;

import org.jasig.cas.TestUtils;

import junit.framework.TestCase;

/**
 * @author Scott Battaglia
 * @version $Revision$ $Date$
 * @since 3.0
 */
public class UsernamePasswordCredentialsToPrincipalResolverTests extends
    TestCase {

    private CredentialsToPrincipalResolver resolver = new UsernamePasswordCredentialsToPrincipalResolver();

    public void testValidSupportsCredentials() {
        assertTrue(this.resolver.supports(TestUtils
            .getCredentialsWithSameUsernameAndPassword()));
    }

    public void testNullSupportsCredentials() {
        assertFalse(this.resolver.supports(null));
    }

    public void testInvalidSupportsCredentials() {
        assertFalse(this.resolver.supports(TestUtils
            .getHttpBasedServiceCredentials()));
    }

    public void testValidCredentials() {
        Principal p = this.resolver.resolvePrincipal(TestUtils
            .getCredentialsWithSameUsernameAndPassword());

        assertEquals(p.getId(), TestUtils
            .getCredentialsWithSameUsernameAndPassword().getUsername());
    }
}