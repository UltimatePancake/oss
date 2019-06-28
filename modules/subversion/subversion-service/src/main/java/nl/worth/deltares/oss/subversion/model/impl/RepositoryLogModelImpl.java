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

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

import nl.worth.deltares.oss.subversion.model.RepositoryLog;
import nl.worth.deltares.oss.subversion.model.RepositoryLogModel;
import nl.worth.deltares.oss.subversion.model.RepositoryLogSoap;

/**
 * The base model implementation for the RepositoryLog service. Represents a row in the &quot;Subversion_RepositoryLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>RepositoryLogModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link RepositoryLogImpl}.
 * </p>
 *
 * @author Pier-Angelo Gaetani @ Worth Systems
 * @see RepositoryLogImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class RepositoryLogModelImpl
	extends BaseModelImpl<RepositoryLog> implements RepositoryLogModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a repository log model instance should use the <code>RepositoryLog</code> interface instead.
	 */
	public static final String TABLE_NAME = "Subversion_RepositoryLog";

	public static final Object[][] TABLE_COLUMNS = {
		{"logId", Types.BIGINT}, {"ipAddress", Types.VARCHAR},
		{"screenName", Types.VARCHAR}, {"action", Types.VARCHAR},
		{"createDate", Types.BIGINT}, {"repository", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("logId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("ipAddress", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("screenName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("action", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("repository", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table Subversion_RepositoryLog (logId LONG not null primary key,ipAddress VARCHAR(75) null,screenName VARCHAR(75) null,action VARCHAR(75) null,createDate LONG,repository VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table Subversion_RepositoryLog";

	public static final String ORDER_BY_JPQL =
		" ORDER BY repositoryLog.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY Subversion_RepositoryLog.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		nl.worth.deltares.oss.subversion.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.nl.worth.deltares.oss.subversion.model.RepositoryLog"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		nl.worth.deltares.oss.subversion.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.nl.worth.deltares.oss.subversion.model.RepositoryLog"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = false;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static RepositoryLog toModel(RepositoryLogSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		RepositoryLog model = new RepositoryLogImpl();

		model.setLogId(soapModel.getLogId());
		model.setIpAddress(soapModel.getIpAddress());
		model.setScreenName(soapModel.getScreenName());
		model.setAction(soapModel.getAction());
		model.setCreateDate(soapModel.getCreateDate());
		model.setRepository(soapModel.getRepository());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<RepositoryLog> toModels(RepositoryLogSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<RepositoryLog> models = new ArrayList<RepositoryLog>(
			soapModels.length);

		for (RepositoryLogSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		nl.worth.deltares.oss.subversion.service.util.ServiceProps.get(
			"lock.expiration.time.nl.worth.deltares.oss.subversion.model.RepositoryLog"));

	public RepositoryLogModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _logId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setLogId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _logId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return RepositoryLog.class;
	}

	@Override
	public String getModelClassName() {
		return RepositoryLog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<RepositoryLog, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<RepositoryLog, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RepositoryLog, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((RepositoryLog)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<RepositoryLog, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<RepositoryLog, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(RepositoryLog)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<RepositoryLog, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<RepositoryLog, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, RepositoryLog>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			RepositoryLog.class.getClassLoader(), RepositoryLog.class,
			ModelWrapper.class);

		try {
			Constructor<RepositoryLog> constructor =
				(Constructor<RepositoryLog>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<RepositoryLog, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<RepositoryLog, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<RepositoryLog, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<RepositoryLog, Object>>();
		Map<String, BiConsumer<RepositoryLog, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<RepositoryLog, ?>>();

		attributeGetterFunctions.put(
			"logId",
			new Function<RepositoryLog, Object>() {

				@Override
				public Object apply(RepositoryLog repositoryLog) {
					return repositoryLog.getLogId();
				}

			});
		attributeSetterBiConsumers.put(
			"logId",
			new BiConsumer<RepositoryLog, Object>() {

				@Override
				public void accept(RepositoryLog repositoryLog, Object logId) {
					repositoryLog.setLogId((Long)logId);
				}

			});
		attributeGetterFunctions.put(
			"ipAddress",
			new Function<RepositoryLog, Object>() {

				@Override
				public Object apply(RepositoryLog repositoryLog) {
					return repositoryLog.getIpAddress();
				}

			});
		attributeSetterBiConsumers.put(
			"ipAddress",
			new BiConsumer<RepositoryLog, Object>() {

				@Override
				public void accept(
					RepositoryLog repositoryLog, Object ipAddress) {

					repositoryLog.setIpAddress((String)ipAddress);
				}

			});
		attributeGetterFunctions.put(
			"screenName",
			new Function<RepositoryLog, Object>() {

				@Override
				public Object apply(RepositoryLog repositoryLog) {
					return repositoryLog.getScreenName();
				}

			});
		attributeSetterBiConsumers.put(
			"screenName",
			new BiConsumer<RepositoryLog, Object>() {

				@Override
				public void accept(
					RepositoryLog repositoryLog, Object screenName) {

					repositoryLog.setScreenName((String)screenName);
				}

			});
		attributeGetterFunctions.put(
			"action",
			new Function<RepositoryLog, Object>() {

				@Override
				public Object apply(RepositoryLog repositoryLog) {
					return repositoryLog.getAction();
				}

			});
		attributeSetterBiConsumers.put(
			"action",
			new BiConsumer<RepositoryLog, Object>() {

				@Override
				public void accept(RepositoryLog repositoryLog, Object action) {
					repositoryLog.setAction((String)action);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<RepositoryLog, Object>() {

				@Override
				public Object apply(RepositoryLog repositoryLog) {
					return repositoryLog.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<RepositoryLog, Object>() {

				@Override
				public void accept(
					RepositoryLog repositoryLog, Object createDate) {

					repositoryLog.setCreateDate((Long)createDate);
				}

			});
		attributeGetterFunctions.put(
			"repository",
			new Function<RepositoryLog, Object>() {

				@Override
				public Object apply(RepositoryLog repositoryLog) {
					return repositoryLog.getRepository();
				}

			});
		attributeSetterBiConsumers.put(
			"repository",
			new BiConsumer<RepositoryLog, Object>() {

				@Override
				public void accept(
					RepositoryLog repositoryLog, Object repository) {

					repositoryLog.setRepository((String)repository);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getLogId() {
		return _logId;
	}

	@Override
	public void setLogId(long logId) {
		_logId = logId;
	}

	@JSON
	@Override
	public String getIpAddress() {
		if (_ipAddress == null) {
			return "";
		}
		else {
			return _ipAddress;
		}
	}

	@Override
	public void setIpAddress(String ipAddress) {
		_ipAddress = ipAddress;
	}

	@JSON
	@Override
	public String getScreenName() {
		if (_screenName == null) {
			return "";
		}
		else {
			return _screenName;
		}
	}

	@Override
	public void setScreenName(String screenName) {
		_screenName = screenName;
	}

	@JSON
	@Override
	public String getAction() {
		if (_action == null) {
			return "";
		}
		else {
			return _action;
		}
	}

	@Override
	public void setAction(String action) {
		_action = action;
	}

	@JSON
	@Override
	public long getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(long createDate) {
		_createDate = createDate;
	}

	@JSON
	@Override
	public String getRepository() {
		if (_repository == null) {
			return "";
		}
		else {
			return _repository;
		}
	}

	@Override
	public void setRepository(String repository) {
		_repository = repository;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, RepositoryLog.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public RepositoryLog toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = _escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		RepositoryLogImpl repositoryLogImpl = new RepositoryLogImpl();

		repositoryLogImpl.setLogId(getLogId());
		repositoryLogImpl.setIpAddress(getIpAddress());
		repositoryLogImpl.setScreenName(getScreenName());
		repositoryLogImpl.setAction(getAction());
		repositoryLogImpl.setCreateDate(getCreateDate());
		repositoryLogImpl.setRepository(getRepository());

		repositoryLogImpl.resetOriginalValues();

		return repositoryLogImpl;
	}

	@Override
	public int compareTo(RepositoryLog repositoryLog) {
		int value = 0;

		if (getCreateDate() < repositoryLog.getCreateDate()) {
			value = -1;
		}
		else if (getCreateDate() > repositoryLog.getCreateDate()) {
			value = 1;
		}
		else {
			value = 0;
		}

		value = value * -1;

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RepositoryLog)) {
			return false;
		}

		RepositoryLog repositoryLog = (RepositoryLog)obj;

		long primaryKey = repositoryLog.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
	}

	@Override
	public CacheModel<RepositoryLog> toCacheModel() {
		RepositoryLogCacheModel repositoryLogCacheModel =
			new RepositoryLogCacheModel();

		repositoryLogCacheModel.logId = getLogId();

		repositoryLogCacheModel.ipAddress = getIpAddress();

		String ipAddress = repositoryLogCacheModel.ipAddress;

		if ((ipAddress != null) && (ipAddress.length() == 0)) {
			repositoryLogCacheModel.ipAddress = null;
		}

		repositoryLogCacheModel.screenName = getScreenName();

		String screenName = repositoryLogCacheModel.screenName;

		if ((screenName != null) && (screenName.length() == 0)) {
			repositoryLogCacheModel.screenName = null;
		}

		repositoryLogCacheModel.action = getAction();

		String action = repositoryLogCacheModel.action;

		if ((action != null) && (action.length() == 0)) {
			repositoryLogCacheModel.action = null;
		}

		repositoryLogCacheModel.createDate = getCreateDate();

		repositoryLogCacheModel.repository = getRepository();

		String repository = repositoryLogCacheModel.repository;

		if ((repository != null) && (repository.length() == 0)) {
			repositoryLogCacheModel.repository = null;
		}

		return repositoryLogCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<RepositoryLog, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<RepositoryLog, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RepositoryLog, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((RepositoryLog)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<RepositoryLog, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<RepositoryLog, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<RepositoryLog, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((RepositoryLog)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static final Function<InvocationHandler, RepositoryLog>
		_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	private long _logId;
	private String _ipAddress;
	private String _screenName;
	private String _action;
	private long _createDate;
	private String _repository;
	private RepositoryLog _escapedModel;

}