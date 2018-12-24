# collections interface

		Overview of Java Collections
		Iterable interface
		collection interface
		���Ϸ���ʵ��


## Java Collections - Overview
 The Java Collections API's provide Java developers with a set of classes and interfaces that makes it easier to handle collections of objects

 it is useful to have an overview of the interfaces it contains

 there are two "groups" of interfaces: Collection's and Map's.

interface hierarchy 

list interface hierarchy

![list](list.png)

set interface hierarchy

![set](set.png)

map intrface hierarchy
![map](map.png)

���ϸ��ӿ�iterable

## Iterable interface

The Iterable interface (*java.lang.Iterable*) is one of the root interfaces of the Java collection classes. 
The Collection interface extends Iterable, so all subtypes of Collection also implement the Iterable interface

The Iterable interface has only one method:
```
public interface Iterable<T> {
  public Iterator<T> iterator();    
}
```

iterable �ṩ����iterator��������ͨ������������ʵ�ּ��ϵı���

```
public interface Iterator<E> {
    boolean hasNext();
    E next();
```

���±���
```
    while (xxx.hasNext){
        statement;
	xxx.next;
    }
```

## collection interface

The Collection interface (java.util.Collection) is one of the root interfaces of the Java collection classes. 

collection�ӿ���Ҫ�ṩ���·���

1. Adding and Removing Elements
2. Checking if a Collection Contains a Certain Element
3. Collection Size
4. Iterating a Collection
5. Collection Subtypes

### collection��Ҫ����

|����|����|
|-|-|
|add|���һ��Ԫ��|
|addAll|�������Ԫ��|
|remove|�Ƴ�һ��Ԫ��|
|removeAll|�Ƴ�����Ԫ��|
|iterator|���ص�����|
|size|���ϴ�С|
|clear|��ռ���|
|contains|�����Ƿ����ĳ��Ԫ��|
|isEmpty|�����Ƿ�Ϊ��|


### Collection Subtypes

* List
* Set
* SortedSet
* NavigableSet
* Queue
* Deque

## ���Ϸ���ʵ��

```
public class MyCollectionUtil {

    public static void printlnItem(Collection collection){
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}


public class MyMain {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("zhenyun.su");

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);

        MyCollectionUtil.printlnItem(list);
        MyCollectionUtil.printlnItem(set);
    }
}

```

#### Adding and Removing Elements

```
public class MyCollectionUtil {

    public static void addItem(Collection collection, Object o){
        collection.add(o);
    }

    public static void clearItem(Collection collection){
        collection.clear();
    }

    public static void remoteItem(Collection collection, Object o){
        collection.remove(o);
    }
}

public class MyMain {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("zhenyun.su");

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "asu1");
        map.put(2, "asu2");

        MyCollectionUtil.clearItem(list);
        MyCollectionUtil.addItem(list, "asushiye");
        MyCollectionUtil.printlnItem(list);

        MyCollectionUtil.remoteItem(set, 2);
        MyCollectionUtil.printlnItem(set);
        MyCollectionUtil.printlnItem(map.entrySet());

    }
}

```
addAll Collection from other collection

```
        Collection collection = new HashSet();
        collection.addAll(set);
        MyCollectionUtil.printlnItem(collection);
        collection.removeAll(set);
```


#### Checking if a Collection Contains a Certain Element and collection size

```
        System.out.println(collection.contains(1));
        collection.removeAll(set);
        System.out.println(collection.contains(1));
	int numberOfElements = collection.size();
```


refer to��JavaGenerics


