package com.jdk8.chapter8;

import com.jdk8.chapter7.Editor;

/**
 * Created by hzliyong on 2017/8/2 0002.
 */
public class Close implements Action {

    private final Editor editor;

    public Close(Editor editor) {
        this.editor = editor;
    }

    @Override
    public void perform() {

    }
}
