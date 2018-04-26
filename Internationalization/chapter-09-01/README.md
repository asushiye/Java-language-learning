# Java Internationalization: Overview
chapter-09-01

		Handling International Input
		Handling International Output
		Adapting Operations
		User Information Needed
		Application Internationalization Layer
		Why an Internationalization Component?
		Java's Internationalization Classes

Internationalizing a Java application typically means making the application able to handle multiple languages, number formats, date formats etc. This text gives you an overview of these aspects.

Basically, your application should be able to handle international input, output and operations. 

In other words, your application should be able to adapt itself to **input**, **output** and **operations** specific to different locations and user preferences.

## Handling International Input
Input is everything that your application receives from its users, either directly through the user interface, sent to it via service calls (e.g. SOAP or REST calls), imported from files etc. Input includes:

		Form input including
		Text (language + character encoding)
		Number formats
		Date and time formats and calculations
		Files received
		Service calls received
## Handling International Output
Output is everything your application is showing or sending to its users, either during the installation process, or during general use. Output includes:

		Text (language + character encoding)
		Number and currency formatting
		Date and time formatting and calculations
		Character comparisons
		String comparisons


## Adapting Operations

 your application may need to adapt certain internal operations to the users location and preferences

 For instance, a web shop may need to add different amounts of VAT to a sale


## User Information Needed
Ϊ����ȷ�ؽ�����Ӧ�ó��򱾵ػ�Ϊ�û�����������Ҫ����һ���������ݣ�

��ѡ����
��ס����
��ǰλ��
��ѡʱ��



The user should be able to tell what language he or she prefers the application to use

�û���ס�����ܻ�Ӱ���û�����ʹ�õĹ����Լ���Щ���ܵĹ�����ʽ

The application may take action based on the users location

## Application Internationalization Layer
In order to handle internationalization of input and output, your application will have a kind of internationalization layer. 

## Java's Internationalization Classes

Java has a set of built-in classes that can help you handle internationalization of your application. 

These classes are:

|Class|	Description|
|-|-|
|Locale	|The Locale class represents a language and a country or region. A Locale may also represent a certain type of formatting - e.g. date or number formatting.|
|ResourceBundle	|The ResourceBundle class can contain localized texts or components (objects). You obtain a ResourceBundle for a specific Locale, and thus obtain texts or objects localized to that Locale.|
|NumberFormat	|The NumberFormat class is used to format numbers according to a certain Locale.|
|DecimalFormat	|The DecimalFormat class is used to format numbers according to customized formatting patterns. These patterns are also Locale sensitive.|
|DateFormat	|The DateFormat class is used to format dates according to a specific Locale.|
|SimpleDateFormat	|The SimpleDateFormat class is used to parse and format dates according to custom formatting patterns. These patterns are also Locale sensitive.|



�ܶ���֮�����Խ�̫�౾�ػ��������û������ԣ����һ������ϵ������û������ġ�

���û�ѡ��ʹ��ʲô���ԣ�ʱ����ʹ��ʲô���ָ�ʽ�����ڸ�ʽ�ȡ�Ҳ���Ա˴˶����ؽ��и��ġ�

��Ҫ����󶨵��û��ı�����

