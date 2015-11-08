package com.effective.chapter10;

public class LazyInitialize {

	
	private FieldType field;
	
	synchronized FieldType getField() {
		if (field == null) {
			field = computFieldValue();
		}
		return field;
	}

	private FieldType computFieldValue() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private static class FieldHolder {
		static final FieldType field = computStaticFieldValues();

		
	}
	
	
	private static FieldType computStaticFieldValues() {
			// TODO Auto-generated method stub
			return null;
		}
	static FieldType getFields() {
		return FieldHolder.field;
	}
	
	private volatile FieldType type;
	
	FieldType getFieldTypes() {
		FieldType result = type;
		if (result == null) {
			synchronized(this) {
				result = type;
				if (result == null) {
					type = result = computFieldValue();
				}
			}
		}
		return result;
		
	}
}
