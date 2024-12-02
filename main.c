#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#define N 4

// Structure to represent the game board
typedef struct {
    int **values; // Stores the card values
    int **revealed; // Stores the state of each card (0 = hidden, 1 = revealed)
    int size; // board size is size * size
} GameBoard;
void freeBoard(GameBoard* gb);
int checkVictory(GameBoard* gb);
int playTurn(GameBoard *gb, int row1, int col1, int row2, int
             col2);

void printBoard(GameBoard *board);

GameBoard *initBoard(const int *predefinedValues, int size);

int main(void) {
   int r1, c1, r2, c2;
    int check;
    int values[] = {1, 2, 3, 4, 5, 6, 7, 8, 8, 1, 2, 3, 4, 5, 6, 7};
    GameBoard *board = initBoard(values, N);
    printBoard(board);
while (checkVictory(board)==0) {

    printf("Please enter the first card row and column: ");
    scanf("%d%d", &r1, &c1);
    printf("Please enter the second card row and column: ");
    scanf("%d%d", &r2, &c2);

  check=  playTurn(board, r1, c1, r2, c2);
if(check==-1) {
    break;
}
}
   freeBoard(board);
    printf("Thank you for playing\n");
}

GameBoard *initBoard(const int *predefinedValues, int size) {
    int **cards = (int **) malloc(sizeof(int *) * size);
    int **revealed_cards = (int **) malloc(sizeof(int *) * size);
    int count = 0;
    for (int i = 0; i < size; i++) {
        revealed_cards[i] = (int *) malloc(sizeof(int) * size);
        cards[i] = (int *) malloc(sizeof(int) * size);
    }
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            cards[i][j] = predefinedValues[i + count];
            revealed_cards[i][j] = 0;
            count++;
        }
        count--;
    }
    GameBoard *board = (GameBoard *) malloc(sizeof(GameBoard));
    board->values = cards;
    board->revealed = revealed_cards;
    board->size = size;
    return board;
}

void printBoard(GameBoard *board) {
    printf("\n");
    printf("\n");
    printf("\n");
    for (int i = 0; i < board->size; i++) {
        for (int j = 0; j < board->size; j++) {
            if (board->revealed[i][j] == 0) {
                printf("|*| \t");
            } else {
                printf("|%d|\t", board->values[i][j]);
            }
        }
        printf("\n");
    }
    printf("\n");
    printf("\n");
}

int playTurn(GameBoard *gb, int row1, int col1, int row2, int col2) {
            if(row1==-1 || row2==-1 || col1==-1 || col2==-1) {
return -1;
            }
if((row1<0 ||row1>N)||(col1<0||col1>N)||(col2<0||col2>N)||(row2<0||row2>N)) {
return -1;
}

    gb->revealed[row1][col1] = 1;
    gb->revealed[row2][col2] = 1;

    if(gb->values[row1][col1] == gb->values[row2][col2]) {
        printBoard(gb);
        printf("Match found!\n");
        printf("\n");
        printBoard(gb);
        return 1;
    }
    else {
        printBoard(gb);
        gb->revealed[row1][col1] = 0;
        gb->revealed[row2][col2] = 0;
        printf("NO Match found!\n");
        printBoard(gb);
        printf("\n");
        return 0;
    }




}
int checkVictory(GameBoard* gb) {
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            if(gb->revealed[i][j] == 0) {
                return 0;
            }

        }


    }
    return 1;
}

void freeBoard(GameBoard* gb) {
 for (int i = 0; i < N; i++) {

        free(gb->revealed[i]);
         free(gb->values[i]);
     }

    free(gb->revealed);
    free(gb->values);
    free(gb);
}