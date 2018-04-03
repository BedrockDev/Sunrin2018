#include<stdio.h>

void print(int A[5][5]) {
	for (int i = 0; i < 5; i++) {
		for (int j = 0; j < 5; j++) {
			int n = A[i][j];

			if (n > 100000 || n < 0) {
				printf("\t");
			}
			else {
				printf("%d\t", A[i][j]);
			}
		}
		printf("\n");
	}
}

void main() {

	int A[5][5];

	int V = 1;
	int R = 1;

	while (true) {
		int C = R;
		
		while (true) {
			A[R - 1][C - 1] = V;
			V = V + 1;
			C = C + 1;

			if (C > 5) {
				break;
			}
		}

		R = R + 1;

		if (R > 5) {
			break;
		}
	}

	print(A);
}