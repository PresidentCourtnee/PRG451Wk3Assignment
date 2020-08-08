package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;

public class Main
{
    public static void main(String[] args)throws IOException
    {
        String amount[]=new String[4];
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Enter the amount of cash at beginning of the day:");
        double cc=Double.parseDouble(in.readLine());

        System.out.println("Enter the amount of cash at end of the day:");
        double cE=Double.parseDouble(in.readLine());
        //Have the user enter the file path they wish to use
        System.out.println("Enter file path:");
        String fp=in.readLine();

        String fName="src/com/company/"+fp;

        double aC=cc;
        BufferedReader b=new BufferedReader(new FileReader(fName));
        String scLine="";
        while((scLine=b.readLine())!=null)
        {
            String str[] = scLine.split(" ");
            if (str[2].equals("P"))
                cc=cc-Double.parseDouble(str[1]);
            else
                cc=cc+Double.parseDouble(str[1]);

        }
        //This will determine if actual cash is equal to amount of cash at end and print the corresponding message
        if(cc==cE)
            System.out.println("Congratulations your expected cash equals your actual cash");
        else
            System.out.println("ERROR: Your expected Cash does not equal the actual cash");
    }
}