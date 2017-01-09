package mari709.coursera.petagram.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import mari709.coursera.petagram.R;

public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setLogo(R.mipmap.logo_app);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        //Incorporo flecha subir (establezco clase padre en el manifiesto)
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
