package com.effective.chapter7;

import java.util.ArrayList;
import java.util.List;

public class Cheese {

	private final List<Cheese> cheesesInStock = new ArrayList<Cheese>();

	private static final Cheese[] EMPTY_CHEESE_ARRAY = new Cheese[0];

	/**
	 * A college degree, such as B.S., M.S., or Ph.D.
	 * <pre>{@code abc<1}</pre>
	 * {@code code<10 this.getCheeses()}
	 * <1
	 * The triangle inequality is |x+y| < |x| + |y|
	 * {@literal The triangle inequality is |x+y| < |x| + |y|}
	 * @return
	 */
	public Cheese[] getCheeses() {
		return cheesesInStock.toArray(EMPTY_CHEESE_ARRAY);
	}
}
