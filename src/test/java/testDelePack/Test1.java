package testDelePack;

import org.apache.commons.lang3.RandomStringUtils;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			String generatedString=RandomStringUtils.randomAlphabetic(8);
			System.out.println(generatedString);
			String rnalphanumber=RandomStringUtils.randomAlphanumeric(8);
			System.out.println(rnalphanumber);
			String rnnumber=RandomStringUtils.randomNumeric(8);
			int num=Integer.parseInt(rnnumber);
			System.out.println(num);
		}
	

}
