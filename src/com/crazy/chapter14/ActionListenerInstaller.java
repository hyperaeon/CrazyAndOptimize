package com.crazy.chapter14;

import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import javax.swing.AbstractButton;

public class ActionListenerInstaller {

	public static void processAnnotation(Object obj){
		try{
			Class cl = obj.getClass();
			for(Field f : cl.getDeclaredFields()){
				f.setAccessible(true);
				ActionListenerFor a = f.getAnnotation(ActionListenerFor.class);
				Object fObj = f.get(obj);
				if(a != null && fObj != null && fObj instanceof AbstractButton){
					Class<? extends ActionListener> listnerClass = a.listener();
					ActionListener a1 = listnerClass.newInstance();
					AbstractButton ab = (AbstractButton)fObj;
					ab.addActionListener(a1);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
