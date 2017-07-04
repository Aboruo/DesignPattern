package com.aboruo.DesignPattern.testclient;

public class MianShiTiTest {

	public static void main(String[] args) throws Exception{
		/** 1.请比较一下判断字符串是否为空的三种方法：str == "",str.isEmpty()，str.length > 0，哪个性能更优？自己平时用哪种方式 */
		/*String strTest = "";
		for(int i = 0; i < 10;i++){
			long now1 = System.nanoTime();
			long now2 = 0;
			if(strTest == ""){
				now2 = System.nanoTime();
				System.out.println("strTest==" + (now2 - now1));
			}
			long now3 = 0;
			if(strTest.isEmpty()){
				now3 = System.nanoTime();
				System.out.println("strTest.isEmpty===" + (now3 - now2));
			}
			long now4 = 0;
			if(strTest.length() == 0){
				now4 = System.nanoTime();
				System.out.println("strTest.length===" + (now4 - now3));
			}
		}*/
		/** 1. answer : str == "" 性能更好，需要了解:String是一个特殊的包装类数据.即可以用String str = new String("abc");的形式来创建，也可以用String str = "abc"；
		 * (1)先定义一个名为str的对String类的对象引用变量：String str；
　　	 * (2)在栈中查找有没有存放值为"abc"的地址，如果没有，则开辟一个存放字面值为"abc"的地址，接着创建一个新的String类的对象o，并将o 的字符串值指向这个地址，而且在栈中这个地址旁边记下这个引用的对象o。如果已经有了值为"abc"的地址，则查找对象o，并返回o的地址。
		 */
		
		/** 2.请写出以下代码运行后的输出 */
		String str2 = "csljc中体骏彩";
		int i = str2.getBytes("utf-8").length; //一个英文字符：1个byte,一个中文字符：3个byte
		int j = str2.getBytes("gbk").length; //一个英文字符：1个byte,一个中文字符：2个byte
		int k = str2.length(); //不论字符是中英文都按字符个数算长度
		System.out.println(i + "，" + j + "，"  + k);
		
		/** 答案： 17，13，9 */
		
		/** 3. 请写出表示手机号码（以1开头的11位数字）的正则表达式 */
//		String MOBILENUMBER_REGEX = "^1\\d{10,10}$"; //写法
		
		/** 4. 请写出一下代码运行后可能的输出 */
		//见TestThread类，答案 Data:
		/** 5. 请写出常用的设计模式 */
		/**
		 * 1.DynamicProxy; 2. Command; 3. ChainOfResponsibility; 4. abstractFactory; 5. TemplateMethod; 6. Bridge; 7.Strategy; 8.Singleton; 
		 * 9. facade; 10. Composite; 11.Flyweight; 12.Observer; 13.Iterator;14.ProtoType
		 */
		
		/** 6. 请写一个函数，将给定的整数转换成每3位用逗号分隔开的字符串，如1234567890，转换成：1,234,567,890 */
		int testNum = 1234567890;
		String retValue = transIntToString(testNum,3,",");
		System.out.println("retValue== " + retValue );
		
		i  = 1;
		j = i++;
		System.out.println("i : " + i + ",j: " + j);
	}
	public static String transIntToString(int originalNum,int bitLength,String splitStr){
		String retValue = "";
		String originalStr = "" + originalNum;
		String originalStrTmp = "";
		int divider = 1 * (int)Math.pow(10, bitLength);
		String tempStr = "";
		int originalNumTemp = 0;
		while(originalNum >= divider){
			originalNumTemp = (originalNum) / divider;
			tempStr = originalNumTemp + "";
			originalStrTmp = tempStr;
			tempStr = originalStr.substring(tempStr.length());
			if(originalNum >= divider) {
				retValue = splitStr + tempStr + retValue;
			}
			originalNum = originalNumTemp;
			originalStr = originalStrTmp;
		}
		retValue = originalNum + retValue;
		return retValue.toString();
	}
}
