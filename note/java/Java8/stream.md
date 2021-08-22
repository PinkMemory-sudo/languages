好处：简洁，提供了内部迭代，就像循环，来处理每个元素。



串行流与并行流









集合获得Stream直接.stream

数组获得stream：Arrays.stream(数组)



获得流的方法

| 方法                                                        | 描述                                 |
| ----------------------------------------------------------- | ------------------------------------ |
| static of(T...values)                                       | 用传入的元素创建一个流，不定长，数组 |
| Collection中的stream                                        | 将该集合转换成流                     |
| Arrays.stream(T[] array)                                    | 根据传入的数组创建流                 |
| stream(T[] array, int startInclusive, int endExclusive)     | 根据数组的一部分创建流               |
| Stream.concat(Stream<? extends T> a, Stream<? extends T> b) | 合并两个流                           |
| Int/LongDoubleStream的静态方法                              |                                      |

创建int/long/double流

IntStream.range(1, 100).boxed()，创建出来的元素时int类型，可以用boxed进行装箱。range的范围时左闭右开,全闭合是***rangeClosed***





中间操作

中间操作是是lazy操作，不会立马执行，终止时才执行。

| 方法                      | 描述                                                         |
| ------------------------- | ------------------------------------------------------------ |
| filter                    | 过滤，返回值为false时过滤掉                                  |
| map                       | 映射，将元素映射成其他值                                     |
| mapToInt                  | 将Interger转为int在进行运算，减少内存占有，还有Long和Double的 |
| sorted                    | 排序，传入比较器                                             |
| distinct                  | 去重，要想对象去重，要重写对象的hashCode和equals             |
| skip                      | 表示从哪开始                                                 |
| limit                     | 传入int，表示只要前几个                                      |
| reduce(T identity,计算器) | T为初始值，计算器来计算相邻两个，返回结果，例如求流中元素的和 |
| min                       | 传入比较器，得最小值                                         |
| max                       | 传入比较器，得最大值                                         |



终结流的方法

| 方法       | 描述                          |
| ---------- | ----------------------------- |
| anyMatch   | 传入一个Predicate             |
| allMatch   | 传入一个Predicate             |
| noneMatch  | 传入一个Predicate             |
| findFirst  | 与findAny相同，返回第一个元素 |
| count()    | 元素个数                      |
| Collectors | 对流中的元素进行总结归纳      |



Collectors的静态方法

| 方法                                                         | 描述                       |
| ------------------------------------------------------------ | -------------------------- |
| toCollection                                                 |                            |
| toList                                                       |                            |
| toSet                                                        |                            |
| toMap(Function keyMapper,  Function valueMapper)             |                            |
| joining                                                      |                            |
| joining(CharSequence delimiter)                              |                            |
| joining(CharSequence delimiter, CharSequence prefix, CharSequence suffix) |                            |
| <T, K>groupingBy(Function)                                   | 运行结果一样的为一组       |
| groupingBy(Function)                                         | 分组后有多个流，又可以聚合 |
| groupingBy(Function,Collector)                               | 分组后再对每一组进行操作   |



groupingBy可用于将List转为Map

groupingBy(Function,Collector)

例如分组后

对每个分组中的元素进行分组，

将每个元素转换成String,List等

可以理解成groupingBy(Function,Collector)，function为key，Collectors为value，没有Collectors时value默认为该组中所有元素组成的value。































java8流中所有的操作都是蓄而不发的，只有执行foreach，collect等终结操作时，流的操作才会执行



TODO：

flapMap

可以对stream流中单个元素再进行拆分，相当于双重for循环

peek

reduce

min

max

count

anyMatch

allMatch

noneMatch

findFirst

findAny

empty

of

builder

generate

concat





并行流的线程安全问题：

在parallelStream里面使用外部变量



groupingBy



Collectors





```json
{0018:{0011:[Student(company:0018, department:0011, people:a13)]}, 001:{0011:[Student(company:001, department:0011, people:a), Student(company:001, department:0011, people:a1), Student(company:001, department:0011, people:a5)]}, 0015:{0011:[Student(company:0015, department:0011, people:6a), Student(company:0015, department:0011, people:a12)]}, 002:{0011:[Student(company:002, department:0011, people:a2)]}, 0016:{0011:[Student(company:0016, department:0011, people:a7), Student(company:0016, department:0011, people:a11)]}, 003:{0011:[Student(company:003, department:0011, people:a3)]}, 0013:{0011:[Student(company:0013, department:0011, people:a9)]}, 004:{0011:[Student(company:004, department:0011, people:a4)]}, 0014:{0011:[Student(company:0014, department:0011, people:a0)]}, 0012:{0011:[Student(company:0012, department:0011, people:a8)]}}

```



## flatMap































4154691121

BeiLunGA