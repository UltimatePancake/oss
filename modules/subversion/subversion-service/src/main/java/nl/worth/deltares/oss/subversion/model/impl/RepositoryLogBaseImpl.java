/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package nl.worth.deltares.oss.subversion.model.impl;

import aQute.bnd.annotation.ProviderType;

import nl.worth.deltares.oss.subversion.model.RepositoryLog;
import nl.worth.deltares.oss.subversion.service.RepositoryLogLocalServiceUtil;

/**
 * The extended model base implementation for the RepositoryLog service. Represents a row in the &quot;Subversion_RepositoryLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RepositoryLogImpl}.
 * </p>
 *
 * @author Pier-Angelo Gaetani @ Worth Systems
 * @see RepositoryLogImpl
 * @see RepositoryLog
 * @generated
 */
@ProviderType
public abstract class RepositoryLogBaseImpl
	extends RepositoryLogModelImpl implements RepositoryLog {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a repository log model instance should use the <code>RepositoryLog</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			RepositoryLogLocalServiceUtil.addRepositoryLog(this);
		}
		else {
			RepositoryLogLocalServiceUtil.updateRepositoryLog(this);
		}
	}

}