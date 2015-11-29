package oop.factory.methodfactory;

/*
Spice Digital Inc. company now decided to makes their global presence. They want to extend their business to London
and NewYork location. Looking at the market interest, London factory will produce only SpiceBolt and SpiceFire model
and New York will produce SpiceFire and SpicePlus.
 */

public abstract class SpiceMobile {
    public double price;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract void prepare();

    public abstract void bundle();

    public abstract void label();
}

// three products which are produced
class SpiceBolt extends SpiceMobile {

    @Override
    public void prepare() {
    }

    @Override
    public void bundle() {
    }

    @Override
    public void label() {
    }
}

class SpiceFire extends SpiceMobile {

    @Override
    public void prepare() {
    }

    @Override
    public void bundle() {
    }

    @Override
    public void label() {
    }
}

class SpicePlus extends SpiceMobile {

    @Override
    public void prepare() {
    }

    @Override
    public void bundle() {
    }

    @Override
    public void label() {
    }
}


// abstract factory

abstract class MobileFactory {

    abstract SpiceMobile constructMobile(String modelName);

    public SpiceMobile produceMobile(String modelName) {
        SpiceMobile spiceMobile = constructMobile(modelName);

        spiceMobile.bundle();
        spiceMobile.prepare();
        spiceMobile.label();

        return spiceMobile;

    }


}

// two factories which produce mobiles
class NyFactory extends MobileFactory {

    SpiceMobile constructMobile(String modelName) {

        SpiceMobile mobile = null;

        if (modelName.equalsIgnoreCase("bolt")) {
            mobile = new SpiceBolt();
            mobile.setPrice(300);
        } else if (modelName.equalsIgnoreCase("fire")) {
            mobile = new SpiceFire();
            mobile.setPrice(400);
        }

        return mobile;

    }

}


class LondonFactory extends MobileFactory {

    SpiceMobile constructMobile(String modelName) {

        SpiceMobile mobile = null;

        if (modelName.equalsIgnoreCase("bolt")) {
            mobile = new SpiceBolt();
            mobile.setPrice(300);
        } else if (modelName.equalsIgnoreCase("plus")) {
            mobile = new SpiceFire();
            mobile.setPrice(600);
        }

        return mobile;

    }

}


class FactoryTest {
    public static void main(String[] args) {
        MobileFactory f = new LondonFactory();
        SpiceMobile mobile = f.produceMobile("plus");
        System.out.println(mobile.getPrice());
    }

}