package org.example.service;

import java.util.Arrays;

public class QuickSort {
    private void quickSort(int[] arr, int min, int max) {
        if (min < max) {
            int pivotIndex = partition(arr, min, max);
            quickSort(arr, min, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, max);
        }
    }

    private int partition(int[] arr, int min, int max) {
        int pivotIndex = (min + max) / 2;
        int pivot = arr[pivotIndex];
        int i = min - 1;
        int j = max + 1;
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            do {
                j--;
            } while (arr[j] > pivot);
            if (i >= j) {
                return j;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }

        int[] arrCopy1 = Arrays.copyOf(arr, arr.length);
        int[] arrCopy2 = Arrays.copyOf(arr, arr.length);
        int[] arrCopy3 = Arrays.copyOf(arr, arr.length);

        QuickSort quickSort = new QuickSort();

        long start1 = System.currentTimeMillis();
        quickSort.quickSort(arrCopy1);
        long time1 = System.currentTimeMillis() - start1;
        System.out.println("Quick sort took " + time1 + " milliseconds");

        long start2 = System.currentTimeMillis();
        // вызов другой сортировки для сравнения времени выполнения
        long time2 = System.currentTimeMillis() - start2;
        System.out.println("Another sort took " + time2 + " milliseconds");

        long start3 = System.currentTimeMillis();
        // вызов третьей сортировки для сравнения времени выполнения
        long time3 = System.currentTimeMillis() - start3;
        System.out.println("Another sort took " + time3 + " milliseconds");
    }
}