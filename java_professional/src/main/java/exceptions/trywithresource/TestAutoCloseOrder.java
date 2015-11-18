package exceptions.trywithresource;

class MyResource implements AutoCloseable {
    String name;

    MyResource(String name) {
        this.name = name;
        System.out.println("Created:" + name);
    }

    public void close() {
        System.out.println("Closed:" + name);
    }
}

class TestAutoCloseOrder {
    public static void main(String args[]) {
        try (MyResource res1 = new MyResource("1");
             MyResource res2 = new MyResource("2")) {
            System.out.println("within try-with-resources");
        } finally {
            System.out.println("finally");
        }
    }
}