package org.apache.chemistry.opencmis.client.bindings.spi.local;

import java.math.BigInteger;
import java.util.List;

import org.apache.chemistry.opencmis.client.bindings.spi.Session;
import org.apache.chemistry.opencmis.commons.data.ExtensionsData;
import org.apache.chemistry.opencmis.commons.data.RepositoryInfo;
import org.apache.chemistry.opencmis.commons.definitions.TypeDefinition;
import org.apache.chemistry.opencmis.commons.definitions.TypeDefinitionContainer;
import org.apache.chemistry.opencmis.commons.definitions.TypeDefinitionList;
import org.apache.chemistry.opencmis.commons.server.CmisService;
import org.apache.chemistry.opencmis.commons.server.CmisServiceFactory;
import org.apache.chemistry.opencmis.commons.spi.RepositoryService;

/**
 * Repository Service local client.
 */
public class RepositoryServiceImpl extends AbstractLocalService implements RepositoryService {

    /**
     * Constructor.
     */
    public RepositoryServiceImpl(Session session, CmisServiceFactory factory) {
        setSession(session);
        setServiceFactory(factory);
    }

    public RepositoryInfo getRepositoryInfo(String repositoryId, ExtensionsData extension) {
        CmisService service = getService(repositoryId);

        try {
            return service.getRepositoryInfo(repositoryId, extension);
        } finally {
            service.close();
        }
    }

    public List<RepositoryInfo> getRepositoryInfos(ExtensionsData extension) {
        CmisService service = getService(null);

        try {
            return service.getRepositoryInfos(extension);
        } finally {
            service.close();
        }
    }

    public TypeDefinition getTypeDefinition(String repositoryId, String typeId, ExtensionsData extension) {
        CmisService service = getService(repositoryId);

        try {
            return service.getTypeDefinition(repositoryId, typeId, extension);
        } finally {
            service.close();
        }
    }

    public TypeDefinitionList getTypeChildren(String repositoryId, String typeId, Boolean includePropertyDefinitions,
            BigInteger maxItems, BigInteger skipCount, ExtensionsData extension) {
        CmisService service = getService(repositoryId);

        try {
            return service.getTypeChildren(repositoryId, typeId, includePropertyDefinitions, maxItems, skipCount,
                    extension);
        } finally {
            service.close();
        }
    }

    public List<TypeDefinitionContainer> getTypeDescendants(String repositoryId, String typeId, BigInteger depth,
            Boolean includePropertyDefinitions, ExtensionsData extension) {
        CmisService service = getService(repositoryId);

        try {
            return service.getTypeDescendants(repositoryId, typeId, depth, includePropertyDefinitions, extension);
        } finally {
            service.close();
        }
    }

}
