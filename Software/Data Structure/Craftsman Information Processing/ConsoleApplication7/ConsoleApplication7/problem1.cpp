#include<stdio.h>

void print(int A[5][5]) {
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			printf("%d\t", A[i][j]);
		}
		printf("\n");
	}
}

void main() {

	int A[5][5];

	int V = 0;
	int C = 1;

	while (true) {
		int R = 1;

		while (true) {
			V = V + 1;
			A[R - 1][C - 1] = V;
			R = R + 1;

			if (R > 5) {
				break;
			}
		}

		C = C + 1;

		if (C > 5) {
			break;
		}
	}

	print(A);
}