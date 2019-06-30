
public class Ordenacao1 {

	public void insertionSort(int vetor[]) {
		int j, aux, i;

		for (j = 1; j < vetor.length; j++) {
			aux = vetor[j];

			for (i = j - 1; (i >= 0) && (vetor[i] > aux); i--) {
				vetor[i + 1] = vetor[i];
			}

			vetor[i + 1] = aux;
		}
	}

	public void mergeSort(int vetor[], int n) {

		if (n < 2) {
			return;
		}

		int metade = n / 2;
		int[] e = new int[metade];
		int[] d = new int[n - metade];

		for (int i = 0; i < metade; i++) {
			e[i] = vetor[i];
		}
		for (int i = metade; i < n; i++) {
			d[i - metade] = vetor[i];
		}
		mergeSort(e, metade);
		mergeSort(d, n - metade);

		merge(vetor, e, d, metade, n - metade);

	}

	public static void merge(int[] vetor, int[] e, int[] d, int esquerda, int direita) {

		int i = 0, j = 0, k = 0;

		while (i < esquerda && j < direita) {
			if (e[i] <= d[j]) {
				vetor[k++] = e[i++];
			} else {
				vetor[k++] = d[j++];
			}
		}
		while (i < esquerda) {
			vetor[k++] = e[i++];
		}
		while (j < direita) {
			vetor[k++] = d[j++];
		}
	}

	public void bucketSort(int vetor[]) {

		int n = vetor.length;

		if (n <= 0)
			return;

		int min = vetor[0];
		int max = min;

		for (int i = 1; i < n; i++) {
			if (vetor[i] > max)
				max = vetor[i];
			if (vetor[i] < min)
				min = vetor[i];
		}

		int bucket[] = new int[max - min + 1];
		for (int i = 0; i < n; i++) {
			bucket[vetor[i] - min]++;
		}

		int i = 0;
		for (int b = 0, len = bucket.length; b < len; b++) {
			for (int j = 0; j < bucket[b]; j++)
				vetor[i++] = b + min;
		}

	}

	public void heapSort(int vetor[]) {
		for (int i = vetor.length / 2 - 1; i >= 0; i--) {
			heapify(vetor, vetor.length, i);
		}

		for (int i = vetor.length - 1; i >= 0; i--) {

			int temp = vetor[0];
			vetor[0] = vetor[i];
			vetor[i] = temp;

			heapify(vetor, i, 0);
		}
	}

	void heapify(int vetor[], int tamanho, int indice) {

		int esquerda = 2 * indice + 1;
		int direta = 2 * indice + 2;

		int maior = indice;

		if (esquerda < tamanho && vetor[esquerda] > vetor[maior])
			maior = esquerda;

		if (direta < tamanho && vetor[direta] > vetor[maior])
			maior = direta;

		if (maior != indice) {

			int swap = vetor[indice];
			vetor[indice] = vetor[maior];
			vetor[maior] = swap;

			heapify(vetor, tamanho, maior);
		}
	}

}
