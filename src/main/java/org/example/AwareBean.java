package org.example;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class AwareBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    @Override
    public void setBeanName(String name) {
        System.out.println("3、BeanNameAware setBeanName: " + name);
        // 在这里可以根据 Bean 的名称执行特定的操作
        if ("myAwareBean".equals(name)) {
            System.out.println("This is myAwareBean");
        }
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) {
        System.out.println("3、BeanFactoryAware setBeanFactory");
        // 在这里可以获取其他 Bean 实例
        MyService myService = beanFactory.getBean(MyService.class);
//        myService.doSomething();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        System.out.println("3、ApplicationContextAware setApplicationContext");
        // 在这里可以获取 Spring 应用上下文中的其他 Bean
        MyService myService = applicationContext.getBean(MyService.class);
//        myService.doSomething();
    }
}
