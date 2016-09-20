package com.thoughtworks;

/**
 * Created by peter on 2016/9/20 0020.
 */
public class Application {
    public static void main(String[] args) {
        try {
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            System.out.println("peter");
        }

    }
}
