package ir.shariaty.financialmanagement;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

import ir.shariaty.financialmanagement.databinding.ActivityMainBinding;

//import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    FirebaseFirestore database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

//        setSupportActionBar(binding.toolbarname);

        database=FirebaseFirestore.getInstance();


        ArrayList<ExpenseModel> expenses = new ArrayList<>();
//
        ExpenseAdaptor adaptor = new ExpenseAdaptor(this,expenses);

        database.collection("expenses").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable  QuerySnapshot value, @Nullable  FirebaseFirestoreException error) {

                expenses.clear();
                for (DocumentSnapshot snapshot:value.getDocuments()){
                    ExpenseModel model = snapshot.toObject(ExpenseModel.class);
                    model.setExpenseId(snapshot.getId());
                    expenses.add(model);
                }
                    adaptor.notifyDataSetChanged();
            }
        });

        binding.ExpenseList.setLayoutManager(new GridLayoutManager(this,1));
        binding.ExpenseList.setAdapter(adaptor);



    }
}