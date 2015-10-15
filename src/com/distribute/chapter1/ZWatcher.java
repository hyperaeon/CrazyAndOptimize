package com.distribute.chapter1;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;

public class ZWatcher implements Watcher {

	@Override
	public void process(WatchedEvent event) {
		if (event.getType() == EventType.NodeDeleted) {
			System.out.println("Node delete");
		}
		if (event.getType() == EventType.NodeChildrenChanged) {
			System.out.println("Node childrenChanged");
		}
		if (event.getType() == EventType.NodeCreated) {
			System.out.println("Node created");
		}
		if (event.getType() == EventType.NodeDataChanged) {
			System.out.println("Node data changed");
		}
	}

}
