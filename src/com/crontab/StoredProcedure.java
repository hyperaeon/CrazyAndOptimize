package com.crontab;

import java.util.List;

public final class StoredProcedure extends AbstractCallableStatement{
	@Override
	protected final void compileInternal() {
		List<SqlParameter> parameters = getDeclaredParameters();
		int parameterCount = 0;
		callString = "{call " + getSql() + "(";
		for (int i = 0; i < parameters.size(); i++) {
			if (parameterCount > 0) {
				callString += ", ";
			}
			if (parameterCount >= 0) {
				callString += "?";
			}
			parameterCount++;
		}
		callString += ")}";
	}
}
