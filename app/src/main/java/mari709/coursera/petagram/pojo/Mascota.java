package mari709.coursera.petagram.pojo;


public class Mascota {

    private String nombre;
    private int foto;
    private int likes;
    private int id;

    public Mascota(String nombre, int foto, int likes) {

        this.nombre = nombre;
        this.foto = foto;
        this.likes = likes;

    }

    public Mascota() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
