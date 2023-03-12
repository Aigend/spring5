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
    
4. AOP编程，面向切面编程，其实就是python中的装饰器，不通过修改源代码而实现添加新的功能
   底层通过动态代理的方式实现：
   1. 有接口的情况：使用JDK动态代理，创建接口实现类代理对象，增强类的方法
   2. 没有接口情况，原始方式是实现子类，重写父类的方法，并增强功能;创建当前类子类的代理对象
   class User{
      public void add(){...}
   }
   class Person extends User{
      public void add(){
      .....
      super.add();
      ....
      }
   }
   3. 术语
      - 连接点：类里能被增强的方法，叫做连接点
      - 切入点：实际被增强的方法，叫做切入点
      - 增强（通知）：实际增强的部分成为增强：前置通知（方法前），后置通知（方法后），环绕通知(方法前后)，异常通知（），最终通知（finally)
      - 切面：是动作，把通知应用到切入点的过程
   4. aop一般是基于AspectJ实现， AspectJ不是spring框架组成部分，是独立的Aop框架
      基于AspectJ实现AOP操作：基于XML配置文件实现；基于注解方式实现
      - 切入点表达式：execution([权限修饰符][返回类型][类全路径名][方法名称][参数列表])
      - execution(* org.example.Book.add(...)) // 对add 方法进行增强
      - execution(* org.example.Book.*(...)) //类中所有方法进行增强
      - execution(* org.example.*.*(...)) //所有类所有方法增强
      进行通知的配置：
      1. 在spring配置文件中，开启注解扫描
      2. 使用注解创建User和UserProxy对象
      3. 在增强类上面添加@Aspect
      4. 在spring配置文件中开启生成代理对象
      