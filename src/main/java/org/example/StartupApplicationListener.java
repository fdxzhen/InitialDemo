package org.example;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/***
 *@see StartupApplicationListener 类通常用于在 Spring 应用程序启动完成后执行一些初始化操作。
 * @see ContextRefreshedEvent 事件表示 Spring 应用上下文已经初始化完成。
 * @see StartupApplicationListener 类的作用是在 Spring 应用上下文初始化完成后执行一些初始化任务。
 */
@Component
public class StartupApplicationListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("7、ContextRefreshedEvent triggered");
        // 在这里执行一些初始化操作
        initializeApplication();
    }

    private void initializeApplication() {
        // 在这里执行一些初始化操作，比如加载配置、启动定时任务等
        System.out.println("Initializing application...");
    }
}
