package top.wangyd.demo;

import java.io.IOException;

/**
 * @author wang
 * @date 2018年11月29日11:22:56
 */
public class System {
    public static void main(String[] args) {
        try {
            Runtime.getRuntime().exec("shutdown -s");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
