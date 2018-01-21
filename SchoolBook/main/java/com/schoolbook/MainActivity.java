package com.schoolbook;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuInflater;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.schoolbook.DAO.SchoolsDB;
import com.schoolbook.Model.School;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    NavigationView navigationView=null;
    Toolbar toolbar=null;
    public static SchoolsDB mySchoolsDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        mySchoolsDB=new SchoolsDB(this,null,null,1);
        if(!prefs.contains("insertedInDB")){
            // insert in DB
            mySchoolsDB.addSchool(new School("Froebels School F-11 Campus","F-11, Islamabad",20000,33.679566,72.995959,"1:20","Froebel's International School is committed to providing: A stimulating and comprehensive programme of studies through which students are inspired to achieve their greatest potential and adapt to a diverse and ever-changing society.",4,1));
            mySchoolsDB.addSchool(new School("Beaconhouse School F-11 Campus","F-11, Islamabad",15000,33.679956,72.998575,"1:30","The Beaconhouse School System has risen from its modest beginnings in 1975 as Les Anges Montessori Academy to become a major force in the education world. With an ever-expanding base, already established in the UK, Malaysia, the Philippines, Pakistan, the UAE, Oman, Belgium and Thailand",4.1,2));
            mySchoolsDB.addSchool(new School("NUST Creative Learning School","H-12, Islamabad",12500,33.648500,72.999559,"1:15","NUST has started NUST Creative Learning School in a beautiful campus \u200B\u200Bwith modern facilities where we are offering full day school with two lunch breaks/nap time and home work on campus. It's a five-day full working school with a facility of Day-care till class 3 at the moment.",4.2,3));
            mySchoolsDB.addSchool(new School("SLS School G-11 Branch","G-11, Islamabad",10000,33.667728,73.006221,"1:20","Tolerance is the positive and cordial effort to understand another's beliefs, practices, and habits without necessarily sharing or accepting them. Joshua Liebman. SLS Montessori & School G-11 Islamabad",2.1,4));
            mySchoolsDB.addSchool(new School("Pak Turk School","H-8, Islamabad",15000,33.691292,73.006221,"1:30","We are committed to our noble task and will continue to strive for imparting quality education to the coming generations of our great country in future also.",4.2,5));
            mySchoolsDB.addSchool(new School("Beaconhouse Margalla Campus","H-8, Islamabad",30000,33.681814,73.065765,"1:20","Froebel's International School is committed to providing: A stimulating and comprehensive programme of studies through which students are inspired to achieve their greatest potential and adapt to a diverse and ever-changing society.",3,6));
            mySchoolsDB.addSchool(new School("LGS H-8 Branch","H-8, Islamabad",30000,33.679017,73.061413,"1:30","LGS-H8",4.5,7));
            mySchoolsDB.addSchool(new School("Headstart School"," Najib Murtaza Road, Off Park Rd, Near CDA Park Enclave، Islamabad 44000",15000,33.711957,73.055801,"1:20","Headstart School",4,8));
            mySchoolsDB.addSchool(new School("Convent School","H-8, Islamabad",15000,33.681703,73.071085,"1:20","Convent School",2.5,9));
            mySchoolsDB.addSchool(new School("City School","Islamabad",20000,33.689210,72.985564,"1:30","City School",2.3,10));
            mySchoolsDB.addSchool(new School("City School Campus","Islamabad",15000,33.704080,72.976598,"1:20","City School Campus",3.3,11));
            mySchoolsDB.addSchool(new School("Smart School","Islamabad",15000,33.687612,73.031500,"1:20","Smart School",4,12));
            mySchoolsDB.addSchool(new School("Imperial School and College","Islamabad",15000,33.700251,73.007041,"1:20","Imperial School and College",3.3,13));
            // create key in prefs
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("insertedInDB", true);
            editor.commit();
        }else{

        }

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        HomeFragment fragment=new HomeFragment();
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_container,fragment);
        fragmentTransaction.commit();


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else if(!drawer.isDrawerOpen(GravityCompat.START)){
            drawer.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);

//        SearchManager searchManager =
//                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView =
//                (SearchView) menu.findItem(R.id.search).getActionView();
//        searchView.setSearchableInfo(
//                searchManager.getSearchableInfo(getComponentName()));

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
        if (id == R.id.homescreen) {
            HomeFragment fragment=new HomeFragment();
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container,fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.top_schools) {
            TopSchoolsFragment fragment=new TopSchoolsFragment();
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container,fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.schools_by_fee) {
            SchoolsByFeeFragment fragment=new SchoolsByFeeFragment();
            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.main_container,fragment);
            fragmentTransaction.commit();
        } else if (id == R.id.nearby_schools) {
            Intent intent=new Intent(this, MapsActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
