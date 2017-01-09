package mari709.coursera.petagram.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import java.util.ArrayList;
import mari709.coursera.petagram.R;
import mari709.coursera.petagram.adaptador.PageAdapter;
import mari709.coursera.petagram.fragment.InstagramFragment;
import mari709.coursera.petagram.fragment.PerfilFragment;
import mari709.coursera.petagram.fragment.RecyclerViewFragment;

public class MainActivity extends AppCompatActivity {

    public Toolbar miActionBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws NullPointerException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();
        setSupportActionBar(miActionBar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_options, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {

            case R.id.menu_likes:
                Toast.makeText(this, "Mascotas favoritas", Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this, MascotaFavorita.class);
                startActivity(intent);
                break;

            case R.id.item_contacto:
                Toast.makeText(this, "Contacto", Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this, Contacto.class);
                startActivity(intent);
                break;

            case R.id.item_acercade:
                Toast.makeText(this, "Acerca de", Toast.LENGTH_SHORT).show();
                intent = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(intent);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private ArrayList<Fragment> agregarFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        fragments.add(new InstagramFragment());
        return fragments;
    }

    private void setUpViewPager() {
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.home);
        tabLayout.getTabAt(1).setIcon(R.mipmap.profile_cat);
        tabLayout.getTabAt(2).setIcon(R.mipmap.instagram);
    }
}