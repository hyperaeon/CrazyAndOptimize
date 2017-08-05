package com.jdk8.chapter8;


/**
 * Created by hzliyong on 2017/8/4 0004.
 */
public class Description {

    private String name;

    public Description() {

    }

    public Description(String name) {
        this.name = name;
    }

    public static void describe(String name, Suite behavior) {
        Description description = new Description(name);
        behavior.specifySuite(description);
    }

    public void should(String description, Specification specification, Suite suite) {
        try {
            Expect expect = new Expect();
            specification.specifyBehaviour(expect);
            Runner.current().recordSuccess(suite, description);
        } catch (AssertionError cause) {
            Runner.current().recordFailue(suite, description, cause);
        } catch (Throwable cause) {
            Runner.current().recordError(suite, description, cause);
        }
    }
}
