package mari709.coursera.petagram.activity;

import android.content.Intent;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import mari709.coursera.petagram.correo.EnviarCorreo;
import mari709.coursera.petagram.R;

public class Contacto extends AppCompatActivity implements View.OnClickListener {

    private TextInputEditText asunto, mensaje;
    private TextView correo;
    public Button btn_enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setLogo(R.mipmap.logo_app);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        //Incorporo flecha subir (establezco clase padre en el manifiesto)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        correo = (TextView) findViewById(R.id.tv_emailUsuario);
        asunto = (TextInputEditText) findViewById(R.id.et_asunto);
        mensaje = (TextInputEditText) findViewById(R.id.et_mensaje);
        btn_enviar = (Button) findViewById(R.id.btn_enviar);
        btn_enviar.setOnClickListener(this);
    }

    //Metodo para enviar correo
    private void enviarEmail() {

        //Obtengo los datos de los EditText
        String correoA = correo.getText().toString().trim();
        String asuntoA = asunto.getText().toString().trim();
        String mensajeA = mensaje.getText().toString().trim();

        //Crea el objeto EnviarCorreo
        EnviarCorreo ec = new EnviarCorreo(this, correoA, asuntoA, mensajeA);
        ec.execute();
    }

    public void onBackPressed() {
        this.startActivity(new Intent(Contacto.this, MainActivity.class));
    }

    @Override
    public void onClick(View v) {
        enviarEmail();
    }
}
