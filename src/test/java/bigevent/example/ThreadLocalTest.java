package bigevent.example;

import org.junit.jupiter.api.Test;

public class ThreadLocalTest {

    @Test
    public void testThreadLocalSetAndGet(){
        // 提供一个ThreadLocl对象
        ThreadLocal tl = new ThreadLocal();

        // 开启两个线程
        new Thread(() -> {
            // 在线程1中设置值
            tl.set("线程1的值");
            tl.get();
            // 获取值
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
        }, "蓝色").start();
        new Thread(() -> {
            // 在线程1中设置值
            tl.set("线程2的值");
            tl.get();
            // 获取值
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
            System.out.println(Thread.currentThread().getName() + ":" + tl.get());
        }, "绿色").start();
    }
}
