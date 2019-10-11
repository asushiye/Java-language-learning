package collection.map;

import java.util.*;

/**
 * @author : zhenyun.su
 * @comment :
 * @since : 2019-10-11
 */

public class Test {
    public static void main(String[] args) {
//        quickStart();
//        map();
        nestMap();
    }

    public static void quickStart() {
        Map<Integer,  Integer> map = new HashMap<>();
        Random random = new Random(37);
        for (int i = 0; i < 1000; i++) {
            Integer rand =  random.nextInt(5);
            Integer value = map.get(rand);
            map.put(rand, map.containsKey(rand) ? (value+1) : 1);
        }
        System.out.println(map);
    }

    public static void map() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "zhenyun.su");
        map.put("age", 20);
        map.put("gender", true);
        System.out.println(map);
        System.out.println("map.size(): "+map.size());
        System.out.println("map.clear()");
//        map.clear();
        System.out.println("map.isEmpty(): "+map.isEmpty());


        System.out.println("map.get(): "+map.get("name"));  // ��ȡname����ֵ����û�з���null
        System.out.println("map.getOrDefault(): "+map.getOrDefault("title", "not title")); // ��ȡname����ֵ����û�з���Ĭ��ֵ
        System.out.println("map.containsKey: "+map.containsKey("name"));
        Set<String> sets = map.keySet();  // ��ȡ���м��ļ���set����û�з��ؿ�ֵ����[]
        System.out.println("map.keySet(): "+sets);
        Collection<Object> values = map.values(); // ��ȡ����ֵ�ļ���collection����û�з��ؿ�ֵ����[]
        System.out.println("map.values(): "+values);

        forPrint(map);
    }

    public static void forPrint(Map<String, Object> map){
        System.out.println("��һ�ֱ�������������Mapʵ��Iterable�ӿڵ�forEach()����");
        map.forEach((key, value)->{
            System.out.println("key="+key+"; value="+value);
        });

        System.out.println("�ڶ��ֱ���������ͨ��key���ϱ�������ȡֵ����");
        Set<String> sets = map.keySet();
        //����������ʾ���ֱ�������
        for (String set:sets){
            System.out.println("key="+set+"; value="+map.get(set));
        }
    }


    public static void nestMap() {
        Map<String, Object> map1 = new HashMap<>();
        map1.put("name", "zhenyun.su");
        map1.put("age", 20);
        map1.put("gender", true);

        Map<String, Object> map2 = new HashMap<>();
        map2.put("name", "cuiyun.shi");
        map2.put("age", 30);
        map2.put("gender", false);

        Map<Integer, Object> nestMap = new HashMap<>();
        nestMap.put(1, map1);
        nestMap.put(2, map2);
        System.out.println(nestMap);
    }
}
