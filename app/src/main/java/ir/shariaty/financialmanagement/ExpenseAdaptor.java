package ir.shariaty.financialmanagement;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ExpenseAdaptor  extends RecyclerView.Adapter <ExpenseAdaptor.expenseViewHolder>{
    Context context;
    ArrayList<ExpenseModel> ExpenseModels;
    public ExpenseAdaptor(Context context, ArrayList<ExpenseModel> ExpenseModels){
        this.context=context;
        this.ExpenseModels=ExpenseModels;
    }
    @NonNull
    @Override
    public expenseViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.item_expense,null);

        return new expenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  ExpenseAdaptor.expenseViewHolder holder, int position) {

        ExpenseModel model=ExpenseModels.get(position);

        holder.textView2.setText(model.getExpenseName());
        holder.textView.setText(model.getExpenseCategory());
//        Glide.with(context)
//                .load(model.getExpenseImage())
//                .into(holder.imageView);
        //TODO
    }

    @Override
    public int getItemCount() {
        return ExpenseModels.size();
    }

    public class expenseViewHolder extends RecyclerView.ViewHolder {
//        ImageView imageView;
        TextView textView,textView2;
        public expenseViewHolder(@NonNull  View itemView) {
            super(itemView);
//            imageView= itemView.findViewById(R.id.image);
            textView=itemView.findViewById(R.id.txtcat);
            textView2=itemView.findViewById(R.id.txtprice);
        }
    }
}

