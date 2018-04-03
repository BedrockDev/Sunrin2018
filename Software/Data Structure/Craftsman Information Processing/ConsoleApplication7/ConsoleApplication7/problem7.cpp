#include<stdio.h>

void print(int A[5][5]) {
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			printf("%c\t", A[i][j] + 65);
		}
		printf("\n");
	}
}

void main() {

	int A[5][5];
	int B[5][5];

	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			A[i][j] = 5 * i + j;
		}
	}

	for (int R = 1; R <= 5; R++) {
		for (int C = 1; C <= 5; C++) {
			int N = 6 - R;
			B[C - 1][N - 1] = A[R - 1][C - 1];
		}
	}

	print(A);
	printf("\n");
	print(B);
}