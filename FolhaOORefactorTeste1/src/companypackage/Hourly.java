package companypackage;

import calendar.MyCalendar;
import visitor.Visitable;
import visitor.Visitor;

public class Hourly extends Employee implements Visitable{
    private double hourlyRate;
    private int extraHours;

    public Hourly() {
        super();
        constructHourly();
    }
    public Hourly(int change){
        this.hourlyRate = change;
    }

    private void constructHourly(){
        System.out.print("Insert the hourly rate for this employee:\nNumber format: 9999,99\nR$");
        double hourlyRate = exception.returnValidDouble();
        read.nextLine();
        setHourlyRate(hourlyRate);
        super.setPayday("s 01 4");
    }

    public int getExtraHours() {
        return extraHours;
    }

    public void setExtraHours(int extraHours) {
        this.extraHours = extraHours;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public void calculateHours(){
        int hours = getHoursWorked();
        this.extraHours += hours - 8;
        super.calculateHours();
    }

    public boolean isPayday(int dayOfWeek){
        return getPayday().substring(5,6).equalsIgnoreCase(Integer.toString(dayOfWeek));
    }



    @Override
    public String toString() {
        return constructToString();
    }
    private String constructToString(){
        String[] week = new String[]{"Mondays", "Tuesdays", "Wednesdays", "Thursdays", "Fridays", "Saturdays", "Sundays"};
        String str,union, payday;
        payday = "Payday : Weekly paid at ";
        payday += week[ Integer.parseInt( getPayday().substring(5,6) )] + "\n";
        str = "Hourly employee\nName: " + getName() + "\nAddress: " + getAddress() + "\nWay of payment: " + getWayPayment()+ "\nID: " + getId()+ "\nPayday: " + getPayday() + "\nHourly Rate: R$" + getHourlyRate() +"\nHours worked(so far): "+ getHours() +"h"+"\nExtra hours worked: "+ getExtraHours()+ "h\nDays worked: "+ getDaysWorked()+ " days\n";
        str += payday;
//        if(getPartUnion()) {
//            union = "--Union Member--" + "\nUnion Fee: R$" + getUnion().getUnionFee() + " , Service Fee(until now): R$" + getUnion().getServiceFee() + "\nUnion ID: " + getUnion().getUnionId()+ "\n\n";
//        }
//        else
//            union = "--Not union member--\n\n";
//        return str + union;
        return str;
    }


    @Override
    public void accept(Visitor visitor, MyCalendar date) {
        visitor.visit(this, date);
    }
}
