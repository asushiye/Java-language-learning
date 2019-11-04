package collection.set;

        import java.util.*;

/**
 * @author : zhenyun.su
 * @comment :
 * @since : 2019-10-11
 */

public class Test {
    public static void main(String[] args) {
//        quickstart();
        forprint();
    }

    public static void quickstart() {
        Set<Integer> hashSet = new HashSet<>(47);
        Random random = new Random(30);
        for (int i = 0; i < 10000; i++) {
            hashSet.add(random.nextInt(30));
        }
        System.out.println("hashSet:" +hashSet);

        System.out.println("hashSet.contains(2): "+hashSet.contains(2));
        System.out.println("hashSet.size(): "+hashSet.size());
        System.out.println("hashSet.isEmpty(): "+hashSet.isEmpty());

        Set<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < 10000; i++) {
            treeSet.add(random.nextInt(10));
        }
        System.out.println("treeSet:" +treeSet);

        Set<Integer> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(99);
        System.out.println("linkedHashSet:"+linkedHashSet);

        System.out.println("1 ��treeSet��linkedHashSet�������ϲ���set");
        Set<Integer> set = new TreeSet<>();
        set.addAll(treeSet);
        set.addAll(linkedHashSet);
        System.out.println("1 ���� set :"+set);


        System.out.println("2 ��ȡhashSet��treeSet���������еĽ���retainSet");
        Set<Integer> retainSet = new HashSet<>();
        retainSet.addAll(hashSet);
        System.out.println("retainSet.retainAll(treeSet): "+retainSet.retainAll(treeSet));
        System.out.println("2 ���� retainSet: "+retainSet);

        System.out.println("3 hashSet���ϳ�ȥ����retainSet�ļ�������");
        Set<Integer> subSet = new HashSet<>();
        subSet.addAll(hashSet);
        subSet.removeAll(retainSet);
        System.out.println("3 ��ȥ�����ļ������� subset:"+subSet);


        System.out.println("4 ���ϰ����ж�");
        System.out.println("set.containsAll(linkedHashSet): "+set.containsAll(linkedHashSet));
        System.out.println("hashSet.containsAll(set): "+hashSet.containsAll(set)+"; hashSet: "+hashSet);

        forPrint(hashSet);
    }

    public static void forPrint(Set<Integer> sets) {
        System.out.println("��һ�ֱ�������������arrayListʵ��Iterable�ӿڵ�forEach()����");
        sets.forEach(animal -> {
            System.out.println(animal);
        });

        System.out.println("�ڶ��ֱ�������������arrayListʵ��Iterable�ӿڵ�Iterator����");
        Iterator<Integer> iterator = sets.iterator();
        while (iterator.hasNext()) {
            Integer name = iterator.next();
            System.out.println(name);
        }

        System.out.println("�����ֱ�����������򵥷�ʽ");
        for (Integer name : sets) {
            System.out.println(name);
        }
    }

    public static void forprint() {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 5; i++) {
            set.add(i);
        }

//        set.forEach(item->{
//            set.remove(2);
//            System.out.println(item+" set "+set);
//        });

        for (Integer item:set){
            System.out.println(item+" set "+set);
            if (item == 2){
                set.remove(item);  //��ѭ����ʹ��remove����ʱ����Ҫ��������������ѭ��
                System.out.println(item+" set "+set);
                return ;
            }
        }
    }
}
