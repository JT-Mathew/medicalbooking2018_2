package c.hayeon.seproject;

import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

import java.util.List;

import c.hayeon.seproject.adapter.AppointmentAdapter;
import c.hayeon.seproject.model.Appointment;
import c.hayeon.seproject.model.User;
import c.hayeon.seproject.viewholder.AppointmentViewHolder;


public class ManageActivity extends AppCompatActivity {
    Toolbar menubar;
    User user;

    private RecyclerView mAppointmentRv;
    private RecyclerView.Adapter<AppointmentViewHolder> mAppointmentViewHolderAdapter;
    private List<Appointment> mAppointments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);

        menubar = findViewById(R.id.menuBar);
        setSupportActionBar(menubar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mAppointmentRv = findViewById(R.id.bookingListRv);

        if(user.getCurrentAppointments().size() == 0){
            Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
            intent.putExtra("user", user);
            startActivityForResult(intent, 0);

        }
        mAppointmentViewHolderAdapter = new AppointmentAdapter(user.getCurrentAppointments());

        mAppointmentRv.setLayoutManager(new LinearLayoutManager(ManageActivity.this));
        mAppointmentRv.setAdapter(mAppointmentViewHolderAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
}
