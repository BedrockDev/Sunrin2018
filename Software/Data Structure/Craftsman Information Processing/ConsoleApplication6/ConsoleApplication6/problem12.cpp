#include<stdio.h>
#include<math.h>

int T[8] = { 1, 1, 1, 1, 0, 1, 1, 0 };
int C[8];

int POWER(int a, int b) {
	return pow((double)a, (double)b);
}

int ABS(int a) {
	return abs(a);
}

void main() {

	int D = 0;
	int SIGN = 1;

	if (T[0] == 0) {
		for (int K = 2; K <= 8; K++) {
			int T1 = POWER(2, 8 - K);
			int T2 = T[K - 1] * T1;
			D = D + T2;
		}

		D = SIGN * D;

		printf("%d", D);
	}
	else {
		SIGN = -1;
		int B = 1;

		for (int K = 8; K >= 2; K--) {
			C[K - 1] = T[K - 1] - B;

			if (!(T[K - 1] == 0 && B == 1)) {
				B = 0;
			}

			C[K - 1] = ABS(C[K - 1]);
			T[K - 1] = 1 - C[K - 1];
		}

		for (int K = 2; K <= 8; K++) {
			int T1 = POWER(2, 8 - K);
			int T2 = T[K - 1] * T1;
			D = D + T2;
		}

		D = SIGN * D;

		printf("%d", D);
	}
}