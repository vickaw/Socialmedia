package kawelenga.packag.com.socialmedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class startActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewpager;
    private TabLayout tabLayout;
    private TabAdapter tabAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        setTitle("Social media app");

       // toolbar = findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        viewpager=findViewById(R.id.viewPager);
        tabAdapter=new TabAdapter(getSupportFragmentManager());
        viewpager.setAdapter(tabAdapter);

        tabLayout=findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewpager,false);
    }
}
