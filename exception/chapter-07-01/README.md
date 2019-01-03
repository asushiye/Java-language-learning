# Basic Exception Handling in Java

		Exception propagation  -  �쳣����
		Throwing Exceptions    -  �׳��쳣
		try-catch-finally            -  �쳣�������
			try
			catch Exceptions   -  �����쳣
			catch Multiple Exceptions
			finally Exceptions        -   ��ʹ�����쳣��һ��Ҫִ��
		How to release resources after an exception  - �쳣�Ժ�����ͷ���Դ ��
			1. Try-Catch-Finally     ʹ��finallyǿ���ͷ���Դ
			2. Try-with-resources    try���� **java.lang.AutoCloseable** �ӿ���ʵ���ͷ�
		Catch or Propagate Exceptions?   - �쳣��ʹ���������ϴ����쳣��
		example

## Exception propagation

if a method A calls B, and B calls C then the call stack looks like this:

    A
    B
    C
 When method C returns the call stack only contains A and B. If B then calls the method D, then the call stack looks like this:

    A
    B
    D

Understanding the call stack is important when learning the concept of exception propagation.

Exception are propagated up the call stack, from the method that initially throws it, until a method in the call stack catches it.

**Ĭ������£��������û�ж��쳣�����쳣һ��������ס�ֱ������JVM�������յ��½����쳣�˳���**


## Throwing Exception

```
    public static float divide(int numberToDivide, int numberToDivideBy) throws Exception {
        if(numberToDivideBy == 0){
            throw new Exception("Cannot divide by 0");
        }
        return numberToDivide / numberToDivideBy;
    }

```

` throw new Exception("Cannot divide by 0");` ��ʾ�����׳��쳣������Ĵ��벻��ִ�У�����finally����

`try-catch` �����ǣ�try-catch �ڲ����쳣��try��䲻��ִ�У�������catchִ�С�


throws Exception���ڷ������,��ʾ�������������쳣�����������ô�����.

�������ô�����Ҫ��������ķ�ʽ��

1. ����ʹ��throws Exception�����ף����쳣ֹͣ�ڱ�������

��ʹ��try catch ���в��񣬲����Ჶ�񵽵��÷������쳣�����Ǳ����������쳣���������ʵ�������֡�

## try-catch-finally            -  �쳣�������

### try

try�����������ִ�д�������в����쳣�������쳣�󣬽���������Ĵ��룬ת��catch���ƥ���쳣���ͻ�throws ת�����ϲ㷽������

### catch  exception

```
    public static void main(String[] args){
        try {
            MyException.divide(2,0);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
```

ʹ�ø������в���ͬ���쳣�������д���

* ���Լ�¼��־
* ��ӡ���쳣��Ϣ
* �Ե��쳣�����д���

��throw new Exception("Cant divide zero") �����ǣ�throw�����׳��쳣


ʹ��catch�����ƥ���쳣����ƥ����������Ӧcatch����������쳣��


### catch Multiple Exceptions

```
try {
   statement
} catch(SQLException e) {
    logger.log(e);
} catch(IOException e) {
    logger.log(e);
} catch(Exception e) {
    logger.severe(e);
}

����

try {
   statement
} catch(SQLException | IOException e) {
    logger.log(e);
} catch(Exception e) {
    logger.severe(e);
}
```

### finally Exceptions

```
    public void openFile(){
        FileReader reader = null;
        try {
            reader = new FileReader("someFile");
            int i=0;
            while(i != -1){
                i = reader.read();
                System.out.println((char) i );
            }
        } catch (IOException e) {
            //do something clever with the exception
        } finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    //do something clever with the exception
                }
            }
            System.out.println("--- File End ---");
        }
    }
```


ʹ��finally��ȷ������ʹ�����쳣ʱ�ܱ�֤�������ִ�У�����ҪӦ����Դ���ͷš�

## How to release resources after an exception  - �쳣�Ժ�����ͷ���Դ ��

���������ַ�����ʵ����Դ���ͷ�

1. Try-Catch-Finally     ʹ��finallyǿ���ͷ���Դ
2. Try-with-resources   try���� **java.lang.AutoCloseable** �ӿ���ʵ���ͷ�

