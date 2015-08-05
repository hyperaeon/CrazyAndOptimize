package com.crontab;

import java.util.Collection;

public class CollectionUtils {

	private CollectionUtils() {

	}

	/**
	 * Return <code>true</code> if the supplied Collection is <code>null</code>
	 * or empty. Otherwise, return <code>false</code>.
	 * 
	 * @param collection
	 *            the Collection to check
	 * @return whether the given Collection is empty
	 */
	public static boolean isEmpty(Collection collection) {
		return collection == null || collection.isEmpty();
	}

	/**
	 * Return <code>true</code> if the supplied Collection is not
	 * <code>null</code> and not empty. Otherwise, return <code>false</code>.
	 * 
	 * @param collection
	 *            the Collection to check
	 * @return whether the given Collection is empty
	 */
	public static boolean isNotEmpty(Collection collection) {
		return !isEmpty(collection);
	}
}
