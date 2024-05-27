import java.util.Scanner;
 class Class{
     public static void main (String[] args){
        Scanner scan = new Scanner(System.in);
//    academic a = new academic();
//    a.work();
        
int a [] = {1,3,8,4,2,5};

System.out.println(find(a,2));


    }

    public static boolean find (int arr [], int x)
    {
        if(arr.length ==1)
        return(arr[0]==x);
        int end =arr.length-1;
        
        boolean a1,a2;
        
        int mid = arr.length/2;
        int b[]=new int[mid];
        for(int i =0;i<mid;i++)
        {
            b[i]=arr[i];
        }
        a1=find (b,x);
        int j=0;
        for (int i =mid;i<=end;i++,j++)
        {
            b[j]=arr[i];
        }
        a2=find (b,x);
        if(a1==true||a2==true)
        return true;
        return false;

    }

}    