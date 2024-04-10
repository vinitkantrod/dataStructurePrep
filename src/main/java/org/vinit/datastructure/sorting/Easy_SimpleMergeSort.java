package org.vinit.datastructure.sorting;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Easy_SimpleMergeSort {

    public static void main(String[] args) {
        int max = 1000000;
        int min = 1000;
        Random random = new Random();
        int[] randomArr = new int[500000];
        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            randomArr[i] = random.nextInt(max - min + 1) + min;
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
//        int[] arr = new int[]{5,6,3,1,8,9,7,2,4};
        t1 = System.currentTimeMillis();
        mergeSort(randomArr, 0, randomArr.length - 1);
        t2 = System.currentTimeMillis();
        System.out.println(t2 - t1);
//        System.out.println(Arrays.toString(randomArr));
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }
    private static void merge(int[] arr, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;
        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];
        int idx = 0;
        for (int i = low; i <= mid; i++) arr1[idx++] = arr[i];
        idx = 0;
        for (int i = mid + 1; i <= high; i++) arr2[idx++] = arr[i];
        int k = low;
        int l1 = 0, l2 = 0;
        while (l1 < arr1.length && l2 < arr2.length) {
            if (arr1[l1] <= arr2[l2]) {
                arr[k++] = arr1[l1++];
            } else if (arr1[l1] > arr2[l2]) {
                arr[k++] = arr2[l2++];
            }
        }
        while (l1 < arr1.length) {
            arr[k++] = arr1[l1++];
        }
        while (l2 < arr2.length) {
            arr[k++] = arr2[l2++];
        }
//        System.out.println(Arrays.toString(arr1) + " : " + Arrays.toString(arr2));
//        System.out.println("final : " + Arrays.toString(arr));
    }
}
