#include<stdio.h>

void main() {
	int input;

	scanf("%d", &input);

	int B[64];
	int O[64];
	int T[64];

	int i = 1;
	int N = 1;

	while (input != 0)
	{
		B[N++] = input % 10;
		input /= 10;
	}

	while (true) {
		O[i] = 1 - B[i];
		i = i + 1;

		if (i > N) {
			break;
		}
	}

	i = N;

	int C = 1;

	while (true) {
		T[i] = 1;

		if (O[i] == C) {
			T[i] = 0;
		}

		C = O[i] * C;
		i = i - 1;

		if (i <= 0) {
			break;
		}
	}

	for (int j = 1; j < N; j++) {
		printf("%d");
	}
}