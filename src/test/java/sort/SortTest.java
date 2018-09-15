package sort;

import algorithm.sort.SelectionSort;
import algorithm.sort.Sort;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SortTest {

    Sort sort;

    @Test
    public void selectionSortTest() {
        sort = new SelectionSort();
        assertThat(sort.sort(new int[] {5,3,7,1,9}), is(new int[] {1,3,5,7,9}));
        assertThat(sort.sort(new int[] {1,2,3,4,5}), is(new int[] {1,2,3,4,5}));
        assertThat(sort.sort(new int[] {5,4,3,2,1}), is(new int[] {1,2,3,4,5}));
    }
}
