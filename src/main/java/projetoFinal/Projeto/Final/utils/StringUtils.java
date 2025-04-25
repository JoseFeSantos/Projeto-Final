package projetoFinal.Projeto.Final.utils;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class StringUtils {
    public static String removerAcentos(String texto) {
        String normalized = Normalizer.normalize(texto, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("");
    }
}