package br.com.portal.srv_portal.util.imagem;

import java.util.UUID;

public class ImagemUtil {

    public static String gerarNomeImagemPng() {
        UUID uuid = UUID.randomUUID();;
        return uuid.toString().concat(".png");
    }

    public static String gerarNomeImagemJJpg() {
        UUID uuid = UUID.randomUUID();;
        return uuid.toString().concat(".jpg");
    }

    public static String gerarNomeImagemJpeg() {
        UUID uuid = UUID.randomUUID();;
        return uuid.toString().concat(".jpeg");
    }

}
