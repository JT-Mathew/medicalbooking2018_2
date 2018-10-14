package c.hayeon.seproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference myRef = database.getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage);
        user = (User) getIntent().getExtras().getSerializable("user");

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
        //mAppointments.add(new Appointment("10/11/2018", "10:30", "Jane Doe" ));
        //mAppointments.add(new Appointment("12/11/2018", "19:00", "Third Doe" ));
        getAppointment(user.studentId);
        mAppointmentRv.setLayoutManager(new LinearLayoutManager(this));

    }

    private void getAppointment(String userID){
        //database pull made appointment
        final String myuserID = userID;
        //   mAppointments.add(new Appointment("10/11/2018", "10:30", "Jane Doe" ));

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                long Num = dataSnapshot.child("User").child(myuserID).child("currentAppointments").getChildrenCount();
                String s_num = String.valueOf(Num+1);
                for(int i=1;i<=Num;i++){
                    s_num = String.valueOf(i);
                    Appointment myAppointment = dataSnapshot.child("User").child(myuserID).child("currentAppointments").child(s_num).getValue(Appointment.class);
                    mAppointments.add(myAppointment);
                    //    mAppointments.add(new Appointment("10/11/2018", "10:30", "Jane Doe" ));
                    //Toast.makeText(ManageActivity.this, "Work", Toast.LENGTH_SHORT).show();
                    mAppointmentViewHolderAdapter = new AppointmentAdapter(mAppointments);


                    mAppointmentRv.setAdapter(mAppointmentViewHolderAdapter);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



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
                GoToActivityAsNewTask(this, LoginActivity.class);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    public static void GoToActivityAsNewTask(Activity context, Class<?> clazz) {
        Intent intent = new Intent(context, clazz);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(intent);
        context.finish();

    }
}