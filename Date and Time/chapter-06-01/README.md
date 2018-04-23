# Java Date and Time Tutorial



		Java 8 Date Time API
		Java 7 Date Time API


The Java date and time API can be rather confusing when you first try to figure out how to use it. 

Therefore I have put together this little trail on Java's date and time classes. 

Hopefully that will help you get an overview of Java's date and time classes.

Actually, the Java date time API has been changed (cleaned up) in Java 8 with the introduction of a whole new set of classes. 

This tutorial will explain both the Java 8 date time API and the Java 7 date time API

## Java 8 Date Time API

In Java 8 a whole new date time API was added. The new Java date time API is located in the Java package java.time which is part of the standard Java 8 class library.

Java 8����ʱ��API����Ҫ�仯�����ں�ʱ��������1970��1��1�������Ĳ����õ�����������ʾ������������������������ʾ

The **java.time** package also contains a set of subpackages which contain more utilities etc. 

For instance the **java.time.chrono** contains classes to work with Japanese, Thai, Taiwanese and Islamic calendars. 

The **java.time.format** package contains classes used to parse and format dates from and to strings.


|�� | ����|
|-|-|
|Instant | ��ʾһ��ʱ�����ϵ�˲���ʱ��|
|Duration | ��ʾ����ʱ�䣬��������˲��֮���ʱ��|
|LocalDate | ����û��ʱ����Ϣ������ - �������գ��ٷ����ڵ�|
|LocalDateTime | Represents a date and time without time zone information|
|LocalTime | Represents a local time of day without time zone informatio|
|ZonedDateTime | Represents a date and time including time zone information|
|DateTimeFormatter | Formats date time objects as Strings. For instance a ZonedDateTime or a LocalDateTime.|




## Java 7 Date Time API

Java 7 has the following date and time classes and methods. Each of these classes are also explained in their own pages, later. See the links at the bottom of this page, or at the top right of every page.

System.currentTimeMillis()
java.util.Date
java.sql.Date
java.sql.Timestamp
java.util.Calendar
java.util.GregorianCalendar
java.util.TimeZone
java.text.SimpleDateFormat



