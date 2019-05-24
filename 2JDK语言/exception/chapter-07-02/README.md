# java exception  - java�쳣����

		�쳣����
		try-catch-finally���л���
			�﷨����
			ִ��˳��
		Java���ڵ��쳣
			Throwable��
			Java�����쳣
				����ʱ�쳣�༰���� runtimeException
				������ʱ�쳣�༰����
		����Լ��쳣��


## �쳣����

Java���쳣��ָ���ڶ����ĸ���״�����磺�ļ��Ҳ�������������ʧ�ܡ��Ƿ������ȡ�

�쳣��һ���¼����������ڳ��������ڼ䣬������������ָ������

Java�쳣���Ƕ��󣬴�Throwable��̳ж����Ĳ������ṩ�ܶ��������������ֲ�ͬ���쳣��

�쳣��㼶�ṹͼ��

![exception](exception.png)

Throwable�� ��������Ҫ�����ࣺException���쳣���� Error�����󣩣����߶��� Java �쳣�������Ҫ���࣬���Զ������������ࡣ

Error����Щ�����ʾ���Ϸ�����������������߷������������ͼִ��Ӧ��ʱ��

��Java��������д���Virtual MachineError�����ඨ�����NoClassDefFoundError���ȡ�

��Щ�����ǲ��ɲ�ģ���Ϊ������Ӧ�ó���Ŀ��ƺʹ�������֮ �⣬���Ҿ�������ǳ�������ʱ��������ֵ�״����

������ƺ����Ӧ�ó�����˵����ʹȷʵ�����˴��󣬱�����Ҳ��Ӧ����ͼȥ��������������쳣״������ Java�д���ͨ��Error������������

Exception�� �ǳ�������Դ�����쳣����Ϊ����ʱ�쳣RuntimeException�ͷ������쳣����RuntimeException������

** �쳣�ʹ���������쳣�ܱ���������Դ����������޷�����** 

����ʱ�쳣��RuntimeException�༰�����඼������ʱ�쳣����NullPointerException(��ָ���쳣)��IndexOutOfBoundsException(�±�Խ���쳣)�ȣ�

��Щ�쳣�ڱ���ʱ�����м���쳣(��ʹû����try-catch��䲶������Ҳû����throws�Ӿ������׳�����Ҳ�����ͨ��)

���ǿ���ѡ�񲶻���Ҳ���Բ�������Щ�쳣һ�����ɳ����߼���������ģ�����Ӧ�ô��߼��ǶȾ����ܱ��������쳣�ķ�����


������ʱ�쳣 �������쳣������RuntimeException������쳣������IOException��SQLException��

�ӳ����﷨�ǶȽ��Ǳ�����д�����쳣���������������Ͳ��ܱ���ͨ����



## try-catch-finally���л���

### �﷨����

1. try֮�������� catch �� finally �顣try ����ͬʱ�� catch �� finally �鲢��catch��finallyǰ�棬��������һ���顣
2. catch ������Ӧ���쳣���������ء�
4. һ�� try ������ж�� catch �顣����ˣ���ִ�е�һ��ƥ��顣��Java��������ʵ���׳����쳣�������κ͸���catch������������쳣����ƥ�䣬����쳣����Ϊĳ���쳣���ͻ��������ʵ������ִ�����catch����飬������ִ�������� catch�����
5. ��Ƕ�� try-catch-finally �ṹ��
6. �� try-catch-finally �ṹ�У��������׳��쳣��
7. ��������������ܽ�ִ�� finally ��Ϊ������JVM ������ֹ������ System.exit(int)������ finally �����׳�һ��δ������쳣��������ϵ硢ʧ�𡢻���������������

### ִ��˳��

1. tryû�в����쳣��try�����е������һ��ִ�У���������catch���飬ִ��finally�����������䣻

2. try�����쳣��catch������û��ƥ���Ӧ�쳣�࣬�쳣û�б�����

