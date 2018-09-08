package com.loyofo.core.s6_interface.e1_interface.f1_innerPkg;

import com.loyofo.core.s6_interface.e1_interface.ConstantInterface;
import static com.loyofo.core.s6_interface.e1_interface.ConstantsClass.*;



/**
 * @author luojbin
 * @version 1.0
 * @create 2018-09-08
 */
public class ConstantsStaticImport {
    public static void main(String[] args){
        System.out.println(ConstantInterface.A);
        System.out.println(D);

        // ConstantsClass c = new ConstantsClass();
        // instance.geta();

        ConstantsStaticImport csi = new ConstantsStaticImport();
    }



}
