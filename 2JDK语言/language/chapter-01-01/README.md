ʹ��idea 2017.4�汾����


# create, compile and run your first Java app,

������ĵ�һ��java����

>����Idea  �˵� new -> project ��Ĭ����һ����ѡ����Ŀ·��


��srcĿ¼��
```
package mypackage;

public class MyJavaApp {
    public static void main(String[] args){
        System.out.println("your first java app");
        System.out.println(args[0]);
        System.out.println(args[1]);
    }
}
```


�һ��༭���ڣ�ѡ�� run MyJavaApp
����
Run Configuration
���� application ��program arguments�� Hello World


# a basic Java project is structured, how the Java code is compiled, and how to execute the finished Java program

## java source and class directories

package �ǽ�һ�����java file����һ���ļ���

java source �ļ�һ�����src�ļ����С����maven�����������src/main/javaĿ¼�� javaĿ¼�¾�������Ŀ��·����

## compiling the java source code 

```
java sdk

cd chapter-01-01

mkdir out 

javac src/mypackage/*.java -d out

java -cp out mypackage.MyJavaApp hello world

```