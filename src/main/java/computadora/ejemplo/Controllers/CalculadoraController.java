package computadora.ejemplo.Controllers;  // ← cambia esto
import computadora.ejemplo.Tools.Calculadora;  // ← y esto
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculadoraController {

    @GetMapping("/")
    public String inicio() {
        return "Calculadora Infix funcionando";
    }

    @GetMapping("/expresion")
    public String calcularInfix(
            @RequestParam String infix
    ) {

        String postfix =
                Calculadora.convertirAPostfix(infix);

        double resultado =
                Calculadora.resolverExpresionPostfix(postfix);

        return "Infix: " + infix +
                "\nPostfix: " + postfix +
                "\nResultado: " + resultado;
    }
}
