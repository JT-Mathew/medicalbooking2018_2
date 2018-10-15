package c.hayeon.seproject;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import c.hayeon.seproject.model.User;

public class DetailActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference myRef = database.getReference();

    EditText nameEt;
    EditText idEt;
    EditText dobEt;
    EditText emailEt;
    EditText add1Et;
    EditText add2Et;
    EditText noEt;
    EditText favDocEt;
    Button updateBtn;
    ImageView add1Btn;
    ImageView add2Btn;
    ImageView noBtn;
    ImageView favDocBtn;
    Toolbar menubar;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nameEt = findViewById(R.id.nameEt);
        idEt = findViewById(R.id.idEt);
        dobEt = findViewById(R.id.dobEt);
        emailEt = findViewById(R.id.emailEt);
        add1Et = findViewById(R.id.add1Et);
        add2Et = findViewById(R.id.add2Et);
        noEt = findViewById(R.id.noEt);
        favDocEt = findViewById(R.id.favDocEt);
        updateBtn = findViewById(R.id.updateBtn);
        add1Btn = findViewById(R.id.add1EditBtn);
        add2Btn = findViewById(R.id.add2EditBtn);
        noBtn = findViewById(R.id.contactNoEditBtn);
        favDocBtn = findViewById(R.id.favDocEditBtn);

        user = (User) getIntent().getExtras().getSerializable("user");

        final User test = new User(user.getFirstName(), user.getLastName(), user.getStudentId(),
                user.getPassword(), user.getAddress1(),
                user.getAddress2(), user.getMobile(), user.getEmail(), user.getDob());


//        String name = user.getFirstName() + " " + user.getLastName();
//        String add1 = user.getAddress1();
//        String add2 = user.getAddress2();
//        String studentId = user.getStudentId();
//        String mobile = user.getMobile();
//        String email = user.getEmail();
//        String dob = user.getDob();
        nameEt.setText(user.getFirstName() + " " + user.getLastName());
        idEt.setText(user.getStudentId());
        add1Et.setText(user.getAddress1());
        add2Et.setText(user.getAddress2());
        noEt.setText(user.getMobile());
        emailEt.setText(user.getEmail());
        dobEt.setText(user.getDob());

        //menubar related
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

        nameEt.setEnabled(false);
        idEt.setEnabled(false);
        emailEt.setEnabled(false);
        dobEt.setEnabled(false);
        add1Et.setEnabled(false);
        add2Et.setEnabled(false);
        noEt.setEnabled(false);
        favDocEt.setEnabled(false);

        updateBtn.setEnabled(false);


        add1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add1Et.setEnabled(true);


                test.setAddress1(add1Et.getText().toString());
                updateBtn.setEnabled(true);
            }
        });
        add2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add2Et.setEnabled(true);
                test.setAddress2(add2Et.getText().toString());
                updateBtn.setEnabled(true);
            }
        });
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noEt.setEnabled(true);
                updateBtn.setEnabled(true);
            }
        });
        favDocBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                favDocEt.setEnabled(true);
                updateBtn.setEnabled(true);
            }
        });
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //update it on database
                test.setAddress1(add1Et.getText().toString());
                test.setAddress2(add2Et.getText().toString());
                test.setMobile(noEt.getText().toString());
                myRef.child("User").child(user.getStudentId()).setValue(test);

                add1Et.setEnabled(false);
                add2Et.setEnabled(false);
                noEt.setEnabled(false);
                favDocEt.setEnabled(false);
                updateBtn.setEnabled(false);
            }
        });
    }

    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
//d

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