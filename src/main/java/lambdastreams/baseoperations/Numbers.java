package lambdastreams.baseoperations;

import java.util.List;
import java.util.Optional;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Numbers {

    private List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Optional min() {
        return numbers.stream().min((s1, s2) -> s1 - s2);
    }

    public Integer sum() {
        return numbers.stream().reduce(0, (a, b) -> a + b, (a, b) -> a + b);
    }

    public boolean isAllPositive() {
        return numbers.stream().allMatch(s -> s >= 0);
    }

    public TreeSet<Integer> getDistinctElements() {
        return numbers.stream().collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
