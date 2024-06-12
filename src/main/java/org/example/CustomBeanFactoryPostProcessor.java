package org.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.stereotype.Component;

@Component
public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

    /***
     * BeanFactoryPostProcessor 是 Spring 提供的一个扩展点，它允许在容器标准初始化之后对 Bean 定义（配置元数据）进行修改。
     * BeanFactoryPostProcessor 在所有 Bean 实例化之前执行，因此它可以对 Bean 的定义进行修改或添加特定的属性。
     *
     * 常见用途
     * 修改 Bean 定义属性：可以动态修改 Bean 的属性值。
     * 注册新的 Bean 定义：可以动态添加新的 Bean 定义。
     * 条件性注册：根据某些条件注册或修改 Bean 定义。
     * @param beanFactory
     * @throws BeansException
     */
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        System.out.println("1、CustomBeanFactoryPostProcessor postProcessBeanFactory");

        // 修改 MyService Bean 的某个属性值
       /* if (beanFactory.containsBeanDefinition("myService")) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition("myService");
            beanDefinition.getPropertyValues().add("someProperty", "newValue");
        } */

        if (beanFactory instanceof BeanDefinitionRegistry) {
            BeanDefinitionRegistry registry = (BeanDefinitionRegistry) beanFactory;

            // 注册一个新的 Bean 定义
            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(NewBean.class);
            registry.registerBeanDefinition("newBean", beanDefinitionBuilder.getBeanDefinition());
        }

        // 条件性修改某个 Bean 的定义
       /* if (beanFactory.containsBeanDefinition("someBean")) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition("someBean");

            // 假设我们有一个条件判断
            boolean someCondition = true; // 这里可以是任意条件判断逻辑
            if (someCondition) {
                beanDefinition.setScope(BeanDefinition.SCOPE_PROTOTYPE);
            }
        }*/
    }
}

class NewBean {
    public NewBean() {
        System.out.println("NewBean Constructor");
    }
}
