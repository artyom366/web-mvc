package lv.test.app.util;

/**
 * Created by artyom on 15.10.11.
 */
public class Machine implements IMachine {
    @Override
    public void start() {
        System.out.println("Machine Starting");
    }
}

