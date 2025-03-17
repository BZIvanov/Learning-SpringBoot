package com.example.demo;

import com.example.demo.service.PrototypeBean;
import com.example.demo.service.SingletonBean;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner {
    private final ApplicationContext context;

    public DemoRunner(ApplicationContext context) {
        this.context = context;
    }

    @Override
    public void run(String... args) throws Exception {
        // SINGLETON BEANS
        SingletonBean sbean1 = context.getBean(SingletonBean.class);
        SingletonBean sbean2 = context.getBean(SingletonBean.class);
        // the same instance will be used for each bean
        System.out.println("SINGLETON BEAN 1: " + sbean1);
        System.out.println("SINGLETON BEAN 2: " + sbean2);

        // PROTOTYPE BEANS
        PrototypeBean pbean1 = context.getBean(PrototypeBean.class);
        PrototypeBean pbean2 = context.getBean(PrototypeBean.class);
        // new instance will be created for each bean
        System.out.println("PROTOTYPE BEAN 1: " + pbean1);
        System.out.println("PROTOTYPE BEAN 2: " + pbean2);
    }
}
