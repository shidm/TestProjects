package enumtest;

import java.util.Observable;

public class Main {
    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//            for (Meal2 meal : Meal2.values()) {
//                Meal2.Food food = meal.randomSelection();
//                System.out.println(food);
//            }
//            System.out.println("---");
//        }

//        Object object = null;
//        "ss".equals(object);
//        Integer a = null;
//        Integer c = a;
//        System.out.println(c);

//        String str = "ab,,,s,,";
//        String tmp[] = str.split(",");
//        System.out.println(tmp.length);
//        System.out.println("\""+tmp[1]+"\"");
//
//        Test test1 = new Test("test1",1);
//        Test test2 = new Test("test2",2);
//        try {
//            Test test3 = (Test) test1.clone();
//            test3.setId(3);
//            System.out.println(test1.toString());
//            System.out.println(test3.toString());
//        } catch (CloneNotSupportedException e) {
//            e.printStackTrace();
//        }


    }

    static class Test implements Cloneable{
        private String name;
        private int id;

        public Test(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        @Override
        public String toString() {
            return "Test{" +
                    "name='" + name + '\'' +
                    ", id=" + id +
                    '}';
        }
    }



}
