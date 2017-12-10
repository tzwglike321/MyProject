# linear_view:
> * 外面先用四个linearlayout（vertical）布局
> * linearlayout（vertical）里面嵌套一个linearlayout(horizontal)
> * linearlayout(horizontal)里面嵌套四个TextView
> * TextView实现白色边框，通过shape来设置背景图片，首先一个textview_border.xml文件放在drawable文件夹里面
> * 为要添加边框的TextView添加一个background,android:background="@drawable/textview_border" 
## 界面截图
* [linear_view] (https://github.com/tzwglike321/MyProject/blob/master/image/AndroidPractice1_img/linear.png)

# relative_view
> * relativelayout里面嵌套5个TextView
> * 设置5个TextView的相对位置、大小、颜色
## 界面截图
* [relative_view] (https://github.com/tzwglike321/MyProject/blob/master/image/AndroidPractice1_img/relative.png)

# table_view
> * tablelayout里面嵌套八个TableRow
> * TableRow里面嵌套相应的TextView
> * TableRow有两项的一个文字左浮动一个右浮动
> * 分割线通过TableRow里面嵌套一个TextView，设置TextView的高度和TableRow的背景颜色实现
## 界面截图
* [table_view] (https://github.com/tzwglike321/MyProject/blob/master/image/AndroidPractice1_img/table.png)