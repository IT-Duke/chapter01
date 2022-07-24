package HanShunPing.Genericity.Exercise;
//对于泛型的练习
import java.util.ArrayList;
import java.util.Comparator;

/**
 * @author 刘伟杰
 */
@SuppressWarnings({"all"})
public class Object01 {
    public static void main(String[] args) {
        //创建ArrayList集合
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee("ban",10000,new MyDate(2001,10,11)));
        employees.add(new Employee("ban",50000,new MyDate(2001,10,21)));
        employees.add(new Employee("yan",20000,new MyDate(2000,10,13)));
        System.out.println("employees="+employees);
        System.out.println("=====员工排序=====");
        //使用ArrayList的定制排序
        employees.sort(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //先判断o1和o2是不是Employee类型，不是则返回
                if (!(o1 instanceof Employee && o2 instanceof Employee)){
                    System.out.println("类型不正确");
                    return 0;
                }
                //先根据姓名排序
                int i = o1.getName().compareTo(o2.getName());
                if (i!=0){
                    return i;
                }
                //若姓名相同，则直接比较日期，因为MyDate中重写了compareTo方法，在这里直接比较即可
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        });
        System.out.println(employees);
    }
}
