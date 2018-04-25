# Exception


		Exception Hierarchies
		Checked or Unchecked Exceptions?
		Exception Wrapping
		Fail Safe Exception Handling
		Validation - Throw Exceptions Early
		logging Exceptions: Where to Log Exceptions?



It is a good idea to create a base exception for your API or application, and have all other exceptions subclass this base exception. 

Individual subclasses makes it possible (but not obligatory) to catch and handle these individual exceptions differently. 

You should create individual exceptions only for errors that can actually be handled differently.

```
public class MyException extends Exception{
    //constructors etc.
}
```

## Checked or Unchecked Exceptions?

* Checked exceptions must be explicitly caught or propagated as described in Basic try-catch-finally Exception Handling. Unchecked exceptions do not have this requirement. They don't have to be caught or declared thrown.

* Checked exceptions in Java extend the java.lang.Exception class. Unchecked exceptions extend the java.lang.RuntimeException.

�Ҷ���Ľ�����ֻʹ�ü����쳣��ֻʹ��δ�����쳣������쳣����ͨ���ᵼ�»����Ͳ�һ�µ�ʹ��

### Checked  Exceptions

```
public class MyCheckException extends Exception {
    public MyCheckException(String message) {
        super(message);
    }
}


public class MyUseCheckException {

    public static String testException(Boolean bException) throws MyCheckException{
        if (bException) {
            throw new MyCheckException("MyCheckException throw Exception");
        };
        return "test";
    }

    public static void main(String[] args) {
        try {
            MyUseCheckException.testException(Boolean.TRUE);
        }catch (MyCheckException e) {
            System.out.println(e.getMessage());
        }
    }
}

```

### Unchecked Exceptions

```
public class MyUnCheckException extends RuntimeException {
    public MyUnCheckException(String message) {
        super(message);
    }
}


public class MyUseUnCheckException {

    public static String testException(Boolean bException){
        if (bException) {
            throw new MyUnCheckException("MyUnCheckException throw Exception");
        };
        return "test";
    }

    public static void main(String[] args) {
        MyUseUnCheckException.testException(Boolean.TRUE);


    }
}

```

Notice how the testException() method no longer declares that it throws MyUnCheckException

The MyUseUnCheckException main() method doesn't have to catch the BadUrlException either

and it no longer has to declare that it propagates the exception.


## Exception Wrapping
		What is Exception Wrapping?
		Why Use Exception Wrapping?


### What is Exception Wrapping?

Exception wrapping is wrapping is when you catch an exception, wrap it in a different exception and throw that exception. Here is an example:

```

    try{
        dao.readPerson();
    } catch (SQLException sqlException) {
        throw new MyException("error text", sqlException);
    }
```

### Why Use Exception Wrapping?

����ʹ���쳣��װ����Ҫԭ������ֹ�����һ�����ϴ���������֪��ϵͳ��ÿ�����ܵ��쳣��

�ϲ��������֪���²�����쳣ϸ�ڣ�����DAO�㣬�����ṩ���ݣ������ݴӲ�ͬ�ĵط���ȡʱ��Ӧ�쳣

���ݿ⣬Web Service��file�ж�ȡ�����Ӧ�׳�SQLException, RemoteException,IOException

���ǿ��Զ���DaoException ����װSQLException, RemoteException,IOExceptionͳһ�������쳣


## Fail Safe Exception Handling

�����catch��finally���������쳣������쳣���ܻ����ظÿ鲶����쳣�� ��ͼȷ�������ԭ��ʱ���������Եġ�

```
  InputStream input = null;

  try{

    input = new FileInputStream("myFile.txt");

    //do something with the stream

  } catch(IOException e){
    throw new WrapperException(e);
  } finally {
    try{
     input.close();
    } catch(IOException e){
       throw new WrapperException(e);
    }
  }

```

FileInputStream constructor throws a FileNotFoundException, and NullPointerException thrown from the finally block

��IOException �� NullPointerException warppering WrapperException

```
    try{
     if(input != null) input.close();
    } catch(IOException e){  //second catch block
       throw new WrapperException(e);
    }
```

## Validation - Throw Exceptions Early

��֤ - �����׳��쳣

For instance, in a DAO method that inserts a user and an address into two different tables in a database, do like this:

```
  check if user already exists
  validate user
  validate address

  insert user
  insert address
```
Do not do like this:

```
  check if user already exists
  validate user
  insert user

  validate address
  insert address

```
## logging Exceptions: Where to Log Exceptions?

��¼�쳣���������¼�쳣��

When designing the logging of an application the question often arise: Where in the code should the exceptions be logged? Basically you have three different options:

* Bottom Level Logging
> Logging in the component where the exception occurs

* Mid Level Logging
> Logging somewhere in the middle of the call stack, where sufficient information is available (the context of the component call)

* Top Level Logging
> Logging centrally at the top of the call stack

�ҽ��龡����ʹ�ö�����־��¼����Ϊ�������ױ����ά������������������ڿ�ʼʱ�����е����ţ�Ҳ�����ڿ����������Ժ���ӡ� �����ܻ����������ڽϵͼ��𲶻�ʹ����쳣�����������Щ������ҵľ����в��ᾭ������

