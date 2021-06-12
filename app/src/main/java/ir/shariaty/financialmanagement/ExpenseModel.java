package ir.shariaty.financialmanagement;

public class ExpenseModel {
    private String expenseId;
    private String expenseName;
    private String expenseImage;
    private String expenseCategory;


    public String getExpenseCategory() {
        return expenseCategory;
    }

    public ExpenseModel(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }



    public ExpenseModel(String expenseId, String expenseName, String expenseImage, String expenseCategory ) {
        this.expenseId = expenseId;
        this.expenseName = expenseName;
        this.expenseImage = expenseImage;
        this.expenseCategory=expenseCategory;
    }

    public ExpenseModel (){
        //TODO
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getExpenseImage() {
        return expenseImage;
    }

    public void setExpenseImage(String expenseImage) {
        this.expenseImage = expenseImage;
    }



}
