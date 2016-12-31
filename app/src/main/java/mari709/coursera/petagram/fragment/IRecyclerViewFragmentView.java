package mari709.coursera.petagram.fragment;

import java.util.ArrayList;

import mari709.coursera.petagram.pojo.Mascota;
import mari709.coursera.petagram.adaptador.MascotaAdaptador;

public interface IRecyclerViewFragmentView {

    void generarLinearLayoutVertical();

    MascotaAdaptador crearAdaptador(ArrayList<Mascota> pets);

    void inicializarAdaptadorRV(MascotaAdaptador adaptador);

}
