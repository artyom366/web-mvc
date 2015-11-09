package lv.test.app.test;

import org.springframework.stereotype.Component;

/**
 * Created by artyom on 15.9.11.
 */

@Component
public class Test implements ITest {

    @Override
    public void run() {
        System.out.println("---------------------------- test");
    }
}
