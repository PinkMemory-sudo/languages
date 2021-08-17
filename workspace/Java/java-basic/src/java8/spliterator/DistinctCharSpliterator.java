package java8.spliterator;

import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class DistinctCharSpliterator implements Spliterator<Character> {

    private List<Character> chars;
    private int index = 0;

    public DistinctCharSpliterator(List<Character> chars) {
        this.chars = chars;
    }

    public DistinctCharSpliterator(List<Character> chars, int start, int end) {
        this.chars = chars.subList(start, end);
    }

    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        // TODO Auto-generated method stub
        action.accept(this.chars.get(index++));
        return index < this.chars.size();
    }

    @Override
    public Spliterator<Character> trySplit() {
        // TODO Auto-generated method stub
        int difLen = this.chars.size() - index;

        // 判断不可以在拆分了
        if (difLen < 3) {
            return null;
        } else {// 表示可以在拆分。


            DistinctCharSpliterator spliterator = new DistinctCharSpliterator(chars.subList(index, index + 2));

            index = index + 2;

            return spliterator;

        }
    }

    @Override
    public long estimateSize() {
        // TODO Auto-generated method stub
        return this.chars.size() - index;
    }

    @Override
    public int characteristics() {
        // TODO Auto-generated method stub
        // 有序 元素不空 遍历过程不能删除，和修改 增加
        return ORDERED + NONNULL + IMMUTABLE;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        List<Character> chars = Arrays.asList('a', 'b', 'c', 'd', 'b', 'a');

        DistinctCharSpliterator distinctCharSpliterator = new DistinctCharSpliterator(chars);

        Stream<Character> stream = StreamSupport.stream(distinctCharSpliterator, true);

        stream.distinct().forEach((Character ch) -> {

            System.out.print(ch+" ");
        });

        IntStream.range(0,10)

    }

}