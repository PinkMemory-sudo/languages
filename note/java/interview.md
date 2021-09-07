# Basic



**==与equals的区别**



**面向对象和面向过程的区别**



**什么是字节码，采用字节码的好处**



**Java采用什么编码方案，有何特点**



**能否重写父类的构造方法**



**String为什么不可变**



**一个无参的构造方法有什么用**



**成员变量和局部变量的区别**



**静态方法和成员方法的不同**



**调用总类构造方法时会调用父类的构造方法，为什么**



**什么是多态，Java是如何实现的**



**Java中有没有指针**



**math中常用的方法**





## 变量

char能不能转int，String，double



**浮点型数据应该怎么计算**



**Java是值传递还是引用传递**



**如何颠倒一个数组的顺序**









## 面向对象



## 字符串



## 日期

55道



## 异常



**Java 的基础类型和字节大小**

boolean 	    8位

byte			    8位

char			    8位

short	  		16位

int				   32位

long				64位

float				32位

double			64位



**final关键字的作用**

被 final 修饰的变量不可以被改变，  如果修饰引用,那么引用不可变,引用指向的内容可变

被 final 修饰的方法,可以继承但不能重写，JVM 会尝试将其内联,以提高运行效率

被 final 修饰的类不可以被继承(断子绝孙类)



**为什么匿名内部类和局部内部类只能访问局部final变量**

内部类和外部类是同一级别的，不会因为外部类执行完就回收内部类。

当外部类执行完销毁时，可能内部类还没执行完，需要用到外部类的变量。解决办法就是内部类会复制一份外部类中的局部变量来作为内部类的类变量，但是为了与外部类保持一致，就需要使用到final来控制。



**四个访问修饰符合访问级别**  

类中的，同包的，子类的，公共的：private，protected，友好的，public

​         

**成员变量和局部变量的区别有哪些**

* 成员变量属于对象，存在堆中，局部变量存在栈中，所以生命周期不相同
* 成员变量有默认值，局部变量没有默认值



**static都有哪些用法**  

static可以作用于变量,方法，代码块，内部类。

被static修饰，会在类被加载的时候就加载，被所有的对象所共享，在内存中只有一个副本。不依赖于对象，可以直接调用。



**static代码块和普通代码块的区别**

static代码块只在类加载的时候执行一次，普通代码块会在每次创建对象时执行一次



**abstract class 和 interface 有什么区别**

由abstract修饰的方法叫抽象方法;由abstract修饰的类叫抽象类。抽象类就是一个还不完善的类

在软件工程中,接口泛指供别人调用的方法或者函数， 在Java语言中,接口是对行为的抽象,是**方法声明的集合**(主要)

* 类用来定义属性和行为，而接口则主要声明类要实现的行为。
* 接口没有构造方法，抽象类中可以定义构造函数(声明通用的构造函数)
* Java8前，接口中都是抽象方法(java8新增default和非抽象方法, jdk9以后可以有private，9之前定义private会便宜报错的 )，抽象类中可以有抽象方法，也可以有实现的方法
*  接口中只能由static 和 final 变量 ，不能有其他成员变量

   

**内部类有什么作用**



​         

**Object 中有哪些公共方法**

hashCode(),返回对象的hash值，主要为了方便计算散列表的索引

equale()与==是一样的，用来比较地址。子类一般需要重写该方法，来比较内容。

toString()返回对象的文本表达形式

clone()对象的浅拷贝(只有实现了 Cloneable 接口才可以调用该方法)

getClass()获得对象的class

notify()

notifyAll()

wait()

finalize()



**&和&&的区别**

两者都可以进行逻辑与运算，&是按位与。&&具用断路功能，即第一个表达式为false时不在进行逻辑与直接返回



   

说几个常见的编译时异常 

**throw 和 throws 的区别**

throw用来抛出一个异常对象，作用在方法内部

throws表示出现异常的一种可能性，作用在方法名后



 运行时异常与一般异常有何异同  

  

**方法重载的规则**

同名不同参，其他的异常，返回值等无关



方法重写的规则

重载和重写的区别   







内存泄漏和内存溢出

什么是反射  



反射的作用

反射中，Class.forName()和 ClassLoader.loadClass()的区别？



**String、StringBuilder、StringBuffer 区别**  

String是不可变字符，都会生成一个新对象(会转成StringBuilder，然后append，再toString)，所以在进行大量字符串拼接是会产生许多对象

StringBuilder只产生一个对象，然后一直append来拼接

StringBuffer与StringBuilder相同，但是StringBuffer是线程安全的



**String str="hello world"和String str=new String("hello world")的区别**

使用""创建的字符串存储在堆中的字符串常量池中，相同的内容只会存储一份。new String()，通过new创建出来的字符串存储是在堆内存中，不会去检查是否存在。



**String a = "hello2"; String b = "hello" + 2; System.out.println((a == b));会输出什么**

true， "hello" + 2会在编译时被jvm优化成"hello2"，所以a和b是同一个对象



**String a = "hello2"; 　 String b = "hello";    String c = b + 2;    System.out.println((a == c));的输出结果**

false 因为c是间接相加的，jvm不会对引用变量进行优化



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







**代码块与构造函数的执行优先级**





**哪些方法不能被重写**

​         

静态类型有什么特点



深拷贝和浅拷贝的区别是什么 



什么是值传递和引用传递

​    

**switch 能否作用在 byte、long、string 上** 

