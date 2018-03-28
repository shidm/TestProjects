package generic;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 为何报错：因为? extends Fruit并没有指定具体的类型，只是指定了一个范围
        Plate<? extends Fruit> ep = new Plate<Apple>(new Apple());

//        ep.set(new Apple());
        ep.get();

        //
        Plate<? super Fruit> sp = new Plate<Fruit>(new Apple());

        sp.set(new Apple());
        sp.get();
        test(new LinkedList());
    }

    private static <T extends List> void test(T list){

    }
}
