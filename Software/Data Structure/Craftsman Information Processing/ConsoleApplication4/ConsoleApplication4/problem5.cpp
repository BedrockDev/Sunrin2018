#include<stdio.h>
#include<math.h>

void main() {
	int N;
	int A[20];

	int debug = 10000;
	int debugCount = 0;

	while (true) {
		scanf("%d", &N);
		fflush(stdin);

		debugCount = 0;

		if (N >= 2) {
			int T = 0;

			while (true) {
				int P = 2;

				while (N % P != 0) {
					P = P + 1;

					if (debugCount++ < debug) {
						printf("%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t\n", N, N >= 2, T, P, (N % P) == 0, A[T - 1], N == 1, T == 1);
					}
				}

				T = T + 1;
				A[T - 1] = P;

				if (debugCount++ < debug) {
					printf("%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t\n", N, N >= 2, T, P, (N % P) == 0, A[T - 1], N == 1, T == 1);
				}

				N = N / P;

				if (N == 1) {
					if (T == 1) {
						printf("Prime number\n");
					}
					else {
						for (int J = 1; J <= T - 1; J++) {
							printf("%d*", A[J - 1]);
						}
						printf("%d\n", A[T - 1]);
					}
					break;
				}
				else {
					continue;
				}
			}
		}
		else {
			return;
		}
	}
}