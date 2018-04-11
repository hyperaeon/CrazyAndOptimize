package com.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.test.vo.Grades;
import com.test.vo.MobileHeader;
import com.test.vo.Student;
import com.util.MD5MsgDigest;

import net.sf.json.JSONObject;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

public class AnyTest implements Serializable {

	private static final AtomicInteger counter = new AtomicInteger();

	private static final String PATTERN = "\\s{1}'\\d{4}-\\d{1,}-\\d{1,} \\d{1,}:\\d{1,}:\\d{1,}'";

	private final static char BRACKET1 = '[';

	private final static char BRACKET2 = ']';

	private static int v = 0;

	private int value = 2;

	private static final Long interval = 10 * 60 * 1000L;// 阅读防刷间隔

	public static void main(String[] args) throws Exception {
//		mapAddTest();
//		replaceEnter();
//		subString();
		// System.out.println("ass".equals(null));
		// long a = 22222;
		// Long b = 22222L;
		// System.out.println(a == b);
		// testJson();
		// Object o = "sdfas";
		// StringBuilder sb = new StringBuilder();
		// System.out.println(sb.toString().substring(0, 2));
//		processBuilder();
//		System.out.println(md5Degest("open seasame"));
//		blockingQueueTest();
		// testNuber();
		// String str =
		// "{\"images\":[],\"userId\":\"1016287\",\"product\":{\"id\":\"prx308091fa5b1fae5998f4d57ec967ad86\",\"nameMap\":{\"productNameList\":[\"鏃犲嵃鑹搧
		// 鑸掓煍鍖栧姘�鏁忔劅鑲岀敤\",\"MUJI Light Toning Water Sensitive
		// Skin\"]},\"noteCount\":12,\"brand\":{\"id\":\"prx557005166692c01f2cb4778e35f3bd3c\",\"followerCount\":0,\"enName\":\"MUJI\",\"zhName\":\"鏃犲嵃鑹搧\",\"mainName\":1},\"sku\":{\"id\":\"11179_3004_11009\",\"skuProperty\":\"鍨嬪彿\",\"imageUrl\":\"http:\\\/\\\/beauty.nosdn.127.net\\\/beauty\\\/img\\\/a1ff2216-441e-4074-a2c6-29a6be792039\",\"enName\":\"Light
		// Toning Water Sensitive Skin High
		// Moisture\",\"mixName\":\"楂樹繚婀垮瀷 High Moisture\",\"grassFlag\":0,\"hasReview\":false,\"zhName\":\"鑸掓煍鍖栧姘�鏁忔劅鑲岀敤 楂樹繚婀縗"},\"imageUrl\":\"http:\\\/\\\/beauty.nosdn.127.net\\\/beauty\\\/img\\\/40d0442e-73bd-4e69-9b18-39ea4eca2c6d\",\"enName\":\"Light
		// Toning Water Sensitive
		// Skin\",\"grassFlag\":0,\"grassed\":false,\"zhName\":\"鑸掓煍鍖栧姘�鏁忔劅鑲岀敤\",\"mainName\":0},\"id\":\"0\",\"productId\":\"prx308091fa5b1fae5998f4d57ec967ad86\",\"emotion\":1,\"skuId\":\"11179_3004_11009\"}";
		
		// System.out.println(System.currentTimeMillis());
		// System.out.println(new Date(System.currentTimeMillis() - interval));
		// emojiTest();
		//
		// String si = "分享分享分享分享分享分享分享分享分享分享分享分享分享分享分享分享分享"
		// + "分享分享分享分享分享分享分享分享分享分享分享分享分享分享分享分享分享分享"
		// + "分享分享分享分享分享分享分享分享分享分享分享分享分享分享分享分享分享分享"
		// + "分享分享分享分享分享分享分享分享分享分享分享分享分享分享分享分享分享";
		// System.out.println(si.length());
		// extractDigital();
		// String gbkStr = new String("\u0000\u0000".getBytes("ISO8859-1"),
		// "GBK");
		// System.out.println("gbk: " + gbkStr);
		// System.out.println(DateUtil.formatDate(new Date(),
		// "yyyy-MM-dd HH:mm:ss"));
		// caseTest();
		// String u = "\u0000\u0000";
		// replaceTest();
		// sendMessage();
		// String s =
		// "少时诵诗书少时诵诗书少时诵诗书反反复复发方法方法法非法方法方法法非法方法发方法方法法非法方法方法法非法方法发发发凤飞飞撒的发生大幅阿萨德f阿发发阿斯顿发啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊试试生上生上生少时诵诗书少时诵诗书少时诵诗书少时诵诗书反反复复发方法方法法非法方法方法法非法方法发方法方法法非法方法方法法非法方法发发发凤飞飞撒的发生大幅阿萨德f阿发发阿斯顿发啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊试试生上生上生少时诵诗书少时诵诗书少时诵诗书少时诵诗书反反复复发方法方法法非法方法方法法非法方法发方法方法法非法方法方法法非法方法发发发凤飞飞撒的发生大幅阿萨德f阿发发阿斯顿发啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊试试生上生上生少时诵诗书少时诵诗书少时诵诗书少时诵诗书反反复复发方法方法法非法方法方法法非法方法发方法方法法非法方法方法法非法方法发发发凤飞飞撒的发生大幅阿萨德f阿发发阿斯顿发啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊试试生上生上生少时诵诗书少时诵诗书少时诵诗书少时诵诗书反反复复发方法方法法非法方法方法法非法方法发方法方法法非法方法方法法非法方法发发发凤飞飞撒的发生大幅阿萨德f阿发发阿斯顿发啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊试试生上生上生少时诵诗书少时诵诗书少时诵诗书少时诵诗书反反复复发方法方法法非法方法方法法非法方法发方法方法法非法方法方法法非法方法发发发凤飞飞撒的发生大幅阿萨德f阿发发阿斯顿发啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊试试生上生上生少时诵诗书少时诵诗书少时诵诗书少时诵诗撒的发生大幅阿萨德f阿发发阿斯顿发啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊试试生上生上生少时诵诗书少时诵诗书少时诵诗书少时诵诗书反反复复发方法方法法非法方法方法法非法方法发方法方法法非法方法方法法非法方法发发发凤飞飞我问问我";
		//
		// System.out.println(s.length());
		// System.out.println(s.replaceAll("\\s*","").length());
		// listTest();
		// formatTest();
		// bigDecimalTest2();
		// trim();
		// sub();
		// boolTest();
		// split163com();
		// setContain();
//		 splitInNumber();
		// String str =
		// "'yongyuandejianlai@163.com','lby5240508@163.com','zhaoerlong@live.com','yhq33@163.com','diane1533@163.com','annie_hq@163.com','lbeiming@126.com','qq374629149@163.com','peter_jiang@me.com','zf19901007@126.com','tj3081102@163.com','m13811050682@163.com','dm_xj@163.com','yangzhang2015@126.com','heidongqiqi@163.com','tj604@163.com','hzmaym@163.com','m13732262421@163.com','o9puesxdlz441e54feeab9c7aaf7cd06f0d39bedd2@wx.163.com','m15858193675@163.com','lemoncnc@126.com','luyinuoo@163.com','hzlengyang@corp.netease.com','wanglina_2004@163.com','eve1986425@163.com','huerjinxiajh@163.com','shangxilei@126.com','sweetpig37@163.com','chainsa@163.com','wuzengan@126.com','lvfang0530@163.com','ffyy505@163.com','f3bac5174e0dcfb46f5245eede3cd946@tencent.163.com','806ee494073953a9c18bc9c997607a76@tencent.163.com','my_love_168@163.com','nht116@126.com','lwf87@163.com','tidykui@163.com','yanghuiczs@163.com','zhangshujun_wh@126.com','anran_7410@126.com','f20ac1aa7d1cd3a89c2fc27a7960faaa@tencent.163.com','900bea89fbfffa4a1f28532bbb509db9@tencent.163.com','enno_chou@163.com','m13951802675_4@163.com','12humin12@163.com','xiekeming1989@126.com','b4df0e5d5d8ddcbabd6cbec14a85994d@tencent.163.com','379994040@qq.com','hankguo6@163.com','v13958190992@163.com','hwz20086768@163.com','carey_cc@126.com','ztx236819@163.com','o9puesygft24f9308903ecf7169087b687786b7f80@wx.163.com','qiuxueling@163.com','j1552090797@163.com','leopoldxx@163.com','jana7098@163.com','amy863211@163.com','eabfbac37e2186cd56baa9fb93d2cc89@tencent.163.com','lanyuzhu5102@163.com','wk508649767@163.com','fanfancute@163.com','sukie129@126.com','vans0416@163.com','m13971184865@163.com','chiyulin90@163.com','sqs19880808@126.com','hhsply619@163.com','m18770056526@163.com','719573968@qq.com','lanlan_laner@126.com','zwy1993612@126.com','174382233@qq.com','575839709@qq.com','jw919575219@163.com','gaojs_2012@163.com','m18267515280_1@163.com','hzshanglin@corp.netease.com','momaek77@126.com','ccaclisi@126.com','ysmeihejin@163.com','alin9112@163.com','441657603@163.com','6af08aaa55215d37aff18793033f08fd@tencent.163.com','1891170484@sina.163.com','bobmingyuan@163.com','4144bd0faca2e145463e9bbd8a40f820@tencent.163.com','yeshize08@126.com','binssky@163.com','hkxzy10@163.com','fancomcn@163.com','sun30301@163.com','hi.carol@qq.com','m15043937386@163.com','zhong.you.liang@163.com','o9pues2f7ldffd143314c241df0a2bd76326090348@wx.163.com','w475774316@163.com','chx810@126.com','995360117@qq.com','o9pues4tza765b4bb7b48671aae1d819099dcb9908@wx.163.com','o9pueszvha672098342368608d54c2daee36de764e@wx.163.com','liuxiaodan0518@126.com','victoria_vicky@126.com','m15088618621_1@163.com','m13548922991@163.com','o9pues6kdtb48322c171a980099e56d14d2d9340ab@wx.163.com','069eb87440188a13a4611d4492d9799bb97b7ed4e4@yixin.163.com','hot_polo@163.com','m15868192716@163.com','m18037214452@163.com','xoo501303755@163.com','lemon_crystal@126.com','2642673288@qq.com','pengtingshu2@163.com','zhejiangchenman@163.com','suomo@126.com','zhanan0610@163.com','m18605711117@163.com','carina_yicen@126.com','m13687601482_1@163.com','m13630134223@163.com','254855080@163.com','shujingyingqingfei@163.com','xiaomaju0924@163.com','m18595573605@163.com','lyw147513258@163.com','cd8b289f9619ea7b9faae8231c3b14db@tencent.163.com','m13587561693_1@163.com','2269513252@sina.163.com','canopal@163.com','02aa8ed9201b04cd17fc6b5d358356a3@tencent.163.com','morning_1hao@163.com','m18105693102@163.com','yanggai315@163.com','hcdp38462138duwen@163.com','nvps4679545dongbe@163.com','m13666600933@163.com','o9pues71d7662886b2d556d14f43c35b4666e030ef@wx.163.com','xuejun022@163.com','m34451311hui@163.com','m15555551927@163.com','7d097b2b5ccf4be9fc6bf49ccedb68cf@tencent.163.com','aeleen0727@163.com','m13881883375_1@163.com','zoic99172695kez@163.com','syh520sj@163.com','3d23393357309dde6b49da3f32de133e@tencent.163.com','thur03726511xink@163.com','m13888677234@163.com','jck1993@yeah.net','m15822333618@163.com','wanglu9422@126.com','m13868043557@163.com','m13951030616@163.com','yanny0201@163.com','bhana743@126.com','ien02258555la@163.com','59094554@163.com','dad8305dee5ca01f18cd08b1853e31ea@tencent.163.com','c0861544chenpin2@163.com','m17854239920@163.com','2003763255@sina.163.com','msj900810@163.com','gdjywrx@163.com','akr562918@163.com','mxy1211@163.com','m13952888912_1@163.com','6a8b7b0918f0cd302f87cb8c434c0d5e@tencent.163.com','5c3299a2bd42938be4bd726f86ff9d7d@tencent.163.com','0eee6352dbaedc554939b0cf132bce45@tencent.163.com','m13784761204_1@163.com','o2500931mofei@163.com','m18670507962@163.com','nj7839001dengyan@163.com','m18132705555@163.com','zjdxzj2006@163.com','toycat14@126.com','b2b55d8330308f4d2508a04836e9cdc4@tencent.163.com','o9pues2wsf98799923d7d5807d6d1f56dcc5fe24de@wx.163.com','toutouhz@126.com','m15397122162_2@163.com','hzhlltest1@163.com','m13167098526@163.com','yu5538266@163.com','aab659854b1aa5ba3ee72cbbd359ec22@tencent.163.com','mcr5433545qian@163.com','m15086138081_2@163.com','m18856939198@163.com','m13971822882_1@163.com','m18768480099@163.com','1116270765@sina.163.com','yalehuan@yeah.net','1cf19672e4777bdc9086686eb7c62f4c@tencent.163.com','o9pues_uct0d099a557378ea35a92ed0fc8ceb2eea@wx.163.com','o9pues2rrnc9e3375d9f73dac36c08945e5ee66fbd@wx.163.com','ye2835753@163.com','o9puesydfy162bf71b974799ec175e8f4721eb0cbb@wx.163.com','sy76520@163.com','nyf4553292@163.com','m13858062181@163.com','c9f0c0f6d0443fe1057edb6aa7a6b070@tencent.163.com','m18767129109@163.com','b244be020d3350d4653ef5114bfbb2eb@tencent.163.com','m18261278555@163.com','ni7818325@163.com','m18616316040@163.com','sdsongax@163.com','m15810284200@163.com','woxiang250@126.com','585bd80b7f08511fdb4e870b94fb7351@tencent.163.com','ygm35713661@163.com','mrsjaney@163.com','o9puesyngq3e5ab503abd4a5b4efbe7efa7f1cb671@wx.163.com','enk9418316gusha@163.com','souplu@126.com','o9pues2wzke552ab95db106c530ed32666bb692bae@wx.163.com','qk1636865@163.com','m18506825655@163.com','xuzhou887@163.com','momory1990@126.com','yxjtest314@163.com','024a727c540145c97b9777ca9f7aaf8f@tencent.163.com','ed2559c4539234952bc151974f6d4fe2@tencent.163.com','fuz2318@126.com','zhy3881@163.com','caihong1996@163.com','m13917752613@163.com','m13913036819_1@163.com','xulele029@126.com','jexb2979660d@163.com','m13738048658@163.com','gebright@126.com','o9pues4pb93840fbddf08e9fb869ccb614aea9ab5a@wx.163.com','0640bd8e49f88afcac7fa9f10ef8af5f@tencent.163.com','ql19941202@163.com','5515788406@sina.163.com','m13693801604@163.com','jnc187735@163.com','lilixin898@163.com','m13818183490@163.com','m13003625320@163.com','z1759950zhanxing@163.com','m13507539931@163.com','mcclixiang@163.com','yxjtest315@163.com','f60e80ca4b26aeb1a75ff3b2b6677b20@tencent.163.com','kuapf32661@163.com','m15840245676_1@163.com','brotherszl@163.com','zhjrona531@126.com','sasa_ric@163.com','jin6f@163.com','1854060812@sina.163.com','exi26234123l@163.com','1849981302@sina.163.com','o9pues4s_x10db37463cffd0f9482ad8b5d9a933ab@wx.163.com','m13968049247@163.com','m13704058973@163.com','yxjtest313@163.com','2695893927@sina.163.com','yxjtest47@163.com','rns8462321@163.com','o9pues_nlo641868a130c3f3593c73aa9591bfd5c2@wx.163.com','lanyong6303@163.com','m13478535282@163.com','wandnyu@163.com','o9puesxs_oe24bd137623e9ee85525e7996c159767@wx.163.com','o9puesxmj_37962b61143d7105219569549d7a5c61@wx.163.com','zhaohao259@163.com','lehtest010@163.com','m15043343033_1@163.com','ncj0614@163.com','capso006@163.com','ade4699323@163.com','xianqi110@163.com','xulele2015_005@163.com','o9puesxv0n9d7211ea31ff013d32fe7f783acaaec6@wx.163.com','yf74885239@163.com','a5dcbe8bf97a7f98142fa6b901e1c9c5@tencent.163.com','o9pues6lvia4d2da8bec6056179b1541b6e584a204@wx.163.com','tabby_kitty@126.com','m18640836990@163.com','3c2055d8275ef95e92bc7957c25df445@tencent.163.com','z872619889@126.com','o9pues7uuh95b53fc478a1c1c8e5436ae36532872b@wx.163.com','m18670333530_1@163.com','1203617129@qq.com','m15756329691@163.com','m15988873691@163.com','evey718@163.com','lg44460@163.com','capso007@163.com','kitwahyeung@yeah.net','gnj829393@163.com','m13968097194@163.com','m17839302700@163.com','sunana_001@163.com','m15029268714@163.com','m15158060012@163.com','huihui20151123@163.com','m17095221688@163.com','zhizhu78353@163.com','yxjtest319@163.com','m15734493336@163.com','rongke796chefei@163.com','xyl@ylsysh.com','o9pues_e9rcbd00f7d8a57ae8fb30270643883297a@wx.163.com','o9puesy48j6e081eb24f00fcd0a68f5fe22a404253@wx.163.com','yxjtest316@163.com','a794445dc8d404cb357009497a4fa87f@tencent.163.com','m18357119517_1@163.com','276447783@qq.com','5a161c290ddc5b4296e63bd1c318ea9d@tencent.163.com','lingchunzou@163.com','2607416263@sina.163.com','bfe1fbd11e797617c617cc11a557bfcc@tencent.163.com','situnliangxingk@163.com','wanbingpeng2008@163.com','m15757122859@163.com','o9pues_0spc85309a225ecf2e00b78d9f57726304a@wx.163.com','dou199410227424@163.com','m13840959013@163.com','princle@163.com','swqnt34474@163.com','ddffyy_3502@163.com','1a22628a60fe26c90c9a04d9f3f6b376@tencent.163.com','fn4tz27sc@126.com','c4515d6e64792fe05ec08871e8973399@tencent.163.com','hb555505@163.com','o9pues1wlz899668463c5636726c071fe3b311037f@wx.163.com','35e29a611f015e3201d8b7b245f68d95@tencent.163.com','m15168394664@163.com','e2de5423d60a9c6a7336ff2fc76fbd0e@tencent.163.com','ab98e15dd71bca53235cedc239b820fb@tencent.163.com','2169659766@qq.com','m15933763251@163.com','d770971693c24b20708b96e3adf8dbe6@tencent.163.com','195114f1b4d92b678102813c663c9275@tencent.163.com','yxjtest325@163.com','m18402010874@163.com','yxjtest48@163.com','yxjtest320@163.com','m15205713638@163.com','e885b83c454c5c61c11403b703025e07@tencent.163.com','m15158172962@163.com','m13952521002@163.com','yxjtest52@163.com','m13894360778@163.com','o9pues1sch2a53f4a3954e91f99d50fdb641dc00ca@wx.163.com','o9pues48uj902a6d9a3b16736b03b4cd233f65defb@wx.163.com','jgxw6636@163.com','yxjtest327@163.com','bei1514jiao@163.com','439cace6e172aad0959bdbe322b2c6eb@tencent.163.com','urstest_zhangxj2@163.com','m15868112400@163.com','m13795193479@163.com','699e928bbef0da74f796bc2e51f4b90c@tencent.163.com','517150773@qq.com','sunxiaonan2010@163.com','m15657173318@163.com','wlwyxzcd@163.com','m18600261036@163.com','m17095034480@163.com','c06137a4ceb1dbbd912de4b82fbfecb1@tencent.163.com','m18100825706@163.com','546600496@qq.com','xielinlin4@yeah.net','182174f2fcacf3afed99f225605e2acb@tencent.163.com','lii62351@yeah.net','zyay8013980@163.com','chan-aini@163.com','m18957122569@163.com','m13898676510@163.com','1719442260@sina.163.com','jing19931977@163.com','yanzhu103@126.com','o9puesygpnb306ef56b175380ca98a094f308ce53b@wx.163.com','m18600317672@163.com','lianjiadeyouxiang@163.com','o9pues7wmr9c693a472c85d94b3e5475a8709d2bf0@wx.163.com','a9d6f64a069421df3ce28d142f9587fb@tencent.163.com','ouxian3293punan@163.com','o9pues3wty13b8526fa088f6a372bea366539714c9@wx.163.com','b7e492220747fd20aa651d59a81be7a9@tencent.163.com','o9pues6bus9c54256e9c532fdfb2cee97c8a0acdb7@wx.163.com','blylb@126.com','949ca565e567eef501fc25cfeadedf2f@tencent.163.com','o9pues0tt61968dd0c82b1a05a2d5b6f37861d4f20@wx.163.com','1a8decf24d472dc260485dbe2956c824@tencent.163.com','yxjtest324@163.com','yxjtest318@163.com','urstest_zhangxj3@163.com','393958626@qq.com','m18666613101@163.com','i8615g7vp7@126.com','aiktfzld@163.com','830719027a70288201e7daa3a64a0d0f@tencent.163.com','1235morb@163.com','o9pues42vt6d285df4adcdbf47ac2621d7ab9a7fbd@wx.163.com','m18604741695@163.com','sophiachucyy@163.com','caiqi1985@126.com','o9pues2mqpa36b8e53fb5144a7fcf29f95cd0ee2da@wx.163.com','bcde339d2e6dfad2fc43c7a5d31bb151@tencent.163.com','hdwoqpr05@163.com','1784596610@sina.163.com','o9pues9w354016948df83b6905ff29de6ed9879216@wx.163.com','357521767@qq.com','lehtest013@163.com','a40242f1b433ac03db5edda3b3fc68d4@tencent.163.com','m13583635316@163.com','aaf24f919f096582dd59e036c2bca9f8@tencent.163.com','o9pues1dob02f224567b2d9953163841dcebb1c07e@wx.163.com','o9puesyuns46228c1fc9ac68cbe6cb4a527a108474@wx.163.com','d41806e87a8d6d6deb4c1a1d5485c7f3@tencent.163.com','xiaoqing_xiong@163.com','eyes.ybq@163.com','yxjtest49@163.com','gvsllb1419@163.com','m13634181299@163.com','o9pues_17jde434a5b7478f12f33e08e700a63e1dd@wx.163.com','o9pues0_vx3f53fab442d2a3ed2301af658b97c3bb@wx.163.com','niclasb1@163.com','m13184284739@163.com','niclasa2@163.com','yxjtest326@163.com'";
		// String[] arr = str.split(",");
		// System.out.println(arr.length);
		// containEnterChar();
		// System.out.println(doubleCompare());
		// transformUnit(Double.valueOf("45020508177"), "/user/xiupin/vstore/");
		// transformMobile();
		// stringLength();
		// System.out.println(replaceSecurityBug("ss`$()"));
		// long time = System.currentTimeMillis();
		// System.out.println(time);
		// byte[] bytes = long2ByteArray(time);
		// System.out.println(bytes);
		// long after = bytes2Long(bytes);
		// System.out.println(after);
		// System.out.println(new Random().nextInt(10000));
		// listOrder();
		// System.out.println(new Random().nextInt(10000));
		// memoryChange();
		// testCode();
		// testParse();
		// int2Boolean();
		// stringDate();
		// tokenizerTest();
		// wordTest();
		// randomTest();
		// testReg();
		// getCalendar("[16/Dec/2012:05:32:50 -0500]");
		// hadoopLsTest();
//		safeTest();
//		putIfAbsentTest();
//		timerTest();
		varargsTest(null);
		int a = 7;
		int b = AnyTest.highestOneBit(a);
		System.out.println(b);
//		testUUID();
//		testUUIDType3();
//		removeListTest();
		String price = "26.9";
		Long p = (long) (Double.valueOf(price) * 100);
		System.out.println(p);
	}

