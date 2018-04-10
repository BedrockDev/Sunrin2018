#include<stdio.h>
#include<time.h>
#include<stdlib.h>

int E[100] = { 0 };

void print() {
	for (int i = 0; i < 100; i++) {
		printf("%d ", E[i]);
	}
	printf("\n");
}

void main() {

	srand(time(NULL));

	for (int i = 0; i < 100; i++){
		E[i] = rand() % 100;
	}

	int i = 1;

	while (true) {
		int j = i + 1;
		
		while (true) {
			if (E[i - 1] > E[j - 1]) {
				int Temp = E[i - 1];
				E[i - 1] = E[j - 1];
				E[j - 1] = Temp;
			}

			j = j + 1;

			if (j > 100) {
				i = i + 1;
				break;
			}
		}

		print();

		if (i > 99) {
			break;
		}
	}

	print();
}