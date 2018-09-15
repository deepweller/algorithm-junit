package algorithm.search;

import algorithm.search.BinarySearch;
import algorithm.search.Search;
import algorithm.search.SimpleSearch;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FinderTest {

    Search search;

    @Test
    public void simpleSearchTest() {
        search = new SimpleSearch();
        assertThat(search.findCount(10,6),is(6));
        assertThat(search.find(new int[] {1,3,5,7,9},5),is(2));
    }

    @Test
    public void binarySearchTest() {
        search = new BinarySearch();
        assertThat(search.findCount(16,16),is(4));
        assertThat(search.find(new int[] {1,3,5,7,9},9),is(4));
    }
}
