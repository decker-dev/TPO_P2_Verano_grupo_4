package org.example.tpo.punto5.punto5_2;

public class Punto5_2 {
    public static void main(String[] args) {
        CesarCipher cesarCipher = new CesarCipher();
        /* Texto original: este texto ha sido descifrado */
        String cifrado = "lzal aleav oh zpkv klzjpmyhkv";
        String descifrado = cesarCipher.descifrarCodigo(cifrado);
        System.out.println("Texto descifrado: " + descifrado);
    }
}
