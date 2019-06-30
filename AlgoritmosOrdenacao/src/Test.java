import java.util.Random;

public class Test {

	private Ordenacao1 ord;

	public Test() {
		this.ord = new Ordenacao1();
	}

	private int[] geraVetor(int tamanho) {

		Random random = new Random();
		int[] vetor = new int[tamanho];

		for (int i = 0; i < tamanho; i++) {
			vetor[i] = random.nextInt(100);
		}

		return vetor;
	}

	public String toString(int[] vetor) {
		String result = "";

		for (int i = 0; i < vetor.length; i++) {
			result += vetor[i] + " ";
		}

		return result;
	}

	public void test(int quantidadeNumeros) {

		int[] vetor = this.geraVetor(quantidadeNumeros);

		System.out.println(
				"-------------------------------- TAMANHO " + quantidadeNumeros + " --------------------------------");
		System.out.println(" ");

		long inicio = System.currentTimeMillis();
		this.ord.insertionSort(vetor);
		long fim = System.currentTimeMillis() - inicio;
		System.out.println("O InsertionSort gastou " + fim + " milli segundos para ordenar um vetor de tamanho "
				+ quantidadeNumeros);

		vetor = this.geraVetor(quantidadeNumeros);

		inicio = System.currentTimeMillis();
		this.ord.mergeSort(vetor, quantidadeNumeros);
		fim = System.currentTimeMillis() - inicio;
		System.out.println(
				"O MergeSort gastou " + fim + " milli segundos para ordenar um vetor de tamanho " + quantidadeNumeros);

		vetor = this.geraVetor(quantidadeNumeros);

		inicio = System.currentTimeMillis();
		this.ord.bucketSort(vetor);
		fim = System.currentTimeMillis() - inicio;
		System.out.println(
				"O BucketSort gastou " + fim + " milli segundos para ordenar um vetor de tamanho " + quantidadeNumeros);

		vetor = this.geraVetor(quantidadeNumeros);

		inicio = System.currentTimeMillis();
		this.ord.heapSort(vetor);
		fim = System.currentTimeMillis() - inicio;
		System.out.println(
				"O HeapSort gastou " + fim + " milli segundos para ordenar um vetor de tamanho " + quantidadeNumeros);

		System.out.println();

	}

	public static void main(String args[]) {
		Test t = new Test();
		t.test(100);
		t.test(1000);
		t.test(10000);
		t.test(100000);
		
		System.out.println("CONCLUSÃO:");
		System.out.println("InsertionSort, por ordenar um item por vez, é muito menos eficiente para vetores grandes se comparado com os outros algoritmos.");
		System.out.println("BucketSort é o mais performático, pois divide os elementos em vetores pequenos (buckets), que são ordenados individualmente usando algum algoritmo diferente.");
	}

}
