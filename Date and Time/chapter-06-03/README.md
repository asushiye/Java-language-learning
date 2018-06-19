# Java Calender

## chapter-06-03



		����
		ʵ��

## ����

������Ҫ��Ϊ�����������������������������ũ����������
ÿ�����ң��ڲ�ͬʱ��ʹ��������Ҳ��һ����Ŀǰ���������й����Ǹ����������

java.util.Calender ��ʾ�����ࡣ���ܽ���ʵ�����ģ�ԭ�����������кܶ಻ͬ������

һ�����ǹ���ʹ�� **GregorianCalendar** ʵ����

## ʵ��


```
    public static void printCalenderInfo(){
        Calendar calendar = new GregorianCalendar();
        System.out.println("Year= "+calendar.get(Calendar.YEAR));
        System.out.println("month= "+calendar.get(Calendar.MONTH));
        System.out.println("dayOfMonth= "+calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("dayOfWeek= "+calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("weekOfYear= "+calendar.get(Calendar.WEEK_OF_YEAR));
        System.out.println("weekOfMonth= "+calendar.get(Calendar.WEEK_OF_MONTH));

        System.out.println("hour= "+calendar.get(Calendar.HOUR));
        System.out.println("hourOfDay= "+calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("minute= "+calendar.get(Calendar.MINUTE));
        System.out.println("second= "+calendar.get(Calendar.SECOND));
        System.out.println("millisecond= "+calendar.get(Calendar.MILLISECOND));
    }
```

����ʱ��ʱ��Ϊ2018-06-19 14:8:30.416

������
```
Year= 2018
month= 5
dayOfMonth= 19
dayOfWeek= 3
weekOfYear= 25
weekOfMonth= 4
hour= 2
hourOfDay= 14
minute= 8
second= 30
millisecond= 416
```

�ӽ�����ǿ��Կ����������·ݣ�����ֵ��0��ʼ����ΪJANUARY������6�·�ֵΪ5��

�������·ݵ��ܣ�����ֵ��1(SUNDAY)��ʼ��7(SATURDAY), �����ܶ�ֵΪ3.

�����ҿ��Ը��ݲ�ͬ��fieldʱ��Σ�������set������add����������������

```
    public static void setCalender(){
        Calendar calendar = new GregorianCalendar();
        //set date to last day of 2009
        calendar.set(Calendar.YEAR, 2009);
        calendar.set(Calendar.MONTH, 11); // 11 = december
        calendar.set(Calendar.DAY_OF_MONTH, 31); // new years eve
        //add one day
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        //date is now jan. 1st 2010
        System.out.println("Year= "+calendar.get(Calendar.YEAR)); // now 2010
        System.out.println("month= "+calendar.get(Calendar.MONTH));  // now 0 (Jan = 0)
        System.out.println("dayOfMonth= "+calendar.get(Calendar.DAY_OF_MONTH)); // now 1
    }
```

������
```
Year= 2010
month= 0    (Jan = 0)
dayOfMonth= 1
```





