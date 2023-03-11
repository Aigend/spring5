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