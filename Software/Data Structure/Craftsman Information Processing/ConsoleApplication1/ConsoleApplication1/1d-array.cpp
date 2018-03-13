#include <stdio.h>

void main() {
	int A[5] = { 5, 10, 7, 9, 30 };
	int I = 0;

	while (1) {
		I = I + 1;
		if (I <= 5) {
			printf("%d\n", A[I - 1]);
		}
		else {
			break;
		}
	}

	I = 1;

	while (1) {
		printf("%d\n", A[I - 1]);
		if (I < 5) {
			I = I + 1;
		}
		else {
			break;
		}
	}
	return;
}