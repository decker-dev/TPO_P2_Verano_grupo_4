package org.example.tpo.punto5.punto5_2;

public class CesarCipher {

    /**
     * Descifra un texto cifrado con el método César, estimando el desplazamiento
     * según la frecuencia de caracteres, asumiendo 'e' como el más común en español.
     *
     * Complejidad: O(n), donde n es la longitud del texto, ya que recorre la cadena
     * varias veces y usa operaciones de diccionario en O(1).
     *
     * @param string Texto cifrado.
     * @return Texto descifrado.
     */


    private static final String abecedario = "abcdefghijklmnopqrstuvwxyz";
    private final Dictionary abcDictionary;

    public CesarCipher() {
        this.abcDictionary = new DynamicDictionary();
        for (int i = 0; i < abecedario.length(); i++) {
            char ch = abecedario.charAt(i);
            abcDictionary.add(ch, 0);
        }
    }

    private void countCharInString(String frase) {
        for (int i = 0; i < frase.length(); i++) {
            char ch = frase.charAt(i);
            if(Character.isLetter(ch)) {
                int count = abcDictionary.get(ch);
                abcDictionary.remove(ch);
                abcDictionary.add(ch, count + 1);
            }
        }
    }

    private int displacementCalculation() {
        int maxVal = 0;
        int maxKey = 0;
        for(char c : abecedario.toCharArray()){
            int val = Character.toLowerCase(abcDictionary.get(c));
            if(val > maxVal){
                maxVal = val;
                maxKey = c;
            }
        }
        int mostCommonCharInSpanish = 'e';
        return maxKey - mostCommonCharInSpanish;
    }

    /**
     * Descifra un texto con cifrado cesar basado en la repeticion de caracteres.
     * Asume el caracter 'e' como ancla de valor mas repetido
     *
     * @param string
     * @return String descifrado
     */
    public String descifrarCodigo(String string) {
        countCharInString(string);
        int displacement = displacementCalculation();
        StringBuilder descifrarCodigo = new StringBuilder();

        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);

            if (Character.isLetter(c)) {
                char descifrado;
                if (Character.isUpperCase(c)) {
                    descifrado = (char) (c - displacement);
                    if (descifrado < 'A') {
                        descifrado = (char) ('Z' - ('A' - descifrado - 1));
                    }
                } else {
                    descifrado = (char) (c - displacement);
                    if (descifrado < 'a') {
                        descifrado = (char) ('z' - ('a' - descifrado - 1));
                    }
                }
                descifrarCodigo.append(descifrado);
            } else {
                descifrarCodigo.append(c);
            }
        }

        return descifrarCodigo.toString();
    }
}