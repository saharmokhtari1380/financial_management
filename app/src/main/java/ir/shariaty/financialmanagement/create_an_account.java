package ir.shariaty.financialmanagement;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
//  import org.jetbrains.annotations.NotNull;

public class create_an_account extends AppCompatActivity {

    FirebaseFirestore database;
    FirebaseAuth auth;

    EditText fullName,Email,password,Refer;
    Button createbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_an_account);
            database=FirebaseFirestore.getInstance();
        auth=FirebaseAuth.getInstance();

        fullName=findViewById(R.id.emailbox);
        Email=findViewById(R.id.passwordbox);
        password=findViewById(R.id.password);
        Refer=findViewById(R.id.Refer);

        createbtn=findViewById(R.id.createbtn);
        createbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email , pass, name , refer;
                email= Email.getText().toString();
                pass=password.getText().toString();
                name=fullName.getText().toString();
                refer=Refer.getText().toString();

                User user=new User();
                user.setEmail(email);
                user.setName(name);
                user.setPass(pass);
                user.setRefer(refer);

                auth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            database.collection("Users").document() .set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    startActivity(new Intent(create_an_account.this, Home_Page.class));

                                }
                            });
                            Toast.makeText(create_an_account.this,"your account is created",Toast.LENGTH_SHORT).show();

                        }
                        else {
                            Toast.makeText(create_an_account.this,task.getException().getLocalizedMessage(),Toast.LENGTH_SHORT).show();
                        }
                    }

                });
            }
        });
    }
}