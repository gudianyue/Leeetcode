package com.hwl;



import java.util.*;

public class Main {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 8, 3, 88, 2, 9, 6};
        System.out.println("hello, git");
        System.out.println("hello, git");
        System.out.println("master");
        System.out.println("hot-fix");
        System.out.println("github test");
        quickSortByLoop(arr);
        for (int num : arr) {
            System.out.println(num);
        }

    }
    //非递归实现快速排序
    public static void quickSortByLoop(int[] array) {
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length - 1);
        stack.push(0);

        while (!stack.isEmpty()) {
            int left = stack.pop();
            int right = stack.pop();

            if(left >= right) {
                continue;
            }

            int index = partition(array,left,right);
            stack.push(right);
            stack.push(index + 1);

            stack.push(index-1);
            stack.push(left);
        }
    }

    private static int partition(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int base = array[j];
        while (i < j){
            //循环从左向后找到比基准值大的元素
            while (i < j && array[i] <= base) {
                i++;
            }

            //代码走到这里，i有可能和j重合，也有可能是找到了比基准值大的元素
            //下面，循环从由向左找比基准值小的元素
            while (i < j && array[j] >= base) {
                j--;
            }

            //交换i位置的元素和j位置的元素
            swap(array,i,j);
        }
        //代码跳出循环之后，说明i和j重合了，就需要交换重合位置的元素和基准值。
        swap(array,i,right);
        return i;
    }
    private static void swap(int[] array, int i, int j) {
        int tmp = array[j];
        array[j] = array[i];
        array[i] = tmp;
    }

}

