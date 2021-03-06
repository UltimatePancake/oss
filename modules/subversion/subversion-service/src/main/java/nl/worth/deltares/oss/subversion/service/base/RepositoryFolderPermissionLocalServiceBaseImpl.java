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

package nl.worth.deltares.oss.subversion.service.base;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalServiceRegistry;
import com.liferay.portal.kernel.service.persistence.ClassNamePersistence;
import com.liferay.portal.kernel.service.persistence.UserPersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import nl.worth.deltares.oss.subversion.model.RepositoryFolderPermission;
import nl.worth.deltares.oss.subversion.service.RepositoryFolderPermissionLocalService;
import nl.worth.deltares.oss.subversion.service.persistence.RepositoryFolderPermissionPersistence;
import nl.worth.deltares.oss.subversion.service.persistence.RepositoryFolderPersistence;
import nl.worth.deltares.oss.subversion.service.persistence.RepositoryLogPersistence;
import nl.worth.deltares.oss.subversion.service.persistence.RepositoryPersistence;

/**
 * Provides the base implementation for the repository folder permission local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link nl.worth.deltares.oss.subversion.service.impl.RepositoryFolderPermissionLocalServiceImpl}.
 * </p>
 *
 * @author Pier-Angelo Gaetani @ Worth Systems
 * @see nl.worth.deltares.oss.subversion.service.impl.RepositoryFolderPermissionLocalServiceImpl
 * @generated
 */
