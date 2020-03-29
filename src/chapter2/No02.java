package chapter2;

/**
 * 实现Singleton模式
 */

public class No02 {


    public static void main(String[] args) {


        C.test();

        C.getInstance();

        System.out.println(C.getInstance());
    }
}

/**
 * 饿汉式，线程安全
 */
class A{
    private static final A instance = new A();

    private A(){}

    public static A getInstance(){
        return instance;
    }

}

/**
 * 懒汉式，两次加锁
 */
class B{
    private static volatile B instance = null;

    private B(){}

    public static B getInstance(){
        if(instance==null){
            synchronized(B.class){
                if(instance==null){
                    instance = new B();
                }
            }
        }
        return instance;
    }


}
class C{
    private C(){
        System.out.println("执行了C()方法！");
    }

    public static C getInstance(){
        System.out.println("执行了getInstance()方法！");
        return Clazz.instance;
    }

    private static class Clazz{
        private static final C instance = new C();
    }

    public static void test(){

    }
}