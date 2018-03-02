package test_fatherandson_method;

public class Main {
    public static void main(String[] args) {
        Father son = new Son();
        son.printData();
        Father father = son;
        father.printData();
    }
}
