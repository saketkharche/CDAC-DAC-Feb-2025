package Day04;

import java.util.Scanner;




public class Gcd {


    static int count=0;

    static void display(char tstr[],int l,int c,boolean a[]){
        if(l==c)
        {
            count++;
            System.out.println(new String(tstr));
            return;
        }


        for(int i=l;i<c;i++)
        {
            if(a[tstr[i]])
                continue;

            a[tstr[i]]=true;

            char temp=tstr[l];
            tstr[l]=tstr[i];
            tstr[i]=temp;


            display(tstr,l+1,c,new boolean[256]);

            char temp1=tstr[l];
            tstr[l]=tstr[i];
            tstr[i]=temp1;

        }

    }
    public static void main(String[] args) {
        boolean a[] = new boolean[256];

        String s= "PETER";
        char[] tstr= s.toCharArray();


        display(tstr,0,tstr.length,a);
        System.out.println(count);
    }
}
