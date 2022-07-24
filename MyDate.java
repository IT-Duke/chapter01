package HanShunPing.Genericity.Exercise;

/**
 * @author 刘伟杰
 */
//MyDate类继承Comparable接口   并进行泛型规定为MyDate
public class MyDate implements Comparable<MyDate> {
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
   //重写comparable接口中的compareTo方法来判断日期
    //MyDate o是调用方法比较时传入的形参
    @Override
    public int compareTo(MyDate o) {
         //先判断年大小
        int yearMinus = year-o.getYear();
        if (yearMinus!=0){
            return yearMinus;
        }
        //再判断月大小
        int monthMinus = month - o.getMonth();
        if (monthMinus!=0){
            return monthMinus;
        }
        //年月相等，直接返回日
        return day-o.getDay();
    }
}
