# simple_adapter.xml
> * LinearLayout(horizontal)布局
> * 里面放一个TextView和一个ImageView,分别用于存放名称和图片
# activity_main.xml
> * LinearLayout(horizontal)布局
> * 里面放一个ListView
# MainActivity
> * 将SimpleAdapter对象装载入ListView对象
> * 定义listview的Item点击事件，弹出相应item的名字
## 界面截图
* [SimpleAdapter](https://github.com/tzwglike321/MyProject/blob/master/image/AndroidPractice2_img/S71220-23591401.jpg)

# alter_dialog.xml
> * LinearLayout(vertical)布局
> * 里面放一个button，用于点击相应弹出自定义对话框
# custom_view.xml
> * LinearLayout(vertical)布局
> * 里面放两个EditText和另一个LinearLayout(horizontal)布局
> * 两个EditText,一个类型是Text,另一个类型是textPassword
> * LinearLayout(horizontal)布局里面放两个button，layout_weight="1"，自适应填充
# ApplycationActivity
> * 调用 AlertDialog.Builder 对象上的 setView() 将布局添加到 AlertDialog
## 界面截图
* [AlertDialog](https://github.com/tzwglike321/MyProject/blob/master/image/AndroidPractice2_img/S71220-23563278.jpg)

# pop_test.xml
> * LinearLayout(vertical)布局
> * 里面放自定义ToorBar和button
# popup_view.xml
> * menu里面放三个Item
> * 第一个Item用于字体大小设定，第二个Item用于普通菜单栏弹出，第三个Item用于字体颜色设定,showAsAction="never"
# PopActivity
> * 定义onOptionsItemSelected事件、AlertDialog字体大小单选框、AlertDialog字体颜色单选框
## 界面截图
* [字体小](https://github.com/tzwglike321/MyProject/blob/master/image/AndroidPractice2_img/S71220-23570489.jpg)
* [字体中](https://github.com/tzwglike321/MyProject/blob/master/image/AndroidPractice2_img/S71220-23571472.jpg)
* [字体大](https://github.com/tzwglike321/MyProject/blob/master/image/AndroidPractice2_img/S71220-23573378.jpg)
* [普通菜单Toast提示](https://github.com/tzwglike321/MyProject/blob/master/image/AndroidPractice2_img/S71220-23582415.jpg)
* [字体颜色红](https://github.com/tzwglike321/MyProject/blob/master/image/AndroidPractice2_img/S71220-23584685.jpg)
* [字体颜色黑](https://github.com/tzwglike321/MyProject/blob/master/image/AndroidPractice2_img/S71220-23585711.jpg)


