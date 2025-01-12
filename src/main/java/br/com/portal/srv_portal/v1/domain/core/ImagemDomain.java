package br.com.portal.srv_portal.v1.domain.core;

public class ImagemDomain {

    private String id;
    private String arquivo;
    private String idPostagem;

    public ImagemDomain() {

    }

    public ImagemDomain(String id, String arquivo, String idPostagem) {
        this.id = id;
        this.arquivo = arquivo;
        this.idPostagem = idPostagem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getArquivo() {
        return arquivo;
    }

    public void setArquivo(String arquivo) {
        this.arquivo = arquivo;
    }

    public String getIdPostagem() {
        return idPostagem;
    }

    public void setIdPostagem(String idPostagem) {
        this.idPostagem = idPostagem;
    }
}
