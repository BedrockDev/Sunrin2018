#include <stdio.h>

int main() {
	int k = 0;
	float l = 0;
	float s = 0;
	int count = 49;
	int sw = 0;

	while (true) {
		k = k + 1;
		l = k / (float)((k + 1) + (k + 2));

		if (sw == 0) {
			s = s + l;
			sw = 1;
		}
		else {
			s = s - l;
			sw = 0;
		}

		if (k == 49) {
			break;
		}
	}

	printf("%.16f\n", s);
}