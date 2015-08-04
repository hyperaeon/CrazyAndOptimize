package com.crontab;

import com.ssc.ssgm.fx.nba.dao.NbaResourceConfigDao;
import com.ssc.ssgm.fx.nba.exception.DatabaseAccessException;
import com.ssc.ssgm.fx.nba.model.NbaResourceConfig;
import com.ssc.ssgm.fx.nba.utils.*;
import oracle.jdbc.OracleTypes;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Map;

public class NbaResourceConfigDaoImpl implements NbaResourceConfigDao {
	
	/**
	 * LOGGER
	 */
	private static final Logger LOGGER = Logger.getLogger(NbaResourceConfigDaoImpl.class);
	
	/**
	 * Oracle Package Information
	 */
	private static final String PACKAGE_NAME 			= "PKG_NBA_RES_CFG";
	private static final String SCHEMA_NAME 			= "NBADBA";
	private static final String PROCEDURE_SELECT_CONFIG = "SELECT_NBA_RES_CFG";
	private static final String PROCEDURE_INSERT_CONFIG = "INSERT_NBA_RES_CFG";
	private static final String PROCEDURE_UPDATE_CONFIG = "UPDATE_NBA_RES_CFG";
	private static final String PROCEDURE_DELETE_CONFIG = "DELETE_NBA_RES_CFG";
	
	private static final String PARAM_HOST 			= "P_HOST";
	private static final String PARAM_MODULE 		= "P_MODULE";
	private static final String PARAM_KEY 			= "P_KEY";
	private static final String PARAM_VALUE 		= "P_VALUE";
	private static final String PARAM_UPDATE_DATE 	= "P_UPD_DATE";
	private static final String PARAM_UPDATE_USER 	= "P_UPD_USER";
	private static final String PARAM_CURSOR_RESULT	= "P_RESULT";
	
	/**
	 * JDBC utility
	 */
	private transient JdbcCaller caller;
	
	/**
	 * inject data source to init JDBC utility
	 * @param ds data source used to get connection
	 */
	public void setDataSource(DataSource ds) {
		this.caller = new JdbcCaller(ds);
	}

	public void insertResourceConfig(NbaResourceConfig config) {
		final AbstractCallableStatement sp = new StoredProcedure()
			.withCatalogName(PACKAGE_NAME)
			.withProcedureName(PROCEDURE_INSERT_CONFIG)
			.withSchemaName(SCHEMA_NAME);
		
		Date updateDate = config.getUpdateDate() == null ? new Date() : config.getUpdateDate();
		try {
			sp.addDeclareParameter(newSqlParam(PARAM_HOST, OracleTypes.VARCHAR, config.getHost()));
			sp.addDeclareParameter(newSqlParam(PARAM_MODULE, OracleTypes.VARCHAR, config.getModule()));
			sp.addDeclareParameter(newSqlParam(PARAM_KEY, OracleTypes.VARCHAR, config.getKey()));
			sp.addDeclareParameter(newSqlParam(PARAM_VALUE, OracleTypes.VARCHAR, config.getValue()));
			sp.addDeclareParameter(newSqlParam(PARAM_UPDATE_DATE, OracleTypes.TIMESTAMP, new java.sql.Timestamp(updateDate.getTime())));
			sp.addDeclareParameter(newSqlParam(PARAM_UPDATE_USER, OracleTypes.VARCHAR, config.getUpdateBy()));
			caller.execute(sp);
			
		} catch (SQLException e) {
			LOGGER.error("insert resource config failed", e);
			throw new DatabaseAccessException("database exception raised", e);
		}
	}
	
