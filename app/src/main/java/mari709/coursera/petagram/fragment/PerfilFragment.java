package mari709.coursera.petagram.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mari709.coursera.petagram.R;
import mari709.coursera.petagram.adaptador.PerfilAdaptador;
import mari709.coursera.petagram.pojo.MascotaPerfil;

public class PerfilFragment extends Fragment {

    private RecyclerView listaFotosPerfil;
    ArrayList<MascotaPerfil> miPerfil;

    public PerfilFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        listaFotosPerfil = (RecyclerView) v.findViewById(R.id.gridPerfil);
        GridLayoutManager glm = new GridLayoutManager(getContext(), 2);
        listaFotosPerfil.setHasFixedSize(true);//
        listaFotosPerfil.setLayoutManager(glm);

        iniciarListaFotosPerfil();
        inicializarAdaptador();
        return v;

    }
    public PerfilAdaptador perfilAdaptador;

    public void inicializarAdaptador() {
        perfilAdaptador = new PerfilAdaptador(miPerfil);
        listaFotosPerfil.setAdapter(perfilAdaptador);
    }

    public void iniciarListaFotosPerfil() {
        miPerfil = new ArrayList<>();
        miPerfil.add(new MascotaPerfil(R.drawable.uliseschico, 2));
        miPerfil.add(new MascotaPerfil(R.drawable.uliseschico, 34));
        miPerfil.add(new MascotaPerfil(R.drawable.uliseschico, 4));
        miPerfil.add(new MascotaPerfil(R.drawable.uliseschico, 3));
        miPerfil.add(new MascotaPerfil(R.drawable.uliseschico, 8));
        miPerfil.add(new MascotaPerfil(R.drawable.uliseschico, 5));
    }
}