	public static void removeListTest() {
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		for (String str : list) {
			if ("2".equals(str)) {
				list.remove(str);
			}
		}
		System.out.println(list.size());
	}
	
	public static void testUUIDType3() {
		for (int i = 0; i < 100000; i++) {
			System.out.println(UUID.nameUUIDFromBytes(String.valueOf(System.nanoTime()).getBytes()));
		}
	}
	
	public static void testUUID() {
		for (int i = 0; i < 100000; i++) {
			System.out.println(UUID.randomUUID().toString());
		}
	}
	
	public static int highestOneBit(int i) {
        // HD, Figure 3-1
        i |= (i >>  1);
        i |= (i >>  2);
        i |= (i >>  4);
        i |= (i >>  8);
        i |= (i >> 16);
        return i - (i >>> 1);
    }
	
	private static void varargsTest(Integer... a) {
		System.out.println(a);
	}
	
	private static void timerTest() {
		System.out.println("About to schedule task.");
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				System.out.println("Time's up");
				timer.cancel();
			}
		}, 3 * 1000);
	}
	
	private static void putIfAbsentTest() {
		Map<String, String> map = new HashMap<>();
		map.putIfAbsent("abc", "bcde");
		map.putIfAbsent("abc", "defs");
		System.out.println(map.get("abc"));
	}
	
	@CallerSensitive
	private static void safeTest() {
		Class arg = Reflection.getCallerClass();
		System.out.println(arg);
	}
	
	private static void mapAddTest() {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("1", "abc");
		map.put("2", "bcd");
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.putAll(map);
		map2.put("3", "cde");
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.putAll(map);
		map3.put("4", "efg");
		map3.put("3", "ggg");
		System.out.println(map2.get("3"));
		System.out.println(map3.get("4"));
	}
	
	private static void subString() {
		String a = "[{}";
		String lines = "abcd";
		String l = lines.substring(0, lines.length());
		System.out.println(l);
	}

	private static void replaceEnter() {
		String abc = "";
		System.out.println(abc.replaceAll("\r\n", "").replaceAll("\n", ""));
	}

	private static void processBuilder() {
		String command = "cd";
		ProcessBuilder pb = new ProcessBuilder(command);
		System.out.println(pb.command());
		String name = "hzliyong";
	}

	/**
	 * md5摘要
	 * @param name
	 */
	private static String md5Degest(String name) {
		return MD5MsgDigest.digest(name).toLowerCase();
	}

	private static void testTreeMap() {
		String s = "_20_0_口红";
		String[] array = s.split("_");
		System.out.println(array.length);
		System.out.println(array[0]);
		Set<Long> set = new HashSet<Long>();
		List<Long> list = new ArrayList<Long>(set);
		System.out.println(list.size());
		TreeMap<Long, Long> map = new TreeMap<Long, Long>();
		map.put(1L, null);
	}
	
	private static void testNuber() {
		String str = "bcd";
		System.out.println(Arrays.asList(str.split(",")));
		String name = "1";
		System.out.println(name.matches("^[0-9]+$"));
	}

	private static void blockingQueueTest() throws InterruptedException {
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);
//		queue.add("abc");
//		queue.add("bcd");
//		queue.add("def");
		String str = queue.poll(5, TimeUnit.SECONDS);
		System.out.println(str);
	}

	private static void testJson() {
		JSONObject.fromObject(Grades.class);

		String jsonStr = "{\"name\":\"三班\",\"students\":[{\"age\":25,\"gender\":\"female\",\"grades\":\"三班\",\"name\":\"露西\",\"score\":{\"网络协议\":98,\"JavaEE\":92,\"计算机基础\":93},\"weight\":51.3},{\"age\":26,\"gender\":\"male\",\"grades\":\"三班\",\"name\":\"杰克\",\"score\":{\"网络安全\":75,\"Linux操作系统\":81,\"计算机基础\":92},\"weight\":66.5},{\"age\":25,\"gender\":\"female\",\"grades\":\"三班\",\"name\":\"莉莉\",\"score\":{\"网络安全\":95,\"Linux操作系统\":98,\"SQL数据库\":88,\"数据结构\":89},\"weight\":55}]}";
		JSONObject jsonObject = JSONObject.fromObject(jsonStr);
		Map<String, Class> map = new HashMap<String, Class>();
		map.put("students", Student.class);
		Grades grades = (Grades) JSONObject.toBean(jsonObject, Grades.class,
				map);
		System.out.println(grades.getName());
	}

	private static void emojiTest() {
		// TODO Auto-generated method stub

	}

	private static void extractDigital() {
		String s = "abcd0123".replaceAll("\\d+", "");
		String n = "中国0123".replaceAll("\\D+", "");
		System.out.println(s);
		System.out.println(n);
		System.out.println("人民币".equals("人民币"));
		System.out.println("﻿人民币".equals("人民币"));
		System.out.println("" + null);
	}

	private static void caseTest() {
		int type = 0;
		switch (type) {
		case 0:
			System.out.println("type=1 || 0");
			break;
		default:
			System.out.println("default");
			break;
		}
	}

	private static void replaceTest() {
		String content = "\r\n    \"uid\":\"user1\",    \"content\":\"2222\",    \"staffId\":143,    \"timeStamp\":1463216914316,    \"staffName\":\"lantian\",";
		content = content.replaceAll("\r\n", "").replaceAll("\\s*", "");
		System.out.println(content);
		// System.out.println(System.getProperties());
		String url = "asdf/oms/administrator/asdfas";
		System.out.println(url.contains("/oms/administrator"));
	}

	private static void sendMessage() {
		String ip = "localhost";
		int port = 80;
		try {
			Socket socket = new Socket(ip, port);
			socket.setSoTimeout(5539900);
			java.io.OutputStream out = socket.getOutputStream();

			byte[] data = "hello world".getBytes();
			out.write(data);
			out.flush();
			byte[] buffer = new byte[1024];
			int len = -1;
			java.io.FileOutputStream fout = new java.io.FileOutputStream(
					"C:/Users/hzliyong/Desktop/response.txt");
			java.io.ByteArrayOutputStream bout = new java.io.ByteArrayOutputStream();
			java.io.InputStream in = socket.getInputStream();
			while ((len = in.read(buffer, 0, buffer.length)) > 0) {
				bout.write(buffer, 0, len);
			}
			in.close();
			bout.flush();
			bout.close();

			byte[] rdata = bout.toByteArray();
			System.out.println(new String(rdata));

			fout.write(rdata);
			fout.flush();
			fout.close();
			socket.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void boolTest() {
		boolean success = true;
		success &= false;
		success &= false;
		success &= true;
		System.out.println(success);
	}

	private static void setContain() {
		Set<Long> set = new HashSet<Long>();
		set.add(2000L);
		Long a = 2000L;
		if (set.contains(a)) {
			System.out.println("yes");
		}
	}

	// public static void hadoopReadHdfsTest() throws IOException {
	// Path path = new Path("/user/hadoop/temp/path.txt");
	// Configuration conf = new Configuration();
	// FileSystem fs = FileSystem.get(conf);
	// FSDataInputStream fsdis = fs.open(path);
	// BufferedReader br = new BufferedReader(new InputStreamReader(fsdis,
	// "utf8"));
	// String line = null;
	// while ((line = br.readLine()) != null) {
	// System.out.println(line);
	// }
	// if (br != null) {
	// br.close();
	// }
	// fs.close();
	//
	// }
	// public static void hadoopCopyFromLocalPathTest() throws IOException {
	// Configuration conf = new Configuration();
	// FileSystem fs = FileSystem.get(conf);
	// Path src = new Path("/home/hadoop/temp/path.txt");
	// Path dst = new Path("/user/hadoop/temp/path.txt");
	// fs.copyFromLocalFile(src, dst);
	// fs.close();
	// }

	// public static void hadoopAddPathTest() throws IOException {
	// Configuration conf = new Configuration();
	// FileSystem fs = FileSystem.get(conf);
	// fs.mkdirs(new Path("/testpath"));
	// fs.close();
	// }

	// public static void hadoopLsTest() throws IOException {
	// Configuration conf = new Configuration();
	// FileSystem fs = FileSystem.get(conf);
	// FileStatus[] fileStatus = fs.listStatus(new Path("/"));
	// Path[] paths = FileUtil.stat2Paths(fileStatus);
	// for (Path path : paths) {
	// System.out.println(path);
	// }
	// }

	public AnyTest() {
		// System.out.println("Constructor");
		counter.incrementAndGet();
	}

	public static void getCalendar(String value) {
		String[] monthArr = { "Dec", "Nov", "Oct", "Sep", "Aug", "Jul", "Jun",
				"May", "Apr", "Mar", "Feb", "Jan" };

		int[] calendarArr = { Calendar.DECEMBER, Calendar.NOVEMBER,
				Calendar.OCTOBER, Calendar.SEPTEMBER, Calendar.AUGUST,
				Calendar.JULY, Calendar.JUNE, Calendar.MAY, Calendar.APRIL,
				Calendar.MARCH, Calendar.FEBRUARY, Calendar.JANUARY };

		String text = value.toString();
		int openBracket = text.indexOf(BRACKET1);
		int closeBracket = text.indexOf(BRACKET2);
		if (openBracket != -1 && closeBracket != -1) {
			String dateString = text.substring(text.indexOf(BRACKET1) + 1,
					text.indexOf(BRACKET2));
			int index = 0;
			int nextIndex = dateString.indexOf('/');
			int day = Integer.parseInt(dateString.substring(index, nextIndex));
			index = nextIndex;
			nextIndex = dateString.indexOf('/', index + 1);
			String month = dateString.substring(index + 1, nextIndex);
			index = nextIndex;
			nextIndex = dateString.indexOf(':', index);
			int year = Integer.parseInt(dateString.substring(index + 1,
					nextIndex));
			index = nextIndex;
			nextIndex = dateString.indexOf(':', index + 1);
			int hour = Integer.parseInt(dateString.substring(index + 1,
					nextIndex));
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.YEAR, year);
			calendar.set(Calendar.DATE, day);
			calendar.set(Calendar.HOUR, hour);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			for (int i = 0; i < monthArr.length; i++) {
				if (monthArr[i].equalsIgnoreCase(month)) {
					calendar.set(Calendar.MONTH, calendarArr[i]);
				}
			}
			System.out.println(calendar.getTime());
		}
	}

	public int getInstanceCount() {
		return counter.get();
	}

	{
		// System.out.println("Normal block");
	}

	static {
		// System.out.println("Static block");
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static void testReg() {
		String src = "<font  class='span-red span-12' >(处理中)</font>";
		System.out.println(src.contains("span-red span-12"));
		System.out
				.println(src.substring(src.indexOf("(") + 1, src.indexOf(")")));
	}

	private static int randomTest() {
		int temp = (int) (48 * Math.random() + 2);
		System.out.println(temp);
		return temp;
	}

	private static void wordTest() {
		String line = "However, lack of evidence forced the police to release all the four suspects. The call data records revealed that  the suspects were not in the Bhandup area where the body was recovered. The forensic analysis also did not indicate any evidence against the suspects.";
		String[] keys = line.trim().split("\\W+");
		for (String k : keys) {
			System.out.println(k);
		}
	}

	private static void tokenizerTest() {
		String sample = "abacus	abaque,boulier (compteur)[Noun]";
		StringTokenizer t = new StringTokenizer(sample, ",");
		while (t.hasMoreTokens()) {
			System.out.println(t.nextToken());
		}

		List<String> values = new ArrayList<String>();
		values.add("abc");
		values.add("def");
		String transactions = "";
		for (String value : values) {
			transactions += "|" + value;
		}
		System.out.println(transactions);

		StringBuilder sb = new StringBuilder();
		for (String value : values) {
			sb.append("|").append(value);
		}
		System.out.println(sb.toString());
	}

	private static void stringDate() {
		String strDate = "2016年3月11日";
		strDate = strDate.replace("年", "-").replace("月", "-").replace("日", "");
		System.out.println(strDate);
	}

	private static void int2Boolean() {
		int a = 0;
		System.out.println(Boolean.valueOf("" + a));
	}

	private static void testParse() {
		String reg = "#messages";
		String source = "$\\(\"#messages\"\\)\\.text\\(\"您的信用信息查询请求已提交，请在24小时后访问平台获取结果。为保障您的信息安全，您申请的信用信息将于7日后自动清理，请及时获取查询结果";
		System.out.println(source.contains(reg));
	}

	private static void testCode() throws UnsupportedEncodingException {
		String name = new String("李勇".getBytes(), "utf8");
		print(name);
	}

	private static void memoryChange() {
		List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		print(list.size());
	}

	private static void listOrder() {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		for (Integer i : list) {
			System.out.println(i);
		}
	}

	private static byte[] long2ByteArray(long time) {
		byte[] result = new byte[8];
		result[0] = (byte) ((time >> 56) & 0xFF);
		result[1] = (byte) ((time >> 48) & 0xFF);
		result[2] = (byte) ((time >> 40) & 0xFF);
		result[3] = (byte) ((time >> 32) & 0xFF);
		result[4] = (byte) ((time >> 24) & 0xFF);
		result[5] = (byte) ((time >> 16) & 0xFF);
		result[6] = (byte) ((time >> 8) & 0xFF);
		result[7] = (byte) (time & 0xFF);// 最低位
		return result;
	}

	private static long bytes2Long(byte[] bytes) {
		long num = bytes[7] & 0xFF;// 最低位
		long s1 = bytes[6] & 0xFF;
		long s2 = bytes[5] & 0xFF;
		long s3 = bytes[4] & 0xFF;
		long s4 = bytes[3] & 0xFF;
		long s5 = bytes[2] & 0xFF;
		long s6 = bytes[1] & 0xFF;
		long s7 = bytes[0] & 0xFF;
		s1 <<= 8;
		s2 <<= 16;
		s3 <<= 24;
		s4 <<= 32;
		s5 <<= 40;
		s6 <<= 48;
		s7 <<= 56;
		num |= s1 | s2 | s3 | s4 | s5 | s6 | s7;
		return num;
	}

	private static String replaceSecurityBug(String source) {
		return source == null ? null : source.replace("`", "").replace("$", "")
				.replace("(", "");
	}

	private static void stringLength() {
		String str = "区域id,当SubCategoryType 为类目时，1代表某个一级类目下的第一个三级类目区域.当SubCategoryType为非类目时，如首页的时尚女装，1代表PC女装类目专题banner，2代表PC女装商品1-10的坑位，依次类推";
		System.out.println(str.length());
	}

	@SuppressWarnings("rawtypes")
	private static void raw() {
		List list = new ArrayList();
		list.toArray();
	}

	private static void transformMobile() {
		Object header = "platform=phone&osVersion=5.0.1&deviceModel=M353&deviceId=861138026314571_bfdd6e643a59b7aa&network=wifi&channel=normal&&appVersion=2.3.0&protocolVersion=2.3.0&os=android&resolution=1080x1800";
		MobileHeader mh = (MobileHeader) header;
		System.out.println(mh);
	}

	private static void transformUnit(double bt, String path) {
		double gb = Math.pow(1024, 3);
		double kb = Math.pow(1024, 1);
		double sum = bt;
		String[] unit = { "GB", "MB", "KB" };
		int i = 0;
		for (double x = gb; x >= kb; x /= 1024) {
			if (sum >= x) {
				System.out.printf("%.2f %s", sum / x, unit[i]);
				break;
			}
			i++;
		}
	}

	private static void staticValue() {
		AnyTest at1 = new AnyTest();
		at1.v++;
		System.out.println(at1.v);
		AnyTest at2 = new AnyTest();
		at2.v++;
		System.out.println(at2.v);
	}

	private static int doubleCompare() {
		String v1 = "0.002";
		String v2 = "0.0020";
		double d1 = Double.valueOf(v1);
		double d2 = Double.valueOf(v2);
		if (d1 > d2) {
			return 1;
		} else if (d1 < d2) {
			return -1;
		} else {
			return 0;
		}
	}

	private static void containEnterChar() {
		String str = "  flyloeswing@163.com,    yang_linji@163.com";
		str = str.trim().replace("\n", "").replaceAll("\\s+", "");
		System.out.println(str);
	}

	private static void listTest() {
		List list = new ArrayList();
		list.add("abc");
		list.add(Integer.valueOf(0));
		for (Object o : list) {
			System.out.println(o);
		}
	}

	private static void formatTest() {
		Object saleAmount = "3.245";
		DecimalFormat df = new DecimalFormat("0.00");
		String sales_amount = saleAmount == null ? null : df.format(new Float(
				3.245));
		System.out.println(sales_amount);
	}

	private static void bigDecimalTest2() {
		Object o = new Float(323.33332);
		BigDecimal b = new BigDecimal(String.valueOf(o));
		b = b.setScale(2, RoundingMode.HALF_UP);
		System.out.println(b);
	}

	private static void trim() {
		String str = "  sd  ";
		System.out.println(str.trim());
	}

	private static void sub() {
		String str = "assfsadfs3";
		System.out.println(str.substring(str.length() - 1));
		String su = " _ _ _ ";
		String[] arr = su.split("_");
		System.out.println(arr.length);

		String s = "3 _ 2018 _ ";
		String[] ss = s.split("_");
		System.out.println("S " + ss.length);
	}

	private static void inserstOrderSkuTest() {
		String buffer = "INSERT INTO TB_Order_ReturnOrderSku VALUES (1158, 1406, 169.00, 1, '', "
				+ "1419211942250, '', 0, '其它', 3, 1, 1001, 169.00, 2110, 4115, '2014-12-22 09:32:22', '2014-12-22 16:10:01');";
		System.out.println(handle(buffer));

		StringBuilder sb = new StringBuilder(" ");
		sb.append("sdsd");
		System.out.print(sb.toString());

		Boolean te = null;
		System.out.println(String.valueOf(te));

		BigDecimal bg = BigDecimal.valueOf(2.30);
		Integer in = bg.intValue();
		System.out.println(in);
	}

	private static void split163com() throws Exception {
		String path = "C:/Users/hzliyong/Desktop/";
		RandomAccessFile raf = null;
		try {
			raf = new RandomAccessFile(path + "userid.txt", "r");
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = raf.readLine()) != null) {
				line = new String(line.getBytes("ISO-8859-1"), "UTF-8");
				sb.append("\'").append(line).append("\',");
			}
			System.out.println(sb.substring(0, sb.length() - 1).toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void splitInNumber() throws Exception {
		String path = "C:/Users/hzliyong/Desktop/";
		RandomAccessFile raf = null;
		int count = 0;
		try {
			raf = new RandomAccessFile(path + "userid.txt", "r");
			String line = null;
			StringBuilder sb = new StringBuilder();
			while ((line = raf.readLine()) != null) {
				sb.append("").append(line).append(",");
			}
			System.out.println("输出：" + sb.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (raf != null) {
				try {
					raf.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static void handleOtherKey() {
		String orderId = "";
		String packageId = "";
		String otherKey = "";
		if (otherKey != null) {
			String[] strArr = otherKey.split("_");
			orderId = strArr[0];
			if (strArr.length == 2) {
				packageId = strArr[1];
			}
		}
		System.out.println("orderId:" + orderId + "  packageId:" + packageId);

	}

	private static String handle(String buffer) {
		String[] seg = buffer.split(",|\\)");
		StringBuilder sb = new StringBuilder();
		for (String s : seg) {
			s = s.replaceAll("\\\\'", "");
			if (s.matches(PATTERN)) {
				sb.append(",to_date(").append(s)
						.append(", 'yyyy-mm-dd hh24:mi:ss')");
			} else {
				sb.append("," + s);
			}
		}
		String result = sb.toString().replaceFirst(",", "")
				.replaceFirst(",;", ");");
		return result;
	}

	private void stringTest() {
		System.out.println("stringTest()");
	}

	private static void dateTest() {
		Date date = new Date(1443061349617L);
		System.out.println(date);
		System.out.println(new Date().getTime());
	}

	private static void iteratorTest() {
		// Iterator<String> iterator
	}

	private static void longAndLongTest() {
		Long a = 230L;
		Long b = 230L;
		System.out.println(b == a);
	}

	// public static void ExecutorServiceTest() {
	// ExecutorService service = Executors.newCachedThreadPool();
	// FutureTask<String> task = new FutureTask<String>(new Cal());
	// service.submit(task);
	// }

	// private static class Cal implements Callable<String> {
	//
	// @Override
	// public String call() throws Exception {
	// // TODO Auto-generated method stub
	// return null;
	// }
	//
	// }

	private static void loggerTest() {
		Logger logger = Logger.getAnonymousLogger();
		logger.log(Level.INFO, "first info message");
	}

	private static void classTest() throws ClassNotFoundException {
		Class clazz = Class.forName("com.test.AnyTest");
		if (Serializable.class.isAssignableFrom(clazz)) {
			System.out.println("Same class");
		}
	}

	private static void eventListenerTest() {
	}

	private static void splitTest() {
		String str = "asdfasdf sfo  asldf sdf;#  ";
		String[] arr = str.split(";#[\\s+]");
		System.out.println(arr);
	}

	private static void threadTest() {
		Thread t = new Thread();
		t.start();
		try {
			Thread.sleep(1000);
			t.interrupt();
		} catch (Exception e) {

		}
		if (t.isAlive()) {
			t.interrupt();
			System.out.println(t.isAlive());
		}
	}

	private static void concurrentModificationExceptionTest() {
		List<String> list = new ArrayList<String>();
		list.add("abc");
		list.add("bcd");
		for (String s : list) {
			System.out.println(s);
			list.add("dsfs");
		}
	}

	private static void bigDecimalTest() {
		BigDecimal big1 = BigDecimal.valueOf(680.00);
		BigDecimal big2 = BigDecimal.valueOf(680);
		System.out.println(big1.doubleValue() == big2.doubleValue());

		BigDecimal big3 = BigDecimal.valueOf(1L);
		BigDecimal big4 = BigDecimal.valueOf(1);
		System.out.println(big3 == big4);
		BigDecimal totalSkuTax = new BigDecimal(1000);
		int count = 9;
		System.out.println(totalSkuTax.divide(BigDecimal.valueOf(count), 2,
				BigDecimal.ROUND_HALF_UP));
		System.out.println(totalSkuTax.divide(BigDecimal.valueOf(count)));

	}

	private static void typeTransformTest() {
		long start = System.currentTimeMillis();
		System.out.println(start);
		long expire = start + 10 * 365 * 3600 * 24 * 1000L;
		System.out.println(expire);
		System.out.println(expire - start);
	}

	private static void getBytesTest() throws UnsupportedEncodingException {
		String word = "我";
		byte[] gbk = word.getBytes("GBK");
		byte[] utf8 = word.getBytes("UTF-8");
		byte[] iso = word.getBytes("ISO8859-1");
		System.out.println("gbk length: " + gbk.length + " gbk: " + gbk[0]);
		System.out.println("utf8 length: " + utf8.length + " utf8: " + utf8[0]);
		System.out.println("iso length: " + iso.length + " iso: " + iso[0]);
		String gbkStr = new String(gbk, "GBK");
		String utf8Str = new String(utf8, "UTF-8");
		String isoStr = new String(iso, "ISO8859-1");
		System.out.println(gbkStr);
		System.out.println(utf8Str);
		System.out.println(isoStr);

		String s_iso = new String(word.getBytes("UTF-8"), "ISO8859-1");
		System.out.println(s_iso);
		System.out.println(new String(s_iso.getBytes("ISO8859-1"), "UTF-8"));
	}

	private static void print(String str) {
		System.out.println(str);
	}

	private static void print(Integer str) {
		System.out.println(str);
	}

}
