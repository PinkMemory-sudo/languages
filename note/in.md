动态代理与cglib

代理模式：一个对象有另一个对象的实例，该对象就拥有另一个对象的同样的功能，在调用另一个对象的方法前后和抛出异常时做一些增强。SpringAOP使用动态代理完成了代码的动态织入。

jdk动态代理是jre提供给我们的类库，可以直接使用。



**JDK动态代理**

接口

实现类

目标对象

InvocationHandler实现类，重写invoke方法

JDK是利用反射机制生成一个实现代理接口的匿名领，再调用incokerHandler来处理。

成功；ib利用asm开元包，通过代理对象类的class文件，修改字节码文件生成子类。

JDK代理，目标和代理类实现同一个接口，本质就是根据目标对象和InvocationHandler实现类的invoked方法生成一个代理类来代理目标对象的功能



提供一个获得代理对象的方法。





JDK来实现代理模式，需要通过代理目标，目标的方法和方法的参数来完成代理对象中方法的功能，然后用Proxy的静态方法根据代理目标,**代理目标的接口**，和实现代理方法的类生成一个代理类。



为什么要使用代理？代理的好处



**JDK动态代理只能针对实现了接口的类进行代理**



从输入输出考虑

输入代理的目标，获得增强侯的代理对象

```java
public class JPtest implements InvocationHandler {

    private Object target;

    public JPtest() {
    }

    public JPtest(Object target) {
        this.target = target;
    }

    // 定义怎么增强
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JDK动态代理，监听开始！");
        Object result = method.invoke(target, args);
        System.out.println("JDK动态代理，监听结束！");
        return result;
    }

    //对外提供一个获得代理对象的方法
    private Object getJDKProxy(Object targetObject) {
        //JDK动态代理只能针对实现了接口的类进行代理，newProxyInstance 函数所需参数就可看出
        return Proxy.newProxyInstance(targetObject.getClass().getClassLoader(), targetObject.getClass().getInterfaces(), this);
    }

    public static void main(String[] args) {
        JPtest jdkProxy = new JPtest(new JdkProxyImpl());//实例化JDKProxy对象
        JdkTest user = (JdkTest) jdkProxy.getJDKProxy(new JdkProxyImpl());//获取代理对象
        user.sayHello();//执行代理
    }
}
```



**cglib**



cglib代理也可以叫子类代理，cglib是针对类来实现代理的，他的原理是对指定的目标类生成一个子类，并覆盖其中方法实现增强，但因为采用的是继承，所以不能对final修饰的类进行代理。

CGLIB包的底层是通过使用一个小而快的字节码处理框架ASM，来转换字节码并生成新的类。不鼓励直接使用ASM，因为它要求你必须对JVM内部结构包括class文件的格式和指令集都很熟悉。



















- Http请求的过程与原理
- TCP连接的特点
- TCP连接如何保证安全可靠的
- 为什么TCP连接需要三次握手，两次不可以吗，为什么

TCP/IP协议模型

应用层的HTTP、FTP、SMTP

传输层的TCP/UDP

网络层的IP协议





Java基础



Java加载顺序



类的加载时机



初始化顺序:

静态方法/静态代码块

非静态代码块

构造方法

































* Gson，Jackson，Fastjson

* 数组与集合的转换

* RestTemplate,HttpClient

* lockback

* 跨域复现

* Linux

* shell

* Kotlin

* Python

* awk

* 文件oss

* 正则

* MD5

* JUC集合

* 队列

* NIO

* 消息队列

* tomcat

* netty

* 编码

* Time API

* TreeSet

* TreeMap

* AOP

* 编码方式与字符集

* 定时任务

* oauth，登录

* 获得设备信息

* docker

* k8s

* maven

* 文件压缩

* 异常

* nginx

* Stream并行流

* 参数校验

* 抓包

* 缓存

* 事件ApplicationListener

* 四种网络模型

* 过滤器，拦截器

* 分布式

* 邮件发送

* MySQL，锁

* 设计模式

* ftp

* Hadoop

* 加密

  



1. Linux



























resume































智能预警

1. hive，shell，python，ftp，密钥，linux，Hadoop













































