#include<stdio.h>

void main() {
	int TN = 0;

	for (int N = 4; N <= 500; N++) {
		int SUM = 0;
		int K = (int)(N / 2);

		for (int J = 1; J <= K; J++) {
			int R = N % J;

			if (R == 0) {
				SUM = SUM + J;
			}
			else {
				continue;
			}
		}

		if (N == SUM) {
			printf("%d\n", N);
			TN = TN + 1;
		}
		else {
			continue;
		}
	}

	printf("%d\n", TN);
}