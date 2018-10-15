package c.hayeon.seproject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import c.hayeon.seproject.adapter.DateAdapter;
import c.hayeon.seproject.model.Appointment;
import c.hayeon.seproject.model.Date;
import c.hayeon.seproject.model.Time;
import c.hayeon.seproject.model.User;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class BookingActivity extends AppCompatActivity {

    private RecyclerView mTimeDateRv;
    private DateAdapter mDateAdapter;
    private List<Date> mDates;
    Toolbar menubar;
    User user;
    Appointment appointment;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference myRef = database.getReference();
    int uniqueId = 0;

    Button bookBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);


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

        bookBtn = findViewById(R.id.bookBtn);

        mTimeDateRv = findViewById(R.id.timeDateRv);
        getDates();
        appointment = new Appointment();
        mDateAdapter = new DateAdapter(mDates, this, appointment);
        mTimeDateRv.setLayoutManager(new LinearLayoutManager(BookingActivity.this));
        mTimeDateRv.setAdapter(mDateAdapter);

        user = (User) getIntent().getExtras().getSerializable("user");

        bookBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Appointment curAppointment = new Appointment(appointment.getDate(), appointment.getTime(), appointment.getDoc());
                UpdateAppointmentNum(user.studentId, curAppointment);

                finish();
            }

            ;
        });
    }

    public void getDates() {
        //dates
        mDates = new ArrayList<Date>();
        List<Time> times = new ArrayList<Time>();
        times.add(new Time("9", "00"));
        times.add(new Time("9", "30"));
        times.add(new Time("10", "00"));
        times.add(new Time("10", "30"));
        times.add(new Time("11", "00"));
        times.add(new Time("11", "30"));
        times.add(new Time("12", "00"));
        times.add(new Time("12", "30"));
        times.add(new Time("13", "00"));
        times.add(new Time("13", "30"));
        times.add(new Time("14", "00"));
        times.add(new Time("14", "30"));
        times.add(new Time("15", "00"));
        times.add(new Time("15", "30"));
        times.add(new Time("16", "00"));
        times.add(new Time("16", "30"));


        mDates.add(new Date("2018/10/17", times));
        mDates.add(new Date("2018/10/18", times));
        mDates.add(new Date("2018/10/19", times));
        mDates.add(new Date("2018/10/20", times));
        mDates.add(new Date("2018/10/21", times));
        mDates.add(new Date("2018/10/22", times));

//        setNewDoctorInformation(times,mDates);

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

    private void UpdateAppointmentNum(String userID, Appointment curAppointment) {

        final String myuserID = userID;
        final Appointment myAppointment = curAppointment;

        myRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String x = myAppointment.getId();
                String id = String.valueOf(x);
                myAppointment.setId(id);
                String state = dataSnapshot.child("Doctor").child(myAppointment.getDoc()).child(myAppointment.getDate()).child(myAppointment.getTime()).getValue(String.class);

                if(state.equals("Available")){
                    myRef.child("Appointment").child(user.studentId).child("curAppointment").child(id).setValue(myAppointment);
                    myRef.child("Doctor").child(myAppointment.getDoc()).child(myAppointment.getDate()).child(myAppointment.getTime()).setValue("Unavailable");
                    Toast.makeText(BookingActivity.this, "Booked", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(BookingActivity.this, "Sorry, this is unavailable", Toast.LENGTH_SHORT).show();
                }



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


    private void setNewDoctorInformation(List<Time> times,List<Date> mDates){
        for(int i=0;i<=times.size();i++){
            for(int j=0;j<mDates.size();j++){
                myRef.child("Doctor").child("Leonard Hofdstater").child(mDates.get(j).getDate()).child(times.get(i).getTime()).setValue("Available");
                myRef.child("Doctor").child("Rajesh Kuthrapali").child(mDates.get(j).getDate()).child(times.get(i).getTime()).setValue("Available");
                myRef.child("Doctor").child("Sheldon Cooper").child(mDates.get(j).getDate()).child(times.get(i).getTime()).setValue("Available");
            }
        }
    }


}