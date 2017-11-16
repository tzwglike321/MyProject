# AccessRight:
> * 一个具有public、private、protected、default访问权限的数据成员和成员函数的class.

# ChocolateBoiler:
> * 实现单例模式模拟把巧克力和牛奶融合在一起生产巧克力棒的巧克力锅炉类. 
> * ChocolateBoiler有两个私有的成员变量，empty和boiled，用来判断锅炉是否为空，以及锅炉内混合物是否已煮沸. 
> * ChocolateBoiler有三个方法来控制锅炉生产巧克力棒. 
> * > public void fill() {…} 向锅炉填满巧克力和牛奶的混合物。首先要判断锅炉是否为空，只有空的锅炉才能填充巧克力和牛奶（填充过程打印一条语句即可）。填充之后empty为false. 
> * > public void boil() {…} 将炉内煮沸。首先判断标志位，只有锅炉是满的，并且没有煮过，才能进行该操作（煮沸操作打印一条语句即可）。煮沸后boiled标志位设置为true. 
> * > public void drain() {…} 排出煮沸的巧克力和牛奶。首先要进行标志位判断，只有锅炉是满的，并且锅炉已经煮沸之后，才能排出混合物（排出混合物的动作打印一条语句即可），排出混合物之后设置empty为true. isEmpty和isBoiled方法来获取empty和boiled标志位的值.

# Test:
> * 调用ChocolateBoiler类测试生产巧克力棒过程.