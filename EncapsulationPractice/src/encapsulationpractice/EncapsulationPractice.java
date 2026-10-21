/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

package encapsulationpractice;
import java.util.Scanner;
import java.text.DecimalFormat;


/**
 *
 * @author acena2028
 */
public class EncapsulationPractice {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        // instantiate new Scanner object
        Scanner scan = new Scanner(System.in);
        
        // instantiate new DecimalFormat object
        DecimalFormat moneyFormat = new DecimalFormat("$#,###.00");
        
        // ask User for a financial amount
        System.out.print("Please input amount of money to repay: $");
        double money = scan.nextDouble();
        // ask User for the number of months for repayment
        System.out.print("Please input number of months for repayment: ");
        int time = scan.nextInt();
        System.out.print("\n");
        
        // instantiate InterestRateCalculator object, with principal = money and months = time
        InterestRateCalculator monthly = new InterestRateCalculator();
        double monthlyVar = monthly.acceptConditions(money, time);
        // output monthly payment amount and total amount repaid
        System.out.println("Monthly payment amount with interest: " + moneyFormat.format(monthlyVar));
        System.out.println("Total amount repaid: " + moneyFormat.format(monthlyVar * time));
    }
    
}

class InterestRateCalculator {
    // declare constants
    public static final double RATE = 0.1;
    // declare variables
    private double principal;
    private int months;
    private double noInterest;
    private double withInterest;
    
    // Constructor: create default states for the new object
    public InterestRateCalculator() {
        principal = 100.00;
        months = 5;
        noInterest = 20.00;
        withInterest = 22.00;
    }
    
    // Mutator: object accepts the principal and months inputted by User
    // uses private method calculateRepayment to return the monthly payment amount with interest
    public double acceptConditions (double principalParam, int monthsParam) {
        principal = principalParam;
        months = monthsParam;
        return calculateRepayment(principal, months);
        
    }
    
    // private method to divide total principal by number of months and apply interest rate
    private double calculateRepayment(double principalCalc, int monthsCalc) {
        noInterest = (principalCalc / monthsCalc);
        withInterest = noInterest * (1 + RATE);
        return withInterest;
    }
    
}




