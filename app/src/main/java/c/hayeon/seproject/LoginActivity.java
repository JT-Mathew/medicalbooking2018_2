package c.hayeon.seproject;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import c.hayeon.seproject.model.User;


public class LoginActivity extends AppCompatActivity {

    EditText idEt;
    EditText passwordEt;
    Button loginBtn;
    Button exitBtn;
    User test;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idEt = findViewById(R.id.idEt);
        passwordEt = findViewById(R.id.passwordEt);
        loginBtn = findViewById(R.id.loginBtn);
        exitBtn = findViewById(R.id.exitBtn);

        test = new User("Hayeon", "Kim", "1",
                "1", "1", "abc road",
                "ABC", 1111);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(idEt.getText().toString().equals(test.getStudentId()) &&
                        passwordEt.getText().toString().equals(test.getPassword())) {

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("user", test);
                    startActivityForResult(intent, 0);
                }else{
                    Toast.makeText(getApplicationContext(), "Wrong Credential",Toast.LENGTH_SHORT).show();
                }
            }
        });

        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}