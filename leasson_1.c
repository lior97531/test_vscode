#include <stdio.h>
#define n 5 //define the letter n in the code as int 5 unlike const it doesnt create a veriable  
int global_x =9 ;//global integer possible to acess from anywhere
int MaxValue(int,int);
int Avrage1D (int arr[]);
int Avrage2D(int arr[][global_x]);//must enter the size of the second dimension 
int main()
{
    const int age = 20;
int x =2;
double y = 2.5;
int z =3;
printf("x is: %d and y is: %lf and z is:%d \n",x,y,z);
/*int temp;
double d1;
scanf("%d %lf" ,&temp,&d1);
printf("%d and %lf and %d",temp,d1,age);

*/

int arr[n];
printf("%d",MaxValue(x,global_x));
}

int MaxValue(int x , int y){
   return x>y ? x:y;
}