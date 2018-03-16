#include<stdio.h>

void main() {
	int s = 0;
	int n = 1;

	while (true) {
		if (n % 5 == 0) {
			if (n % 2 == 1) {
				s = s + n;
			}
		}
		n = n + 1;

		if (n > 500) {
			break;
		}
	}

	printf("%d\n", s);
}