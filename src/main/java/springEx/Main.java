package springEx;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by WORK_x64 on 13.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("springEx.xml");
        FooService foo = (FooService) ctx.getBean("fooService1");
        System.out.println(foo.fooService.doStuff());
        ctx.close();
    }
}
