package com.aditya.test.rest;

import java.util.ArrayList;

import org.junit.Test;

public class MissingNumberTest
{

    //@Test
    public void test()
    {

        int array[] = {1, 0, 2, 3, 6, 7};
        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < 10; i++)
        {
            list.add(i);
        }

        for (int i : array)
        {
            list.remove(Integer.valueOf(i));
        }
        System.out.println(list);
	    
		/*String s1= new String("Raj");
		String s2 = "Raj";
		
		System.out.println(s1==s2);
		System.out.println(s1.intern()==s2);
		System.out.println(s1.equals(s2));*/


    }

}
