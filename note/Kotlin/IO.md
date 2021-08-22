# IO





**kotlinIO的优点：**

* 复用了Java的IO，但是添加了许多扩展函数
* File就能满足大部分需求



**FIle**

文件复制

```kotlin
val file = File("test")
file.copyTo(File("test.bak"))
```

| 方法                          | 描述                                 |
| ----------------------------- | ------------------------------------ |
| list()                        | 获得指定目录下的文件和文件夹名       |
| listFile()                    | 获得指定目录下所有文件和文件夹的FIle |
| list/listFile(FileNameFilter) | 获得指定的文件或文件夹               |
| list/listFile(FileFilter)     | 获得指定的文件或文件夹               |

**复制文件**



**遍历文件**

在遍历文件及其子文件时要用listFIle



**修改修改时间**



**修改权限**





实用inline  function：use({代码块})不用再考虑关闭资源

提供了丰富的IO扩展函数







runCatching



FIle



InputStream

OutoutStream

BufferInputStream

BufferOutputStream



Read

Writer

BufferRead

BufferWriter



## File

直接使用File对象就可以对小文件的读取，底层实际通过BufferedReader读取