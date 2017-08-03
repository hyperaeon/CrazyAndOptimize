package com.jdk8.chapter8;

import com.jdk8.chapter7.Editor;
import com.jdk8.chapter7.EditorImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzliyong on 2017/8/2 0002.
 */
public class Macro {

    private final List<Action> actions;

    public Macro() {
        actions = new ArrayList<>();
    }

    public void record(Action action) {
        actions.add(action);
    }

    public void run() {
        actions.forEach(Action::perform);
    }

    public void main(String[] args) {
        Editor editor = new EditorImpl();
        Macro macro = new Macro();
        macro.record(() -> editor.open());
        macro.record(editor::save);
        macro.record(new Close(editor));
        macro.run();
    }
}