@ProviderType
public abstract class RepositoryFolderPermissionLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements RepositoryFolderPermissionLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>RepositoryFolderPermissionLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>nl.worth.deltares.oss.subversion.service.RepositoryFolderPermissionLocalServiceUtil</code>.
	 */

	/**
	 * Adds the repository folder permission to the database. Also notifies the appropriate model listeners.
	 *
	 * @param repositoryFolderPermission the repository folder permission
	 * @return the repository folder permission that was added
	 * @throws SystemException
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public RepositoryFolderPermission addRepositoryFolderPermission(
			RepositoryFolderPermission repositoryFolderPermission)
		throws SystemException {

		repositoryFolderPermission.setNew(true);

		return repositoryFolderPermissionPersistence.update(
			repositoryFolderPermission);
	}

	/**
	 * Creates a new repository folder permission with the primary key. Does not add the repository folder permission to the database.
	 *
	 * @param permissionId the primary key for the new repository folder permission
	 * @return the new repository folder permission
	 */
	@Override
	@Transactional(enabled = false)
	public RepositoryFolderPermission createRepositoryFolderPermission(
		long permissionId) {

		return repositoryFolderPermissionPersistence.create(permissionId);
	}

	/**
	 * Deletes the repository folder permission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param permissionId the primary key of the repository folder permission
	 * @return the repository folder permission that was removed
	 * @throws PortalException if a repository folder permission with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public RepositoryFolderPermission deleteRepositoryFolderPermission(
			long permissionId)
		throws PortalException {

		return repositoryFolderPermissionPersistence.remove(permissionId);
	}

	/**
	 * Deletes the repository folder permission from the database. Also notifies the appropriate model listeners.
	 *
	 * @param repositoryFolderPermission the repository folder permission
	 * @return the repository folder permission that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public RepositoryFolderPermission deleteRepositoryFolderPermission(
		RepositoryFolderPermission repositoryFolderPermission) {

		return repositoryFolderPermissionPersistence.remove(
			repositoryFolderPermission);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			RepositoryFolderPermission.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return repositoryFolderPermissionPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>nl.worth.deltares.oss.subversion.model.impl.RepositoryFolderPermissionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return repositoryFolderPermissionPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>nl.worth.deltares.oss.subversion.model.impl.RepositoryFolderPermissionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return repositoryFolderPermissionPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return repositoryFolderPermissionPersistence.countWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return repositoryFolderPermissionPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public RepositoryFolderPermission fetchRepositoryFolderPermission(
		long permissionId) {

		return repositoryFolderPermissionPersistence.fetchByPrimaryKey(
			permissionId);
	}

	/**
	 * Returns the repository folder permission with the primary key.
	 *
	 * @param permissionId the primary key of the repository folder permission
	 * @return the repository folder permission
	 * @throws PortalException if a repository folder permission with the primary key could not be found
	 */
	@Override
	public RepositoryFolderPermission getRepositoryFolderPermission(
			long permissionId)
		throws PortalException {

		return repositoryFolderPermissionPersistence.findByPrimaryKey(
			permissionId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			repositoryFolderPermissionLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(RepositoryFolderPermission.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("permissionId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			repositoryFolderPermissionLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			RepositoryFolderPermission.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"permissionId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			repositoryFolderPermissionLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(RepositoryFolderPermission.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("permissionId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return repositoryFolderPermissionLocalService.
			deleteRepositoryFolderPermission(
				(RepositoryFolderPermission)persistedModel);
	}

	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return repositoryFolderPermissionPersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns a range of all the repository folder permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>nl.worth.deltares.oss.subversion.model.impl.RepositoryFolderPermissionModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of repository folder permissions
	 * @param end the upper bound of the range of repository folder permissions (not inclusive)
	 * @return the range of repository folder permissions
	 */
	@Override
	public List<RepositoryFolderPermission> getRepositoryFolderPermissions(
		int start, int end) {

		return repositoryFolderPermissionPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of repository folder permissions.
	 *
	 * @return the number of repository folder permissions
	 */
	@Override
	public int getRepositoryFolderPermissionsCount() {
		return repositoryFolderPermissionPersistence.countAll();
	}

	/**
	 * Updates the repository folder permission in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param repositoryFolderPermission the repository folder permission
	 * @return the repository folder permission that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public RepositoryFolderPermission updateRepositoryFolderPermission(
		RepositoryFolderPermission repositoryFolderPermission) {

		return repositoryFolderPermissionPersistence.update(
			repositoryFolderPermission);
	}

	/**
	 * Returns the repository local service.
	 *
	 * @return the repository local service
	 */
	public nl.worth.deltares.oss.subversion.service.RepositoryLocalService
		getRepositoryLocalService() {

		return repositoryLocalService;
	}

	/**
	 * Sets the repository local service.
	 *
	 * @param repositoryLocalService the repository local service
	 */
	public void setRepositoryLocalService(
		nl.worth.deltares.oss.subversion.service.RepositoryLocalService
			repositoryLocalService) {

		this.repositoryLocalService = repositoryLocalService;
	}

	/**
	 * Returns the repository persistence.
	 *
	 * @return the repository persistence
	 */
	public RepositoryPersistence getRepositoryPersistence() {
		return repositoryPersistence;
	}

	/**
	 * Sets the repository persistence.
	 *
	 * @param repositoryPersistence the repository persistence
	 */
	public void setRepositoryPersistence(
		RepositoryPersistence repositoryPersistence) {

		this.repositoryPersistence = repositoryPersistence;
	}

	/**
	 * Returns the repository folder local service.
	 *
	 * @return the repository folder local service
	 */
	public nl.worth.deltares.oss.subversion.service.RepositoryFolderLocalService
		getRepositoryFolderLocalService() {

		return repositoryFolderLocalService;
	}

	/**
	 * Sets the repository folder local service.
	 *
	 * @param repositoryFolderLocalService the repository folder local service
	 */
	public void setRepositoryFolderLocalService(
		nl.worth.deltares.oss.subversion.service.RepositoryFolderLocalService
			repositoryFolderLocalService) {

		this.repositoryFolderLocalService = repositoryFolderLocalService;
	}

	/**
	 * Returns the repository folder persistence.
	 *
	 * @return the repository folder persistence
	 */
	public RepositoryFolderPersistence getRepositoryFolderPersistence() {
		return repositoryFolderPersistence;
	}

	/**
	 * Sets the repository folder persistence.
	 *
	 * @param repositoryFolderPersistence the repository folder persistence
	 */
	public void setRepositoryFolderPersistence(
		RepositoryFolderPersistence repositoryFolderPersistence) {

		this.repositoryFolderPersistence = repositoryFolderPersistence;
	}

	/**
	 * Returns the repository folder permission local service.
	 *
	 * @return the repository folder permission local service
	 */
	public RepositoryFolderPermissionLocalService
		getRepositoryFolderPermissionLocalService() {

		return repositoryFolderPermissionLocalService;
	}

	/**
	 * Sets the repository folder permission local service.
	 *
	 * @param repositoryFolderPermissionLocalService the repository folder permission local service
	 */
	public void setRepositoryFolderPermissionLocalService(
		RepositoryFolderPermissionLocalService
			repositoryFolderPermissionLocalService) {

		this.repositoryFolderPermissionLocalService =
			repositoryFolderPermissionLocalService;
	}

	/**
	 * Returns the repository folder permission persistence.
	 *
	 * @return the repository folder permission persistence
	 */
	public RepositoryFolderPermissionPersistence
		getRepositoryFolderPermissionPersistence() {

		return repositoryFolderPermissionPersistence;
	}

	/**
	 * Sets the repository folder permission persistence.
	 *
	 * @param repositoryFolderPermissionPersistence the repository folder permission persistence
	 */
	public void setRepositoryFolderPermissionPersistence(
		RepositoryFolderPermissionPersistence
			repositoryFolderPermissionPersistence) {

		this.repositoryFolderPermissionPersistence =
			repositoryFolderPermissionPersistence;
	}

	/**
	 * Returns the repository log local service.
	 *
	 * @return the repository log local service
	 */
	public nl.worth.deltares.oss.subversion.service.RepositoryLogLocalService
		getRepositoryLogLocalService() {

		return repositoryLogLocalService;
	}

	/**
	 * Sets the repository log local service.
	 *
	 * @param repositoryLogLocalService the repository log local service
	 */
	public void setRepositoryLogLocalService(
		nl.worth.deltares.oss.subversion.service.RepositoryLogLocalService
			repositoryLogLocalService) {

		this.repositoryLogLocalService = repositoryLogLocalService;
	}

	/**
	 * Returns the repository log persistence.
	 *
	 * @return the repository log persistence
	 */
	public RepositoryLogPersistence getRepositoryLogPersistence() {
		return repositoryLogPersistence;
	}

	/**
	 * Sets the repository log persistence.
	 *
	 * @param repositoryLogPersistence the repository log persistence
	 */
	public void setRepositoryLogPersistence(
		RepositoryLogPersistence repositoryLogPersistence) {

		this.repositoryLogPersistence = repositoryLogPersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.kernel.service.CounterLocalService
		getCounterLocalService() {

		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.kernel.service.CounterLocalService
			counterLocalService) {

		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the class name local service.
	 *
	 * @return the class name local service
	 */
	public com.liferay.portal.kernel.service.ClassNameLocalService
		getClassNameLocalService() {

		return classNameLocalService;
	}

	/**
	 * Sets the class name local service.
	 *
	 * @param classNameLocalService the class name local service
	 */
	public void setClassNameLocalService(
		com.liferay.portal.kernel.service.ClassNameLocalService
			classNameLocalService) {

		this.classNameLocalService = classNameLocalService;
	}

	/**
	 * Returns the class name persistence.
	 *
	 * @return the class name persistence
	 */
	public ClassNamePersistence getClassNamePersistence() {
		return classNamePersistence;
	}

	/**
	 * Sets the class name persistence.
	 *
	 * @param classNamePersistence the class name persistence
	 */
	public void setClassNamePersistence(
		ClassNamePersistence classNamePersistence) {

		this.classNamePersistence = classNamePersistence;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.kernel.service.ResourceLocalService
		getResourceLocalService() {

		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.kernel.service.ResourceLocalService
			resourceLocalService) {

		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.kernel.service.UserLocalService
		getUserLocalService() {

		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.kernel.service.UserLocalService userLocalService) {

		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		persistedModelLocalServiceRegistry.register(
			"nl.worth.deltares.oss.subversion.model.RepositoryFolderPermission",
			repositoryFolderPermissionLocalService);
	}

	public void destroy() {
		persistedModelLocalServiceRegistry.unregister(
			"nl.worth.deltares.oss.subversion.model.RepositoryFolderPermission");
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return RepositoryFolderPermissionLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return RepositoryFolderPermission.class;
	}

	protected String getModelClassName() {
		return RepositoryFolderPermission.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				repositoryFolderPermissionPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(
		type = nl.worth.deltares.oss.subversion.service.RepositoryLocalService.class
	)
	protected nl.worth.deltares.oss.subversion.service.RepositoryLocalService
		repositoryLocalService;

	@BeanReference(type = RepositoryPersistence.class)
	protected RepositoryPersistence repositoryPersistence;

	@BeanReference(
		type = nl.worth.deltares.oss.subversion.service.RepositoryFolderLocalService.class
	)
	protected
		nl.worth.deltares.oss.subversion.service.RepositoryFolderLocalService
			repositoryFolderLocalService;

	@BeanReference(type = RepositoryFolderPersistence.class)
	protected RepositoryFolderPersistence repositoryFolderPersistence;

	@BeanReference(type = RepositoryFolderPermissionLocalService.class)
	protected RepositoryFolderPermissionLocalService
		repositoryFolderPermissionLocalService;

	@BeanReference(type = RepositoryFolderPermissionPersistence.class)
	protected RepositoryFolderPermissionPersistence
		repositoryFolderPermissionPersistence;

	@BeanReference(
		type = nl.worth.deltares.oss.subversion.service.RepositoryLogLocalService.class
	)
	protected nl.worth.deltares.oss.subversion.service.RepositoryLogLocalService
		repositoryLogLocalService;

	@BeanReference(type = RepositoryLogPersistence.class)
	protected RepositoryLogPersistence repositoryLogPersistence;

	@ServiceReference(
		type = com.liferay.counter.kernel.service.CounterLocalService.class
	)
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ClassNameLocalService.class
	)
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@ServiceReference(type = ClassNamePersistence.class)
	protected ClassNamePersistence classNamePersistence;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.ResourceLocalService.class
	)
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@ServiceReference(
		type = com.liferay.portal.kernel.service.UserLocalService.class
	)
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@ServiceReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;

	@ServiceReference(type = PersistedModelLocalServiceRegistry.class)
	protected PersistedModelLocalServiceRegistry
		persistedModelLocalServiceRegistry;

}