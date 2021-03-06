package creational.start;

import creational.start.build.Director;
import creational.start.build.Product;
import creational.start.build.ProductABuilder;
import creational.start.build.ProductBBuilder;
import creational.start.entity.AbstractProductA;
import creational.start.entity.AbstractProductB;
import creational.start.singleton.SingletonObject;
import creational.start.singleton.SynchronizedObject;

/**
 * @author : zhenyun.su
 * @comment : 创建型模式-测试
 * @since : 2019/8/7
 */

public class ClientCreational {
    public static void main(String[] args) {
        simpleFactory();
        methodFactory();
        abstractFactory();
        builderFactory();
        singletonFactory();
    }

    public static void simpleFactory() {
        System.out.println("===========1.简单工厂模式===========");
        System.out.println("输出A类的产品");
        AbstractProductA productA1 = new creational.start.simple.ProductAFactory().createProductA("ProductA1");
        productA1.service();
        AbstractProductA productA2 = new creational.start.simple.ProductAFactory().createProductA("ProductA2");
        productA2.service();
        System.out.println("输出B类的产品");
        AbstractProductB productB1 = new creational.start.simple.ProductBFactory().createProductA("ProductB1");
        productB1.service();
        AbstractProductB productB2 = new creational.start.simple.ProductBFactory().createProductA("ProductB2");
        productB2.service();
    }

    public static void methodFactory() {
        System.out.println("===========2.工厂方法模式===========");
        System.out.println("输出A类的产品");
        AbstractProductA productA1 = new creational.start.method.ProductA1Factory().createProductA();
        productA1.service();
        AbstractProductA productA2 = new creational.start.method.ProductA2Factory().createProductA();
        productA2.service();
        System.out.println("输出B类的产品");
        AbstractProductB productB1 = new creational.start.method.ProductB1Factory().createProductB();
        productA1.service();
        AbstractProductB productB2 = new creational.start.method.ProductB2Factory().createProductB();
        productA2.service();
    }

    public static void abstractFactory() {
        System.out.println("===========3.抽象工厂模式===========");
        System.out.println("输出产品族1，包含A类和B类");
        AbstractProductA productA1 = new creational.start.sabstract.Product1Factory().createProductA();
        productA1.service();
        AbstractProductB productB1 = new creational.start.sabstract.Product1Factory().createProductB();
        productB1.service();
        System.out.println("输出产品族2，包含A类和B类");
        AbstractProductA productA2 = new creational.start.sabstract.Product2Factory().createProductA();
        productA2.service();
        AbstractProductB productB2 = new creational.start.sabstract.Product2Factory().createProductB();
        productB2.service();
    }
    public static void builderFactory() {
        System.out.println("===========4.建造者模式===========");
        System.out.println("建造产品A");
        Director director = new Director();
        director.setProductBuilder(new ProductABuilder());
        Product productA = director.construct();
        productA.server();
        System.out.println("建造产品B");
        director.setProductBuilder(new ProductBBuilder());
        Product productB = director.construct();
        productB.server();
    }
    public static void singletonFactory() {
        System.out.println("===========4.单实例模式===========");
        SingletonObject singletonObject = SingletonObject.getInstance();
        singletonObject.show();

        SynchronizedObject synchronizedObject = SynchronizedObject.getInstance();
        synchronizedObject.show();

//        SingletonEnum singletonEnum = SingletonEnum.
    }
}