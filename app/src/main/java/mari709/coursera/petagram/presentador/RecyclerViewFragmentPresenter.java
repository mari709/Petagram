package mari709.coursera.petagram.presentador;

import android.content.Context;

import java.util.ArrayList;

import mari709.coursera.petagram.db.ConstructorMascotas;
import mari709.coursera.petagram.pojo.Mascota;
import mari709.coursera.petagram.fragment.IRecyclerViewFragmentView;

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){

        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();

    }

    @Override
    public void obtenerMascotasBaseDatos() {

        ConstructorMascotas constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();

    }

    @Override
    public void mostrarMascotasRV() {

        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas)); /** crearAdaptador viene de IRecyclerViewFragmentView */
        iRecyclerViewFragmentView.generarLinearLayoutVertical();

    }
}
