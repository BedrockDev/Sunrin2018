#include<stdio.h>

void main() {
	int n = 1;
	int b = 1;

	float s = 1;
	float h;

	while (true) {
		n = n * b;
		h = 1 / (float)n;

		if (b % 2 == 1) {
			s = s - h;
		}
		else {
			s = s + h;
		}
		
		b = b + 1;

		if (b > 10) {
			break;
		}
	}

	printf("%f\n", s);
}