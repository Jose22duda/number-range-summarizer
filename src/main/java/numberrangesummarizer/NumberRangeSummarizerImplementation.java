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
        if (input == null || input.isEmpty()) {
            return "";
        }
        List<Integer> numbers = new ArrayList<>(input);
        Collections.sort(numbers);

        StringBuilder sb = new StringBuilder();
        int rangeStart = numbers.get(0);
        int previous = rangeStart;

        for (int i = 1; i < numbers.size(); i++) {
            int current = numbers.get(i);
            if (current == previous + 1) {
                // sequence, move on
                previous = current;
            } else {
                // not sequential, close previous range
                appendRange(sb, rangeStart, previous);
                sb.append(", ");
                rangeStart = current;
                previous = current;
            }
        }
        // Add the last range/number
        appendRange(sb, rangeStart, previous);

        return sb.toString();
    }

    private void appendRange(StringBuilder sb, int start, int end) {
        if (start == end) {
            sb.append(start);
        } else {
            sb.append(start).append("-").append(end);
        }
    }


}