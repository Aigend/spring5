1. 下载jar包：
    https://repo.spring.io/ui/repos/tree/General/release/org/springframework/spring/5.2.6.RELEASE
2. 配置bean.xml
3. xml:
    - 工厂bean
    - bean的作用域：spring 可以设置创建的实例是单实例还是多实例，默认是单实例
    - bean的生命周期：
      1. 通过构造器创建bean实例
      2. 为bean的属性设置值和对其他bean的引用(调用set方法)
      3. 初始化前，把bean的实例传递给bean后置处理器方法（需要添加后置处理器，创建类实现BeanPostProcessor）
      4. 调用bean的初始化方法：需要额外配置初始化方法
      5. 初始化后，把bean的实例传递给bean后置处理器方法（需要添加后置处理器，创建类实现BeanPostProcessor）
      6. bean可以使用了
      7. 容器关闭，调用bean的销毁方法：需要额外配置销毁的方法
    - xml自动装配：根据指定的装配规则（属性名称或者属性类型）
    - bean 引入外部的属性文件properties,配置数据的库的连接池（引入druid1.1.9数据库操作的jar包）：https://repo1.maven.org/maven2/com/alibaba/druid/1.1.19/
    - 注解方式管理bean: 1.使用需要引入aop包依赖 2.开启组件扫描
      @注解名称(属性名称=属性值，属性名称=属性值)
      注解用在类，属性，方法上面，简化bean xml配置
      Component 
      Service 
      Controller 
      Repository
    - 配置注解的扫描方式，针对哪些包进行扫描，哪些包不进行扫描
    - 基于注解实现属性注入 
      @AutoWired:根据属性类型自动进行装配
      @Qualifier:根据属性名称进行注入, 可以和AutoWired 一起使用
      @Resource:可以根据属性名称，可以根据属性类型注入
      @Value:注入普通类型属性
    - 完全注解开发：不需要xml配置文件
      1. 创建配置类
      