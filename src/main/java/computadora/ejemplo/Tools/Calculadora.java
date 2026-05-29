package computadora.ejemplo.Tools;  // ← solo cambia esta línea
import java.util.Stack;

public class Calculadora {

    public static int Ejecutor(char operador) {

        switch (operador) {

            case '+':
            case '-':
                return 1;

            case '*':
            case '/':
                return 2;

            case '^':
                return 3;
        }

        return -1;
    }

    public static String convertirAPostfix(String infix) {

        StringBuilder postfix = new StringBuilder();

        Stack<Character> pila = new Stack<>();

        for (int i = 0; i < infix.length(); i++) {

            char c = infix.charAt(i);

            if (c == ' ') {
                continue;
            }

            if (Character.isDigit(c)) {
                postfix.append(c);
            }

            else if (c == '(') {
                pila.push(c);
            }

            else if (c == ')') {

                while (!pila.isEmpty() &&
                        pila.peek() != '(') {

                    postfix.append(pila.pop());
                }

                pila.pop();
            }

            else {

                while (!pila.isEmpty() &&
                        Ejecutor(c) <= Ejecutor(pila.peek())) {

                    postfix.append(pila.pop());
                }

                pila.push(c);
            }
        }

        while (!pila.isEmpty()) {
            postfix.append(pila.pop());
        }

        return postfix.toString();
    }

    public static double resolverExpresionPostfix(
            String postfix
    ) {

        Stack<Double> fila = new Stack<>();

        for (int i = 0; i < postfix.length(); i++) {

            char c = postfix.charAt(i);

            if (Character.isDigit(c)) {

                fila.push((double)(c - '0'));
            }

            else {

                double b = fila.pop();
                double a = fila.pop();

                switch (c) {

                    case '+':
                        fila.push(a + b);
                        break;

                    case '-':
                        fila.push(a - b);
                        break;

                    case '*':
                        fila.push(a * b);
                        break;

                    case '/':
                        fila.push(a / b);
                        break;

                    case '^':
                        fila.push(Math.pow(a, b));
                        break;
                }
            }
        }

        return fila.pop();
    }
}
