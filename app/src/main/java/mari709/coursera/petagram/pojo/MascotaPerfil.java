package mari709.coursera.petagram.pojo;

public class MascotaPerfil {

    private int foto;
    private int likes;
    private int id;

    public MascotaPerfil (int foto, int likes){

        this.foto = foto;
        this.likes = likes;

    }

    public MascotaPerfil () {
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

