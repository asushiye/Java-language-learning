# Java cipher
 chapter-04-02
		Creating a Cipher
			Cipher Modes
		Initializing a Cipher
		Encrypting and Decrypting Data
		Encrypting / Decrypting Part of a Byte Array
		Encrypting / Decrypting Into an Existing Byte Array
		Reusing a Cipher Instance

The Java Cipher (javax.crypto.Cipher) class represents an encryption algorithm

The term Cipher is standard term for an encryption algorithm in the world of cryptography. 
That is why the Java class is called Cipher and not e.g. Encrypter / Decrypter or something else.

You can use a Cipher instance to encrypt and decrypt data in Java.

## Creating a Cipher

`Cipher cipher = Cipher.getInstance("AES");`

### Cipher Modes

Some encryption algorithms can work in different modes. An encryption mode specifies details about how the algorithm should encrypt data


����ģʽ��ʱ��������ֲ�ͬ�ļ����㷨һ��ʹ�� - ���񸽼ӵ����ļ����㷨�ļ���һ����
�����Ϊʲô��Щģʽ����Ϊ������㷨�����Ƿ���ģ������Ǽ����㷨�ġ������������ ������һЩ��֪��������ģʽ��

EBC - �����뱾
CBC - ���������
CFB - ���뷴��
OFB - �������
CTR - ������

`Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");`

## Initializing a Cipher

Here is an example of initializing a Cipher instance in encryption mode:
```
Key key = ... // get / create symmetric encryption key
cipher.init(Cipher.ENCRYPT_MODE, key);
```
Here is an example of initializing a Cipher instance in decryption mode:
```
Key key = ... // get / create symmetric encryption key
cipher.init(Cipher.DECRYPT_MODE, key);
```

## Encrypting and Decrypting Data
```
byte[] plainText  = "abcdefghijklmnopqrstuvwxyz".getBytes("UTF-8");
byte[] cipherText = cipher.doFinal(plainText);

Decrypting Data
byte[] plainText = cipher.doFinal(cipherText);
```

```
byte[] data1 = "abcdefghijklmnopqrstuvwxyz".getBytes("UTF-8");
byte[] data2 = "zyxwvutsrqponmlkjihgfedcba".getBytes("UTF-8");
byte[] data3 = "01234567890123456789012345".getBytes("UTF-8");

byte[] cipherText1 = cipher.update(data1);
byte[] cipherText2 = cipher.update(data2);
byte[] cipherText3 = cipher.doFinal(data3);

```



ʵ��˵��

```
public class MyCipher {

    public static void main(String[] args)
    {
        try {
            //����AES�ļ����㷨��������
            Cipher cipher = Cipher.getInstance("AES");

            //�������������Կkey
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            SecureRandom secureRandom = new SecureRandom();
            keyGenerator.init(secureRandom);
            Key key = keyGenerator.generateKey();

            //��ʼ������ģʽ
            cipher.init(Cipher.ENCRYPT_MODE, key);

            String plainText1 = "zhenyun.su";

            System.out.println("plainText1: "+plainText1);
            byte[] plainByte = plainText1.getBytes("UTF-8");
            byte[] cipherByte = cipher.doFinal(plainByte);

            //��ʼ������ģʽ
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainText2 = cipher.doFinal(cipherByte);

            System.out.println("plainText2: "+new String(plainText2));


        }catch (NoSuchAlgorithmException e){
            System.out.print(e.getMessage());
         }catch (Exception e){
            System.out.print(e.getMessage());
    }

    }
}
```