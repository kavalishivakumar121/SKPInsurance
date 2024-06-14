package com.app.skp.generators;

import java.util.Random;

public class RandomPwdGenerate {
	

public static String generatePassword()
{
	String alp="ABCDEFGHIJKLMNOPQRSTUVWXYZ123456789";
	StringBuilder sb=new StringBuilder();
	Random rand=new Random();
	int len=5;
	for(int i=0;i<len;i++){
		
		int index=rand.nextInt(alp.length());
		char randomChar=alp.charAt(index);
		sb.append(randomChar);
	}
	return sb.toString();
	}

}
