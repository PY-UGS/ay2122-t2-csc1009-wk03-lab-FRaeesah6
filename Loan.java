import java.text.DecimalFormat;
import java.util.Date;
import java.util.Scanner;

public class Loan {

    private static final DecimalFormat df = new DecimalFormat("0.00");
    private double annualInterestRate = 2.5;
    private int numberOfYears = 1;
    private double loanAmount = 100;
    private Date loanDate = new Date();

    public Loan() {
        //this.loanDate = new Date();
    }

    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.loanAmount = loanAmount;
        //this.loanDate = new Date();
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumberOfYears() {
        return numberOfYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public Date getLoanDate() {
        return loanDate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfYears(int numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public double getMonthlyPayment(){
        double monthlyPayment = (this.loanAmount * (this.annualInterestRate /100 / 12)) / (1 - (1 / Math.pow((1 + (this.annualInterestRate / 100 / 12)), (this.numberOfYears * 12))));
        return monthlyPayment;
    }

    public double getTotalPayment(){
        double totalPayment;
        totalPayment = this.getMonthlyPayment() * numberOfYears * 12;
        return totalPayment;
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter annual interest rate, for example, 8.25: ");
        double annualInterestRate = sc.nextDouble();
        System.out.println("Enter number of years as an integer: ");
        int numberOfYears = sc.nextInt();
        System.out.println("Enter loan amount, for example, 120000.95: ");
        double loanAmount = sc.nextDouble();

        Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);
        System.out.println("The loan was created on " + loan.getLoanDate().toString());
        System.out.println("The monthly payment is " + df.format(loan.getMonthlyPayment()));
        System.out.println("The total payment is " + df.format(loan.getTotalPayment()));
    }


}
