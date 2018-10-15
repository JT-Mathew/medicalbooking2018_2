

package c.hayeon.seproject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.Query;


import c.hayeon.seproject.model.Appointment;
import c.hayeon.seproject.model.User;


public class ManageActivity extends AppCompatActivity {
    Toolbar menubar;
    User user;

    ProgressDialog pd;
    private RecyclerView mAppointmentRv;

    DatabaseReference myRef;
    private FirebaseRecyclerAdapter<Appointment, ManageActivity.AppointmentViewHolder> appointmentAdapter;

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
        mAppointmentRv.setLayoutManager(new LinearLayoutManager(this));

        final String myuserID = user.getStudentId();

        myRef = FirebaseDatabase.getInstance().getReference().child("User").child(myuserID).child("currentAppointments");
        myRef.keepSynced(true);


        final DatabaseReference appRef = FirebaseDatabase.getInstance().getReference().child("Doctor");
        final DatabaseReference appointmentRef = FirebaseDatabase.getInstance().getReference().child("User").child(myuserID).child("currentAppointments");
        Query appointmentQuery = appointmentRef.orderByKey();

        FirebaseRecyclerOptions appointmentOptions = new FirebaseRecyclerOptions.Builder<Appointment>().setQuery(appointmentQuery, Appointment.class).build();
        appointmentAdapter = new FirebaseRecyclerAdapter<Appointment, ManageActivity.AppointmentViewHolder>(appointmentOptions) {

            @NonNull
            @Override
            public ManageActivity.AppointmentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.appointment_list, parent, false);

                return new AppointmentViewHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull AppointmentViewHolder holder, int position, @NonNull Appointment model) {
                holder.setDate(model.getDate());
                holder.setDoc(model.getDoc());
                holder.setTime(model.getTime());
                final String t = model.getId();
                final String doc = model.getDoc();
                final String date = model.getDate();
                final String time = model.getTime();
                holder.mDeleteBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        appRef.child(doc).child(date).child(time).setValue("Available");
                        myRef.child(t).removeValue();

                    }
                });
            }
        };
        mAppointmentRv.setAdapter(appointmentAdapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        appointmentAdapter.startListening();
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

    public static class AppointmentViewHolder extends RecyclerView.ViewHolder {
        View mView;
        Button mDeleteBtn;

        public AppointmentViewHolder(View itemView) {
            super(itemView);
            mView = itemView;
            mDeleteBtn = itemView.findViewById(R.id.deleteAppBtn);
        }

        public void setDate(String date) {
            TextView dateTv = mView.findViewById(R.id.dateTv);
            dateTv.setText(date);
        }

        public void setTime(String time) {
            TextView timeTv = mView.findViewById(R.id.timeTv);
            timeTv.setText(time);
        }

        public void setDoc(String doc) {
            TextView docTv = mView.findViewById(R.id.doctorTv);
            docTv.setText(doc);
        }


    }
}