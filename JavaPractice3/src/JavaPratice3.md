# FCFS:
## FCFS算法按照任务到达的顺序进行服务，先来先服务 
## 每个Task对象可以描述为至少包含下列属性： 
> * taskID //任务ID 
> * arrivalTime //到达时间 
> * serviceTime //服务时间 
> * startingTime //开始时间 
> * finishingTime //完成时间=开始时间+服务时间 
> * turnAroundTime //周转时间=完成时间-达到时间 
> * weightTurnAround //带权周转时间=周转时间/服务时间 
>  > 任务(Task)的ID、开始时间和服务时间由文件读入，形如"taskID 到达时间 服务时间"。这个任务列表文件首先由程序生成，每秒一个任务达到，服务时间由{6,2,1,3,9}这个集合中的数据随机获取。文件列表要包含至少100个任务。 实现如下要求的FCFS 当只有一个处理队列时的情况 当有两个处理队列时的情况.
## 运行截图
* [一个队列情况](https://github.com/tzwglike321/MyProject/blob/master/JavaPractice3/fcfs_img/p1.png)图片1
* [一个队列情况](https://github.com/tzwglike321/MyProject/blob/master/JavaPractice3/fcfs_img/p2.png)图片2
* [一个队列情况](https://github.com/tzwglike321/MyProject/blob/master/JavaPractice3/fcfs_img/p3.png)图片3
* [一个队列情况结束和两个队列情况开始](https://github.com/tzwglike321/MyProject/blob/master/JavaPractice3/fcfs_img/p4.png)图片4
* [两个队列情况](https://github.com/tzwglike321/MyProject/blob/master/JavaPractice3/fcfs_img/p5.png)图片5
* [两个队列情况](https://github.com/tzwglike321/MyProject/blob/master/JavaPractice3/fcfs_img/p6.png)图片6
* [两个队列情况](https://github.com/tzwglike321/MyProject/blob/master/JavaPractice3/fcfs_img/p7.png)图片7
* [两个队列情况](https://github.com/tzwglike321/MyProject/blob/master/JavaPractice3/fcfs_img/p8.png)图片8
* [两个队列情况](https://github.com/tzwglike321/MyProject/blob/master/JavaPractice3/fcfs_img/p9.png)图片9
# SJF:
https://github.com/tzwglike321/MyProject/blob/master/JavaPractice3/sjf_img/p1.png
> SJF算法首先调度已到达的任务中，服务时间最短的任务，这里不要求实现任务的抢占,按照FCFS算法的要求实现SJF算法. 同样要求处理两种情况： 当只有一个处理队列时的情况 当有两个处理队列时的情况
* [一个队列情况](https://github.com/tzwglike321/MyProject/blob/master/JavaPractice3/sjf_img/p1.png)图片1
* [一个队列情况](https://github.com/tzwglike321/MyProject/blob/master/JavaPractice3/sjf_img/p2.png)图片2
* [一个队列情况结束和两个队列情况开始](https://github.com/tzwglike321/MyProject/blob/master/JavaPractice3/sjf_img/p3.png)图片3
* [两个队列情况](https://github.com/tzwglike321/MyProject/blob/master/JavaPractice3/sjf_img/p4.png)图片4
* [两个队列情况](https://github.com/tzwglike321/MyProject/blob/master/JavaPractice3/sjf_img/p5.png)图片5
* [两个队列情况](https://github.com/tzwglike321/MyProject/blob/master/JavaPractice3/sjf_img/p6.png)图片6
* [两个队列情况](https://github.com/tzwglike321/MyProject/blob/master/JavaPractice3/sjf_img/p7.png)图片7
