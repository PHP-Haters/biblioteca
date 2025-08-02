package app.model;

public class Livro {

    private Integer id;
    private String titulo;
    private String sinopse;
    private Integer paginas;
    
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopse() {
        return this.sinopse;
    }
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public Integer getPaginas() {
        return this.paginas;
    }
    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }
}
