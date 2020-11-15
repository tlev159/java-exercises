package arraysofarrays;

public class ArraysOfArraysMain {

  public static void main(String[] args) {
    ArraysOfArraysMain arraysOfArraysMain = new ArraysOfArraysMain();

    int[][] array = arraysOfArraysMain.multiplicationTable(4);
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array[i].length; j++) {
        System.out.print(array[i][j] + " ");
      }
      System.out.println();
    }

    int[][] a = {{1, 2, 3, 4} , {1, 2, 3}, {1, 2, 3, 4}, {2, 3, 4}};
    arraysOfArraysMain.printArrayOfArray(a);

    int[][] triangularArray = arraysOfArraysMain.triangularMatrix(4);
    for (int i = 0; i < triangularArray.length; i++) {
      for (int j = 0; j <= i; j++) {
        System.out.print(triangularArray[i][j] + " ");
      }
      System.out.println();
    }

    int[][] values = arraysOfArraysMain.getValues();
    for (int i = 0; i < values.length; i++) {
      for (int j = 0; j < values[i].length; j++) {
        System.out.print(values[i][j] + " ");
      }
      System.out.println();
    }

    int[][] array2 = arraysOfArraysMain.multiplicationTable(4);
    for (int i = 0; i < array2.length; i++) {
      for (int j = 0; j < array2[i].length; j++) {
        if (array2[i][j] < 10) {
          System.out.print("  " + array2[i][j]);
        } else if (array2[i][j] < 100) {
          System.out.print(" " + array2[i][j]);
        } else {
          System.out.print(array2[i][j]);
        }
      }
      System.out.println();
    }

  }

  public int[][] getValues() {
    int[] daysInTheMonths = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    int[][] monthDays = new int[12][];
    for (int i = 0; i < daysInTheMonths.length; i++) {
      monthDays[i] = new int[daysInTheMonths[i]];
    }
    return monthDays;
  }

  public int[][] triangularMatrix(int size) {
    int[][] triangular = new int[size][];
    for (int i = 0; i < size; i++) {
        triangular[i] = new int[i+1];
    }
    for (int i = 0; i < size; i++) {
      for (int j = 0; j <= i; j++) {
        triangular[i][j] = i;
      }
    }
    return triangular;
  }

  public void printArrayOfArray(int[][] a) {
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a[i].length; j++) {
        System.out.print(a[i][j] + " ");
      }
      System.out.println();
    }
  }

  public int[][] multiplicationTable(int size) {
    int[][] multiplation = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        multiplation[i][j] = (i + 1) * (j + 1);
      }
    }
    return multiplation;
  }
}
