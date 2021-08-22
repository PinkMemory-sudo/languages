[overview](https://kotlinlang.org/docs/reference/server-overview.html)

兼容所有基于Java的框架

迁移简单，可以直接在Java项目中插入kotlin

Spring等框架的支持

JDBC和NoSQL的支持

使用JVM，支持跨平台



































## 包：

源文件中所有的内容(类和方法等)都属于package

没有指定package的属于同一个没有名字的package





## 函数



不指定返回值代表没有返回值

访问修饰符



**main函数**

作为程序的入口，main函数没有返回值，1.3之前必须有一个参数Array\<String>,1.3之后不需要

```kotlin
fun main(args: Array<String>) {
    println("Hello, World!")
}
```



函数的参数可以有默认值，在函数声明时用=指定默认值

```kotlin
fun printMessageWithPrefix(message: String, prefix: String = "Info") {  // 2
    println("[$prefix] $message")
}
```

建议：有默认值的参数放在后面，调用方法时，只需要传入前面的参数



**infix function**



**Operator Functions**









**参数传递**

默认参数值和命名参数

参数传递时，会根据传入的顺序去匹配函数中的参数，所以，当调用函数时参数的顺序不能匹配函数的参数时，用通过参数名传参

```kotlin
fun printMessageWithPrefix(prefix: String = "Info",message: String,) {  // 2
    println("$prefix $message")
}


fun main() {
    printMessageWithPrefix(message="hello")           // 8
}
```

即要么将参数按顺序传入，要么用参数名传入



不定参数

































基础语法

类，方法，变量的定义





基本类型



字符串拼接变量

双引号中可以使用$变量名来引用变量值



Int





String

| 方法               | 描述                                      |
| ------------------ | ----------------------------------------- |
| isBlank/isNotBlank | 是否empty/都是空格                        |
| isEmpty/isNotBlank |                                           |
| isNullOrblank      |                                           |
| isNullOrEmpty      |                                           |
| toXXX              | 类型转换，除了基本类型，还有Array，List等 |
|                    |                                           |









流程控制



Null安全



协程



代码规范







































































































































































































# 基础语法



## **包的定义与引入**

```kotlin
package my.demo

import kotlin.text.*
fun printMessage() { /*...*/ }
class Message { /*...*/ }
```

?不需要匹配目录和软件包：可以将源文件任意放置在文件系统中



​		源文件中所有的内容(类和方法等)都属于这个package，所以方法printMessage完整的名字是my.demo.printMessage，Message完整的名字是my.demo.Message

​		没有指定package的属于同一个没有名字的package



**默认引入的包**

[默认引入的包](https://kotlinlang.org/docs/reference/packages.html)

还有一些包会根据平台引入



引入的类名有冲突时，使用as起别名

```kotlin
import org.example.Message // Message is accessible
import org.test.Message as testMessage // testMessage stands for 'org.test.Message'
```



## 程序入口

```kotlin
fun main() {
    println("Hello world!")
}	
```



## 函数

函数通过fun关键字声明，可以直接写在包里，写在类里的叫number function，写在方法里的叫local function







### 参数

参数定义*name*: *type*，需要明确类型

与Java不一样的地方，类型写在后面，最后一个参数后面也可以有一个comma

```kotlin
fun sum(a: Int, b: Int): Int {
    return a + b
}
```



***参数默认值***

参数可以有默认值

```kotlin
fun read(
    b: Array<Byte>, 
    off: Int = 0, 
    len: Int = b.size,
) { /*...*/ }
```



重写的方法，使用它父类的默认值，不能再设置默认值，即**重写的方法不能设置默认值**

```kotlin
open class A {
    open fun foo(i: Int = 10) { /*...*/ }
}

class B : A() {
    override fun foo(i: Int) { /*...*/ }  // No default value is allowed
}
```



**传参**

传参是按顺序传的，默认值在最后可以不用传，但是当传参顺序不一致时，就要用参数名=参数值的方式来传。

```kotlin
fun foo(
    bar: Int = 0, 
    baz: Int,
) { /*...*/ }

foo(baz = 1) 
```



**参数是lambda时**

可以在括号中传入，也可以在括号外传入

```kotlin
fun foo(
    bar: Int = 0,
    baz: Int = 1,
    qux: () -> Unit,
) { /*...*/ }

foo(qux = { println("hello") })//
foo { println("hello") }  
```



**vararg修饰符**

不定参数，与Java，本质是一个数组，vararg只能修饰一个参数

传参时，可以一个一个传，也可以与现有的数组结合(通过*引用)

```kotlin
fun <T> asList(vararg ts: T): List<T> {
    val result = ArrayList<T>()
    for (t in ts) // ts is an Array
        result.add(t)
    return result
}
val a = arrayOf(1, 2, 3)
val list = asList(-1, 0, *a, 4)
```



### Single-expression functions

当函数体是一个表达式时，可以直接赋值给函数，并且返回值类型可以自己推断。

```kotlin
fun sum(a: Int, b: Int) = a + b
```



### Infix function



中缀函数，可以理解成时一个运算符，比如 +、-、*、/，都是两个参数，中间加个符号，生成另一个数。



转infixFunction要求

* They must be member functions or extension functions;
* They must have a single parameter；
* The parameter must not accept variable number of arguments and must have no default value.



作用：就像是定义了一个操作符

```kotlin
class Account {
    var balance = 100.0

    infix fun add(amount: Double) : Unit {
        this.balance = balance + amount
    }
}
val  account = Account()
account add 100.00
print(account.balance)
```



注意：

Infix function calls have lower precedence than the arithmetic operators, type casts, and the `rangeTo` operator.

比逻辑判断高



中缀函数要同时指定接收者和参数

```kotlin
class MyStringCollection {
    infix fun add(s: String) { /*...*/ }
    
    fun build() {
        this add "abc"   // Correct
        add("abc")       // Correct
        //add "abc"        // Incorrect: the receiver must be specified
    }
}
```



### Inline function

内联函数

https://kotlinlang.org/docs/reference/inline-functions.html



### Extension functions

https://kotlinlang.org/docs/reference/extensions.html



### Higher-order functions and lambdas

https://kotlinlang.org/docs/reference/lambdas.html



### Tail recursive functions

函数式编程

[tail recursion](https://en.wikipedia.org/wiki/Tail_call)



## 变量



**使用val声明只读变量**

类似final？

```kotlin
val a: Int = 1  // immediate assignment
val b = 2   // `Int` type is inferred
val c: Int  // Type required when no initializer is provided
c = 3       // deferred assignment
```

声明变量时直接初始化，不用指定变量类型，可以推断，不初始化时需要明确类型



**使用var声明可以重复赋值的变量**

```kotlin
var x = 5 // `Int` type is inferred
x += 1
```



### 属性与字段



**属性**

声明属性完整的方法，简化了Java中的entity，属性就是私有的，getter/settet方法默认生成，使用时会自动调用getter/setter。例如：对象.属性实际就会执行getter方法。

```kotlin
var <propertyName>[: <PropertyType>] [= <property_initializer>]
    [<getter>]
    [<setter>]
```

getter/setter方法是可选的(默认自动生成)，如果类型可以推断则类型也可以省略。

private修饰后要自己重写getset

```kotlin
var name: String? = null
set(value) {
  name = value
}
get() = name  // 这样会出现递归调用
```



**Backing Fields**

在kotlin中，field作为属性的一部分，只有在需要属性值得时候才会用到。不能直接声明field，when a property needs a backing field，kotlin为自动提供field，在get/set方法中想要属性的值时可以用field。

```kotlin
var counter = 0 // Note: the initializer assigns the backing field directly
    set(value) {
        if (value >= 0) field = value
    }
```



**Backing Properties**

https://kotlinlang.org/docs/reference/properties.html



## 流程控制



### if

在Kotlin中，if是一个表达式，即它返回一个值

没有三目运算符，因为可以使用if-else实现

```kotlin
if (a > b) {
    max = a
} else {
    max = b
}
```

等价于

```kotlin
if(a > b) a else b
```

如果if是作为表达式(有返回值)而不是语句时，必须需要else分支



**类型判断**

is等效与instanceOf



**范围判断**

使用in进行判断是否属于某个范围

if (x in 1..10)   if (x !in 1..10)



### when

when就是switch语句，可以当成表达式(满足条件的值)或者语句来使用，作为表达式使用时，else是强制的(不能没有值)，除非是enum/sealed，能列出所有情况

```kotlin
when (x) {
    1 -> print("x == 1")
    2 -> print("x == 2")
    3, 4 -> print("x == 0 or x == 1")     // 多种情况处理的方式一样时
    in 5..10 -> print("x is in the range") // 或者!in,!is
    is String -> x.startsWith("prefix")
    else -> { // Note the block
        print("x is neither 1 nor 2")
    }
}
```

->前面是条件，后面是要执行的代码，条件不仅能是一个变量，还能是多个变量，还能是表达式，可见与switch相比的强大之处。



可以用来替换if-else

不提供参数，判断的条件都是boolean类型

```kotlin
when {
    x.isOdd() -> print("x is odd")
    y.isEven() -> print("y is even")
    else -> print("x+y is odd.")
}
```



捕获异常

```kotlin
fun Request.getBody() =
        when (val response = executeRequest()) {
            is Success -> response.body
            is HttpError -> throw HttpException(response.status)
        }
```



### 循环



*for* loop iterates through anything that provides an iterator

```kotlin
for (item in collection) print(item)
```



To iterate over a range of numbers

```kotlin
for (i in 1..3) {
    println(i)
}
for (i in 6 downTo 0 step 2) {
    println(i)
}
```



If you want to iterate through an array or a list with an index

```kotlin
for (i in array.indices) {
    println(array[i])
}
```



while

```kotlin
while (x > 0) {
    x--
}

do {
    val y = retrieveData()
} while (y != null) // y is visible here!
```



Kotlin supports traditional *break* and *continue* operators in loops



Any expression in Kotlin may be marked with a *label*

label的格式xxx@，标签可以直接加在表达式的前面



指定break/continue的位置

```kotlin
loop@ for (i in 1..100) {
    for (j in 1..100) {
        if (...) break@loop
    }
}
```



退出lambda表达式

```kotlin
fun foo() {
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // local return to the caller of the lambda, i.e. the forEach loop
        print(it)
    }
    print(" done with explicit label")
}
```

如果只写return这是直接返回foo

使用隐式的标签更加便利，隐式标签就输lambda传入的函数名

```kotlin
fun foo() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // local return to the caller of the lambda, i.e. the forEach loop
        print(it)
    }
    print(" done with implicit label")
}
```



## NullSafety

为了避免空值判断，消除`NullPointerException` kotlin提供了两种类型：Nullable types and Non-Null Types



**变量声明**



**当引用类型可能是null时，必须用?明确指定**

```kotlin
fun parseInt(str: String): Int? {
    // ...
}
```

声明的时候不加?就表示该值不能为null，需要为null时必须明确说明(类型后加？)

```kotlin
var a:String="hello"
        a=null  // 报错
```

所以,nul就赋值不给变量，所以就避免了空指针

而在nullable类型下，编译时会判断



**安全调用**



**?.**

安全调用

使用?.进行调用，为空时返回null，不为空时返回结果，常用于链式调用

即null.方法返回的值是null

**?:**

为null时指定一个值

`val l: Int = if (b != null) b.length else -1`等效与`b?.length?:-1`

注意：null时?:后的表达式才会处理



**!!**

为空时抛异常，跟Java效果一样



**Safe Casts**

```kotlin
val aInt: Int? = a as? Int
```

Java不能转换时会抛异常ClassCastException，safe cast如果不能转会返回null



**filterNotNull**

```kotlin
val nullableList: List<Int?> = listOf(1, 2, null, 4)
val intList: List<Int> = nullableList.filterNotNull()
```



See [Classes](https://kotlinlang.org/docs/reference/classes.html) and [Type casts](https://kotlinlang.org/docs/reference/typecasts.html).



## Ranges and Progressions



kotlin中可以使用Range非常方便的创建一组范围

除了数字外，Ranges are defined for comparable types: having an order。即实现comparable的都可以

rangeTo方法等效与.. (闭区间)

downTo来倒序

指定步数`for (i in 8 downTo 1 step 2) print(i)`

左闭右开`for (i in 1 until 10)`

in表示Constance的意思



# 集合











# 类和对象



## Classes

Class包含class name, the class header (specifying its type parameters, the primary constructor etc.) and the class body.

class header和class body都是可选的

```kotlin
class Empty  // 有什么用？
```



### 构造函数



#### **primary constructor** 

A class in Kotlin can have a **primary constructor** and one or more **secondary constructors**

**首要构造函数作为class header的一部分**，放在方法名后。

```kotlin
class Person constructor(firstName: String) { /*...*/ }
```

If the primary constructor does not have any annotations or visibility modifiers, the *constructor* keyword can be omitted:

```kotlin
class Person(firstName: String) { /*...*/ }
```

The primary constructor cannot contain any code.初始化操作放在init代码块中，按出现的顺序执行

```kotlin
class InitOrderDemo(name: String) {
    val firstProperty = "First property: $name".also(::println)
    
    init {
        println("First initializer block that prints ${name}")
    }
    
    val secondProperty = "Second property: ${name.length}".also(::println)
    
    init {
        println("Second initializer block that prints ${name.length}")
    }
}
```

首要构造函数中的参数可以在init代码块中使用，**也可以在类中的属性初始化的时候使用**

```kotlin
class Customer(name: String) {
    val customerKey = name.toUpperCase()
}
```

可以通过首要函数声明并初始化属性

```kotlin
class Person(val firstName: String, val lastName: String, var age: Int) { /*...*/ }
```



#### **secondary constructor** 

在类体中使用constructor声明

```kotlin
class Person {
    var children: MutableList<Person> = mutableListOf()
    constructor(parent: Person) {
        parent.children.add(this)
    }
}
```

如果有首要构造函数时，每个次要构造函数都需要委托给首要构造函数(直接或者通过其他次要构造函数)

用this来调用其他构造函数

？？？？？



### 继承

所有类都继承了Any。

所有类默认是final的，不能被继承，想要集成要用open修饰，classHeader后:要集成的类

```kotlin
open class Base(p: Int)

class Derived(p: Int) : Base(p)
```



#### Any

Any有三个方法：

equals

hashCode

toString



































### Creating DTOs

一行代码生成entity

```kotlin
data class Customer(val name: String, val email: String)
```

提供了一下功能

- getters (and setters in case of *var*s) for all properties
- `equals()`
- `hashCode()`
- `toString()`
- `copy()`
- `component1()`, `component2()`, …, for all properties (see [Data classes](https://kotlinlang.org/docs/reference/data-classes.html))



### Creating a singleton

```kotlin
object Resource {
    val name = "Name"
}
```





kotlin中，造成空指针异常的可能只是：

* 手动的抛出，throw NullPointerException()



Lazy property

Extension Functions

使用with，一次调用多个方法

apply

with



交换两个值

```kotlin
var a = 1
var b = 2
a = b.also { b = a }
```



todo

```kotlin
fun calcTaxes(): BigDecimal = TODO("Waiting for feedback from accounting")
```





# kotlin package



## Pair

