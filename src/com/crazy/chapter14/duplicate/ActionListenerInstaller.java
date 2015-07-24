package com.crazy.chapter14.duplicate;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.AbstractButton;

public class ActionListenerInstaller {

	public static void processAnnotation(Object obj) {
		try {
			Class<? extends Object> clazz = obj.getClass();
			for (Field f : clazz.getDeclaredFields()) {
				ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);
				Object fObj = f.get(obj);
				if (a != null && fObj != null && fObj instanceof AbstractButton) {
					Class<? extends ActionListener> listener = a.listener();
					System.out.println(a.name());
					ActionListener listen = listener.newInstance();
					AbstractButton b = (AbstractButton) fObj;
					b.addActionListener(listen);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
