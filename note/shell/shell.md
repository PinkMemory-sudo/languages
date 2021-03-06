# 基本概念



**什么是shell**

内核外面加的一层保护壳，接受命令，调用内核。符合shell语法规范的才能调用内核。

用户登录到Linux系统后，系统将启动一个用户shell。在这个shell中，可以使用shell命令或声明变量，也可以创建并运行shell脚本程序。运行shell脚本程序时，系统将创建一个子shell。此时，系统中将有两个shell，一个是登录时系统启动的shell，另一个是系统为运行脚本程序创建的shell。当一个脚本程序运行完毕，脚本shell将终止，返回到执行该脚本之前的shell。



**命令解释器**

`echo #SHELL` 查看当前系统默认的解释器类型

`cat /etc/shells`shell支持多种不同风格的解释器



**shell不同解释器**

```bash
cat /etc/shells
/bin/sh
/bin/bash
/usr/bin/sh
/usr/bin/bash
/bin/tcsh
/bin/csh
```

不同解释器的语法可能不同

csh，可以解释c语言结构的shell

sh与bash是默认的解释器。sh是一个软连接，指向了bash



**为什么一些命令可以直接运行**

因为可以当前用户的在环境变量中找到

`echo $PATH`,查看当前用户的环境变量，可以看到bin和sbin已经配置到环境变量中了，所以在bin或sbin下的命令可以直接运行。



**运行脚本几种方式的区别**：

1. `解释器 脚本 参数`或者`解释器 -c 命令`**新开一个bash来执行脚本**，一运行完bash就关闭了

2. 通过`./`执行，只要不带路径的，都会去环境变量中查找，所以可以给脚本加上路径来执行**新开bash**

3. 通过`source`或者`.`（等价）不会新开bash，**在当前bash执行**





# 语法





## 变量



**声明**：

变量名=变量值，变量在第一次赋值时产生，**赋值时=两边不能有空格**，变量的值有空格时，要用引号引起来，因为在shell中，默认空格前面的是命令，后面跟着的是脚本的参数



*readonly*

声明静态变量

```bash
readonly 变量名
```

`readonly 变量名` 将一个变量修改成一个只读变量，变成只读变量后，不能再进行赋值(没有初始化也不行)和删除



*export*

`export 变量名` 将一个变成提升为全局变量，即之前只能在本bash使用，export可以在其他bash中使用(执行一个脚本就会新开一个bash)，前提时本bash**不能关闭**，可以把bash理解成对象(不能真的这么认为)，可以通过pstree查看

每个shell都是由某个shell（称为父shell）派生的。在子shell中定义的变量只在该子shell内有效。如果在一个shell脚本程序中定义了一个变量，当该脚本程序运行时，这个定义的变量只是该脚本程序内的一个局部变量，其他的shell不能引用它。而export后，每生成一个新的shell时，就会复制一份这个变量的定义。

`export -f 函数名`

`export -n 变量名` 表示后续新开shell时，不会再复制这个变量的声明

`export -p` 列出所有shell赋值声明的变量



*赋值时，单引号的区别：*

""中引用的变量会进行转义，''里边是什么就会输出什么



**引用**

$变量名

常用的系统变量：$HOME, $SHELL, &USER等

`set`,查看当前bash中定义的所有变量，可以看到SHELL等变量已经定义好了



**修改**

与声明相同：变量名=变量值



**删除**

unset 变量名



### 特殊变量

| 变量 | 描述                                                        |
| ---- | ----------------------------------------------------------- |
| $0   | 脚本名                                                      |
| $n   | 参数n                                                       |
| $?   | 上一条命令的返回值，0表示执行成功                           |
| $#   | 参数个数                                                    |
| $*   | 参数列表                                                    |
| $@   | 参数列表 ，大多数情况下与$*相同，在双引号中使用时会有所不同 |

**$*与$@的区别**

平时都是一样的，当他们出现在双引号中时，$*会将所有参数作为一个整体，而$@则会成为多个



###  整数的运算



在shell中，变量默认的类型都是字符串，无法直接进行数值运算

格式：

* ((运算))或[运算]

* expr +，-\\*,/,%  **命令和数字，运算符和数字之间要有空格** expr 
* let，let表示后面的是算数运算，并且变量不需要用$引用，可以用(())替换







## 流程控制



### 条件判断



**格式**

[ 表达式 ] **方括号左右要有空格**

没办法进行逻辑判断时不空就是真，空字符串，空数组就是false

**[]中，=是字符串的比较**，并且=左右要加空格 [ hello = hi ]

多条件判断

`&&` 前面的条件执行成功后才执行后面的

`||` 前面的语句执行失败后才执行后面的



**数字的判断**

| 参数 | 描述     |
| ---- | -------- |
| -ge  | 大于等于 |
| -le  | 小于等于 |
| -eq  | 等于     |
| -ne  | 不等于   |



**文件存在性判断**

