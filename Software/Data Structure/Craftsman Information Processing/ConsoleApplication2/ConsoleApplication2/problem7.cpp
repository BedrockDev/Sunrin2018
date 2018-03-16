#include <stdio.h>

int main() {
	int sum = 0;
	int count = 100;

	for (int i = 1; i <= count; i++) {
		if (i % 2 == 0) {
			sum = sum - i;
		}
		else {
			sum = sum + i;
		}
	}

	printf("%d\n", sum);
}