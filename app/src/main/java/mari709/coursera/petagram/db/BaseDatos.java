package mari709.coursera.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import mari709.coursera.petagram.pojo.Mascota;

class BaseDatos extends SQLiteOpenHelper {

    private static BaseDatos mInstance = null;

    private BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
    }

    static BaseDatos getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new BaseDatos(context.getApplicationContext());
        }
        return mInstance;
    }

    //Composición de las tablas
    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                ConstantesBaseDatos.TABLE_MASCOTAS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                ConstantesBaseDatos.TABLE_MASCOTAS_FOTO + " INTEGER" +
                ")";

        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_LIKES_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + " INTEGER, " +
                ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + " INTEGER, " +
                "FOREIGN KEY (" + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + ") " +
                "REFERENCES " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")" +
                ")";
        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXISTS " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA);
        onCreate(db);
    }

    ArrayList<Mascota> obtenerTodasLasMascotas() {
        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query, null);

        while (registros.moveToNext()) {
            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryLikes = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + ") as likes " +
                    " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA +
                    "=" + mascotaActual.getId();

            //Recuperación de datos
            Cursor registrosLikes = db.rawQuery(queryLikes, null);
            if (registrosLikes.moveToNext()) {
                mascotaActual.setLikes(registrosLikes.getInt(0));
            } else {
                mascotaActual.setLikes(0);
            }
            mascotas.add(mascotaActual);
        }
        db.close();
        return mascotas;
    }

    void insertarMascota(ContentValues contentValues) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();
    }

    void darLikeMascotaA(ContentValues contentValues) {
        SQLiteDatabase db = getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_LIKES_MASCOTA, null, contentValues);
        db.close();
    }

    int obtenerLikesMascotaA(Mascota mascota) {
        int likes = 0;

        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_LIKES_MASCOTA_NUMERO_LIKES + ")" +
                " FROM " + ConstantesBaseDatos.TABLE_LIKES_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_LIKES_ID_MASCOTA + "=" +
                mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registroLikes = db.rawQuery(query, null);

        if (registroLikes.moveToNext()) {
            likes = registroLikes.getInt(0);
        }
        db.close();
        return likes;
    }
}