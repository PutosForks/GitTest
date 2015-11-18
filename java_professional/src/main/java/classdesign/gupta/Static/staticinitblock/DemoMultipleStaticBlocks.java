/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classdesign.gupta.Static.staticinitblock;

/**
 *
 * @author 502413934
 */
public class DemoMultipleStaticBlocks {

    static {
        staticVar = 10; 
    }
    static int staticVar = 0;

    static {
        ++staticVar;
    }

    public DemoMultipleStaticBlocks() {
        System.out.println("Constructor:" + staticVar);
    }

    public static void main(String args[]) {
        new DemoMultipleStaticBlocks();
    }
}
