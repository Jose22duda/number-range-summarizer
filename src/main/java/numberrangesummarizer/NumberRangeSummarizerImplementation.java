package numberrangesummarizer;
import java.util.*;
import java.util.stream.Collectors;
public class NumberRangeSummarizerImplementation implements NumberRangeSummarizer{

    /**
     * Collect input string (comma-separated numbers) into a sorted collection.
     * Throws IllegalArgumentException for invalid format.
     */
    @Override
    public Collection<Integer> collect(String input) {
        if (input == null || input.trim().isEmpty()) {
            return Collections.emptyList();
        }
        String[] parts = input.split(",");
        return Arrays.stream(parts)
                .map(String::trim)
                .filter(part -> !part.isEmpty())
                .map(part -> {
                    try {
                        return Integer.parseInt(part);
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Input contains non-integer: " + part);
                    }
                })
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    
    /**
     * Summarize sequential ranges in a collection and return as a comma-separated string.
     */
    @Override
    public String summarizeCollection(Collection<Integer> input) {
        return "TODO: Implement this method";

    }


}