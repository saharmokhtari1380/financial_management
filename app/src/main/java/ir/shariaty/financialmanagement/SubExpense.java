package ir.shariaty.financialmanagement;

public class SubExpense {

    public SubExpense() {
        this.expensePrice = expensePrice;
        this.expenseCategory = expenseCategory;
        this.expenseDate = expenseDate;
        this.expenseDetails = expenseDetails;
    }

    private String expensePrice;
    private String expenseCategory;

    public String getExpensePrice() {
        return expensePrice;
    }

    public void setExpensePrice(String expensePrice) {
        this.expensePrice = expensePrice;
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public String getExpenseDate() {
        return expenseDate;
    }

    public void setExpenseDate(String expenseDate) {
        this.expenseDate = expenseDate;
    }

    public String getExpenseDetails() {
        return expenseDetails;
    }

    public void setExpenseDetails(String expenseDetails) {
        this.expenseDetails = expenseDetails;
    }

    private String expenseDate;
    private String expenseDetails;



}
