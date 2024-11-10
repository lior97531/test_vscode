#include <stdio.h>
#define n 5
int calcDiagonalSums(int size, int matrix[size][size]);
int isMagicSquare(int size , int matrix[size][size]);
void main(void) {


    int arr[n][n]={{17,24,1,8,15},{23,5,7,14,16},{4,6,13,20,22},{10,12,19,21,3},{11,18,25,2,9}};
   printf("%d",isMagicSquare(n,arr));


}

int calcDiagonalSums(int size , int matrix[size][size]) {
int sum =0;
int sum2 =0;
    for(int i = 0 ; i < size ; i++) {
    sum+=matrix[i][i];
    }
    for(int i = 0 ; i < size ; i++) {
        sum2+=matrix[i][size-i-1];
    }
    if(sum==sum2) {
        return sum;
    }
return 0;
}

int isMagicSquare(int size , int matrix[size][size]) {
int check =calcDiagonalSums(size,matrix);
    int sumR=0;
    int sumC=0;
for(int i = 0 ; i < size ; i++) { // checking rows
    for(int j=0;j<size;j++) {
        sumR+=matrix[i][j];
       sumC+=matrix[j][i];
    }
    if(sumR!=check||sumC!=check) {
        return 0;
    }
    sumR=0;
    sumC=0;
}



    return 1;
}
