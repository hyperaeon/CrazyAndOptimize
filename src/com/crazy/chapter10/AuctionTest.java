package com.crazy.chapter10;

public class AuctionTest {

	private double initPrice = 30.0;

	public void bid(String bidPrice) throws AuctionException {
		double d = 0.0;
		try {
			d = Double.parseDouble(bidPrice);
		} catch (NumberFormatException e) {
			e.printStackTrace();
			throw new AuctionException("竞拍必须是数值");
		}
		if (initPrice > d) {
			throw new AuctionException("竞拍价比起拍价低，这样不行的呢");
		}
		initPrice = d;
	}

	public static void main(String[] args) {
		AuctionTest at = new AuctionTest();
		try {
			at.bid("bd");
		} catch (AuctionException e) {
			System.err.println(e.getMessage());
		}
	}
}