### Try-Catch-Finally

```
    private static final String FILE_FULL_NAME= "E:\\6_Java\\4_workdemo\\Java-language-learning\\exception\\chapter-07-01\\src\\file.txt";

    private static void printFile() throws IOException {
        InputStream input = null;

        try {
            input = new FileInputStream(FILE_FULL_NAME);

            int data = input.read();
            while(data != -1){
                System.out.print((char) data);
                data = input.read();
            }
        } finally {
            if(input != null){
                input.close();
            }
        }
    }
```
��finally �е���FileInputStream.close()���ͷ���Դ


### Try-with-resources

```
    private static void pringFileFromJava() throws IOException{
        try (InputStream  input = new FileInputStream(FILE_FULL_NAME)) {
            int data = input.read();
            while(data != -1){
                System.out.println((char) data);
                data= input.read();
            }
        }
    }
```

�ڹؼ��� **try**  ����������Դ���� input������try�����������Զ��ͷ���Դ

Ϊʲô���ͷ��أ�

FileInputStreamʵ�� ** java.lang.AutoCloseable** �ӿڣ��ӿ��е�close()����ʵ����Դ�ͷ�


Ҳ�����������Ҳʵ��AutoCloseable�ӿڵķ�����Ҳ������try-with-resources��ʵ����Դ���Զ��ͷš�

ʵ�����£�

��д��Դ��MyAutoClosable
```
public class MyAutoClosable implements AutoCloseable {

    public void doIt(){
        System.out.println("MyAutoClosable doing it!");
    }

    @Override
    public void close() throws Exception {
        System.out.println("MyAutoClosable closed!");
    }
}

```

������Դ��
```
    private static void myClose() throws Exception{
        try(MyAutoClosable myAutoClosable =  new MyAutoClosable()){
            myAutoClosable.doIt();
        }
    
```

�÷�����try�����ʱ���Զ��ͷ�����Դ���쳣��throws Exception�����ס�



## Catch or Propagate Exceptions?   - �쳣��ʹ���������ϴ����쳣��

You might be wondering whether you should catch or propate exceptions thrown in your program. 
It depends on the situation. In many applications you can't really do much about the exception but tell the user that the requested action failed
In these applications you can usually catch all or most exceptions centrally in one of the first methods in the call stack

��Ӧ���÷�����һ������쳣������ʽ������쳣��Ҫ��ʱ�����򲶻��쳣�ķ�ʽ


## example


```
/**
 * @author : zhenyun.su
 * @since : 2019/1/3
 */

public class TestException {
    public TestException() {
    }

    boolean testEx() throws Exception {
        boolean ret = true;
        try {
            ret = testEx1();
        } catch (Exception e) {
            System.out.println("testEx, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx1() throws Exception {
        boolean ret = true;
        try {
            ret = testEx2();
            if (!ret) {
                return false;
            }
            System.out.println("testEx1, at the end of try");
            return ret;
        } catch (Exception e) {
            System.out.println("testEx1, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx1, finally; return value=" + ret);
            return ret;
        }
    }

    boolean testEx2() throws Exception {
        boolean ret = true;
        try {
            for (int i = 2; i >= -2; i--) {
                System.out.println("i=" + 2 / i);
            }
            return true;
        } catch (Exception e) {
            System.out.println("testEx2, catch exception");
            ret = false;
            throw e;
        } finally {
            System.out.println("testEx2, finally; return value=" + ret);
            return ret;
        }
    }

    public static void main(String[] args) {
        TestException testException1 = new TestException();
        try {
            testException1.testEx();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```

�ܶ�����Ϊ���������£�
```
i=2
i=1
testEx2, catch exception
testEx2, finally; return value=false

testEx1, catch exception
testEx1, finally; return value=false

testEx, catch exception
testEx, finally; return value=false
```

��ʵ�ϣ����������£�
```
i=1
i=2
testEx2, catch exception
testEx2, finally; return value=false
testEx1, finally; return value=false
testEx, finally; return value=false
```

��������쳣����ȥ���أ�  

����ֻҪ����return�쳣���ջ��б�main���ز��񲢴���

��ע����ʵ����֮��http://www.importnew.com/14688.html