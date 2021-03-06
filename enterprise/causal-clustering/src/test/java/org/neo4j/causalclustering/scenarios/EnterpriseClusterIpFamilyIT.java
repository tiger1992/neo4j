/*
 * Copyright (c) 2002-2018 "Neo4j,"
 * Neo4j Sweden AB [http://neo4j.com]
 *
 * This file is part of Neo4j Enterprise Edition. The included source
 * code can be redistributed and/or modified under the terms of the
 * GNU AFFERO GENERAL PUBLIC LICENSE Version 3
 * (http://www.fsf.org/licensing/licenses/agpl-3.0.html) with the
 * Commons Clause, as found in the associated LICENSE.txt file.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * Neo4j object code can be licensed independently from the source
 * under separate terms from the AGPL. Inquiries can be directed to:
 * licensing@neo4j.com
 *
 * More information is also available at:
 * https://neo4j.com/licensing/
 */
package org.neo4j.causalclustering.scenarios;

import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Supplier;

import org.neo4j.causalclustering.discovery.DiscoveryServiceFactory;
import org.neo4j.causalclustering.discovery.IpFamily;

import static org.neo4j.causalclustering.discovery.IpFamily.IPV4;
import static org.neo4j.causalclustering.discovery.IpFamily.IPV6;
import static org.neo4j.causalclustering.scenarios.DiscoveryServiceType.HAZELCAST;
import static org.neo4j.causalclustering.scenarios.DiscoveryServiceType.SHARED;

public class EnterpriseClusterIpFamilyIT extends BaseClusterIpFamilyIT
{
    @Parameterized.Parameters( name = "{0} {1} useWildcard={2}" )
    public static Collection<Object[]> data()
    {
        return Arrays.asList( new Object[][]{
                {SHARED, IPV4, false},
                {SHARED, IPV6, true},

                {HAZELCAST, IPV4, false},
                {HAZELCAST, IPV6, false},

                {HAZELCAST, IPV4, true},
                {HAZELCAST, IPV6, true},
        } );
    }

    public EnterpriseClusterIpFamilyIT( Supplier<DiscoveryServiceFactory> discoveryServiceFactory, IpFamily ipFamily, boolean useWildcard )
    {
        super( discoveryServiceFactory, ipFamily, useWildcard );
    }
}
