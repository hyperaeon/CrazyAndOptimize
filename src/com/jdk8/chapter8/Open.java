package com.jdk8.chapter8;

import com.jdk8.chapter7.Editor;

/**
 * Created by hzliyong on 2017/8/1 0001.
 */
public class Open implements Action {

    private final Editor editor;

    public Open(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {

    }
}
