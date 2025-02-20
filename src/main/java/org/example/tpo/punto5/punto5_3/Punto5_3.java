package org.example.tpo.punto5.punto5_3;

public class Punto5_3 {
    public static void main(String[] args) {
        String balanceado = "(dlfsjf{albfllda} askdb'[sd'aks[df])alsfd";
        String desbalanceado = "(lbgslkdbfl[adsfba]asfas{asf}sfa\")\"afa";

        ParenthesesValidator.isBalanced(balanceado);
        ParenthesesValidator.isBalanced(desbalanceado);
    }
}