	public void updateResourceConfig(NbaResourceConfig config) {
		final AbstractCallableStatement sp = new StoredProcedure()
			.withCatalogName(PACKAGE_NAME)
			.withProcedureName(PROCEDURE_UPDATE_CONFIG)
			.withSchemaName(SCHEMA_NAME);
		
		Date updateDate = config.getUpdateDate() == null ? new Date() : config.getUpdateDate();
		try {
			sp.addDeclareParameter(newSqlParam(PARAM_HOST, OracleTypes.VARCHAR, config.getHost()));
			sp.addDeclareParameter(newSqlParam(PARAM_MODULE, OracleTypes.VARCHAR, config.getModule()));
			sp.addDeclareParameter(newSqlParam(PARAM_KEY, OracleTypes.VARCHAR, config.getKey()));
			sp.addDeclareParameter(newSqlParam(PARAM_VALUE, OracleTypes.VARCHAR, config.getValue()));
			sp.addDeclareParameter(newSqlParam(PARAM_UPDATE_DATE, OracleTypes.TIMESTAMP, new java.sql.Timestamp(updateDate.getTime())));
			sp.addDeclareParameter(newSqlParam(PARAM_UPDATE_USER, OracleTypes.VARCHAR, config.getUpdateBy()));
			caller.execute(sp);
			
		} catch (SQLException e) {
			LOGGER.error("update resource config failed", e);
			throw new DatabaseAccessException("database exception raised", e);
		}
	}
	
	public void deleteResourceConfigByKey(String host, String module, String key) {
		final AbstractCallableStatement sp = new StoredProcedure()
			.withCatalogName(PACKAGE_NAME)
			.withProcedureName(PROCEDURE_DELETE_CONFIG)
			.withSchemaName(SCHEMA_NAME);
		
		try {
			sp.addDeclareParameter(newSqlParam(PARAM_HOST, OracleTypes.VARCHAR, host));
			sp.addDeclareParameter(newSqlParam(PARAM_MODULE, OracleTypes.VARCHAR, module));
			sp.addDeclareParameter(newSqlParam(PARAM_KEY, OracleTypes.VARCHAR, key));
			caller.execute(sp);
			
		} catch (SQLException e) {
			LOGGER.error("delete resource config failed", e);
			throw new DatabaseAccessException("database exception raised", e);
		}
	}
	
	public NbaResourceConfig queryResourceConfigByKey(String host, String module, String key) {
		final AbstractCallableStatement sp = new StoredProcedure()
			.withCatalogName(PACKAGE_NAME)
			.withProcedureName(PROCEDURE_SELECT_CONFIG)
			.withSchemaName(SCHEMA_NAME);

		try {
			sp.addDeclareParameter(newSqlParam(PARAM_HOST, OracleTypes.VARCHAR, host));
			sp.addDeclareParameter(newSqlParam(PARAM_MODULE, OracleTypes.VARCHAR, module));
			sp.addDeclareParameter(newSqlParam(PARAM_KEY, OracleTypes.VARCHAR, key));
			sp.addDeclareParameter(new SqlOutParameter(PARAM_CURSOR_RESULT, OracleTypes.CURSOR, new ResultSetHandler<NbaResourceConfig>() {

				@Override
				public NbaResourceConfig handle(ResultSet rs) throws SQLException {
					
					if (rs.next()) {
						NbaResourceConfig cfg = new NbaResourceConfig();
						cfg.setHost(rs.getString("HOST"));
						cfg.setModule(rs.getString("MODULE"));
						cfg.setKey(rs.getString("KEY"));
						cfg.setValue(rs.getString("VALUE"));
						cfg.setUpdateDate(rs.getTimestamp("UPDATED_DATETIME"));
						cfg.setUpdateBy(rs.getString("UPDATED_BY"));
						
						return cfg;
					}
					
					return null;
				}
			}));
			
			final Map<String, Object> resultMap = caller.execute(sp);
			return (NbaResourceConfig) resultMap.get(PARAM_CURSOR_RESULT);
		} catch (SQLException e) {
			LOGGER.error("delete resource config failed", e);
			throw new DatabaseAccessException("database exception raised", e);
		}
	}
	
	private SqlInParameter newSqlParam(String name, int sqlType, Object value) {
		return new SqlInParameter(name, sqlType, value);
	}
	

}
