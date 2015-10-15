package com.distribute.chapter1;

import java.io.IOException;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

public class ZookeeperTest {

	private static String url = "127.0.0.1:2181";

	private static int sessionTimeOut = 50000;

	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		ZooKeeper zooKeeper = new ZooKeeper(url, sessionTimeOut, new Watcher() {

			@Override
			public void process(WatchedEvent arg0) {
				System.out.println(arg0.getPath());
			}
		});
		if (zooKeeper.exists("/tmp", false) == null) {
			// create node
			zooKeeper.create("/tmp", "root data".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		}
		if (zooKeeper.exists("/tmp/child", false) == null) {
			// create child node
			zooKeeper.create("/tmp/child", "child data".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
		}
		// delete node
		// zooKeeper.delete("/root", -1);

		// set data
		zooKeeper.setData("/tmp", "hello".getBytes(), -1);
		Stat stat = new Stat();
		byte[] data = zooKeeper.getData("/tmp", false, stat);
		System.out.println("data :" + new String(data));
		Stat stat2 = zooKeeper.exists("/tmp/child", false);
		if (stat2 == null) {
			System.out.println("Node does not exist");
		} else {
			System.out.println("Node exist");
		}

		zooKeeper.create("/tmp/testChild1", "child1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
		zooKeeper.create("/tmp/testChild2", "child2".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
		zooKeeper.create("/tmp/testChild3", "child3".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL_SEQUENTIAL);
		System.out.println(zooKeeper.getChildren("/tmp", false));
	}
}
