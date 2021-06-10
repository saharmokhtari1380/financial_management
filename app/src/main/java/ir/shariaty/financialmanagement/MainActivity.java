package ir.shariaty.financialmanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText PersonName , Password;
    Button loginbtn , signUpbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PersonName=findViewById(R.id.fullName);
        Password=findViewById(R.id.Email);
            loginbtn=findViewById(R.id.createbtn);
            signUpbtn=findViewById(R.id.signUpbtn);

            signUpbtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainActivity.this,create_an_account.class));
                }
            });

    }
}