���쳣���ᴫ�����ϲ㷽������finally���������仹�ǻᱻִ�У���finally��������䲻�ᱻִ�У�

�ر���ʾ�����finally���� return��䣬�쳣���ᱻ�������ϲ㷽����

3. try�����쳣��catch��������ƥ���Ӧ�쳣��,�쳣������

try������䲻�ᱻִ�У�������catch����Ҳ���ᱻִ�У�catch����ִ�����ִ��finally���������䣬���ִ��finally��������䣻


![trycatchfinally](trycatchfinally.png)

## Java���ڵ��쳣


### Throwable��

getCause()�������׳��쳣��ԭ����� cause �����ڻ�δ֪���򷵻� null��

getMeage()�������쳣����Ϣ��Ϣ��

printStackTrace()������Ķ�ջ����������������������Ϊ�ֶ� System.err ��ֵ��

��ʱΪ�˼򵥻���Ե�catch����Ĵ��룬����try-catch���ͳ���һ�ְ��裬

һ�����������й����г������쳣���ͻ���Դ����쳣������������ԭ����Ѳ��ҡ������Լ���Ե��쳣


### Java�����쳣

####  ����ʱ�쳣�༰���� runtimeException

1.  java.lang.ArrayIndexOutOfBoundsException

    ��������Խ���쳣���������������ֵΪ��������ڵ��������Сʱ�׳���

2. java.lang.ArithmeticException

    ���������쳣��Ʃ�磺��������ȡ�

3. java.lang.NullPointerException

    ��ָ���쳣����Ӧ����ͼ��Ҫ��ʹ�ö���ĵط�ʹ����nullʱ���׳����쳣��Ʃ�磺����null�����ʵ������. ����null���������. ����null����ĳ���. ʹ��throw����׳�null�ȵ�

4. java.lang.ClassNotFoundException

    �Ҳ������쳣����Ӧ����ͼ�����ַ�����ʽ�����������࣬���ڱ���CLASSPAH֮���Ҳ�����Ӧ���Ƶ�class�ļ�ʱ���׳����쳣��

5. java.lang.NegativeArraySizeException  ���鳤��Ϊ���쳣

6. java.lang.ArrayStoreException �����а��������ݵ�ֵ�׳����쳣

7. java.lang.SecurityException ��ȫ���쳣

8. java.lang.IllegalArgumentException �Ƿ������쳣

#### ������ʱ�쳣�������

IOException�������������������ʱ���ܳ��ֵ��쳣��

EOFException   �ļ��ѽ����쳣

FileNotFoundException   �ļ�δ�ҵ��쳣

ClassCastException    ����ת���쳣��

ArrayStoreException  �����а��������ݵ�ֵ�׳����쳣

SQLException   �������ݿ��쳣��

NoSuchFieldException   �ֶ�δ�ҵ��쳣

NoSuchMethodException   ����δ�ҵ��׳����쳣

NumberFormatException    �ַ���ת��Ϊ�����׳����쳣

StringIndexOutOfBoundsException �ַ�������������Χ�׳����쳣

IllegalAccessException  ���������ĳ���쳣

InstantiationException  ��Ӧ�ó�����ͼʹ��Class���е�newInstance()��������һ�����ʵ������ָ����������޷���ʵ����ʱ���׳����쳣


## ����Լ��쳣��

�û��Զ����쳣�ֻ࣬��̳�Exception�༴��

����UserException�쳣
```
/**
 * @author : zhenyun.su
 * @since : 2019/1/3
 */

public class UserException extends Exception {
    public UserException(String message) {
        super(message);
    }

    public static void getException(String message) throws UserException {
        throw new UserException(message);
    }
}

```

��̬����getException���ڿ��ٴ����쳣

ʹ������

```
    public static void main(String[] args) {
        try {
            UserException.getException("���б���");
        }catch (UserException e) {
            System.out.println(e.getMessage());
        }
    }
```

