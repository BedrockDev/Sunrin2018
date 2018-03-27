#include<stdio.h>

void main() {
	int P[9] = { 0, 1, 0, 0, 1, 0, 0, 0, 1 };

	int PN = 0;

	for (int K = 1; K <= 8; K++) {
		if (P[K] == 1) {
			PN = PN + 1;
		}
		else {
			continue;
		}
	}

	int E = PN % 2;

	if (P[0] == E) {
		printf("No error\n");
	}
	else {
		printf("Error found\n");
	}
}