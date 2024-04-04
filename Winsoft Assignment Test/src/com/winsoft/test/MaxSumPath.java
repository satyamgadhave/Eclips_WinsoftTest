package com.winsoft.test;

import java.util.Arrays;

public class MaxSumPath {
	
	public static void main(String[] args) {
        int[] X = {3, 6, 7, 8, 10, 12, 15, 18, 100};
        int[] Y = {1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50};

        int[] result = maximumSumPath(X, Y);
        int maxSum = result[0];
        int[] path = Arrays.copyOfRange(result, 1, result.length);

        System.out.print("The maximum sum path is: ");
        for (int i = 0; i < path.length; i++) {
            System.out.print(path[i]);
            if (i < path.length - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println();
        System.out.println("The maximum sum is: " + maxSum);
    }

    public static int[] maximumSumPath(int[] X, int[] Y) {
        int[] path = new int[X.length + Y.length];
        int pathIndex = 0;
        int i = 0, j = 0;
        int sumX = 0, sumY = 0;
        int maxSum = 0;

        while (i < X.length && j < Y.length) {
            if (X[i] < Y[j]) {
                sumX += X[i];
                path[pathIndex++] = X[i++];
            } else if (X[i] > Y[j]) {
                sumY += Y[j];
                path[pathIndex++] = Y[j++];
            } else { // When elements are equal, we have found a common element
                maxSum += Math.max(sumX, sumY) + X[i]; // Add maximum sum until now and the common element
                path[pathIndex++] = X[i]; // Add the common element to the path
                sumX = 0;
                sumY = 0;
                i++;
                j++;
            }
        }

        // Add remaining elements of array X
        while (i < X.length) {
            sumX += X[i];
            path[pathIndex++] = X[i++];
        }

        // Add remaining elements of array Y
        while (j < Y.length) {
            sumY += Y[j];
            path[pathIndex++] = Y[j++];
        }

        // Add maximum sum of remaining elements from either array
        maxSum += Math.max(sumX, sumY);

        // Trim the path array to the correct size
        return Arrays.copyOf(path, pathIndex + 1);
    }
	
	
	

}
