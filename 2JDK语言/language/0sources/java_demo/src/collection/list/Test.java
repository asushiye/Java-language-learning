package collection.list;

import collection.FillCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author : zhenyun.su
 * @comment :
 * @since : 2019-10-11
 */

public class Test {
    public static void main(String[] args) {
        arrayList();
//        linkedList();
    }

    public static void arrayList() {
        List<String> smallAnimals = new ArrayList<>();
        smallAnimals.add("dog");
        smallAnimals.add("cat");
        System.out.println("1 smallAnimals add dog,cat: " + smallAnimals);

        System.out.println("1 smallAnimals dog index: " + smallAnimals.indexOf("cat"));
        String dog = smallAnimals.get(0);
        smallAnimals.remove(dog);
        System.out.println("1 smallAnimals remove dog: " + smallAnimals);
        System.out.println("1 smallAnimals.contains(dog): " + smallAnimals.contains(dog));
        System.out.println("1 smallAnimals.isEmpty(): " + smallAnimals.isEmpty());
        System.out.println("1 smallAnimals.size(): " + smallAnimals.size());
        smallAnimals.clear();
        System.out.println("1 smallAnimals.clear():" + smallAnimals);
        smallAnimals.add("dog");
        smallAnimals.add("cat");

        List<String> bigAnimals = new ArrayList<>();
        bigAnimals.add("elephant");
        bigAnimals.add("lion");
        System.out.println("2 bigAnimals add elephant, lion: " + bigAnimals);

        List<String> animals = new ArrayList<>();
        animals.addAll(smallAnimals);
        animals.addAll(bigAnimals);
        System.out.println("2 animals add smallAnimals, bigAnimals : " + animals);

        System.out.println("2 animals.containsAll(bigAnimals) is " + animals.containsAll(bigAnimals));
        System.out.println("2 smallAnimals.containsAll(bigAnimals) is " + smallAnimals.containsAll(bigAnimals));

        List<String> subAnimals = animals.subList(2, animals.size());
        System.out.println("3 get sub animals from animals : " + subAnimals);

        forPrint(animals);

        listSort(animals);
    }

    public static void linkedList() {
        LinkedList<String> animals = new LinkedList<>();
        animals.addFirst("cat");  //addFirst ����ͷ�������
        animals.addFirst("dog");
        System.out.println("1 animals add cat, dog to list begin:" + animals);

        animals.addLast("elephant"); //addLast ����β�������
        animals.addLast("lion");
        System.out.println("1 animals add elephant, lion to list end:" + animals);


        System.out.println("2 animals.getFirst(): " + animals.getFirst()); //getFirst ��ȡ��ͷ������ɾ��, ���գ��쳣NoSuchElementException
        System.out.println("2 animals.getFirst(): " + animals.getFirst());
        System.out.println("2 animals.getLast(): " + animals.getLast()); //getLast ��ȡ��ͷ������ɾ��, ���գ��쳣NoSuchElementException
        System.out.println("2 animals.getLast(): " + animals.getLast());

        System.out.println("2 animals.peek(): " + animals.peek()); //peek ��ȡ��ͷ������ɾ��, ����,���� null
        System.out.println("2 animals.peekLast(): " + animals.peekLast());

        System.out.println("2 animals.poll(): " + animals.poll() + "; animals: " + animals); //������ͷԪ�أ���ɾ��, ����,���� null
        System.out.println("2 animals.pollLast(): " + animals.pollLast() + "; animals: " + animals);//������βԪ�أ���ɾ��, ����,���� null

        System.out.println("2 animals.removeFirst(): " + animals.removeFirst() + "; animals: " + animals); //������ͷԪ�أ���ɾ��, ���գ��쳣NoSuchElementException
        System.out.println("2 animals.pop(): " + animals.pop() + "; animals: " + animals); //pop()����removeFirst����

        animals.add("dog");
        animals.add("cat");
        forPrint(animals);

        listSort(animals);
    }

    public static void forPrint(List<String> list) {
        System.out.println("��һ�ֱ�������������arrayListʵ��Iterable�ӿڵ�forEach()����");
        list.forEach(animal -> {
            System.out.println(animal);
        });

        System.out.println("�ڶ��ֱ�������������arrayListʵ��Iterable�ӿڵ�Iterator����");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        System.out.println("�����ֱ�����������򵥷�ʽ");
        for (String name : list) {
            System.out.println(name);
        }

        System.out.println("�����ֱ���������ʹ��forѭ����ʽ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + "= " + list.get(i));
        }
    }

    public static void listSort(List<String> list) {
        System.out.println("4 animals sort start: " + list);
        list.sort(new MyComparator());
        System.out.println("4 animals sort end: " + list);
    }
}