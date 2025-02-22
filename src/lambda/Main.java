package lambda;

public class Main {
    public static void main(String[] args) {
        Calculator calc = Calculator.instance.get();

        int a = calc.plus.apply(1, 2);
        int b = calc.minus.apply(1, 1);
        int c = calc.devide.apply(a, b);

        calc.println.accept(c);
//Код не работает тк мы пытаемся поделить на ноль.
// 1) Можно выкинуть исключение через throws ArithmeticException
// 2) проверить y на 0 в операции divide в классе калькулятор

    }
}
