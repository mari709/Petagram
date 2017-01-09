package mari709.coursera.petagram.adaptador;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mari709.coursera.petagram.R;
import mari709.coursera.petagram.db.ConstructorMascotas;
import mari709.coursera.petagram.pojo.Mascota;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;
    private Activity objActivity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity objActivity) {
        this.mascotas = mascotas;
        this.objActivity = objActivity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota objMascota = mascotas.get(position);
        holder.img_foto.setImageResource(objMascota.getFoto());
        holder.tv_nombreMascota.setText(objMascota.getNombre());
        holder.tv_contadorLikes.setText(String.valueOf(objMascota.getLikes()));

        holder.imgbtnLike.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Toast.makeText(objActivity, "Diste Like a " + objMascota.getNombre(), Toast.LENGTH_SHORT).show();
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(objActivity);
                constructorMascotas.darLikeMascota(objMascota);
                holder.tv_contadorLikes.setText(String.valueOf(constructorMascotas.obtenerLikesMascota(objMascota)));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    static class MascotaViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_foto;
        private TextView tv_nombreMascota;
        private ImageView imgbtnLike;
        private TextView tv_contadorLikes;

        private MascotaViewHolder(View itemView) {
            super(itemView);
            img_foto = (ImageView) itemView.findViewById(R.id.img_foto);
            tv_nombreMascota = (TextView) itemView.findViewById(R.id.tv_nombreMascota);
            imgbtnLike = (ImageView) itemView.findViewById(R.id.imgbtnLike);
            tv_contadorLikes = (TextView) itemView.findViewById(R.id.tv_contadorLikes);
        }
    }
}