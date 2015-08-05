package com.crontab;

/**
 * DAO class of table NBADBA.NBA_RESOURCE_CONFIG
 */
public interface NbaResourceConfigDao {

	/**
	 * insert one resource config into DB
	 * 
	 * @param config
	 *            resource config
	 */
	void insertResourceConfig(NbaResourceConfig config);

	/**
	 * update one resource config with given combination key, consist of (host,
	 * module , key) and value
	 * 
	 * @param config
	 *            resource config
	 */
	void updateResourceConfig(NbaResourceConfig config);

	/**
	 * delete one resource config with given combination key, consist of (host,
	 * module , key)
	 * 
	 * @param host
	 *            host name of config
	 * @param module
	 *            module name of config
	 * @param key
	 *            key of config
	 */
	void deleteResourceConfigByKey(String host, String module, String key);

	/**
	 * query one resource config with given combination key, consist of (host,
	 * module , key)
	 * 
	 * @param host
	 *            host name of config
	 * @param module
	 *            module name of config
	 * @param key
	 *            key of config
	 * @return recourse config identified by given key (combination of host,
	 *         module, key)
	 */
	NbaResourceConfig queryResourceConfigByKey(String host, String module,
			String key);
}
