class

* 构造方法
* 成员
* 实例
* 继承
* 抽象类
* class header在哪定义的？
* 实例化过程
* 主构造函数与次构造函数的区别与关系
* This
* 包和类，方法的关系
* 适合来干什么
* :类型，返回值，继承

* 变量
* 函数
* 对象
* 类
* 构造函数
* 判空
* 集合
* IO





**与Java的关系**

​		Kotlin除了语法与java不一样外，其余的与java一样。它编译生成的也是.class文件，也可以打包成jar，并能通过java命令进行该jar。









### 编译期常量

​		满足三个条件

* 位于顶层或者是 object 声明 或 companion object 的一个成员
* 以 String 或原生类型值初始化

### 延迟初始化属性和变量

​		属性为非空类型必须在构造函数中初始化，但在一些情况下，属性需要通过依赖注入的方式来初始化或者在单元测试中的setup中初始化，可以用lateinit来修饰，自 Kotlin 1.2 起，也用于顶层属性与局部变量。该属性或变量必须为非空类型，并且不能是原生类型。在初始化前使用会抛异常，可以通过 isInitialized来检查是否初始化了。





































### 1. 参数

参数名 ： 参数类型[?]	加?表示可以为空













































### 常用方法

yield

yieldAll

take





























# 与Java的一些不同

## 1. class对象

***Java的class与kotlin的class***

## 2. package

​		kotlin使用关键字package进行定义。包名并不一定要与文件夹名对应，因为编译时会自动生成相应的路径，并将class文件放入其中。

## 3. 类与文件

## 4. import与as

​		基本用法与java一样。但可以通过***as***关键字为指定的类定义别名——可以避免一个类中引入多个同名类导致的某些类必须得写命名的问题。

## 5. 三目运算符

​		kotlin中没用三目运算符，可以使用a=if(expression)b?c

## 6. continue

​		kotlin中没有continue，使用return@。。。

is 用来进行类型判断



### kotlin Standard Library





***习惯用法***

* 创建DTO
* 指定参数默认值
* 检测元素是否存在于集合中
* If not null 缩写?.  If not null and else 缩写  ?.属性?:默认值
* ?: 值  前面的值为空时显示后面的
* ?. 前面的值不为空时执行后面的
* 交换两个变量  a=b.also{b=a}   also(block: (T) -> Unit)  调用后原值经过了处理，但是返回的还是原值，



## Int

|                                |              |
| ------------------------------ | ------------ |
| or()                           | 按位或       |
| div(Int)                       | 整除         |
| and()                          | 按位与       |
| compareTo                      | -1,0,1       |
| dec()                          | 减一         |
| inc()                          | 加一         |
| minus(Int)                     | 减           |
| pluse(Int)                     | 加           |
| inv                            | 按位取反     |
| times(Int)                     | 乘  不精确   |
| rem                            | 求余         |
| unaryMinus                     | 取相反数     |
| rangeTo(other: Byte): IntRange | 返回一个区间 |
| toXxx                          | 类型转换     |

Standard.kt



|                                                       |      |
| ----------------------------------------------------- | ---- |
| public inline fun <T> T.apply(block: T.() -> Unit): T |      |
| public inline fun <T> T.also(block: (T) -> Unit): T   |      |
|                                                       |      |























下转型

## 





类与继承

类用class声明，类的header和body都是可选的

两种构造器

一个primary constructor和多个 secondary constructors

primary constructor是header的一部分

```kotlin
class Person constructor(firstName: String) { /*...*/ }
```

如果primary constructor中没有任何声明和修改，constructor 关键字可以省略

primary constructor不能包含任何代码，初始化代码要放在初始化代码块中(init修饰的代码块)

实例初始化时,init代码块并不是最先执行的，执行顺序是按照body中的顺序执行的



Secondary constructors

如果有主构造器的话，每个第二构造器都需要直接或间接的用this调用主构造器，给主构造器传参,所以init代码块会在Secondary constructors之前运行，即使没有主构造器，还会隐式调用init代码块



不指名构造器时，默认会生成一个无参的，公开的，主构造器，想要私有构造器可以声明一个空的主构造器

```kotlin
class DontCreateMe private constructor () { /*...*/ }
```



class中可以包括，

构造函数和init代码块

函数和属性

内嵌或内部类

object声明



继承

Any是kotlin中的超类，包含equals，hashCode，toString三个函数

kotlin的类默认是final的，想要被集成需要用open修饰

类头后面:父类 来继承

如果派生类中有primary constructor，必须使用派生类的参数传给基类进行初始化

```kotlin
open class Base(p: Int)

class Derived(p: Int) : Base(p)
```

没有primary constructor，需要在secondary constructor上使用super给基类传参数,也可以调用其他次要构造器来初始化基类

```kotlin
class MyView : View {
    constructor(ctx: Context) : super(ctx)

    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs)
}
```

重写方法

重写的方法前必须加override修饰，不用override编译期会报错，

基类中方法没用open修饰，子类中声明一个名字相同的方法是非法的

在没有被open修饰的类中用open修饰成员，修饰不起作用



重写属性

重写属性与重写方法一样，必须用override修饰，val可以重写成var，反之亦然

使用super关键字调用父类方法或属性

内部类访问外部类的超类：super@外部类名.方法/属性



如果继承的类和实现的方法中有相同的方法，必须重写这个方法，可以使用super<类名>.方法区分

