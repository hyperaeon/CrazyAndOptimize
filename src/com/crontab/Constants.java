package com.crontab;

/**
 * 
 * 
 * @version $Revision$
 * @author Your Name
 */
public abstract class Constants {

    public static final String DB_ERR_MSG_DATA_ACCESS = "Execute database operations failed.";
    public static final String SERVICE_ERR_MSG_NO_CRITERIA = "Please specify search criteria.";
    public static final String UNDER_LINE = "_";
    public static final String COMMA = ",";
    public static final String SEMICOLON = ";";
    		

    private Constants() {
        //Add private constructor to hide the implicit one.
    }
    
	public static final int ERROR_PARSING = 10001;
	public static final int ERROR_DUPLICATION = 10002;
	public static final int ERROR_SERVER = 10003;
	public static final int ERROR_TIER_INCOMPLETE = 10004;
	public static final int ERROR_QUERY_NO_RESULT = 10005;
	public static final int ERROR_NO_SIGNON_INFO = 10006;
	public static final int ERROR_MISSING_GROUP_ELEMENT = 10007;
	public static final int ERROR_VALUE_INVALID = 10008;
	public static final int ERROR_NO_ZERO_TIER = 10009;
	public static final int ERROR_NO_FUND = 10010;
	public static final int ERROR_NO_NORMAL_SIZE = 10011;
	public static final int ERROR_NO_CUST_ID = 10012;
	
	public static final String RESP_LEVEL_ERROR = "ERROR";
	public static final String RESP_LEVEL_INFO = "INFO";
	

	
	
	
	
	
}
