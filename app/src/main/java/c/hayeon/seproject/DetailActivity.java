package c.hayeon.seproject;


import android.app.Activity;
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

import c.hayeon.seproject.model.User;

public class DetailActivity extends AppCompatActivity {

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

        String name = user.getFirstName() + " " + user.getLastName();
        String add1 = user.getRoadNumber() + " " + user.getStreetName();
        String add2 = user.getSuburbName() + " " + user.getPostcode();
        nameEt.setText(name);
        idEt.setText(user.getStudentId());
        add1Et.setText(add1);
        add2Et.setText(add2);

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
                updateBtn.setEnabled(true);
            }
        });
        add2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add2Et.setEnabled(true);
                updateBtn.setEnabled(true);
            }
        });
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                noBtn.setEnabled(true);
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