import java.util.Random;

//Hecho por Joel Santillan A01634748
public class Ordenamientos {
	
	public static <E extends Comparable<E>> void bubbleSort(E[] datos) {
		for(int i=0;i<datos.length-1;i++) {//El numero de iteraciones que requiero
			for(int j=0;j<datos.length-1-i;j++) {
				if(datos[j].compareTo(datos[j+1])>0) {//Como hacer que si ya esta ordenado, no lo cheque y nomas lo entregue
					swap(datos, j, j+1);
				}
			}
		}
	}
	
	public static <E extends Comparable<E>> void bubbleSortRecursive(E[] datos, int size) {
		if(size==1) {
			return;
		}else {
			for (int i=0; i<size-1; i++) 
		        if (datos[i].compareTo(datos[i+1])>0) 
		            swap(datos, i, i+1);
			bubbleSortRecursive(datos, size-1);
		}
	}
	
	public static <E extends Comparable<E>> void mergeSort(E[] datos) {//funcion de preparacion
		mergeSort(datos,0,datos.length-1);
	}
	
	public static <E extends Comparable<E>> void mergeSort(E[] datos,int primero, int ultimo) {//funcion recursiva
		if(primero<ultimo) {
			int central = (primero+ultimo)/2;
			mergeSort(datos,primero,central);
			mergeSort(datos,central+1,ultimo);
			mezcla(datos,primero,ultimo);
		}
	}
	
	private static <E extends Comparable<E>> void mezcla(E[] datos, int primero, int ultimo) {
		int central = (primero+ultimo)/2;
		//atributos que actuan como puntadores de sus respectivas listas
		int indexIzq = 0;
		int	indexDer = 0;
		int indexMerge = primero;
		//se crean las listas temporales
		E[] listaIzq = (E[]) new Comparable[central-primero+1];
		E[] listaDer = (E[]) new Comparable[ultimo-central];
		//se pasan los datos
		for(int i=0;i<listaIzq.length;i++) {
			listaIzq[i] = datos[primero+i];
		}
		for(int i=0;i<listaDer.length;i++) {
			listaDer[i] = datos[central+1+i];
		}
		//revisa el valor mas chico y cambia el orden si es necesario dentro de la lista original
		while(indexIzq<listaIzq.length && indexDer<listaDer.length) {
			if(listaIzq[indexIzq].compareTo(listaDer[indexDer])<0) {
				datos[indexMerge] = listaIzq[indexIzq];
				indexIzq++;
			}else {
				datos[indexMerge] = listaDer[indexDer];
				indexDer++;
			}
			indexMerge++;
		}
		//vacia el resto de los datos de la lista sobrante
		while(indexIzq<listaIzq.length) {
			datos[indexMerge] = listaIzq[indexIzq];
			indexIzq++;
			indexMerge++;
		}
		while(indexDer<listaDer.length) {
			datos[indexMerge] = listaDer[indexDer];
			indexDer++;
			indexMerge++;
		}
		//imprimirArreglo(datos);
	}
	
	public static <E extends Comparable<E>> void quickSort(E[] datos) {
		quickSort(datos,0,datos.length-1);
	}
	
	public static <E extends Comparable<E>> void quickSort(E[] datos, int left, int right) {
		if(left<right) {
			int pivote = particion(datos,left,right);
			quickSort(datos,left,pivote-1);
			quickSort(datos,pivote+1,right);
		}
	}
	
	private static <E extends Comparable<E>> int particion(E[] datos, int left, int right) {
		E pivote = datos[left];
		int i = left+1;
		for(int j=left+1;j<=right;j++) {//en caso de que el pivote sea el numero mas alto del arreglo, da un ciclo mas para terminar en la ultima posicion
			if(datos[j].compareTo(pivote)<0) {
				swap(datos,i,j);
				i++;
			}
		}
		swap(datos,left,i-1);
		return i-1;
	}
	
	private static <E> void swap(E[] datos, int i, int j) {
		E aux = datos[i];
		datos[i]=datos[j];
		datos[j]=aux;
	}
	
	private static <E> void imprimirArreglo(E[] datos) {
		for(E tmp: datos) {
			System.out.print(tmp+",");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Integer[] lista = {6,2,9,3,8,1,5,4,7};
		bubbleSortRecursive(lista, lista.length);
		for (int e : lista) {
			System.out.println(e);
		}
		//mergeSort(lista);
		quickSort(lista);
		//imprimirArreglo(lista);
	}
}
