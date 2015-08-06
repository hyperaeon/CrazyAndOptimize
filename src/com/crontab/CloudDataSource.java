package com.crontab;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.ssc.faw.util.GenConnectionPool;

/**
 * This Datasource get connection from GenConnection pool.
 * 
 * @author e523436
 * @since 29.09.2013
 */
public class CloudDataSource implements DataSource {

	/**
	 * Log variable print logger.
	 */
	private static final Logger LOG = Logger.getLogger(CloudDataSource.class);
	/**
	 * gen datasource name.
	 */
	private final String dataSourceName;
	/**
	 * gfx datasouce name on setting.xml
	 */
	public final static String NBA_DATASOURCE = "NBADataSource";
	/**
	 * legacy oms datasouce name on setting.xml
	 */
	public final static String LEGACY_OMS_DATASOURCE = "LegacyOMSDataSource";

	public CloudDataSource(String dsName) {
		this.dataSourceName = dsName;
	}
	/**
	 * get connection from GenConnection Pool.
	 * 
	 * @return Connection
	 * @throws SQLException
	 *             in case of failure
	 */
	@Override
	public Connection getConnection() throws SQLException {
		return getConnection(dataSourceName);
	}

	/**
	 * get connection by GenConnectionPool.
	 * 
	 * @param dsName
	 *            database name on settings.xml configure
	 * @return Connection
	 * @throws SQLException
	 *             SQLException
	 */
	private Connection getConnection(final String dsName) throws SQLException {
		try {
			return GenConnectionPool.getConnection(dsName);
		} catch (Exception e) {
			LOG.error("GET DataSource:" + dsName + " failed", e);
			LOG.fatal("CX408 Can't retrieve the DB connection. dsName is"
					+ dsName);
			throw new SQLException("GET DataSource:" + dsName + " failed",
					e.getCause());
		}
	}

	/**
	 * this method will not implement since the password will be passed from
	 * PwMatrix.
	 * 
	 * @param username
	 *            for database
	 * @param password
	 *            for the database
	 * @return Connection
	 */
	@Override
	public Connection getConnection(final String username, final String password) {
		throw new UnsupportedOperationException();
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {

		throw new UnsupportedOperationException();
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		throw new UnsupportedOperationException();

	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		throw new UnsupportedOperationException();

	}

	@Override
	public int getLoginTimeout() throws SQLException {
		throw new UnsupportedOperationException();
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		throw new UnsupportedOperationException();
	}
	@Override
	public java.util.logging.Logger getParentLogger()
			throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}
	
}