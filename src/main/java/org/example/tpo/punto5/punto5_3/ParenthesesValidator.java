package org.example.tpo.punto5.punto5_3;

public class ParenthesesValidator {

    /**
     * Verifica si la expresión tiene paréntesis, llaves y corchetes balanceados,
     * ignorando caracteres entre comillas simples o dobles.
     *
     * Complejidad: O(n), ya que recorre la expresión una vez y usa pilas con operaciones O(1).
     *
     * @param expression Expresión a validar.
     * @return true si está balanceada, false en caso contrario.
     */
    public static boolean isBalanced(String expression) {
        Stack parenthesisStack = new DynamicStack();
        Stack bracketStack = new DynamicStack();
        Stack curlyStack = new DynamicStack();
        boolean insideQuotes = false;

        for (char c : expression.toCharArray()) {
            // Manejar comillas simples o dobles
            if (c == '\'' || c == '\"') {
                insideQuotes = !insideQuotes;
                continue;
            }

            // Si estamos dentro de comillas, ignoramos los paréntesis
            if (insideQuotes) {
                continue;
            }

            // Procesamos paréntesis
            if (c == '(') {
                parenthesisStack.add(c);
            } else if (c == ')') {
                if (parenthesisStack.isEmpty()) {
                    return false; // Paréntesis de cierre sin su correspondiente apertura
                }
                parenthesisStack.remove(); // Quitamos el paréntesis de apertura correspondiente
            }

            if (c == '{') {
                curlyStack.add(c);
            } else if (c == '}') {
                if (curlyStack.isEmpty()) {
                    return false; // Paréntesis de cierre sin su correspondiente apertura
                }
                curlyStack.remove(); // Quitamos el paréntesis de apertura correspondiente
            }


            if (c == '[') {
                bracketStack.add(c);
            } else if (c == ']') {
                if (bracketStack.isEmpty()) {
                    return false; // Paréntesis de cierre sin su correspondiente apertura
                }
                bracketStack.remove(); // Quitamos el paréntesis de apertura correspondiente
            }
        }

        // La expresión está balanceada si no quedan paréntesis sin cerrar
        // y no estamos dentro de comillas
        return parenthesisStack.isEmpty() && curlyStack.isEmpty() && bracketStack.isEmpty() && !insideQuotes;
    }
}