# Java Concurrency  

## concept   ----   概念

		Single-threaded
		Multithreading		
		Benefits
		Cost
		Concurrecy Model
			并行工作者模式
			流水线并发模型
			同一线程模型
		关于并发和并行概念

## javaThread   ------  线程类

		概念
		实现
		Thread属性和方法
		        线程名称
			获取当前线程实例
			暂停线程
			停止线程


##  Thread Safe  ------ 线程安全

		竞争状态和临界区
		避免竞争状态
		临界区的吞吐量
		线程安全


## Java memory model  ------   java内存模型

		JVM内存模型
			JVM内存模型结构
			实例说明内存结构
		硬件内存结构
		Java内存模型与硬件内存架构之间的差距
			共享对象，在不同线程中不可见
			在读\写共享对象时产生竞争
		synchronized blocks同步块
			实例方法
			静态方法
			实例方法里面的代码块
			静态方法里面的代码块
		Synchronized  实例演示
			单线程实例
			多线程异常
			同步线程
		Volatile标识
			能保证不同线程可见性
			不能保证共享数据竞争
			
## Java ThreadLocal   ------ 本地线程

		ThreadLocal概念
		ThreadLocal实现
		ThreadLocal实例
		ThreadLocal初始化

## Thread Signaling   ------ 线程信号

		概念
		如何实现线程信号
		忙碌等候信号


## Thread Deadlock   ------  线程死锁

		什么是线程死锁
		如何产生死锁
			实例讲解
			数据库死锁
		如何防止死锁
			1. 锁定顺序
			2. 锁定超时
			3. 死锁检测	

## Java lock   ------ java 锁

		饥饿和公平 - Starvation and Fairness
			Java中饥饿的原因
			用Java实现公平
		锁 - lock
		读写锁 - read / write lock  
		重入锁定 - Reentrance Lockout
		信号量 - Semaphore 
		滑倒的条件  - Slipped Conditions

## Java Blocking Queues  ----- 阻塞队列

		什么是阻塞队列
		阻塞队列实现逻辑

## thread pool   ------  线程池
