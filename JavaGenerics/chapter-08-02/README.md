# Java Generic Classes

## Java Generic Classes

���������Լ���Java�ࡣ ���Ͳ�����Java API�е�Ԥ������



## Java Generic Methods

```
    public static <T> T AddAndReturn(T element, Collection<T> collection){
        collection.add(element);
        return element;
    }

    public static void main(String[] args){
        String stringElement = "name";
        List<String> list =  new ArrayList<String>();
        String theElement= GenericMethod.AddAndReturn(stringElement, list);
	System.out.println(list.iterator().next());

        Integer integerElement = 1;
        Set<Integer> set = new HashSet<Integer>();
        Integer theiElement = GenericMethod.AddAndReturn(integerElement, set);
        System.out.println(set.iterator().next());
    }
```

<T> ��ʾ����ָ��ΪT�ķ������ͣ� T��ʾ��������ֵΪT����


## Java Generics - Class Objects as Type Literals

```
public static <T> T getInstance(Class<T> theClass)
    throws IllegalAccessException, InstantiationException {

    return theClass.newInstance();
}

String string   = getInstance(String.class);

MyClass myClass = getInstance(MyClass.class);
```


## Java Generics - Implementing the Iterable Interface

```
public class MyCollection<E> implements Iterable<E>{

    public Iterator<E> iterator() {
        return new MyIterator<E>();
    }
}

public class MyIterator <T> implements Iterator<T> {

    public boolean hasNext() {
    
        //implement...
    }

    public T next() {
        //implement...;
    }

    public void remove() {
        //implement... if supported.
    }
}

Here is how to use the MyCollection generified, and with the new for-loop:

public static void main(String[] args) {
    MyCollection<String> stringCollection = new MyCollection<String>();

    for(String string : stringCollection){

    }
}

```



