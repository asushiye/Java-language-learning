package generic.method;

/**
 * @author : zhenyun.su
 * @comment : ���ͷ���
 * @since : 2019-10-18
 */

public class GenericMethods {
    public <T> void getClassName(T x){
        System.out.println(x.getClass().getName()+" value:"+x);
    }

    public <T> void getExClassName(T x){
        System.out.println(x.getClass().getName());
    }
}
