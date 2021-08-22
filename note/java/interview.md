# Basic



类变量，方法，构造函数等的初始化顺序



final关键字的作用

被 final 修饰的变量不可以被改变，  如果修饰引用,那么引用不可变,引用指向的内容可变

被 final 修饰的方法,可以继承但不能重写，JVM 会尝试将其内联,以提高运行效率

被 final 修饰的类不可以被继承(断子绝孙类)





Java 的基础类型和字节大小



四个访问修饰符合访问级别  

​         

成员变量和局部变量的区别有哪些



​         静态方法和实例方法有何不同    



abstract class 和 interface 有什么区别?

由abstract修饰的方法叫抽象方法;由abstract修饰的类叫抽象类。抽象类就是一个还不完善的类

在软件工程中,接口泛指供别人调用的方法或者函数， 在Java语言中,接口是对行为的抽象,是**方法声明的集合**(主要)

* 类用来定义属性和行为，而接口则主要声明类要实现的行为。
* 接口没有构造方法，抽象类中可以定义构造函数(声明通用的构造函数)
* Java8前，接口中都是抽象方法(java8新增default和非抽象方法, jdk9以后可以有private，9之前定义private会便宜报错的 )，抽象类中可以有抽象方法，也可以有实现的方法
*  接口中只能由static 和 final 变量 ，不能有其他成员变量

​         

Java 创建对象的几种方式  

​         

Object 中有哪些公共方法



&和&&的区别



内部类有什么作用      

说几个常见的编译时异常 

throw 和 throws 的区别

​         运行时异常与一般异常有何异同  

  

方法重载的规则

方法重写的规则

重载和重写的区别   



​         List、Map、Set 三个接口存取元素时，各有什么特点  

​         Comparable 和 Comparator接口的区别  

Java 集合类：list、set、queue、map、stack 的特点与用法  



set怎么保证不重复的



HashSet 的底层实现是什么  



说出 ArrayList,Vector, LinkedList 的存储性能和特性？



Hashtable 和 Hashmap 的区别



​         TreeMap、HashMap、LindedHashMap 的区别   



为什么重写 equals 时必须重写 hashCode 方法



Java 中==和 equals()的区别    



HashSet 和 TreeSet 有什么区别



内存泄漏和内存溢出

​         什么是反射  



​         反射的作用

反射中，Class.forName()和 ClassLoader.loadClass()的区别？



String、StringBuilder、StringBuffer 区别  



强引用和软引用和弱引用以及虚引用 

​       

 数组在内存中如何分配



​        

 Java 中怎么创建一个不可变对象 



​        

 Java 中 ++ 操作符是线程安全的吗



​         

new 一个对象的过程和 clone 一个对象的过程

  

​         

final、finalize 和 finally 的不同之处  



Java 的多态表现在哪里



哪些类是不能被继承的



static都有哪些用法  

​         

静态类型有什么特点



深拷贝和浅拷贝的区别是什么 



什么是值传递和引用传递

​         switch 能否作用在 byte、long、string 上  

   

​            





# IO

1. Java有几种类型的流
2. 字节流与字符流怎么选
3. 缓冲区的作用
4. 缓冲流与缓冲区的区别
5. 字节流和字符流的区别
6. 什么是Java序列化，如何实现Java序列化
7. 什么是节点流和处理流
8. 各个read方法的含义
9. 字节数组流
10. read()与read(byte[] b)区别





# 容器

​         什么是迭代器(Iterator)  

 Iterator 和 ListIterator 的区别是什么？

​         实现集合的排序 

​         ArrayList 源码分析  

​         HashMap 源码分析  

​         ConcurrentHashMap 源码分析   



# JVM

​         内存划分  

​         什么是 Java 虚拟机？为什么 Java 被称作是无关平台的编程语言  

​         如何判断一个对象应该被回收  



常量池

​         字符串常量池到底存在于内存空间的哪里  

​         Java 中的编译期常量是什么？使用它又什么风险  



# JUC



# Java8新特性



​         JDK 1.7 中的新特性



JDK1.8的新特性

































make PREFIX=~/2022/redis/ install





## 为什么不建议使用Arrays.asList、ArrayList的subList



