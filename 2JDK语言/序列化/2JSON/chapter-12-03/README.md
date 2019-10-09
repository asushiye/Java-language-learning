# fastjson

https://github.com/alibaba/fastjson


## Maven������Fastjson

```
<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.47</version>
</dependency>
```

## ���л�һ�������JSON�ַ���

����Car��
```
public class Car {
    private String brand;
    private Integer doors;
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private ZonedDateTime createDate;
    private Boolean canDrive;
    private String Field1;
    private String Field2;

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", doors=" + doors +
                ", createDate=" + DateTimeFormatter.ofPattern("yyyy-MM-dd H:m:s").format(createDate)+
                ", canDrive=" + canDrive +
                ", Field1='" + Field1 + '\'' +
                ", Field2='" + Field2 + '\'' +
                '}';
    }

```

```
public static void main(String[] args) {
        System.out.println(JSON.defaultLocale);
        System.out.println(JSON.defaultTimeZone);

        Car car = new Car();
        car.setBrand("daphne");
        car.setDoors(4);
        car.setCreateDate(ZonedDateTime.now());
        car.setCanDrive(true);
        car.setField1("");
        car.setField2(null);

        String carJson = JSON.toJSONString(car);
        // {"brand":"daphne","canDrive":true,"createDate":"2018-04-27 14:30:04","doors":4,"field1":""}
        System.out.println(carJson);

    }
```

## �������л�����

fastjson�����л����Զ�����ö���� **com\alibaba\fastjson\serializer\SerializerFeature.java**�У�

����ͨ�����ö�����Ե�FastjsonConfig��ȫ��ʹ�ã�
Ҳ������ĳ�������JSON.writeJSONStringʱ��Ϊ����ʹ�á�

1. QuoteFieldNames, //keyʹ������
2. UseSingleQuotes, //ʹ�õ�����
3. WriteMapNullValue, //���Map��nullֵ
4. WriteEnumUsingToString, //ö���������toString�Ľ��
5. WriteEnumUsingName, //ö���������name
6. UseISO8601DateFormat, //ʹ�����ڸ�ʽ
7. WriteNullListAsEmpty, //ListΪ�������[]
8. WriteNullStringAsEmpty, //StringΪ�����������
9. WriteNullNumberAsZero, //Number����Ϊ�������0
10. WriteNullBooleanAsFalse, //Boolean����Ϊ�������false
11. SkipTransientField,
12. SortField, //�����ֶ�
13. WriteTabAsSpecial,
14. PrettyFormat, // ��ʽ��JSON����
15. WriteClassName, // �������
16. DisableCircularReferenceDetect, // ��ֹѭ������
17. WriteSlashAsSpecial, // ��б�ܡ�/������ת��
18. BrowserCompatible,
19. WriteDateUseDateFormat, // ȫ���޸����ڸ�ʽ,Ĭ��Ϊfalse��JSON.DEFFAULT_DATE_FORMAT = ��yyyy-MM-dd��;JSON.toJSONString(obj, SerializerFeature.WriteDateUseDateFormat);
20. PrettyFormat   //��ʽ��Tree�ṹչʾ

```
public static void main(String[] args) {
        System.out.println(JSON.defaultLocale);
        System.out.println(JSON.defaultTimeZone);

        Car car = new Car();
        car.setBrand("daphne");
        car.setDoors(4);
        car.setCreateDate(ZonedDateTime.now());
        car.setCanDrive(true);
        car.setField1("");
        car.setField2(null);

        String carJson = JSON.toJSONString(car,
                SerializerFeature.PrettyFormat,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteNullListAsEmpty
        );
        System.out.println(carJson);

    }
```
������
```
{
	"brand":"daphne",
	"canDrive":true,
	"createDate":"2018-04-27 14:34:13",
	"doors":4,
	"field1":"",
	"field2":""
}
```

�������Ա���������

```
        String carStringArray=  JSON.toJSONString(car, SerializerFeature.BeanToArray);
        System.out.println(carStringArray);

[true,"2018-04-27 17:41:01",null,4,"daphne",""]

```



##  �����л�һ��JSON�ַ�����Java����

```
    public static void readObjectFromJson(){
        String carJson = "{\"brand\":\"daphne\",\"canDrive\":true,\"createDate\":\"2018-04-27 14:34:13\",\"doors\":4,\"field1\":\"\"}";
        Car car = JSON.parseObject(carJson, Car.class);
        System.out.println(car.toString());

        String carJsons = "[{\"brand\":\"daphne\",\"canDrive\":true,\"createDate\":\"2018-04-27 14:34:13\",\"doors\":4,\"field1\":\"\"},{\"brand\":\"shoebox\",\"canDrive\":true,\"createDate\":\"2019-04-27 14:34:13\",\"doors\":6,\"field1\":\"\"}]";

        List<Car> cars = JSON.parseArray(carJsons, Car.class);
        System.out.println("car count: "+cars.size());
        for (Car item: cars){
            System.out.println(item.toString());
        }
    }

 ```

 ## Annotation

 JSONField 

ע�⣺1����������˽�еģ�������set*�����������޷������л���

package com.alibaba.fastjson.annotation;

```
public @interface JSONField {
    // �������л��ͷ����л���˳��1.1.42�汾֮���֧��
    int ordinal() default 0;

     // ָ���ֶε�����
    String name() default "";

    // ָ���ֶεĸ�ʽ�������ڸ�ʽ����
    String format() default "";

    // �Ƿ����л�
    boolean serialize() default true;

    // �Ƿ����л�
    boolean deserialize() default true;
}
```
