# JVM 概述

Java Virtual Machine ，Java 程序的**运行环境（Java 二进制字节码的运行环境）**

#### JVM、JRE、JDK的关系

<img src="/Users/kevin/Documents/MyCode/jvm_prac/img/截屏2022-09-01 11.09.33.png" alt="截屏2022-09-01 11.09.33" style="zoom:20%;" />

JVM的学习路线，也是java程序运行到的流程

<img src="/Users/kevin/Documents/MyCode/jvm_prac/img/截屏2022-09-01 11.10.59.png" alt="截屏2022-09-01 11.10.59" style="zoom:30%;" />

**ClassLoader：Java 代码编译成二进制后，会经过类加载器，这样才能加载到 JVM 中运行。**
**Method Area：类是放在方法区中。**
**Heap：类的实例对象。**
**当类调用方法时，会用到 JVM Stack、PC Register、本地方法栈。**
**方法执行时的每行代码是有执行引擎中的解释器逐行执行，方法中的热点代码频繁调用的方法，由 JIT 编译器优化后执行，GC 会对堆中不用的对象进行回收。需要和操作系统打交道就需要使用到本地方法接口。**

# 内存结构

## 程序计数器（内存区域）

Program Counter Register 程序计数器（寄存器）
作用：是记录下一条 jvm 指令的执行地址行号。

执行native本地方法时，程序计数器的值为空（Undefined）。

**程序计数器的值为对应线程执行字节码指令的地址**。程序计数器只是改变所记录的地址，并不会申请新的内存空间，所以程序计数器的内存空间一旦分配，是不会发生改变的，因此也不存在内存溢出。

**jvm指令（实例如下）并不是机器码，jvm指令还要经过解释器变成机器码**

```java
0: getstatic #20 // PrintStream out = System.out; 
3: astore_1 // -- 
4: aload_1 // out.println(1); 
5: iconst_1 // -- 
6: invokevirtual #26 // -- 
9: aload_1 // out.println(2); 
10: iconst_2 // -- 
11: invokevirtual #26 // -- 
14: aload_1 // out.println(3); 
15: iconst_3 // -- 
16: invokevirtual #26 // -- 
19: aload_1 // out.println(4); 
20: iconst_4 // -- 
21: invokevirtual #26 // -- 
24: aload_1 // out.println(5); 
25: iconst_5 // -- 
26: invokevirtual #26 // -- 
29: return
```

特点：

- 是线程私有的
- 不会存在内存溢出（所在的区域不会发生内存溢出）

- 解释器会解释指令为机器码交给 cpu 执行，**程序计数器会记录下一条指令的地址行号**，这样**下一次解释器会从程序计数器拿到指令**然后进行解释执行。

- 多线程的环境下，如果两个线程发生了上下文切换，那么程序计数器会记录线程下一行指令的地址行号，以便于接着往下执行。

### 虚拟机栈（内存空间）

- 每个线程运行需要的内存空间，称为虚拟机栈
- 每个栈由多个栈帧（Frame）组成，对应着每次调用方法时所占用的内存
- 每个线程只能有一个活动栈帧，对应着当前正在执行的方法

栈内存是方法调用产生的，方法调用结束后会弹出栈，所以不涉及垃圾回收

栈内存越大，可以支持更多的递归调用，但是可执行的线程数就会越少。

栈帧过大、过多、或者第三方类库操作，都有可能造成栈内存溢出 java.lang.stackOverflowError 。

使用 -Xss256k 指定栈内存大小

### 本地方法栈

一些带有 native 关键字的方法就是需要 JAVA 去调用本地的C或者C++方法，因为 JAVA 有时候没法直接和操作系统底层交互，所以需要用到本地方法栈，服务于带 native 关键字的方法。