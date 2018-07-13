package com.example.demo.test;

import java.text.spi.NumberFormatProvider;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

public class L {

    public static void BC(B b,C c){

    }

    /**
     * eg 1
     * @param e
     * @return
     */
    public Optional add (E e){
        Optional<Integer> x = e.getNumber();
        Optional<Integer> y = e.getNumber();
        if(x.isPresent() && y.isPresent()){
            Integer z = Math.max(x.get(),y.get());
            return Optional.of(z);
        }else {
            return Optional.empty();
        }
    }


    public Optional add2(E e){
        return e.getNumber()
               .flatMap(x->e.getNumber().map(y->Math.max(x,y)));
    }

    public Optional max(E e){
        return F.<Integer,Integer,Integer>testMax(Math::max).apply(e.getNumber(),e.getNumber());
    }



    public static void main(String [] args){
      A a = (x,y) -> x+y;

      B b = msg -> {
          System.out.println(msg);
      };

        //无参数，返回一个结果。
        Supplier<C> c = C::new;

        BiConsumer<B,C> bc = L::BC;
        //接受一个输入参数，返回一个结果。

        Function<Double,Function<Object,Object>> add = x->y->x*(Integer) y;
        Double t = (Double) add.apply(3.40).apply(32);
        System.out.println(t);

//      D.getInts()
////              .parallel()
//              .map(i->i*i)
//              .filter(i->i<5000)
//              .limit(10)
//              .sorted()
//              .forEach(System.out::println);

      IntSummaryStatistics statistics = D.getInts()
              .parallel()
              .limit(20)
              .map(i->i/2)
              .filter(i->i<100)
              .summaryStatistics();

//      System.out.println("statistics : "+statistics.getMin());

    }

}
