package com.netease.util;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;




/**
 * 
 * @ClassName: SSLClient
 * @Description: 用于进行Https安全请求的HttpClient
 * @author:JonneyZhang
 * @date: 2016年5月17日 上午10:22:30
 */
public class SSLClient extends DefaultHttpClient{
	public SSLClient() throws Exception{
        super();
        //SSLContext: 此类的实例表示安全套接字协议的实现， 它是SSLSocketFactory、SSLServerSocketFactory和SSLEngine的工厂
        SSLContext ctx = SSLContext.getInstance("TLS");
        //TrustManager 负责管理做出信任决定时使用的的信任材料，也负责决定是否接受同位体提供的证书
        X509TrustManager tm = new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] chain,
                        String authType) throws CertificateException {
                }
                @Override
                public void checkServerTrusted(X509Certificate[] chain,
                        String authType) throws CertificateException {
                }
                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
        };
        //初始化
        ctx.init(null, new TrustManager[]{tm}, null);
        //
        SSLSocketFactory ssf = new SSLSocketFactory(ctx,SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
        ClientConnectionManager ccm = this.getConnectionManager();
        SchemeRegistry sr = ccm.getSchemeRegistry();
        sr.register(new Scheme("https", 443, ssf));
    }
	
}
