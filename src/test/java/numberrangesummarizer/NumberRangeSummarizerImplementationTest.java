package src.test.java.numberrangesummarizer;
import java.util.*;

import numberrangesummarizer.NumberRangeSummarizer;
import numberrangesummarizer.NumberRangeSummarizerImplementation;
import static org.junit.Assert.*;
import org.junit.Test;

public class NumberRangeSummarizerImplementationTest {
    private final NumberRangeSummarizer summarizer = new NumberRangeSummarizerImplementation();

    @Test
    public void testCollectNormalInput() {
        Collection<Integer> result = summarizer.collect("1,3,6,7,8,12,13,14,15,21,22,23,24,31");
        List<Integer> expected = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        assertEquals(expected, new ArrayList<>(result));
    }

    @Test
    public void testCollectWithWhitespaceAndDuplicates() {
        Collection<Integer> result = summarizer.collect(" 1, 3,  6,7, 8, 6,8, 3 ");
        List<Integer> expected = Arrays.asList(1, 3, 6, 7, 8);
        assertEquals(expected, new ArrayList<>(result));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCollectWithInvalidInput() {
        summarizer.collect("1,2,foo,4");
    }

    @Test
    public void testSummarizeCollectionNormal() {
        Collection<Integer> input = Arrays.asList(1, 3, 6, 7, 8, 12, 13, 14, 15, 21, 22, 23, 24, 31);
        String summarized = summarizer.summarizeCollection(input);
        assertEquals("1, 3, 6-8, 12-15, 21-24, 31", summarized);
    }

    @Test
    public void testSummarizeCollectionSingleNumber() {
        Collection<Integer> input = Collections.singletonList(42);
        String summarized = summarizer.summarizeCollection(input);
        assertEquals("42", summarized);
    }

    @Test
    public void testSummarizeCollectionEmpty() {
        Collection<Integer> input = Collections.emptyList();
        String summarized = summarizer.summarizeCollection(input);
        assertEquals("", summarized);
    }

    @Test
    public void testSummarizeCollectionWithGaps() {
        Collection<Integer> input = Arrays.asList(1, 2, 4, 5, 6, 9);
        String summarized = summarizer.summarizeCollection(input);
        assertEquals("1-2, 4-6, 9", summarized);
    }

    @Test
    public void testSummarizeUnsortedInput() {
        Collection<Integer> input = Arrays.asList(3, 1, 2);
        String summarized = summarizer.summarizeCollection(input);
        assertEquals("1-3", summarized);
    }

}
