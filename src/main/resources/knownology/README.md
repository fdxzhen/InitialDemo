# CustomBeanFactoryPostProcessor postProcessBeanFactory:

这个方法在Spring容器初始化时被调用，并且在所有Bean定义（Bean Definitions）已经加载但还没有初始化任何Bean实例之前执行。
主要作用：
可以修改Bean定义，例如改变Bean的scope，属性值等。
可以为某些Bean动态添加或修改依赖关系。
# CustomBeanPostProcessor postProcessBeforeInitialization:

这个方法在每个Bean实例化之后，但在其初始化方法（例如afterPropertiesSet或自定义的初始化方法）之前被调用。
主要作用：
可以在Bean初始化之前对Bean进行一些额外处理，比如设置某些属性值，代理增强等。
# CustomBeanPostProcessor postProcessAfterInitialization:

这个方法在每个Bean初始化方法之后被调用。
主要作用：
可以在Bean完全初始化后对Bean进行处理，例如对某些Bean做代理包装等。
# BeanNameAware setBeanName: awareBean:

当一个Bean实现BeanNameAware接口时，Spring会在Bean初始化之前调用此方法，将Bean的名字传递给Bean实例。
主要作用：
Bean可以知道自己在容器中的名字，这在某些情况下（例如需要根据名字做特定逻辑）是有用的。
# BeanFactoryAware setBeanFactory:

当一个Bean实现BeanFactoryAware接口时，Spring会在Bean初始化之前调用此方法，将当前的BeanFactory实例传递给Bean。
主要作用：
使得Bean可以访问BeanFactory来获取其他Bean实例或进行某些自定义操作。
# ApplicationContextAware setApplicationContext:

当一个Bean实现ApplicationContextAware接口时，Spring会在Bean初始化之前调用此方法，将当前的ApplicationContext实例传递给Bean。
主要作用：
使得Bean可以访问整个应用上下文，比如获取其他Bean、发布事件等。
# MyComponent Constructor:

这是一个自定义组件的构造函数，在Bean实例化时被调用。
主要作用：
初始化MyComponent实例，可以在构造函数中做一些初始化逻辑。
# MyRepository Constructor:

这是一个自定义仓库（Repository）类的构造函数，在Bean实例化时被调用。
主要作用：
初始化MyRepository实例，可以在构造函数中做一些初始化逻辑。
# MyService Constructor:

这是一个自定义服务（Service）类的构造函数，在Bean实例化时被调用。
主要作用：
初始化MyService实例，可以在构造函数中做一些初始化逻辑。
# MyService PostConstruct:

这是一个标记为@PostConstruct的方法，在Bean的依赖注入完成之后立即被调用。
主要作用：
在Bean完全初始化后执行一些自定义初始化逻辑，例如资源加载、依赖检查等。
# ContextRefreshedEvent triggered:

这是一个Spring的上下文刷新事件，在所有Bean都完全初始化并且应用上下文已准备就绪之后发布。
主要作用：
可以在这个事件中执行一些应用启动后的逻辑，例如启动一些后台任务、进行数据预加载等。