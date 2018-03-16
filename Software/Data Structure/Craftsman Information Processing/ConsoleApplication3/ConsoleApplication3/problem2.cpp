#include<stdio.h>

void main() {
	int a = 1;
	int b = 0;
	int c = 0;

	int s = 0;
	int n = 2;

	while (true) {
		c = a + b;
		s = s + c;
		a = b;
		b = c;
		n = n + 1;

		if (n == 46) {
			break;
		}
	}

	printf("%d\n", s);
}