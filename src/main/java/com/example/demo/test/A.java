package com.example.demo.test;

import java.util.Optional;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.IntStream;

public interface A {
    public int operation(int a ,int b);

//    public void printMsg(String msg);
}
interface B{
    default void print(){
        printMsg("i'm B");
    }
    public void printMsg(String msg);
}

interface E{
    Optional<Integer> getNumber();
}

interface F{
    static <T,U,R> BiFunction<Optional<T>,Optional<U>,Optional<R>> testMax(
            BiFunction<? super T,? super U,? extends R> function){
        return (x,y)->x.flatMap(
                xv->y.map(
                        yv->function.apply(xv,yv)
                )
        );
    }
}

class C{

}

class D{
    static Random random = new Random(47);

    public static IntStream getInts(){
        return  random.ints(1,100).limit(100);
    }
}