#include<stdio.h>

void main() {
	int s1 = 0;
	int s2 = 0;

	int n1, n2;

	scanf("%d %d", &n1, &n2);

	int a, b;

	if (n1 < n2) {
		a = n1;
		b = n2;
	}
	else {
		a = n2;
		b = n1;
	}

	for (int i = a; i <= b; i++) {
		s1 = s1 + i;
		if (i % 2 == 1) {
			s2 = s2 + i;
		}
	}

	printf("%d %d\n", s1, s2);
}