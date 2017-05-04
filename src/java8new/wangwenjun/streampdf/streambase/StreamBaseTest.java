package java8new.wangwenjun.streampdf.streambase;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Copyright © 2016年 author. All rights reserved.
 *
 * @Author 临江仙 hxqiuxm@163.com
 * @Date 2017/5/4 0004 16:03
 */
public class StreamBaseTest {

    //From Collection
    @Test
    public void formCollection(){

        List<String> list = Collections.emptyList();
        Stream<String> stream = list.stream();
        Stream<String> streamParallel = list.parallelStream();
    }

    //From Arrays
    @Test
    public  void fromArrays(){

        int[] array = {1,2,3,4,5};
        IntStream intStream = Arrays.stream(array);
        Stream<Integer> integerStream = Stream.of(1,2,3,4,5);
    }

    //From Files
    @Test
    public void fromFiles() throws IOException {

        Path path = Paths.get("");

        Stream<Path> stream = Files.walk(path);
    }


}