```kotlin
open class Rectangle {
    open fun draw() { /* ... */ }
}

interface Polygon {
    fun draw() { /* ... */ } // interface members are 'open' by default
}

class Square() : Rectangle(), Polygon {
    // The compiler requires draw() to be overridden:
    override fun draw() {
        super<Rectangle>.draw() // call to Rectangle.draw()
        super<Polygon>.draw() // call to Polygon.draw()
    }
}
```





抽象类可以不用open修饰



跳转与返回值



kotlin标准库



# KClass

***KCLass与Java的Class***

KClass实例加.java得到Java的Class

获得KClass  对象/类名::class



Use



基础类型

kotlin不会自动类型转换,参数类型是double，只能穿double，不能是float/int等

***较小的数据类型不会转换成交大的数据类型***  较小的值不会付给较大的值，long就得用lang型的数字复制

int与long比较始终是false

***类型不一样的不能用==或者===***

```kotlin
        val a:Int=1
        val b:Long=1
        // Long和Int类型不一样，不能用==或者===比较
        println(a===b)
        println(a==b)
```



但是类型不一样，进行运算，结果的类型能推导

使用显示转换

​		toXxx()

没有八进制，十六进制0x开头，二进制0b开头

数字可以使用下划线变得更加清晰



数字-128~127是同一个对象===为true，其他为false



**位运算**

只针对于Int和Long

|            |      |
| ---------- | ---- |
| 左移       | shl  |
| 右移       | shr  |
| 无符号右移 | ushr |
| 与         | and  |
| 或         | or   |
| 异或       | xor  |
| 按位取反   | inv  |



浮点数的比较

大于小于等于in\\!in



# Array

array有get/set方法，size属性等，Array是不可变的

创建数组

|                             |                                       |
| --------------------------- | ------------------------------------- |
| arrayOf(1,2,3)              | 创建[1,2,3]                           |
| arrayOfNulls<T>(size:Int)   | 创建指定长度的数组，用空元素填充      |
| Array(size:Int, {index-{}}) | 传入长度和函数，函数根据index生成元素 |

**原始类型的数组**

ByteArray，ShortArray等，他们没有继承Array，但是拥有与Array一样的方法



无符号数字

UInt，ULong等，并且数字后面加u，如 val a:UInt=1u

无符号数组类似

















# 内联函数

* **also**

T.also{it...} 括号中可以改变T，最后将T的原值返回



also()



* **let**

简化空指针判断，虽然我们可以通过?.来引用，但是需要引用多次时，就可以用let来简化

```kotlin
    fun test(){
        var a:Int?=1;
        a=a?.let {
            it.inc()
            it.div(2)
        }
        println(a)
    }
```

**注意**  最后一行会作为返回结果，代码块中it的值是初始值，不会随着代码块中的更改而更改，所以上面的结果是0

* with

with(object,{})

对象作为参数,常用于调用一个对象的多个方法



* run

let与with的结合，相当于能省略let中的it



* apply

整体作用功能和run函数很像，唯一不同点就是它返回的值是对象本身



**括号中的代码块**

also({block})可以写成also{}

with(object,{bolck})可以写成with(object){}



导入名称冲突可以使用as起别名



基本类型

流程控制

类和对象

函数和lambda

集合



# 流程控制



## if

因为if是一个表达式，能返回值和赋值，所以kotlin中没有三元运算符

```kotlin
// 将if后的变量/表达式赋给前面的变量
val max = if (a > b) a else b
```

**如果将if-else作为表达式来得到它的值，else分支是必须的**



## when

类似于Java的switch，一个条件，多种情况

```kotlin
when (x) {
  	1 -> print("x == 1")
  	0, 1 -> print("x == 0 or x == 1")
  	in 1..10 -> print("x is in the range")
    parseInt(s) -> print("s encodes x")
    else -> print("s does not encode x")
}
```

**与Java的不同**

条件不仅可以用值匹配变量，还可以用表达式和函数的值来匹配。

表达式/函数->语句/函数

| 条件               | 描述                       |
| ------------------ | -------------------------- |
| 1                  | x=1时执行后面的函数/表达式 |
| 2,3,4              | x=2/3/4时执行              |
| 1..10              | 是否在1-10之间             |
| [!]in validNumbers | 是否在/不在                |
| is String          | 判断类型，会只能装换       |





## 循环



**for**

实现iterate的都能使用for循序，相当于Java的foreach

**遍历集合**

```kotlin
for (item in collection) print(item)
```

**循环指定次数**

```kotlin
for (i in 1..3) {
    println(i)
}
```

指定循环方向个步长

```kotlin
for (i in 6 downTo 0 step 2) {
    println(i)
}
```



range和array用for进行遍历，不会实用迭代器而是基于index

通过下表遍历

```kotlin
for (i in array.indices) {
    println(array[i])
}
for ((index, value) in array.withIndex()) {
    println("the element at $index is $value")
}
```



**while**

```kotlin
while (x > 0) {
    x--
}

do {
    val y = retrieveData()
} while (y != null)
```



练习：

交换两个数(also)

==与===

？！

object

init

package kotlin

集合

kotlin与Java相比的优势

反射

use的作用

number的比较



## return

Returns and Jumps

break与continue与Java一样，终止/跳过最近的循环

跳出到指定标签可以使用 XXX@来设置一个标签，然后break @XXX来跳出

return，结束最近的函数，lambda中还能通过return 标签来跳出lambda表达式，或者用匿名函数代替lambda，通过return跳出匿名函数

implicit labels： forEach



break

声明标签：标签明@

跳出到标签：break @标签名



## Exception

































**kotlin做server-side**

* 可以兼容基于java的技术栈



**与java的异同(优点)**

* type-safe





空值判断

