package classdesign.gupta.Interface;

interface Interface {
    float degree = 0;
    float degree1 = 0;
    float degree2 = 0;
    float degree3 = 0;
    //static float degree4;
    // float degree5;
}


class Instance implements Interface {

    float degree = 2;

    public static void main(String[] args) {
        Instance instance = new Instance();
        System.out.println(instance.degree);
        System.out.println(Interface.degree3);
    }

    void test() {
        //degree3++;
    }


}
