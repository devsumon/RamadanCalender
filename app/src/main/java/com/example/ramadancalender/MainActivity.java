package com.example.ramadancalender;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private String [] dayofRamadan ={"৭ মে মঙ্গলবার","৮ মে বুধবার","৯ মে বৃহস্পতিবার","১০ মে শুক্রবার","১১ মে শনিবার","১২ মে রবিবার","১৩ মে সোমবার","১৪ মে মঙ্গলবার"};
    private String [] sehriTime ={"সেহরি 3:01" , "সেহরি 3:02", "সেহরি 3:03","সেহরি 3:04" , "সেহরি 3:05", "সেহরি 3:06", "সেহরি 3:07", "সেহরি 3:08"};
    private String [] iftarTime ={"ইফতা 6:01" , "ইফতা 6:02", "ইফতা 6:03","ইফতা 6:04" , "ইফতা 6:05", "ইফতা 6:06", "ইফতা 6:07", "ইফতা 6:08"};

    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv =findViewById(R.id.recyclerViewId);
        //for listView code
        rv.setLayoutManager(new LinearLayoutManager(this));

        //for GridView code
        //rv.setLayoutManager(new GridLayoutManager(this, 2));
        rv.setAdapter(new MyAdapter());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyHolder> {

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

            View v = LayoutInflater.from(MainActivity.this)
                    .inflate(R.layout.activity_ramadan, viewGroup, false);

            return new MyHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {

            myHolder.nameView.setText(dayofRamadan[i]);
            myHolder.sehriTime.setText(sehriTime[i]);
            myHolder.iftarTime.setText(iftarTime[i]);


        }

        @Override
        public int getItemCount() {
            return dayofRamadan.length;
        }

        public class MyHolder extends RecyclerView.ViewHolder {

            TextView nameView;
            TextView sehriTime;
            TextView iftarTime;


            public MyHolder(@NonNull View itemView) {
                super(itemView);
                nameView = itemView.findViewById(R.id.numberoframadanID);
                sehriTime = itemView.findViewById(R.id.sehriTimeTextID);
                iftarTime = itemView.findViewById(R.id.iftarTimeTextId);

            }
        }
    }


}
