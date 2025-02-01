package calculator;

import java.util.function.*;

public class Calculator {

    static Supplier<Calculator> instance = Calculator::new;

    BinaryOperator<Integer> plus = (x, y) -> x + y;
    BinaryOperator<Integer> minus = (x, y) -> x - y;
    BinaryOperator<Integer> multiply = (x, y) -> x * y;
    // в этой реализации  будет java.lang.ArithmeticException: / by zero при делении на 0, т.к. делить на ноль нельзя.
    // BinaryOperator<Integer> devide = (x, y) -> x / y;

    // моя реализация - перехватить исключение в try catch:
    BinaryOperator<Integer> devide = this::divideMethod;

    UnaryOperator<Integer> pow = x -> x * x;
    UnaryOperator<Integer> abs = x -> x > 0 ? x : x * -1;

    Predicate<Integer> isPositive = x -> x > 0;

    Consumer<Integer> println = System.out::println;

    int divideMethod(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            throw new ArithmeticException("Нельзя делить на 0!");
        }
    }

}