| 参数 | 描述                     |
| ---- | ------------------------ |
| -f   | 是一个常规的文件并且存在 |
| -d   | 是一个文件夹并且存在     |
| -e   | 文件存在                 |
| -s   | 文件存在且不空           |
| -l   | 文件存在且是一个链接     |



**文件权限判断**

| 参数 | 描述           |
| ---- | -------------- |
| -r   | 是否有读权限   |
| -w   | 是否有写权限   |
| -x   | 是否有执行权限 |





### if



***格式***

```bash
if [ 条件表达式 ]；then
 	pass
elif [ 条件表达式 ];then
	pass
else 
	pass
fi
```

**注意**

* then不能直接加在if表达式后面，需要在表达式后面加;
* []中的空格
* if后的空格



**C语言风格**

(()))



### case



***格式***

```bash
case $变量名 in
	"值1") pass ;;
	"值2") pass ;;
	"值3") pass ;;
	*) pass ;;
esac
```

* 两个分号结尾表示break

* *表示default



### for



***格式***

```bash
for (( 初始值;循环条件;变量变化 ))
	do
		pass
	done
```



### foreach

***格式***

```bash
for 变量 in 值1 值2...
	do
	 	pass
	done
```





### while

***格式***

```bash
while [ 条件判断 ]
	do
		pass
	done
```

或者

```bash
while ((表达式))
	do
		pass
	done
```





$默认解析，可以使用单引号不让他解析





# 函数



## 自定义函数



**定义**

关键字functio

n,函数名后的括号可以忽略，参数列表可以忽略(直接通过$n引用),return可选，默认返回最后一条语句的执行结果

```bash
function 函数名(){
	pass
	[return]
}
```



**调用**

`函数名 参数` 就像是一个Linux命令的使用



## 系统函数

`read` 从控制台获得输入 ，可选参数-p -t `read -p 提示文字 -t 等待时间 变量名` 



`dirname  路径字符串`  相当于获得最后一个斜杠前的字符串，但是这个路径必须时存在的



`basename 路径字符串` 与dirname相反，可以获得路径中最后一个斜杠的后半部分，可以通过去掉后缀只获得文件名



`date` 

***格式化字符串***

使用 +""来格式化输出的字符串

`date +"%Y-%m-%d %H:%M:%S"`

***获得指定时间***

`date -d "1 day ago" +"%Y-%m-%d %H:%m:%S"`

***获得时间戳***

`date +"%s"`



***字符串转时间戳***

`date -d "2021-01-01" +"%s"`



***设置系统时间***（root）

`date -s "2012-05-23 01:01:01"`



#### 文本处理

shell脚本最常见的一个用途就是处理文本



**cut**

用来提取指定的列

| 参数 | 描述                                                         |
| ---- | ------------------------------------------------------------ |
| -d   | 指定分隔符                                                   |
| -f   | 指定提取的列数，多行用逗号隔开，范围用-  -n表示第一列到第n列，n-表示n之后 |
| -b   | 字符分隔截取                                                 |



**sed**

被成为流编辑器。在编辑器处理数据之前，预先提供一组规则来编辑数据流。并不会修改原文件，而是将结果输出到STDOUT

| 参数 | 描述                                                         |
| ---- | ------------------------------------------------------------ |
| -e   | 需要多条命令时需要用-e指明,命令之间用分号隔开，并且不能有空格， sed -e "s/hello/hi";"s/tom/tim" |
| -f   | 如果处理文本需要大量的命令，通常可以将他们放在一个文件中(通常用.sed结尾) |
|      |                                                              |



| 动作 | 说明                                                         |
| ---- | ------------------------------------------------------------ |
| a    | sed "a hello" 每一个行的下面添加一个hello，2a表示只在第二行添加一个hello |
| d    | sed "2d" 删除第二行，sed "/hello/d"将含有hello的行删除       |
| s    | 替换。"s/hello/hi/g",讲hello换成hi,没有左后的g只会替换每一行第一个 |



***sed的工作流程***

* 一次从输入中读取一行数据

* 根据提供的规则匹配数据

* 按照命令修改数据

* 将新的数据输出到STDOUT

可以看出它是读取一行数据，将所有命令应用与该行后再读取下一行，所以它的速度要比交互式的编辑器快



**awk**

用来进行文本处理更强大，不再是一些命令而是一种编程语言，可以定义和使用变量，进行算数和字符串计算，重新排列和格式化。

**格式** `awk 参数 "pattern1{action1}  pattern2{action2}..." fileName`

pattern用来匹配数据，action用来对匹配到的数据执行命令

| 参数         | 描述         |
| ------------ | ------------ |
| -F           | 指定分隔符   |
| -f           | 指定脚本     |
| -v var=value | 定义一个变量 |



常用实例

`awk '{print $3,$9}'` 获得第3，9列

`awk '\^root\{print $n}'` 获得含有root开始的行的第n列

awk内置变量





**split**

tar

gzip

zip











nd5sum











重定向





&PATH与env的区别

nologin？

chmod

软链接



