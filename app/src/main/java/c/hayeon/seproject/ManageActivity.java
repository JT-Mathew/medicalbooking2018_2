package c.hayeon.seproject;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import c.hayeon.seproject.adapter.AppointmentAdapter;
import c.hayeon.seproject.model.Appointment;
import c.hayeon.seproject.model.User;


public class ManageActivity extends AppCompatActivity {
    Toolbar menubar;
    User user;

    private RecyclerView mAppointmentRv;
    private AppointmentAdapter mAppointmentViewHolderAdapter;
    private List<Appointment> mAppointments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        menubar = findViewById(R.id.menuBar);
        setSupportActionBar(menubar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        menubar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_goback));
        menubar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();//What to do on back clicked
            }
        });

        mAppointmentRv = findViewById(R.id.bookingListRv);
        mAppointments.add(new Appointment("10/11/2018", "10:30", "Jane Doe" ));
        mAppointments.add(new Appointment("12/11/2018", "19:00", "Third Doe" ));

        mAppointmentViewHolderAdapter = new AppointmentAdapter(mAppointments);

        mAppointmentRv.setLayoutManager(new LinearLayoutManager(this));
        mAppointmentRv.setAdapter(mAppointmentViewHolderAdapter);
    }

    private void getAppointment(){
        //database pull made appointment

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_logout:
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
