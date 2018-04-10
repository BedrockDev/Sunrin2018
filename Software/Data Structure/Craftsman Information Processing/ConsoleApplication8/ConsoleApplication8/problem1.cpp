#include<stdio.h>
#include<time.h>
#include<stdlib.h>

void main() {
	int A[25][2], R[25] = { 0 };

	srand(time(NULL));

	for (int i = 0; i < 25; i++){
		A[i][0] = i + 1;
		A[i][1] = rand() % 100;

		R[i] = 0;
	}

	for (int i = 1; i <= 25; i++) {
		for (int j = 1; j <= 25; j++) {
			if (A[i - 1][1] <= A[j - 1][1]) {
				R[i - 1] = R[i - 1] + 1;
			}
		}

		printf("%d\t %d\n", A[i - 1][0], R[i - 1]);
	}

	printf("\n");

	for (int i = 0; i < 25; i++){
		printf("[%d\t %d]\n", A[i][0], R[i]);
	}
}