package mari709.coursera.petagram.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import java.util.ArrayList;
import mari709.coursera.petagram.R;
import mari709.coursera.petagram.adaptador.MascotaAdaptador;
import mari709.coursera.petagram.pojo.Mascota;

public class MascotaFavorita extends AppCompatActivity {

    private RecyclerView listaMascotas;
    private ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota_favorita);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setLogo(R.mipmap.logo_app);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        //Incorporo flecha subir (establezco clase padre en el manifiesto)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rv_favoritos);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();

    }

        public MascotaAdaptador adaptador;
    public void inicializarAdaptador(){
        adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<>();

        //datos dummy
        mascotas.add(new Mascota("Lisa",R.drawable.mascota7,50));
        mascotas.add(new Mascota("Abi",R.drawable.mascota6,25));
        mascotas.add(new Mascota("Lui",R.drawable.mascota5,20));
        mascotas.add(new Mascota("Mojo",R.drawable.mascota4,18));
        mascotas.add(new Mascota("Pomelo",R.drawable.mascota3,7));


    }
}
