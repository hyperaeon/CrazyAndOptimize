package com.crazy.chapter17;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class GetPostTest {

	public static String sendGet(String url, String param) {
		String result = "";
		String urlName = url + "?" + param;
		try {
			URL realUrl = new URL(urlName);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("Accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible);MSIE 6.0; Windos NT 5.1; SV1)");
			conn.connect();
			Map<String, List<String>> map = conn.getHeaderFields();
			for (String key : map.keySet()) {
				System.out.println(key + "--->" + map.get(key));
			}
			try (BufferedReader in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf-8"))) {
				String line;
				while ((line = in.readLine()) != null) {
					result += "\n" + line;
				}
			}
		} catch (Exception e) {
			System.out.println("发送GET请求出现异常！" + e);
			e.printStackTrace();
		}
		return result;
	}

	public static String sendPost(String url, String param) {
		String result = "";
		try {
			URL realUrl = new URL(url);
			URLConnection conn = realUrl.openConnection();
			conn.setRequestProperty("Accept", "*/*");
			conn.setRequestProperty("connection", "Keep-Alive");
			conn.setRequestProperty("user-agent",
					"Mozilla/4.0 (compatible);MSIE 6.0; Windos NT 5.1; SV1)");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			try (PrintWriter out = new PrintWriter(conn.getOutputStream())) {
				out.print(param);
				out.flush();
			}
			try (BufferedReader in = new BufferedReader(new InputStreamReader(
					conn.getInputStream(), "utf-8"))) {
				String line;
				while ((line = in.readLine()) != null) {
					result += "\n" + line;
				}
			}
		} catch (Exception e) {
			System.out.println("发送POST请求出现异常！" + e);
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		String s = GetPostTest.sendGet("http://localhost:8080/abc/a.jsp", null);
		System.out.println(s);
		String sl = GetPostTest.sendPost("http://localhost:8080/abc/a.jsp",
				"name=abc&pass=lee");
		System.out.println(sl);

	}
}
