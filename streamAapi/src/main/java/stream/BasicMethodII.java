package stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Liangsh
 * @description StreamAPI II
 * @date 2022/7/18 15:29
 */
public class BasicMethodII {

    public static void main(String[] args) {
        // (1)reduce
        // T reduce(T identity, BinaryOperator<T> accumulator);
        // Optional<T> reduce(BinaryOperator<T> accumulator);
        // <U> U reduce(U identity,
        //                 BiFunction<U, ? super T, U> accumulator,
        //                 BinaryOperator<U> combiner);

        Stream<String> stream = Stream.of("I", "love", "you", "too");
        Optional<String> longest = stream.reduce((s1, s2) -> s1.length() >= s2.length() ? s1 : s2);
        System.out.println(longest.get());

        // 求单词长度之和
        // 参数：(1)初始值　   (2)累加器     (3)部分和拼接器，并行执行时才会用到
        Integer lengthSum = stream.reduce(0, (sum, str) -> sum + str.length(),
                (a, b) -> a + b);
        System.out.println(lengthSum);
        // 组合map + sum
        // int lengthSum = stream.mapToInt(str -> str.length()).sum();

        // collect
        // 将Stream转换成容器或Map
        // (1)
        List<String> list = stream.collect(Collectors.toList());
        // (2)
        Set<String> set = stream.collect(Collectors.toSet());
        // (3)
        Map<String, Integer> map = stream.collect(Collectors.toMap(Function.identity(), String::length));

        //　将Stream规约成List
        List<String> list1 = stream.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);// 方式１
        //List<String> list = stream.collect(Collectors.toList());// 方式2
        System.out.println(list1);

        
    }
}