switch 可作用在 char、byte、short、int(小于等于int的数字)及他们的包装类上和String



Iterator   遍历时修改？



## 反射



获取 Class对象 的三种方式       

* 通过实例获得：对象.getClass()方法
* 通过类名获得：类名.class
* 通过Class获得：Class.forName("xxx")



**通过反射实例化对象和通过new实例化对象那个效率高**





# IO

**Java有几种类型的流**



**BIO,NIO,AIO的区别**



**Files常用的方法**



**字节流和字符流的区别**



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

* 数据结构
* 扩容
* 性能



72道



**List和Set的区别**



**ArrayList与LinkedList的区别**

两者的区别主要是底层的数据结构引起的。

ArrayList的数据结构是数组，它是一片连续的存储空间，所以可以做到随机访问。

LinkedList的数据结构是链表，分散存储在内存中，不能随机访问，并且占用的空间要大一些。

ArrayList在添加元素时可能会出发扩容，不在尾部添加时还需要移动(把插入的那个位置空出来)，而LinkedList只需要改变指针就行。

LinkedList不要使用for循环遍历，因为git(i)每次都会又从头开始查。



**List、Map、Set 三个接口存取元素时，各有什么特点**  



**Java 集合类：list、set、queue、map、stack 的特点与用法**  



**set怎么保证不重复的**

set进行add时，实际调用的是HashMap的put方法，会先判断元素的hashcode，如果不相同，则认为是两个不同的对象，直接插入，如果相同，则进一步调用equals来比较。



**HashSet 的底层实现是什么**  



**说出 ArrayList,Vector, LinkedList 的存储性能和特性**

ArrayList的底层数据结构是数组，需要一片连续的存储空间，所以可以进行随机访问，适合进查询

LinkedList的底层数据结构是双向链表，适合进行增加删除操作



**Hashtable 和 Hashmap 的区别**

* HashTable是线程安全的，HashMap线程非安全
* Hashtable 不允许 null 值HashMap 允许 null 值(key 和value 都可以)



**TreeMap、HashMap、LindedHashMap 的区别**   



**为什么重写 equals 时必须重写 hashCode 方法**

默认情况下，hashCode是对象在堆中的一个特殊值，而equals比较的则是在堆中的地址，所以无论如何，每个对象的hashcode和equals都不会相同。对象的hashcode主要用来计算出该对象在hash表中的索引，然后equals来比较两个对象是否相同这样就减少了比较的次数；在set中，会先根据hashcode计算出索引比较是否相同，有的还在调用equals比较对象是否相同来保证元素不重复，如果equals相同但是hashcode不同，可能计算出来的索引不同，就不能保证元素不重复。

所以必须保证：

equals相同时，hashCode也一定要相同。所以重写了equals方法，则生成hashcode的条件也要发生改变。



**Java 中==和 equals()的区别**    

==

用来比较**栈中的值**，基本数据类型比较的是值，引用数据类型在栈中保存的是对象的引用，所以比较的是对象的地址。

equals

object中的equals()与==相同，所以没有重写equals时，==和equal是相等的。通常都会重写equals，比如String就重写了equals。







**HashSet 和 TreeSet 有什么区别**

**什么是迭代器(Iterator)**

 



**Iterator 和 ListIterator 的区别是什么？**

* Iterator是遍历Collection的通用的方法，ListIterator 只能用来遍历LIst

* Iterator 对集合只能是前向遍历，ListIterator 既可以前向也可以后向
*  ListIterator 实现了 Iterator 接口，并包含其他的功能，比如：增加元素，替换元素，获取前一个和后一个元素的索引，等等





​         实现集合的排序 

​         ArrayList 源码分析  

​         HashMap 源码分析  

​         ConcurrentHashMap 源码分析   

**Comparable 和 Comparator接口的区别**  

这两个接口主要用来对集合进行排序。

实现Comparable接口的类，可以直接用来排序。通过Collections.sort()来排序。

而没有实现Comparable接口的类要想排序，需要定义一个比较器。通过list.sort,传入一个Comparator来排序。

Comparable实现compareTo来定义与跟一个对象的比较方法

Comparator实现compare方法定义两个对象的比较

第一个参数-第二个参数为升序









Java中  String、Byte、Char、Date 等大量的类都实现了Compareable接口。



# JVM

​         内存划分  

​         什么是 Java 虚拟机？为什么 Java 被称作是无关平台的编程语言  

​         如何判断一个对象应该被回收  



**什么是JVM，JVM都包括什么**



**如果对象的引用被置为null，GC是否会立即释放对象占用的空间**



**串行收集器和吞吐量收集器的区别**



常量池

**字符串常量池到底存在于内存空间的哪里**  



 **Java 中的编译期常量是什么？**

编译时就能够知道变量的值并且值不会再改变的变量，会直接替换成值。这种就是编译期常量(即使那种final修饰的并且直接赋值的)



# JUC

notify，线程通信

锁



**线程同步的方法**





# Java8新特性



Stream API，充分利用现代多核 CPU  

**Time API**  

接口  



 JDK 1.7 中的新特性

​         **try-with-resource**  

​         Fork-Join  

​         **Switch**   

​         菱形操作符**(<>)用于类型推断**  

JDK1.8的新特性

































make PREFIX=~/2022/redis/ install





## 为什么不建议使用Arrays.asList、ArrayList的subList





设计模式

66道