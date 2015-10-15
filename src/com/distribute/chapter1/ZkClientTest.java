package com.distribute.chapter1;

import java.util.List;

import org.I0Itec.zkclient.IZkChildListener;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.IZkStateListener;
import org.I0Itec.zkclient.ZkClient;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.Watcher.Event.KeeperState;

public class ZkClientTest {

	private static final String PATH = "/tmp";

	public static void main(String[] args) {
		String serverList = "10.0.2.15";
		ZkClient zkClient = new ZkClient(serverList);
		// create node
		zkClient.createPersistent(PATH);
		// create child node
		zkClient.create(PATH + "/child", "child node", CreateMode.EPHEMERAL);
		// get childe node
		List<String> children = zkClient.getChildren(PATH);
		// get children number
		int childCount = zkClient.countChildren(PATH);
		// judge if node exist
		zkClient.exists(PATH);
		// write data
		zkClient.writeData(PATH + "/child", "hello everyone");
		// read node data
		Object obj = zkClient.readData(PATH + "/child");
		// delete node
//		zkClient.delete(PATH + "child");
		//subscribe child node
		zkClient.subscribeChildChanges(PATH, new IZkChildListener() {
			
			@Override
			public void handleChildChange(String arg0, List<String> arg1) throws Exception {
			}
		});
		//subscribe data change
		zkClient.subscribeDataChanges(PATH, new IZkDataListener() {
			
			@Override
			public void handleDataDeleted(String arg0) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void handleDataChange(String arg0, Object arg1) throws Exception {
				// TODO Auto-generated method stub
				
			}
		});
		//subscribe connection state change
		zkClient.subscribeStateChanges(new IZkStateListener() {
			
			@Override
			public void handleStateChanged(KeeperState arg0) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void handleSessionEstablishmentError(Throwable arg0) throws Exception {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void handleNewSession() throws Exception {
				// TODO Auto-generated method stub
				
			}
		});
	}
}
