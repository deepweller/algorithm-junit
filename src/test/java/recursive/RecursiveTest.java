package recursive;

import algorithm.recursive.Factorial;
import algorithm.recursive.MaximumSquare;
import algorithm.recursive.QuickSort;
import algorithm.recursive.SumArray;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class RecursiveTest {

    Factorial factorial;
    MaximumSquare maximumSquare;
    SumArray sumArray;
    QuickSort quickSort;

    @Test
    public void factorialTest() {
        assertThat(factorial.getFactorial(5), is(120));

    }

    @Test
    public void squareTest() {
        assertThat(maximumSquare.getMaxSize(1680,640), is(80));
        assertThat(maximumSquare.getMaxSize(400,400), is(400));
        assertThat(maximumSquare.getMaxSize(8,3), is(1));
    }

    @Test
    public void arraySumTest() {
        assertThat(sumArray.sumArray(new int[]{2,4,6}, 0), is(12));

    }

    @Test
    public void quickSortTest() {
        int[] arr1 = {};
        int[] sortedArr1 = {};
        assertThat(quickSort.solution(arr1, 0, arr1.length - 1), is(sortedArr1));
        int[] arr2 = {6,4,1,8,9,2,7,5,3};
        int[] sortedArr2 = {1,2,3,4,5,6,7,8,9};
        assertThat(quickSort.solution(arr2, 0, arr2.length - 1), is(sortedArr2));
        int[] arr4 = {6,4,2,10,9,1,7,11,5,3,0,8};
        int[] sortedArr4 = {0,1,2,3,4,5,6,7,8,9,10,11};
        assertThat(quickSort.solution(arr4, 0, arr4.length - 1), is(sortedArr4));
        int[] arr3 = {1};
        int[] sortedArr3 = {1};
        assertThat(quickSort.solution(arr3, 0, arr3.length - 1), is(sortedArr3));
    }

}
