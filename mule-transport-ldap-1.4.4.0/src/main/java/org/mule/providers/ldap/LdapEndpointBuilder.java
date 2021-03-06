/*
 * $Id: LdapEndpointBuilder.java 54 2007-08-09 16:55:45Z hsaly $
 * --------------------------------------------------------------------------------------
 * Copyright (c) MuleSource, Inc.  All rights reserved.  http://www.mulesource.com
 *
 * The software in this package is published under the terms of the MuleSource MPL
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */

package org.mule.providers.ldap;

import java.net.URI;
import java.util.Properties;

import org.mule.impl.endpoint.ResourceNameEndpointBuilder;
import org.mule.umo.endpoint.MalformedEndpointException;
import org.mule.util.StringUtils;

public class LdapEndpointBuilder extends ResourceNameEndpointBuilder
{

    // @Override
    protected void setEndpoint(URI uri, Properties props)
            throws MalformedEndpointException
    {

        super.setEndpoint(uri, props);

        // validate
        if (!"ldap.in".equals(this.address)
                && !this.address.startsWith("ldap.out"))
        {
            throw new MalformedEndpointException(
                    this.address
                            + " (only 'ldap[s]://ldap.in' or 'ldap[s]://ldap.out[/query]' supported.)");
        }

        if (!StringUtils.isEmpty(this.userInfo))
        {
            throw new MalformedEndpointException(
                    this.address
                            + " (only 'ldap[s]://ldap.in' or 'ldap[s]://ldap.out[/query]' without userinfo supported.)");
        }

    }

}
