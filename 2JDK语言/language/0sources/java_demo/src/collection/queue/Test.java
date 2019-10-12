package collection.queue;


import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author : zhenyun.su
 * @comment :
 * @since : 2019-10-12
 */

public class Test {
    public static void main(String[] args) {
        priorityQueue(); //���ȼ��ж�
    }

    public static void priorityQueue() {
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.add("dog"); //��ͷ����
        priorityQueue.offer("elephant"); //��β����
        priorityQueue.offer("lion"); //��β����
        priorityQueue.add("cat");
        System.out.println("priorityQueue: " + priorityQueue);

        System.out.println("priorityQueue.size(): " + priorityQueue.size());
        System.out.println("priorityQueue.isEmpty(): " + priorityQueue.isEmpty());

        System.out.println("priorityQueue.peek(): " + priorityQueue.peek()+"; priorityQueue: "+priorityQueue); //��ȡ��ͷԪ�أ����գ��򷵻�null
        System.out.println("priorityQueue.element(): " + priorityQueue.element()+"; priorityQueue: "+priorityQueue);//��ȡ��ͷԪ�أ����գ��򷵻��쳣NoSuchElementException

        System.out.println("priorityQueue.poll(): " + priorityQueue.poll()+"; priorityQueue: "+priorityQueue); //��ȡ��ͷԪ�أ���ɾ�������գ��򷵻�null
        System.out.println("priorityQueue.poll(): " + priorityQueue.remove()+"; priorityQueue: "+priorityQueue); //��ȡ��ͷԪ�أ���ɾ�������գ��򷵻��쳣NoSuchElementException
        forPrint(priorityQueue);

    }

    public static void forPrint(Queue<String> queue){
        System.out.println("��һ�ֱ�������������ʵ��Iterable�ӿڵ�forEach()����");
        queue.forEach(animal -> {
            System.out.println(animal);
        });

        System.out.println("�ڶ��ֱ�������������ʵ��Iterable�ӿڵ�Iterator����");
        Iterator<String> iterator = queue.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }

        System.out.println("�����ֱ�����������򵥷�ʽ");
        for (String name : queue) {
            System.out.println(name);
        }

        System.out.println("�����ֱ���������ʹ��forѭ����ʽ");
        while(queue.size()>=1){
            System.out.println(queue.poll());
        }
    }

    public static void listSort(Queue<String> queue) {
        System.out.println("queue sort begin: "+queue);
        PriorityQueue<String> priorityQueue = new PriorityQueue<>(new MyComparator());
        priorityQueue.addAll(queue);
        System.out.println("queue sort end: "+priorityQueue);
    }
}
