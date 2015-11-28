package classdesign.gupta.abstractclass;

class Base {

    int dummy;

    Base(int dummy) {
        this.dummy = dummy;
    }

}

class Derived extends Base {

    Derived() {     // without this constructor class won't compile
        super(1);
    }
}
