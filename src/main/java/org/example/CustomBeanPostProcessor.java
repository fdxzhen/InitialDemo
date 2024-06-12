package org.example;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;
import java.util.Objects;

@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    /***
     * BeanPostProcessor 是 Spring 提供的一个扩展点，它允许在 Spring 容器实例化和初始化 Bean 的前后添加自定义逻辑。BeanPostProcessor 的典型用途包括：
     *
     * 初始化前后的自定义逻辑：可以在 Bean 初始化前后执行一些操作，比如设置一些额外的属性，或者执行某些初始化逻辑。
     * 代理对象：可以返回一个代理对象以替换原始的 Bean 实例，实现 AOP 或其他拦截逻辑。
     * 条件性处理：根据 Bean 的类型或名称有选择地处理某些 Bean。
     */
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (Objects.equals(beanName, "myService")) {
            System.out.println("2、CustomBeanPostProcessor postProcessBeforeInitialization: " + beanName);
            // 可以在这里执行一些初始化前的逻辑，比如设置默认值
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (Objects.equals(beanName, "myService")) {
            System.out.println("2、CustomBeanPostProcessor postProcessAfterInitialization: " + beanName);
            // 可以在这里执行一些初始化后的逻辑，比如开启一个代理
            // 创建代理对象
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(bean.getClass());
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    System.out.println("Before method: " + method.getName());
                    Object result = proxy.invoke(bean, args);
                    System.out.println("After method: " + method.getName());
                    return result;
                }
            });
            return enhancer.create();
        }
        return bean;
    }
}
