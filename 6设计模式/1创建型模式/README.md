# 1创建型模式

    创建型模式
      简单工厂模式（Simple Factory
      工厂方法模式（Factory Method）
      抽象工厂模式（Abstract Factory）
      建造者模式（Builder）
      原型模式（Prototype）
      单例模式（Singleton）

## 创建型模式

创建型模式对类的实例化过程交给工厂类来完成，将对象的创建与对象的使用过程分离。

包含模式
1. 简单工厂模式（Simple Factory） 重要程度：4 （5为满分）
2. 工厂方法模式（Factory Method） 重要程度：5
3. 抽象工厂模式（Abstract Factory）重要程度：5
4. 建造者模式（Builder）重要程度：2
5. 原型模式（Prototype）重要程度：3
6. 单例模式（Singleton）重要程度：4

创建型模式在创建什么(What)，由谁创建(Who)，何时创建(When)等方面都为软件设计者提供了尽可能大的灵活性，

在实际中结合不同场景来使用不同创建型模式。

### 简单工厂模式（Simple Factory

#### 定义

简单工厂模式专门定义一个工厂类来负责创建其他类的实例，被创建的实例通常都具有共同的父类。

根据不同参数来返回不同类的实例

#### 包含的角色

**工厂角色**负责实现创建所有实例的内部逻辑；
**抽象产品角色**是所创建的所有对象的父类，负责描述所有实例所共有的公共接口；
**具体产品角色**是创建目标，所有创建的对象都充当这个角色的某个具体类的实例。

#### 优缺点

优点：当你需要什么，只需要传入一个正确的参数，就可以获取你所需要的对象，而无须知道其创建细节。
缺点：工厂类的职责相对过重，增加新的产品需要修改工厂类的判断逻辑，这一点与开闭原则是相违背的

#### 适用场景

产品类级少，工厂类很少修改，工厂方法中的业务比较简单的业务场景。

比如Java加密技术
```
获取不同加密算法的密钥生成器:
KeyGenerator keyGen=KeyGenerator.getInstance("DESede");
创建密码器:
Cipher cp=Cipher.getInstance("DESede");
```

### 工厂方法模式（Factory Method）

#### 定义

在工厂方法模式中，抽象工厂类只针对一种类型产品对象而定义的一个抽象方法，而工厂子类则负责生成具体的产品对象。

若新增一个产品，现有系统保持不变，只要新增对应工厂类和产品类即可。
#### 包含的角色

**抽象工厂类**是定义所有创建抽象产品对象的抽象方法；
**具体工厂类**是抽象工厂类的子类，实现了抽象工厂中定义的工厂方法，并可由客户调用，返回一个具体产品类的实例。
**抽象产品类**是所创建的所有对象的父类，负责描述所有实例所共有的公共接口；
**具体产品类**是创建目标，所有创建的对象都充当这个角色的某个具体类的实例。

#### 优缺点
优点：增加新的产品类时无须修改现有系统，并封装了产品对象的创建细节，系统具有良好的**可扩展性**；

缺点：在于增加新产品的同时需要增加新的工厂，导致系统类的个数成对增加，在一定程度上增加了系统的复杂性。
#### 适用场景

大部分场景都适用，只是编写麻烦

### 抽象工厂模式（Abstract Factory）

#### 定义

抽象工厂模式在工厂方法模式基础上，抽象工厂类提供一系列的用于创建不同类型对象的抽象方法。

假如工厂方法模式针对的是一个产品等级结构，而抽象工厂模式则需要面对多个产品等级结构。

产品等级结构(小米手机，华为手机)都属于手机的等级结构。

在抽象工厂模式下：也就是一个具体工厂类(小米工厂)，可以生产小米手机，也可以生成小米电视

在工厂方法模式下：也就是一个具体工厂类(小米手机工厂)，只生产小米手机

#### 包含的角色

和工厂方法模式一样，抽象工厂类和具体工厂类，都针对一系列的产品对象。

#### 优缺点

优点：保持了系统扩展性外，还简化了工厂方法模式下系统复杂性，在设计之初，就定义出一个组织下所有产品创建的一个抽象工厂方法。

缺点：若一个组织下新增的产品，只能新增工厂类。

#### 适用场景

大部分场景都可以应用，特别是一个组织下有很多产品。

### 建造者模式（Builder）

#### 定义

建造者模式是一步一步创建一个复杂的对象，它允许用户只通过指定复杂对象的内容就可以构建它们，

用户不需要知道内部的具体构建细节

#### 包含的角色

抽象建造者：为创建一个产品对象的各个部件指定抽象接口；
```
具体建造者：实现了抽象建造者的接口完成各个部件的构造和装配方法，
并提供一个方法返回创建好的复杂产品对象；
```
产品角色：是被构建的复杂对象，包含多个组成部件；
```
指挥者：负责安排复杂对象的建造次序，指挥者与抽象建造者之间存在关联关系，
可以在其construct()建造方法中调用建造者对象的部件构造与装配方法，完成复杂对象的建造
```
#### 优缺点
优点：极大简化类产品对象的使用者，因为已将过于复杂产品类，通过指挥者和建造者完成产品的创建。

缺点:在于由于建造者模式所创建的产品一般具有较多的共同点，其组成部分相似，

因此其使用范围受到一定的限制，如果产品的内部变化复杂，

可能会导致需要定义很多具体建造者类来实现这种变化，导致系统变得很庞大
#### 适用场景

只针对同一个类型的复杂产品

### 原型模式（Prototype）

### 单例模式（Singleton）

#### 定义

单例模式确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例，这个类称为单例类，它提供全局访问的方法

#### 包含的角色

在单例类的内部实现只生成一个实例，同时它提供一个静态的工厂方法，让客户可以使用它的唯一实例；为了防止在外部对其实例化，将其构造函数设计为私有。

#### 优缺点

优点：在于提供了对唯一实例的受控访问并可以节约系统资源；

缺点：在于因为缺少抽象层而难以扩展，且单例类职责过重。
#### 适用场景

系统只需要一个实例对象；客户调用类的单个实例只允许使用一个公共访问点。
