package com.test;

public interface CommentConst {
	int ContentLimit = 1000;
	int ContentListLimit = 100;

	public interface CommentType {
		int CommentForMyResource = 0;// 我收到的直接对我的资源的评论
		int ReplyForMyComment = 1; // 我收到的对我的评论的一个回复
		int ReplyForMyResourceComment = 2; // 我收到的别人对我的资源的评论的一个回复

		int MyComment = 10;// 我发出的直接对资源的评论
		int MyReply = 11; // 我发出的对一个资源的评论的回复
	}

	public interface CommentStatus {
		int DELETE_HOTCOMMENT_TOPLIST = 7;// 排行榜更新的精彩评论
		int DELETE_HOTCOMMENT_AUTO = 5;// 机器删除精彩评论
		int DELETE_HOTCOMMENT_MANUAL = 2;// 人工删除精彩评论
		int NORMAL = 0;
		int DELETE_BY_USER = -5;
		int DELETE_BY_ANTISPAM = -10;
	}
	
	/**
	 * 热门评论审核操作类型
	 */
	public interface AuditOpType {
		int DELETE_COMMENT = 1;
		int REMOVE_HOT_COMMENT = 2;
		int RECOVER = 3;
	}
	
	/**
	 * 取得点赞数，评论数关键字
	 */
	public interface ThreadLocalKeyword {
		String LIKED_COUNT_KEY = "LikedTotal";
		String COMMENT_COUNT_KEY = "commentTotal";
	}
	


}
