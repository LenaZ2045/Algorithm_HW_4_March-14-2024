package com.telran.org.algorithmsHomeworks.algorithm_HW_4_March_14_2024;

import java.util.Arrays;

public class MergeTwoArraysApp {
    public static void main(String[] args) {
        int[] m = {100, 112, 256, 349, 770};
        System.out.println(Arrays.toString(m));
        int[] n = {72, 86, 113, 119, 265, 445, 892};
        System.out.println(Arrays.toString(n));
        int[] k = {100, 112, 256, 349, 770, 72, 86, 113, 119, 265, 445, 892};

        quickSort(k, 0, k.length - 1);
        System.out.println(" Sorted array k " + Arrays.toString(k));
        int arr_k_7thPosition = k[6];
        String k_7thPosition = "Array k on 7th Position is ";
        System.out.println(k_7thPosition + binarySearch(k, arr_k_7thPosition));
    }

    public static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int indexPivot = partition(arr, start, end);
            quickSort(arr, start, indexPivot - 1);
            quickSort(arr, indexPivot + 1, end);
        }
    }

    public static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];
        int j = start;
        for (int i = start; i < end; i++) {
            if (arr[i] <= pivot) {
                swap(arr, i, j);
                j++;
            }
        }
        swap(arr, end, j); // indexPivot in quick sort method
        return j; // indexPivot in quick sort method
    }

    public static int binarySearch(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == x) return x;
            if (arr[mid] < x) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}