package c.hayeon.seproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import c.hayeon.seproject.model.AddAppiontDetail;
//import c.hayeon.seproject.model.Appointment;
//import c.hayeon.seproject.model.Doctor;
import c.hayeon.seproject.model.User;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();

    DatabaseReference myRef = database.getReference();


    EditText idEt;
    EditText passwordEt;
    Button loginBtn;
    Button exitBtn;
    User test;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idEt = findViewById(R.id.idEt);
        passwordEt = findViewById(R.id.passwordEt);
        loginBtn = findViewById(R.id.loginBtn);
        exitBtn = findViewById(R.id.exitBtn);

        test = new User("", "", "",
                "", "",
                "", "", "", "");

//        myRef.child("User").child(test.studentId).setValue(test);


        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                search(idEt.getText().toString(),passwordEt.getText().toString());
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private User getUser(){

        //database
        return null;
    }

    private void search(final String id, String password) {
        final String myID = id;
        final String myPassword = password;
        pd = new ProgressDialog(this);
        pd.setMessage("Verifying Credentials... ");
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show();
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User myUser = dataSnapshot.child("User").child(myID).getValue(User.class);
                try {
                    Toast.makeText(LoginActivity.this, myUser.password, Toast.LENGTH_SHORT).show();

                    if(myUser.password.equals(myPassword)){
                        pd.dismiss();
                        Toast.makeText(LoginActivity.this, "Log in successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        test.setFirstName(myUser.getFirstName());
                        test.setLastName(myUser.getLastName());
                        test.setAddress1(myUser.getAddress1());
                        test.setAddress2(myUser.getAddress2());
                        test.setStudentId(myUser.getStudentId());
                        test.setMobile(myUser.getMobile());
                        test.setEmail(myUser.getEmail());
                        test.setDob(myUser.getDob());
                        test.setPassword(myUser.getPassword());
                        intent.putExtra("user", test);
                        startActivityForResult(intent, 0);
                    }else{
                        pd.dismiss();
                        Toast.makeText(LoginActivity.this, "Wrong credentials. Please try again!", Toast.LENGTH_SHORT).show();
                    }

                } catch (NullPointerException e) {
                    pd.dismiss();
                    Toast.makeText(LoginActivity.this, "Sorry, No current user is available", Toast.LENGTH_SHORT).show();
                }

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}