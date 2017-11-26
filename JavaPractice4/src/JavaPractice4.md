# IOTest:
> * 基本IO操作
> * 从键盘接收字节流
> * 写入到当前目录下的src.txt文件中
> * 将src.txt文件内容复制到当前目录下dest.txt文件中
> * 将dest.txt文件内容显示到屏幕上
## 运行结果截图
* [基本IO操作](https://github.com/tzwglike321/MyProject/blob/master/image/JavaPractice4_img/IOTest.png)
# FileInformation:
> * 用于存储文件信息
> * 重载了以中文字符比较的compareTo函数
# GetFileTree:
> * 获取某个目录下的目录信息，目录从控制台输入
> * 目录信息包括该目录下的所有文件和文件夹的列表。对于每个文件夹显示其名称，修改日期。对于每个文件显示其名称，修改日期和大小
> * 目录的信息写出到文件中。注意，文件信息首先按类型分类，文件夹在前，文件在后，并且他们各自按照文件名字符串的顺序排序
## 运行结果截图
* [获取系统的文件树1](https://github.com/tzwglike321/MyProject/blob/master/image/JavaPractice4_img/FileTree1.png)
* [获取系统的文件树2](https://github.com/tzwglike321/MyProject/blob/master/image/JavaPractice4_img/FileTree2.png)
# TestTime:
> * 用带缓冲和不带缓冲的字符流实现文件复制，并比较耗时情况
## 运行结果截图
* [IO时间比较](https://github.com/tzwglike321/MyProject/blob/master/image/JavaPractice4_img/TestTime.png)
# Student:
> * 属性包括{studentID, name, sex} (学号，姓名，性别)
> * 重载了以studentID比较的compareTo函数
# FlattenStudent:
> * 将学生信息从文件list.txt读入，并按照学号升序排列
> * 序列化Student对象
> * 使用ObjectOutputStream将已经排序的学生信息写出到文件“student.bin”中
# InflateStudent:
> * 反序列化Student对象
> * 使用ObjectInputStream将“student.bin”中的对象信息读入程序，显示在控制台中
# MainStudent
> * 调用FlattenStudent和InflateStudent实现Student对象序列化和反序列化，并将对象信息显示在控制台中
## 运行结果截图
* [对象序列化1](https://github.com/tzwglike321/MyProject/blob/master/image/JavaPractice4_img/Student1.png)
* [对象序列化2](https://github.com/tzwglike321/MyProject/blob/master/image/JavaPractice4_img/Student2.png)
