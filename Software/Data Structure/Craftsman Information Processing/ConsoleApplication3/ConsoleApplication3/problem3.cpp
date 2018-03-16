#include<stdio.h>

void main() {
	int s = 0;
	int n = 2;

	while (true) {
		n = n + 1;

		s = s + n;

		if (n == 101) {
			break;
		}

		n = n + 1;

		s = s - n;
	}

	printf("%d\n", s);
}