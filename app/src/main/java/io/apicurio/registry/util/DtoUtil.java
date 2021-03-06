/*
 * Copyright 2020 Red Hat
 * Copyright 2020 IBM
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

package io.apicurio.registry.util;

import io.apicurio.registry.rest.beans.ArtifactMetaData;
import io.apicurio.registry.rest.beans.VersionMetaData;
import io.apicurio.registry.storage.ArtifactMetaDataDto;
import io.apicurio.registry.storage.ArtifactVersionMetaDataDto;
import io.apicurio.registry.storage.EditableArtifactMetaDataDto;
import io.apicurio.registry.types.ArtifactType;

/**
 * @author eric.wittmann@gmail.com
 */
public final class DtoUtil {

    /**
     * Creates a jax-rs meta-data entity from the id, type, and storage meta-data.
     *
     * @param artifactId
     * @param artifactType
     * @param dto
     */
    public static final ArtifactMetaData dtoToMetaData(String artifactId, ArtifactType artifactType,
                                                  ArtifactMetaDataDto dto) {
        ArtifactMetaData metaData = new ArtifactMetaData();
        metaData.setCreatedBy(dto.getCreatedBy());
        metaData.setCreatedOn(dto.getCreatedOn());
        metaData.setDescription(dto.getDescription());
        if (artifactId != null) {
            metaData.setId(artifactId);
        } else {
            metaData.setId(dto.getId());
        }
        metaData.setModifiedBy(dto.getModifiedBy());
        metaData.setModifiedOn(dto.getModifiedOn());
        metaData.setName(dto.getName());
        if (artifactType != null) {
            metaData.setType(artifactType);
        } else {
            metaData.setType(dto.getType());
        }
        metaData.setVersion(dto.getVersion());
        metaData.setGlobalId(dto.getGlobalId());
        metaData.setState(dto.getState());
        metaData.setLabels(dto.getLabels());
        metaData.setProperties(dto.getProperties());
        return metaData;
    }

    /**
     * Creates a jax-rs version meta-data entity from the id, type, and storage meta-data.
     *
     * @param artifactId
     * @param artifactType
     * @param dto
     */
    public static final VersionMetaData dtoToVersionMetaData(String artifactId, ArtifactType artifactType,
                                                        ArtifactMetaDataDto dto) {
        VersionMetaData metaData = new VersionMetaData();
        metaData.setId(artifactId);
        metaData.setCreatedBy(dto.getCreatedBy());
        metaData.setCreatedOn(dto.getCreatedOn());
        metaData.setDescription(dto.getDescription());
        metaData.setName(dto.getName());
        metaData.setType(artifactType);
        metaData.setVersion(dto.getVersion());
        metaData.setGlobalId(dto.getGlobalId());
        metaData.setState(dto.getState());
        return metaData;
    }

    /**
     * Creates a jax-rs version meta-data entity from the id, type, and storage meta-data.
     *
     * @param artifactId
     * @param artifactType
     * @param amd
     */
    public static final VersionMetaData dtoToVersionMetaData(String artifactId, ArtifactType artifactType,
                                                             ArtifactMetaData amd) {
        VersionMetaData metaData = new VersionMetaData();
        metaData.setId(artifactId);
        metaData.setCreatedBy(amd.getCreatedBy());
        metaData.setCreatedOn(amd.getCreatedOn());
        metaData.setDescription(amd.getDescription());
        metaData.setName(amd.getName());
        metaData.setType(artifactType);
        metaData.setVersion(amd.getVersion());
        metaData.setGlobalId(amd.getGlobalId());
        metaData.setState(amd.getState());
        return metaData;
    }

    /**
     * Creates a jax-rs version meta-data entity from the id, type, and storage meta-data.
     *
     * @param artifactId
     * @param artifactType
     * @param dto
     */
    public static final VersionMetaData dtoToVersionMetaData(String artifactId, ArtifactType artifactType,
                                                             ArtifactVersionMetaDataDto dto) {
        VersionMetaData metaData = new VersionMetaData();
        metaData.setId(artifactId);
        metaData.setCreatedBy(dto.getCreatedBy());
        metaData.setCreatedOn(dto.getCreatedOn());
        metaData.setDescription(dto.getDescription());
        metaData.setName(dto.getName());
        metaData.setType(artifactType);
        metaData.setVersion(dto.getVersion());
        metaData.setGlobalId(dto.getGlobalId());
        metaData.setState(dto.getState());
        return metaData;
    }

    /**
     * Sets values from the EditableArtifactMetaDataDto into the ArtifactMetaDataDto.
     *
     * @param amdd
     * @param editableArtifactMetaData
     * @return the updated ArtifactMetaDataDto object
     */
    public static final ArtifactMetaDataDto setEditableMetaDataInArtifact(ArtifactMetaDataDto amdd, EditableArtifactMetaDataDto editableArtifactMetaData) {
        if (editableArtifactMetaData.getName() != null) {
            amdd.setName(editableArtifactMetaData.getName());
        }
        if (editableArtifactMetaData.getDescription() != null) {
            amdd.setDescription(editableArtifactMetaData.getDescription());
        }
        if (editableArtifactMetaData.getLabels() != null && !editableArtifactMetaData.getLabels().isEmpty()) {
            amdd.setLabels(editableArtifactMetaData.getLabels());
        }
        if (editableArtifactMetaData.getProperties() != null) {
            amdd.setProperties(editableArtifactMetaData.getProperties());
        }
        return amdd;
    }

}
