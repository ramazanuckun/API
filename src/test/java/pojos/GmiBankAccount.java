package pojos;

public class GmiBankAccount
{
    private Integer id;
    private String description;
    private Integer balance;
    private String accountType;
    private  String accountStatusType;
    private  String createDate;

    public GmiBankAccount() {
    }

    private  String closedDate;
    private String employee;
    private String accountlogs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "GmiBankAccount{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", balance=" + balance +
                ", accountType='" + accountType + '\'' +
                ", accountStatusType='" + accountStatusType + '\'' +
                ", createDate='" + createDate + '\'' +
                ", closedDate='" + closedDate + '\'' +
                ", employee='" + employee + '\'' +
                ", accountlogs='" + accountlogs + '\'' +
                '}';
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountStatusType() {
        return accountStatusType;
    }

    public void setAccountStatusType(String accountStatusType) {
        this.accountStatusType = accountStatusType;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getClosedDate() {
        return closedDate;
    }

    public void setClosedDate(String closedDate) {
        this.closedDate = closedDate;
    }

    public String getEmployee() {
        return employee;
    }

    public void setEmployee(String employee) {
        this.employee = employee;
    }

    public String getAccountlogs() {
        return accountlogs;
    }

    public void setAccountlogs(String accountlogs) {
        this.accountlogs = accountlogs;
    }

    public GmiBankAccount(Integer id, String description, Integer balance, String accountType, String accountStatusType, String createDate, String closedDate, String employee, String accountlogs) {
        this.id = id;
        this.description = description;
        this.balance = balance;
        this.accountType = accountType;
        this.accountStatusType = accountStatusType;
        this.createDate = createDate;
        this.closedDate = closedDate;
        this.employee = employee;
        this.accountlogs = accountlogs;
    }
}
