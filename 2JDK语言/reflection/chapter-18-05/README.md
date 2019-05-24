# Java Reflection - Generics,Arrays, Dynamic Proxies 

chapter-18-05

		Dynamic Proxies 
		Dynamic Class Loading and Reloading
		Modules

## Dynamic Proxies 



### Dynamic Proxies

Using Java Reflection you create dynamic implementations of interfaces at runtime. You do so using the class **java.lang.reflect.Proxy**

 Dynamic proxies can be used for many different purposes, e.g. 
 
 database connection and transaction management,
 
 dynamic mock objects for unit testing, 
 
 and other AOP-like method intercepting purposes.


ʹ��Java Reflection��������������ʱ�����ӿڵĶ�̬ʵ�֡� ������ʹ����java.lang.reflect.Proxy���в����� �������������ҽ���Щ��̬�ӿ�ʵ�ֳ�Ϊ��̬�����ԭ�� ��̬�������������಻ͬ��Ŀ�ģ����磬 ���ݿ����Ӻ�����������ڵ�Ԫ���ԵĶ�̬ģ������Լ�������AOP��������Ŀ�ġ�
### Creating Proxies


### 

refer to : https://blog.csdn.net/pangqiandou/article/details/52964066

һ������ĸ���

��̬������������java����������Ҫ��һ������������ѧϰjava��ܵĻ��������ᶯ̬����������ô��ѧϰSpring��Щ���ʱ��ѧ�����׵ġ�

��̬������������������һ������Ĵ������ġ��ڿ�����Ϊʲô��ҪΪһ�����������������أ�

��һ����ʵ�����е����ӣ�

���Ƕ���һ���Լ��ľ����ˣ���������˾������ǵĴ����ˣ���������Ҫ�����ǳ��裬����ʱ������ֱ���ҵ������ǣ�ֻ���������ǵĴ����ˡ�

��������˴��ڵļ�ֵ�����������Ƕ����»���ֱ�ӷ��ʣ�

�����ʵ�е����Ӻ������ڿ�������һ���ģ������ڿ�����֮����Ҫ����һ������Ĵ��������Ҫ�������ض���ʵҵ�����ķ��ʡ�

��ô�������Ӧ�þ���ʲô�����أ��������Ӧ�þ��к�Ŀ�������ͬ�ķ���

������������ȷ���������������
��������1�����������ڵļ�ֵ��Ҫ�������ض���ʵҵ�����ķ��ʡ�
��������2���������Ӧ�þ��к�Ŀ�����(��ʵҵ�����)��ͬ�ķ�����


����java�еĴ���

2.1��"java.lang.reflect.Proxy"�����

����Ҫ����ĳһ������Ĵ����������������ͨ��ҲҪ��дһ���������ɣ���������Ҫ��д�������ɴ��������ࡣ

��java������ó���ȥ����һ������Ĵ��������


`static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) `

newProxyInstance������������һ�����������������ܹ���3��������

* ClassLoader loader����ָ�����ɴ������ʹ���ĸ���װ������
* Class<?>[] interfaces����ָ�������ĸ�����Ĵ������ͨ���ӿ�ָ����
* InvocationHandler h����ָ������������������Ҫ��ʲô���顣

��������ֻ��Ҫ����newProxyInstance�����Ϳ��Եõ�ĳһ������Ĵ�������ˡ�

2.2���������Ǿٸ�����

1������������Ϊ�ӿ�

```
public interface Person {
    public String sing(String name);
    public String dance(String name);
}

```

2������Ŀ��ҵ�������

```
public class LiuDeHua implements Person {
    @Override
    public String sing(String name) {
        System.out.println("�����»�������"+name+"��");
        return "���ѳ���лл��ң�";
    }

    @Override
    public String dance(String name) {
        System.out.println("�����»�������"+name+" ��");
        return "�赸���꣬лл��ң�";
    }
}
```

3��ʵ�ִ�����

```
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LdhInvocationHandler implements InvocationHandler {
    private Person person = null;

    public LdhInvocationHandler(Person person) {
        this.person = person;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("sing".equals(method.getName())){
            System.out.println("�������ľ����ˣ�Ҫ�������裬�Ƚ�10��");
            return method.invoke(person,args);
        }
        if ("dance".equals(method.getName())){
            System.out.println("�������ľ����ˣ�Ҫ�������裬�Ƚ�20��");
            return method.invoke(person,args);
        }
        return null;
    }
}
```

4���������ɴ������Ĵ�����

```
public class LiuDeHuaProxy {
    private Person ldh = new LiuDeHua();

    public Person getPersonProxy(){
        InvocationHandler ldhInvocationHandler = new LdhInvocationHandler(ldh);
        try {
            return(Person) Proxy.newProxyInstance(LiuDeHuaProxy.class.getClassLoader(), ldh.getClass().getInterfaces(),
                    ldhInvocationHandler);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

}
```
5����д������

```
public class PersonProxyTest {
    public static void main(String[] args) {
        LiuDeHuaProxy proxy = new LiuDeHuaProxy();

        Person person= proxy.getPersonProxy();
        String retSing = person.sing("����");
        System.out.println(retSing);
        String retDance = person.dance("����");
        System.out.println(retDance);
    }
}

```