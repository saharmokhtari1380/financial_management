package ir.shariaty.financialmanagement;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class loginPage extends AppCompatActivity {
    FirebaseAuth auth;
    EditText emaibox , passwordbox;
    Button loginbtn , signUpbtn;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        dialog=new ProgressDialog(this);
        dialog.setMessage("please wait ...");
        auth= FirebaseAuth.getInstance();

        emaibox=findViewById(R.id.emailbox);
        passwordbox=findViewById(R.id.passwordbox);
        loginbtn=findViewById(R.id.createbtn);
        signUpbtn=findViewById(R.id.signUpbtn);

        if (auth.getCurrentUser()!=null){
            startActivity(new Intent(loginPage.this,Home_Page.class));
            finish();
        }

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                String email, pass;
                email = emaibox.getText().toString();
                pass= passwordbox.getText().toString();
                auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            dialog.dismiss();
                            startActivity(new Intent(loginPage.this,Home_Page.class));
                            finish();

                        }
                        else {
                            Toast.makeText(loginPage.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });

        signUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginPage.this,create_an_account.class));
            }
        });
    }
}
