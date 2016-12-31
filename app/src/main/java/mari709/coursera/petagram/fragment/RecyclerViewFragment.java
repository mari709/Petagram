package mari709.coursera.petagram.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mari709.coursera.petagram.presentador.IRecyclerViewFragmentPresenter;
import mari709.coursera.petagram.pojo.Mascota;
import mari709.coursera.petagram.adaptador.MascotaAdaptador;
import mari709.coursera.petagram.R;
import mari709.coursera.petagram.presentador.RecyclerViewFragmentPresenter;

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {

    private RecyclerView rv_mascotas;
    private IRecyclerViewFragmentPresenter presenter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_recycler_view, container, false);

        rv_mascotas = (RecyclerView) v.findViewById(R.id.rv_mascotas);

        presenter = new RecyclerViewFragmentPresenter(this, getContext());

        return v;
    }


    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rv_mascotas.setLayoutManager(llm);

    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {

        return new MascotaAdaptador(mascotas, getActivity());
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdaptador adaptador) {

        rv_mascotas.setAdapter(adaptador);

    }
}
