package c.hayeon.seproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import c.hayeon.seproject.adapter.DateAdapter;
import c.hayeon.seproject.model.Date;
import c.hayeon.seproject.model.Time;

public class BookingActivity extends AppCompatActivity {

    private RecyclerView mTimeDateRv;
    private DateAdapter mDateAdapter;
    private List<Date> mDates;
    Toolbar menubar;

    Button timeBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        menubar = findViewById(R.id.menuBar);
        setSupportActionBar(menubar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mTimeDateRv = findViewById(R.id.timeDateRv);
       getDates();
        mDateAdapter = new DateAdapter(mDates, this);
        mTimeDateRv.setLayoutManager(new LinearLayoutManager(BookingActivity.this));
        mTimeDateRv.setAdapter(mDateAdapter);


    }

    public void getDates() {
        mDates = new ArrayList<>();
        List<Time> times = new ArrayList<>();
        times.add(new Time("9", "00"));
        times.add(new Time("9", "30"));
        times.add(new Time("10", "00"));
        times.add(new Time("10", "30"));
        times.add(new Time("11", "00"));
        mDates.add(new Date("11/10/2018", times));
        mDates.add(new Date("12/10/2018", times));
        mDates.add(new Date("13/10/2018", times));
        mDates.add(new Date("14/10/2018", times));
        mDates.add(new Date("15/10/2018", times));
        mDates.add(new Date("16/10/2018", times));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
}
