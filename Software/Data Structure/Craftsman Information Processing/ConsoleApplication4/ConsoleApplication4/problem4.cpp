#include<stdio.h>
#include<math.h>

void main() {
	int P = 2;
	int N = 3;

	int debug = 11;
	int debugCount = 0;

	while (true) {
		int M = round(sqrt((double)N)); // or int()
		int i = 2;
		int R;

		while (true) {
			R = N % i;

			if (R == 0) {

				if (debugCount++ < debug) {
					printf("%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t\n", P, N, M, i, R, R == 0, i > M, N > 100);
				}

				break;
			} 
			else {
				i = i + 1;

				if (i > M) {
					P = N;
				}

				if (debugCount++ < debug) {
					printf("%d\t%d\t%d\t%d\t%d\t%d\t%d\t%d\t\n", P, N, M, i, R, R == 0, i > M, N > 100);
				}
				else {
					continue;
				}
			}
		}

		N = N + 1;

		if (N > 100) {
			break;
		}
		else {
			continue;
		}
	}

	printf("%d\n", P);
}