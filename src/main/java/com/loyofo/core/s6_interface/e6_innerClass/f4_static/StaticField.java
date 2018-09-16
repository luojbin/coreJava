package com.loyofo.core.s6_interface.e6_innerClass.f4_static;

public class StaticField {
    String field = "非静态域";
    static String sField = "静态域";

    class InnerA {
        String innerField = "内部类非静态域";
        // static String innerSField = "内部类静态域";

        public void testField(){
            field = "InnerA 修改" + field;
            sField = "InnerA 修改" + sField;
        }
    }

    static class InnerBS {
        String innerField = "内部类非静态域";
        static String innerSField = "内部类静态域";

        public void testField() {
            // field = "InnerB 修改" + field;
            sField = "InnerB 修改" + sField;
            innerField = "InnerB 修改" + innerField;
            innerSField = "InnerB 修改" + innerSField;
        }
    }
}
