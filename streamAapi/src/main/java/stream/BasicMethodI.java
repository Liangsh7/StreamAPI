package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author Liangsh
 * @description StreamAPI 操作
 * @date 2022/7/18 14:53
 */
public class BasicMethodI {

    /**
     * 中间操作：
     *  	concat() distinct() filter() flatMap() limit() map() peek()
     *      skip() sorted() parallel() sequential() unordered()
     *
     * 结束操作：
     *      allMatch() anyMatch() collect() count() findAny() findFirst()
     *      forEach() forEachOrdered() max() min() noneMatch() reduce() toArray()
     */
    public static void main(String[] args) {
        // 使用Stream.forEach()迭代
        Stream<String> stream = Stream.of("I", "love", "you", "too");
        stream.forEach(System.out::println);


        // filter 保留长度等于3的字符串
        stream.filter(str -> str.length()==3)
                .forEach(System.out::println);

        // distinct 去重
        stream.distinct()
                .forEach(System.out::println);

        // sorted 排序
        stream.sorted((str1, str2) -> str1.length()-str2.length())
                .forEach(System.out::println);

        // map 转换
        stream.map(str -> str.toUpperCase())
                .forEach(System.out::println);

        // flatMap 平铺转换
        Stream<List<Integer>> stream2 = Stream.of(Arrays.asList(1,2), Arrays.asList(3, 4, 5));
        stream2.flatMap(list -> list.stream())
                .forEach(System.out::println);
    }

}
