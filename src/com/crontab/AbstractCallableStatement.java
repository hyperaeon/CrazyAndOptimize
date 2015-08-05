package com.crontab;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public abstract class AbstractCallableStatement {
	private boolean compiled = false;
	
	private String procedureName;
	
	private String schemaName;
	
	private String catalogName;
	
	private List<SqlParameter> declaredParameters = new ArrayList<SqlParameter>();
	
	private boolean isCompiled() {
		return compiled;
	}

	protected String callString;

	public String getCallString() throws SQLException {
		if(!isCompiled()) {
			compile();
		}
		return callString;
	}
	/**
	 * Return a list of the declared objects.
	 */
	protected List<SqlParameter> getDeclaredParameters() {
		return this.declaredParameters;
	}

	public String getSql() {
		StringBuilder sb = new StringBuilder();
		if (StringUtils.isNotBlank(schemaName)) {
			sb.append(schemaName).append(".");
		}
		if (StringUtils.isNotBlank(catalogName)) {
			sb.append(catalogName).append(".");
		}
		if (StringUtils.isNotBlank(procedureName)) {
			sb.append(procedureName);
		}
		return sb.toString();
	}
	
	public AbstractCallableStatement withProcedureName(String procedureName) {
		this.procedureName = procedureName;
		return this;
	}

	public AbstractCallableStatement withSchemaName(String schemaName) {
		this.schemaName = schemaName;
		return this;
	}

	public AbstractCallableStatement withCatalogName(String catalogName) {
		this.catalogName =catalogName;
		return this;
	}

	/**
	 * Declare a parameter for this operation.
	 * @param param the SqlParameter to add. This will specify SQL type and (optionally)
	 * the parameter's name.
	 * @throws SQLException if the operation is already compiled,
	 * and hence cannot be configured further
	 */
	public void addDeclareParameter(SqlParameter param) throws SQLException {
		if (isCompiled()) {
			throw new SQLException("Cannot add parameters once the query is compiled");
		}
		this.declaredParameters.add(param);
	}

	protected abstract void compileInternal();
	
	/**
	 * Compile this query.
	 * Ignores subsequent attempts to compile.
	 * @throws SQLException if the object hasn't been correctly initialized
	 */
	protected final void compile() throws SQLException {
		if (!isCompiled()) {
			if (StringUtils.isBlank(getSql())) {
				throw new SQLException("Property 'procedureName' is required");
			}
			compileInternal();
			this.compiled = true;
		}
	}

}
