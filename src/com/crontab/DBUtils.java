package com.crontab;

import java.math.BigDecimal;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.Calendar;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

public final class DBUtils {
	private static final Logger LOG = Logger.getLogger(DBUtils.class);
    /**
     * Default constructor.
     */
    private DBUtils() {
    }

    /**
     * Close a Connection, avoid closing if null.
     *
     * @param conn Connection to close.
     * @throws SQLException if a database access error occurs
     */
    public static void close(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }

    /**
     * Close a ResultSet, avoid closing if null.
     *
     * @param rs ResultSet to close.
     * @throws SQLException if a database access error occurs
     */
    public static void close(ResultSet rs) throws SQLException {
        if (rs != null) {
            rs.close();
        }
    }

    /**
     * Close a Statement, avoid closing if null.
     *
     * @param stmt Statement to close.
     * @throws SQLException if a database access error occurs
     */
    public static void close(Statement stmt) throws SQLException {
        if (stmt != null) {
            stmt.close();
        }
    }

    /**
     * Close a Connection, avoid closing if null and hide
     * any SQLExceptions that occur.
     *
     * @param conn Connection to close.
     */
    public static void closeQuietly(Connection conn) {
        try {
            close(conn);
        } catch (SQLException e) {
        	LOG.info("Close the connection with exception: ", e);
        	LOG.warn("Close the connection with exception:" + e.getMessage());
        }
    }


    /**
     * Close a ResultSet, avoid closing if null and hide any
     * SQLExceptions that occur.
     *
     * @param rs ResultSet to close.
     */
    public static void closeQuietly(ResultSet rs) {
        try {
            close(rs);
        } catch (SQLException e) { 
        	LOG.info("Close the connection with exception: ", e);
        	LOG.warn("Close the connection with exception:" + e.getMessage());
        }
    }

    /**
     * Close a Statement, avoid closing if null and hide
     * any SQLExceptions that occur.
     *
     * @param stmt Statement to close.
     */
    public static void closeQuietly(Statement stmt) {
        try {
            close(stmt);
        } catch (SQLException e) { 
        	LOG.info("Close the connection with exception: ", e);
        	LOG.warn("Close the connection with exception:" + e.getMessage());
        }
    }

    public static Connection getConnection(DataSource dataSource) throws SQLException {
    	assert dataSource != null;
        return dataSource.getConnection();
    }
    
    public static void setParameterValue(PreparedStatement ps, int paramIndex, int sqlType, Object inValue)
    		throws SQLException {
		if (inValue == null) {
			setNull(ps, paramIndex, sqlType);
		} else {
			setValue(ps, paramIndex, sqlType, inValue);
		}    	
    }

	private static void setValue(PreparedStatement ps, int paramIndex,
			int sqlType, Object inValue) throws SQLException {
		
		if (sqlType == Types.CLOB) {
			ps.setClob(paramIndex, (Clob) inValue);
		} else if (sqlType == Types.VARCHAR || sqlType == Types.LONGVARCHAR) {
			ps.setString(paramIndex, inValue.toString());
		} else if (sqlType == Types.DECIMAL || sqlType == Types.NUMERIC) {
			if (inValue instanceof BigDecimal) {
				ps.setBigDecimal(paramIndex, (BigDecimal) inValue);
			} else {
				ps.setObject(paramIndex, inValue, sqlType);
			}
		} else if (sqlType == Types.DATE) {
			if (inValue instanceof java.util.Date) {
				if (inValue instanceof java.sql.Date) {
					ps.setDate(paramIndex, (java.sql.Date) inValue);
				} else {
					ps.setDate(paramIndex, new java.sql.Date(((java.util.Date) inValue).getTime()));
				}
			} else if (inValue instanceof Calendar) {
				Calendar cal = (Calendar) inValue;
				ps.setDate(paramIndex, new java.sql.Date(cal.getTime().getTime()), cal);
			} else {
				ps.setObject(paramIndex, inValue, Types.DATE);
			}
		} else if (sqlType == Types.TIME) {
			if (inValue instanceof java.util.Date) {
				if (inValue instanceof java.sql.Time) {
					ps.setTime(paramIndex, (java.sql.Time) inValue);
				} else {
					ps.setTime(paramIndex, new java.sql.Time(((java.util.Date) inValue).getTime()));
				}
			} else if (inValue instanceof Calendar) {
				Calendar cal = (Calendar) inValue;
				ps.setTime(paramIndex, new java.sql.Time(cal.getTime().getTime()), cal);
			} else {
				ps.setObject(paramIndex, inValue, Types.TIME);
			}
		} else if (sqlType == Types.TIMESTAMP) {
			if (inValue instanceof java.util.Date) {
				if (inValue instanceof java.sql.Timestamp) {
					ps.setTimestamp(paramIndex, (java.sql.Timestamp) inValue);
				} else {
					ps.setTimestamp(paramIndex, new java.sql.Timestamp(((java.util.Date) inValue).getTime()));
				}
			} else if (inValue instanceof Calendar) {
				Calendar cal = (Calendar) inValue;
				ps.setTimestamp(paramIndex, new java.sql.Timestamp(cal.getTime().getTime()), cal);
			} else {
				ps.setObject(paramIndex, inValue, Types.TIMESTAMP);
			}
		} else {
			// Fall back to generic setObject call with SQL type specified.
			ps.setObject(paramIndex, inValue, sqlType);
		}
		
	}

	private static void setNull(PreparedStatement ps, int paramIndex,
			int sqlType) throws SQLException {
		ps.setNull(paramIndex, sqlType);
	}
}
