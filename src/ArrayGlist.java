import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class ArrayGlist<T> extends ArrayList<Integer> {

    public ArrayGlist() {

    }

    public ArrayGlist(List<Integer> list) {
        this.addAll(list);
    }

    public void bubbleSort() {
        for (int i = 0; i < this.size(); i++) {
            for (int j = 1 + i; j < this.size(); j++) {
                if (this.get(i) > this.get(j)) {
                    Collections.swap(this, i, j);
                }
            }
        }
    }

    public void streamBubbleSort() {
        IntStream.range(0, this.size())
                .forEach(i -> IntStream.range(i + 1, this.size())
                        .filter(j -> this.get(i) > this.get(j))
                        .forEach(j -> Collections.swap(this, i, j)));
    }
}
