package pt.ulusofona.deisi;

public class Item {
    String titulo;
    String genero;
    String descricao;

    public Item(String titulo, String tipo, String genero, String descricao) {
        this.titulo = titulo;
        this.genero = genero;
        this.descricao = descricao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getgenero() {
        return genero;
    }

    public void setgenero(String genero) {
        this.genero = genero;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
