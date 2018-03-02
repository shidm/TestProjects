package reflect;

import reflect.pojo.User;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) {
        try {
            //使用ClassLoader
            reflectForClassLoader();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //直接使用Class
        reflectForClass();

        try {
            testPrivateMethod();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void reflectForClass() {
        try {
            Class clazz = Class.forName("reflect.pojo.User");

            /*
            * Object object = constructor.newInstance("lala","woman","20","xiangzhou");
            *   与
            * Object obj = clazz.newInstance();区别是-------上一个可以指定某一个构造函数，而下一个指定默认的无参构造函数
            * */

            Constructor constructor = clazz.getConstructor(String.class,String.class,String.class,String.class);
            Object object = constructor.newInstance("lala","woman","20","xiangzhou");

            Object obj = clazz.newInstance();

            Method method = clazz.getMethod("getName",null);
            System.out.println(method.invoke(object,null));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void reflectForClassLoader() throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class clazz = classLoader.loadClass("reflect.pojo.User");
        try {
            Constructor constructor = clazz.getConstructor(String.class,String.class,String.class,String.class);
            Method method = clazz.getMethod("getName",null);
            Object object = constructor.newInstance("sdm","男","22","香洲");
//            Object obj = clazz.newInstance();
//            Method md = clazz.getMethod("setName",String.class);
//            md.invoke(obj,"NB");
//            System.out.println(((User)obj).getName());
            System.out.println(method.invoke(object,null));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void testPrivateMethod() throws ClassNotFoundException {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        Class clazz = classLoader.loadClass("reflect.pojo.User");
        try {
            Constructor constructor = clazz.getConstructor(String.class,String.class,String.class,String.class);
            Method method = clazz.getDeclaredMethod("privateTest",String.class);
            method.setAccessible(true);
            Object object = constructor.newInstance("sdm","男","22","香洲");
            System.out.println(method.invoke(object,"私有方法测试"));
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
