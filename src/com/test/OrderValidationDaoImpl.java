//package com.ssc.ssgm.fx.nba.dao.impl;
//
//import java.math.BigDecimal;
//import java.sql.SQLException;
//import java.sql.Types;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.TreeMap;
//
//import javax.sql.DataSource;
//
//import oracle.jdbc.OracleTypes;
//
//import org.apache.commons.lang.StringUtils;
//import org.apache.log4j.Logger;
//import com.ssc.ssgm.fx.utils.CollectionUtils;
//
//import com.google.gson.Gson;
//import com.ssc.ssgm.fx.nba.dao.OrderValidationDao;
//import com.ssc.ssgm.fx.nba.exception.OrderValidationException;
//import com.ssc.ssgm.fx.nba.model.CurrencyPairGroup;
//import com.ssc.ssgm.fx.nba.model.OrderSizeTier;
//import com.ssc.ssgm.fx.nba.model.json.JsonOrderSizeTier;
//import com.ssc.ssgm.fx.nba.utils.AbstractCallableStatement;
//import com.ssc.ssgm.fx.nba.utils.JdbcCaller;
//import com.ssc.ssgm.fx.nba.utils.SqlInParameter;
//import com.ssc.ssgm.fx.nba.utils.SqlOutParameter;
//import com.ssc.ssgm.fx.nba.utils.StoredProcedure;
//import com.ssc.ssgm.fx.utils.Constants;
//
///**
// * The reference data service DAO implementation.
// * 
// * @author e482588
// */
//public class OrderValidationDaoImpl implements OrderValidationDao {
//    /**
//     * log4j logger object.
//     */
//    private static final Logger LOGGER = Logger
//	    .getLogger(OrderValidationDaoImpl.class);
//    /**
//     * default database package name.
//     */
//    private static final String PACKAGE_NAME = "PKG_NBA_DATA";
//    /**
//     * default database schema name.
//     */
//    private static final String SCHEMA_NAME = "NBADBA";
//    /**
//     * * Cursor String.
//     */
//    private static final String DB_CURSOR = "oDBC_RESULT";
//    /**
//     * WSS database JdbcCaller jdbcTemplate.
//     */
//    private transient JdbcCaller caller;
//
//    /**
//     * @param dataSource
//     *            is injected by invoker.
//     */
//    @Override
//    public void setWSSDataSource(final DataSource dataSource) {
//	this.caller = new JdbcCaller(dataSource);
//    }
//
//	@Override
//	public void addTiers(JsonOrderSizeTier t, String user) throws OrderValidationException{
//		LOGGER.info("Start in addTiers DAO");
//		if (!legalParam(t)) {
//			throw new OrderValidationException(null,null,null,null);
//		}
//		//Step 1: make sure the tiers are completed (i.e. 0->max with no gaps.)
//		//If tiers are NOT complete, return OrderValidationException with ERROR_TIER_INCOMPLETE, RESP_LEVEL_INFO, MSG_TIER_INCOMPLETE_ERRROR
//		if (!tierComplete(t)) {
//			throw new OrderValidationException(Constants.ERROR_TIER_INCOMPLETE, Constants.RESP_LEVEL_INFO, Constants.MSG_TIER_INCOMPLETE_ERRROR, null);
//		}
//		
//		//TODO: Step 2: If the tiers already exists, return OrderValidationException with Constants.ERROR_DUPLICATION,Constants.RESP_LEVEL_INFO, MSG_DUPLICATION_ERRROR
//		String groupLevelCcy = orgnizeGroupLevelCcy(t);
//		if (existTiers(groupLevelCcy)) {
//			throw new OrderValidationException(Constants.ERROR_DUPLICATION, Constants.RESP_LEVEL_INFO, Constants.MSG_DUPLICATION_ERRROR, null);
//		}
//		
//		//Step 3: make sure the ccyPairGroup exists, otherwise add it firstly.
//		checkOrAddCcyPairGroup(t.getCurrencyPairGroup().getPricingServiceId(),
//				t.getCurrencyPairGroup().getCcy1(), t.getCurrencyPairGroup().getCcy2(), user);
//		//Step 4: add the tiers and return the new group id. make sure the user name is also updated.
//		String currencyPairGroupParam = organizeCurrencyPairGroupParam(t);
//		String ccyTierParam1 = organizeCcy1TierParam(t);
//		String ccyTierParam2 = organizeCcy2TierParam(t);
//		String groupID = addOrderSizeTiers(currencyPairGroupParam, ccyTierParam1, ccyTierParam2);
//		t.getCurrencyPairGroup().setGroupId(groupID);		
//		
//		//TODO: If any other issue in DB/server, return OrderValidationException with Constants.ERROR_SERVER, Constants.RESP_LEVEL_ERROR,MSG_SERVER_ERRROR		
//			
//		
//		LOGGER.info("End in addTiers DAO");
//		
//		
//	}
//	
//	/**
//	 * check if tiers exist.
//	 * @param groupLevelCcy
//	 * @return
//	 */
//	private boolean existTiers(String groupLevelCcy) throws OrderValidationException {
//		final AbstractCallableStatement sp = new StoredProcedure().withCatalogName(PACKAGE_NAME)
//				.withProcedureName("checkOrderSizeTier").withSchemaName(SCHEMA_NAME);
//		try {
//			sp.addDeclareParameter(new SqlInParameter("iGROUP_LEVEL_CCY", OracleTypes.VARCHAR, groupLevelCcy));
//			sp.addDeclareParameter(new SqlOutParameter("oCOUNT", Types.INTEGER));
//			final Map<String, Object> resultMap = caller.execute(sp);
//			Integer count = (Integer) resultMap.get("oCOUNT");
//			if (count <= 0) {
//				return false;
//			}
//		} catch (SQLException e) {
//			LOGGER.error(e.getMessage());
//			throw new OrderValidationException(Constants.ERROR_SERVER, Constants.RESP_LEVEL_ERROR, Constants.MSG_SERVER_ERRROR, e);
//		}
//		return true;
//	}
//
//	/**
//	 * concate group_Id,tier_level and currency by COMMA, different tiers parsed by SEMICOLON.
//	 * @param t
//	 * @return
//	 */
//	private String orgnizeGroupLevelCcy(JsonOrderSizeTier t) {
//		List<OrderSizeTier> tiers1 = t.getCcy1tiers();
//		List<OrderSizeTier> tiers2 = t.getCcy2tiers();
//		StringBuilder builder = organizeGroupLevelCcy(tiers1);
//		builder.append(organizeGroupLevelCcy(tiers2));
//		return builder.toString();
//	}
//	
//	/**
//	 * 
//	 * @param tiers
//	 * @return
//	 */
//	private StringBuilder organizeGroupLevelCcy(List<OrderSizeTier> tiers) {
//		StringBuilder builder = new StringBuilder();
//		if (CollectionUtils.isNotEmpty(tiers)) {
//			for (OrderSizeTier tier : tiers) {
//				builder.append(tier.getGroupId())
//				.append(Constants.COMMA)
//				.append(tier.getTierLevel())
//				.append(Constants.COMMA)
//				.append(tier.getCurrency())
//				.append(Constants.SEMICOLON);
//			}
//		}
//		return builder;
//	}
//
//	@Override
//	public List<JsonOrderSizeTier> queryTiers(JsonOrderSizeTier t) throws OrderValidationException{
//		//TODO query tiers in DB with any of ccy1, ccy2 and pricingServiceID 
//		//Step 1: set the param with input JsonOrderSizeTier. when any of ccy1, ccy2 and pricingServiceID is null, it means there is no filter creteria
//		//If there is no result with query, return OrderValidationException with Constants.ERROR_QUERY_NO_RESULT,Constants.RESP_LEVEL_INFO, MSG_QUERY_NO_RESULT_ERRROR
//		//Step 2: Query out and set back with list of object JsonOrderSizeTier	
//		//If any other issue in DB/server, return OrderValidationException with Constants.ERROR_SERVER, Constants.RESP_LEVEL_ERROR,MSG_SERVER_ERRROR
//		
//		LOGGER.info("in queryTiers DAO");
//		
//		
//		//mock some data for testing
//		List<JsonOrderSizeTier> queryResult = new ArrayList();
//		queryResult.add(mockData(0));
//		queryResult.add(mockData(1));
//		queryResult.add(mockData(2));
//		queryResult.add(mockData(3));
//		
//		
//		return queryResult;
//		
//		
//				
//	}
//
//	private JsonOrderSizeTier mockData(int i) {
//		JsonOrderSizeTier mocktier = new JsonOrderSizeTier();
//
//		CurrencyPairGroup currencyPairGroup = new CurrencyPairGroup();
//		currencyPairGroup.setCcy1("EUR");
//		currencyPairGroup.setCcy2("USD");
//		currencyPairGroup.setGroupId("GGG_ID");
//		currencyPairGroup.setPricingServiceId("HPS");
//
//		mocktier.setCurrencyPairGroup(currencyPairGroup);
//		
//
//		List<OrderSizeTier> tiers = new ArrayList();
//
//		OrderSizeTier ost0 = new OrderSizeTier();
//		ost0.setFactor(1+i/10);
//		ost0.setMaxSize(new BigDecimal(i*1000000));
//		ost0.setMinSize(new BigDecimal((i+1)*1000000));
//		ost0.setTierLevel(i);
//
//		OrderSizeTier ost = new OrderSizeTier();
//		ost.setFactor(1+i/10);
//		ost.setMaxSize(new BigDecimal(i*1000000));
//		ost.setMinSize(new BigDecimal((i+1)*1000000));
//		ost.setTierLevel(i);
//
//		tiers.add(ost0);
//		tiers.add(ost);
//
//		mocktier.setCcy1tiers(tiers);
//		mocktier.setCcy2tiers(tiers);
//
//		return mocktier;
//		
//		}
//
//
//	/**
//	 * add tiers to ORDER_SIZE_TIER.
//	 * @param currencyPairGroupParam
//	 * @param ccyTierParam1
//	 * @param ccyTierParam2
//	 */
//	private String addOrderSizeTiers(String currencyPairGroupParam,
//			String ccyTierParam1, String ccyTierParam2) {
//		// TODO Auto-generated method stub
//		return "DUMMYGRPID";
//		
//	}
//
//	/**
//	 * concate tiers by ','.
//	 * different tiers in the same currency are seprated by ';'.
//	 * @param t
//	 * @return
//	 */
//	private String organizeCcy1TierParam(JsonOrderSizeTier t) {
//		List<OrderSizeTier> ccy1Tiers = t.getCcy1tiers();
//		if (CollectionUtils.isEmpty(ccy1Tiers)) {
//			return StringUtils.EMPTY;
//		}
//		return organizeCcyTierParam(ccy1Tiers);
//	}
//
//	/**
//	 * concate tiers by ','.
//	 * different tiers in the same currency are seprated by ';'.
//	 * @param t
//	 * @return
//	 */
//	private String organizeCcy2TierParam(JsonOrderSizeTier t) {
//		List<OrderSizeTier> ccy2Tiers = t.getCcy2tiers();
//		if (CollectionUtils.isEmpty(ccy2Tiers)) {
//			return StringUtils.EMPTY;
//		}
//		return organizeCcyTierParam(ccy2Tiers);
//	}
//	
//	/**
//	 * 
//	 * @param ccyTiers
//	 * @return
//	 */
//	private String organizeCcyTierParam(List<OrderSizeTier> ccyTiers) {
//		StringBuilder stringBuilder = new StringBuilder();
//		for (OrderSizeTier tier : ccyTiers) {
//			stringBuilder.append(tier.getFactor())
//				.append(Constants.COMMA)
//				.append(tier.getMaxSize())
//				.append(Constants.COMMA)
//				.append(tier.getMinSize())
//				.append(Constants.COMMA)
//				.append(tier.getTierLevel())
//				.append(Constants.SEMICOLON);
//		}
//		return stringBuilder.toString();
//	}
//	
//	/**
//	 * concate pricing service id, ccy1 and ccy2 by ",". 
//	 * @param t
//	 * @return
//	 */
//	private String organizeCurrencyPairGroupParam(JsonOrderSizeTier t) {
//		StringBuilder stringBuilder = new StringBuilder();
//		stringBuilder.append(t.getCurrencyPairGroup().getCcy1())
//			.append(Constants.COMMA)
//			.append(t.getCurrencyPairGroup().getCcy2())
//			.append(Constants.COMMA)
//			.append(t.getCurrencyPairGroup().getPricingServiceId());
//		return stringBuilder.toString();
//	}
//
//
//	/**
//	 * check if tier cover all the range.
//	 * @param t
//	 * @return
//	 */
//	private boolean tierComplete(JsonOrderSizeTier t) {
//		List<OrderSizeTier> ccy1Tiers = t.getCcy1tiers();
//		List<OrderSizeTier> ccy2Tiers = t.getCcy2tiers();
//		if (CollectionUtils.isEmpty(ccy1Tiers) 
//				|| CollectionUtils.isEmpty(ccy2Tiers)) {
//			return false;
//		}
//		Map<String, List<String>> groupIdCurrencyTier = new HashMap<String, List<String>>();
//		for (OrderSizeTier ccy1Tier: ccy1Tiers) {
//			travese(ccy1Tier, groupIdCurrencyTier);
//		}
//		for (OrderSizeTier ccy2Tier : ccy2Tiers) {
//			travese(ccy2Tier, groupIdCurrencyTier);
//		}
//		Map<String, TreeMap<Integer, OrderSizeTier>> groupIdCurrencyTierMap = convertValueFromListToMap(groupIdCurrencyTier);
//		if (groupIdCurrencyTierMap == null) {
//			return false;
//		}
//		for (Map.Entry<String, TreeMap<Integer, OrderSizeTier>> entry : groupIdCurrencyTierMap.entrySet()) {
//			if (!isCoverAllRange(entry.getValue())) {
//				return false;
//			}
//		}
//		return true;
//	}
//
//	/**
//	 * convert the value of the groupIdCurrencyTier from List to Map.
//	 * @param groupIdCurrencyTier
//	 * @return
//	 */
//	private Map<String, TreeMap<Integer, OrderSizeTier>> convertValueFromListToMap(
//			Map<String, List<String>> groupIdCurrencyTier) {
//		Map<String, TreeMap<Integer, OrderSizeTier>> groupIdCurrencyTierMap = new HashMap<String, TreeMap<Integer,OrderSizeTier>>();
//		for (Map.Entry<String, List<String>> entry : groupIdCurrencyTier.entrySet()) {
//			String[] strArray;
//			TreeMap<Integer, OrderSizeTier> levelMinMaxMap = new TreeMap<Integer, OrderSizeTier>();
//			for (String levelMinMax : entry.getValue()) {
//				strArray = levelMinMax.split(Constants.UNDER_LINE);
//				OrderSizeTier  tier = new OrderSizeTier();
//				Integer tierLevel = Integer.parseInt(strArray[0]);
//				tier.setMinSize(new BigDecimal(strArray[1]));
//				tier.setMaxSize(new BigDecimal(strArray[2]));
//				if (levelMinMaxMap.get(tierLevel) != null) {
//					return null;
//				}
//				levelMinMaxMap.put(tierLevel, tier);
//			}
//			groupIdCurrencyTierMap.put(entry.getKey(), levelMinMaxMap);
//		}
//		return groupIdCurrencyTierMap;
//	}
//
//	/**
//	 * check if tier lever covers all range.
//	 * @param value
//	 * @return
//	 */
//	private boolean isCoverAllRange(TreeMap<Integer, OrderSizeTier> value) {
//		List<OrderSizeTier> orderSizeTierList = new ArrayList<OrderSizeTier>();
//		for (Map.Entry<Integer, OrderSizeTier> map : value.entrySet()) {
//			orderSizeTierList.add(map.getValue());
//		}
//		int size = orderSizeTierList.size();
//		for (int i = 0; i < size; i ++) {
//			Double currentMinSize = orderSizeTierList.get(i).getMinSize().doubleValue();
//			Double currentMaxSize = orderSizeTierList.get(i).getMaxSize().doubleValue();
//			if (i == 0) {
//				if (currentMinSize != Double.parseDouble("0") 
//						|| currentMaxSize !=  Double.parseDouble("0")) {
//					return false;
//				}
//			} else if (i == size - 1) {
//				if (currentMaxSize != Double.parseDouble("-1")) {
//					return false;
//				}
//			} else {
//				Double nextMinSize = orderSizeTierList.get(i + 1).getMinSize().doubleValue();
//				Double nextMaxSize = orderSizeTierList.get(i + 1).getMinSize().doubleValue();
//				if (currentMinSize >= currentMaxSize
//						|| nextMinSize >= nextMaxSize
//						|| currentMaxSize > nextMinSize) {
//					//invalid tier
//					return false;
//				}
//				if (currentMaxSize < nextMinSize) {
//					//tiers don't cover all the range
//					return false;
//				}
//			}
//		}
//		return false;
//	}
//
//	/**
//	 * 
//	 * @param ccyTier
//	 * @param groupIdCurrencyTier
//	 */
//	private void travese(OrderSizeTier ccyTier,
//			Map<String, List<String>> groupIdCurrencyTier) {
//		String key = concateKey(ccyTier);
//		String levelMinMax = concateValue(ccyTier);
//		if (groupIdCurrencyTier.get(key) != null) {
//			groupIdCurrencyTier.get(key).add(levelMinMax);
//		} else {
//			List<String> valueList = new ArrayList<String>();
//			valueList.add(levelMinMax);
//			groupIdCurrencyTier.put(key, valueList);
//		}
//	}
//
//	/**
//	 * concate groupId and currency by '_'.
//	 * @param tier
//	 * @return
//	 */
//	private String concateKey(OrderSizeTier tier) {
//		StringBuilder keyBuilder = new StringBuilder();
//		keyBuilder.append(tier.getGroupId())
//			.append(Constants.UNDER_LINE)
//			.append(tier.getCurrency());
//		return keyBuilder.toString();
//	}
//	
//	/**
//	 * concate tierLevel, minSize and maxSize by '_'.
//	 * @return
//	 */
//	private String concateValue(OrderSizeTier tier) {
//		StringBuilder levelMinMaxBuilder = new StringBuilder();
//		levelMinMaxBuilder.append(tier.getTierLevel())
//			.append(Constants.UNDER_LINE)
//			.append(tier.getMinSize())
//			.append(Constants.UNDER_LINE)
//			.append(tier.getMaxSize());
//		return levelMinMaxBuilder.toString();
//	}
//	
//	/**
//	 * create one record of CURRENCY_PAIR_GROUP 
//	 * @param groupId1
//	 */
//	private void addCcyPairGroup(String groupId1) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	
//	/**
//	 * check if group id exist in CURRENCY_PAIR_GROUP or ORDER_SIZE_TIER.
//	 * @param groupId1
//	 * @param groupId2
//	 * @param paramType
//	 * @return
//	 * @throws OrderValidationException
//	 */
//	private void checkOrAddCcyPairGroup(String pricingServiceId, String ccy1, String ccy2, String user) throws OrderValidationException {
//		final AbstractCallableStatement sp = new StoredProcedure().withCatalogName(PACKAGE_NAME)
//				.withProcedureName("checkOrAddCcyPairGroup").withSchemaName(SCHEMA_NAME);
//		try {
//			sp.addDeclareParameter(new SqlInParameter("iPRICING_SERVICE_ID", OracleTypes.VARCHAR, pricingServiceId.toUpperCase()));
//			sp.addDeclareParameter(new SqlInParameter("iCCY1", OracleTypes.VARCHAR, ccy1.toUpperCase()));
//			sp.addDeclareParameter(new SqlInParameter("iCCY2", OracleTypes.VARCHAR, ccy2.toUpperCase()));
//			sp.addDeclareParameter(new SqlInParameter("iUSER", OracleTypes.VARCHAR, user));
//		} catch (SQLException e) {
//			LOGGER.error(e.getMessage());
//			throw new OrderValidationException(Constants.ERROR_SERVER, Constants.RESP_LEVEL_ERROR, Constants.MSG_SERVER_ERRROR, e);
//		}
//	}
//	/**
//	 * 
//	 * @param t
//	 * @return
//	 */
//	private boolean legalParam(JsonOrderSizeTier t) {
//		if (t.getCurrencyPairGroup() == null 
//				|| StringUtils.isEmpty(t.getCurrencyPairGroup().getPricingServiceId()) 
//				|| StringUtils.isEmpty(t.getCurrencyPairGroup().getCcy1())
//				|| StringUtils.isEmpty(t.getCurrencyPairGroup().getCcy2())) {
//			return false;
//		}
//		return true;
//	}
//}
