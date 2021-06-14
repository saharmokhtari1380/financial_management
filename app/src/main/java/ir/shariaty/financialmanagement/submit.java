package ir.shariaty.financialmanagement;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class submit extends AppCompatActivity {
    EditText txtprice,txtcategory,txtdate,txtdetails;
    Button exbtn,salarybtn;

    FirebaseFirestore database;
    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);
        txtprice=findViewById(R.id.price);
        txtcategory=findViewById(R.id.category);
        txtdate=findViewById(R.id.date);
        txtdetails=findViewById(R.id.details);
        exbtn=findViewById(R.id.exsubbtn);
        salarybtn=findViewById(R.id.salarysubbtn);

        database=FirebaseFirestore.getInstance();

        SubExpense subExpense;


        exbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String price=txtprice.getText().toString();
                String category=txtcategory.getText().toString();
                String date=txtdate.getText().toString();
                String details=txtdetails.getText().toString();

                final
                SubExpense subExpense=new SubExpense();
                subExpense.setExpensePrice(price);
                subExpense.setExpenseCategory(category);
                subExpense.setExpenseDate(date);
                subExpense.setExpenseDetails(details);
                database.collection("expenses");



            }
        });
    }





}