#include <stdio.h>
#include <cmath>

int main() {
	int x = 0;
	while (true) {
		x = x + 1;
		printf("%.16f\n", pow(1 + (1 / (float)x), x));
		// this doesn't work
	}
	return 0;
}