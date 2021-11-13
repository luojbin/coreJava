package com.loyofo.core.s7_asserLog.e1_try;

public class TryFinallyReturn {

    public static void main(String[] args) {
        try{
            System.out.println(getEx());
        } catch (Exception e) {
            System.out.println("抓到异常: " + e.getMessage());
            System.out.println("还有被抑制的" + e.getSuppressed()[0]);
        }
    }

    static int get() {
        int a = 1;
        try {
            return ++a;
        } finally {
            return ++a;
        }
    }

    static String getEx() {
        Exception ex = null;
        try {
            try {
                System.out.println("内层的try");
                if (true) {
                    throw new RuntimeException("内层try抛的异常");
                }
                return "没毛病";
            } catch (Exception e1) {
                ex = e1;
                throw e1;
            }
        } finally {
            try {
                System.out.println("finally 的 try");
                if (true) {
                    System.out.println("finally 也想抛异常");
                    throw new RuntimeException("finally 抛的异常");
                }
            } catch (Exception e2) {
                if (ex == null) {
                    throw e2;
                } else {
                    ex.addSuppressed(e2);
                }
            }
        }
    }
}
