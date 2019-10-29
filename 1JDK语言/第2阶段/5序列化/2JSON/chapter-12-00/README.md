# json

JSON is short for JavaScript Object Notation. 

JSON is a popular data exchange format between browsers and web servers because the browsers can parse JSON into JavaScript objects natively. 


		�ṹ������
		JSON����ָ��
		JSON���
		JSON����


## �ṹ������

* ֻ�����ֽṹ�������ڵļ�ֵ�Լ��Ͻṹ�����顣 ������{}��ʾ���ڲ��ǡ�key��:��value����������[]��ʾ����ֵͬ�ö��ŷֿ�
* ������ֵ��7����number, string, boolean, object, array, null 
* �ټ��Ͻṹ����Ƕ�ף���������������︴�ӵ�����

```
{
   "Image": {
       "Width":  800,
       "Height": 600,
       "Title":  "View from 15th Floor",
       "Thumbnail": {
           "Url":    "http://www.example.com/image/481989943",
           "Height": 125,
           "Width":  "100"
       },
       "IDs": [116, 943, 234, 38793]
     }
}
```


## JSON����ָ��

��ѭ�õ���������������ǰ���80%������:

* ���İ�Google JSON���ָ�ϣ�https://github.com/darcyliu/google-styleguide/blob/master/JSONStyleGuide.md
* Ӣ�İ�Google JSON Style Guide��https://google.github.io/styleguide/jsoncstyleguide.xml


��������ֵ������˫���ţ���Ҫ��ע��д���������棬��������Ҫ���
��Ҫ����ṹ����������Ƽ����ñ�ƽ����ʽ����β�Ҫ̫����
�շ�ʽ��������ѭBean�淶
ʹ�ð汾�����Ʊ����ͻ
����һЩ�ؼ��֣���Ҫ������key
���л�ö������ʱ��ʹ��name������value
����Ҫ�ñ�׼��ʽ����

���ָ���Ƕ���Google����JSON APIs���ṩ��ָ����׼��ͽ��顣

����������JSON APIsӦ��ѭJSON.org�ϵĹ淶.

��Щָ�������ڻ���RPC�ͻ���REST����API��JSON�������Ӧ��


### һ��׼��
JSON�����в�����ע��
### ʹ��˫����
���е�������������˫�����ڡ��ַ����͵�����ֵ����ʹ��˫���š���������ֵ���粼�������֣���Ӧ��ʹ��˫���š�

### ��ƽ������ VS �ṹ���

JSON�е�����Ԫ��Ӧ�Ա�ƽ����ʽ���֡�����Ϊ�˷����������������顣

һ����ַ�����б�ʾ���ַ�ʽ�����ṹ���ķ�ʽ�Կ�����Ա�������ܸ������壺

��ƽ����ַ:
```
{
  "company": "Google",
  "website": "http://www.google.com/",
  "addressLine1": "111 8th Ave",
  "addressLine2": "4th Floor",
  "state": "NY",
  "city": "New York",
  "zip": "10011"
}
```

�ṹ����ַ��

```
{
  "company": "Google",
  "website": "http://www.google.com/",
  "address": {
    "line1": "111 8th Ave",
    "line2": "4th Floor",
    "state": "NY",
    "city": "New York",
    "zip": "10011"
  }
}
```

### ������׼��

ѡ���������������,�շ�ʽ�ģ�ASCII���ַ���,����ʹ��Javascript�еı����ؼ���

��JSON���󱻵���mapʹ��ʱ��API�ļ�Ӧ������˵����

Map�ļ�����һ��Ҫ��ѭ�������Ƶ�����׼�򡣼������԰��������Unicode�ַ����ͻ��˿�ʹ��maps��Ϥ�ķ�������������Щ���ԡ�������result.thumbnails["72"]��

### ���������� VS ����������

��������Ӧ���Ǹ�����������������������Ӧ���ǵ�����

```
{
  // ����
  "author": "lisa",
  // һ��ͬ��, ����
  "siblings": [ "bart", "maggie"],
  // "totalItem" ������������
  "totalItems": 10,
  // �� "itemCount" Ҫ��Щ
  "itemCount": 10
}
```

### ����ֵ׼��

����ֵ������Unicode �� booleans��������, ����(numbers), �ַ���(strings), ����(objects), ����(arrays), �� null.

```
{
  "canPigsFly": null,     // null
  "areWeThereYet": false, // boolean
  "answerToLife": 42,     // number
  "name": "Bart",         // string
  "moreData": {},         // object
  "things": []            // array
}
```

�ջ�Null ����ֵ ���Ǵ�JSON��ȥ�������ԣ��������Ĵ����к�ǿ������ԭ��

ö��ֵӦ�����ַ�������ʽ����

## Java���

* Fastjson
* Jackson
* Gson


## JSON����

* ��ʽ������: jsbeautifier

* soapui: https://www.soapui.org/downloads/soapui.html

