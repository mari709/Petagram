package mari709.coursera.petagram.adaptador;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mari709.coursera.petagram.R;
import mari709.coursera.petagram.pojo.MascotaPerfil;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilAdaptadorViewHolder> {

    private ArrayList<MascotaPerfil> mascotaPerfil;

    public PerfilAdaptador(ArrayList<MascotaPerfil> mascotaPerfil) {
        this.mascotaPerfil = mascotaPerfil;
    }

    @Override
    public PerfilAdaptadorViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_perfil, parent, false);
        return new PerfilAdaptadorViewHolder(v);
    }

    //Se asocia cada elemento con cada View
    @Override
    public void onBindViewHolder(PerfilAdaptadorViewHolder holder, int position) {

        final MascotaPerfil pMascota = mascotaPerfil.get(position);

        holder.img_pFoto.setImageResource(pMascota.getFoto());
        holder.tv_pContadorLikes.setText(String.valueOf(pMascota.getLikes()));
    }

    @Override
    public int getItemCount() {
        return mascotaPerfil.size();
    }

    static class PerfilAdaptadorViewHolder extends RecyclerView.ViewHolder {

        private ImageView img_pFoto;
        private TextView tv_pContadorLikes;


        PerfilAdaptadorViewHolder(View itemView) {
            super(itemView);
            img_pFoto = (ImageView) itemView.findViewById(R.id.img_pFoto);
            tv_pContadorLikes = (TextView) itemView.findViewById(R.id.tv_pContadorLikes);
        }
    }
}

