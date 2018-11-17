
                              
import java.util.List;
import java.util.LinkedList;

interface Filter<T>
{
  boolean accept(T y);
}

//自訂過濾器
class myMember implements Filter<Member>{
  public boolean accept(Member z) {
    return (z.firstname.startsWith("A"));
  }

}

class MyFilter implements Filter<Integer> {
    public boolean accept(Integer x) {
      return (x % 2 == 1 && x >= 10 && x <= 60);
    }      
}
class MyFilter2 implements Filter<Integer> {
    public boolean accept(Integer x) {
      return (x % 2 == 0);
    }      
}

//主要的 泛形T
public class FilterTool<T>
{

//  List<Integer> select(Integer x[]) {
//    List<Integer> list = new LinkedList();
//    for(int i = 0; i < x.length; i++) {
//        //if(x[i] > 20 && x[i] % 2 == 0) list.add(x[i]);
//        if(x[i] % 2 != 0) list.add(x[i]);
//    }
//    return list;
//  }
//  List<Integer> select(Integer x[], Filter<Integer> filter) {
//    List<Integer> list = new LinkedList();
//    for(int i = 0; i < x.length; i++) {
//      if(filter.accept(x[i])) list.add(x[i]);
//    }
//    return list;
//  }

    List<T> select(T x[], Filter<T> filter) {
    List<T> list = new LinkedList();
    for(T v : x) {
      if(filter.accept(v)) list.add(v);
    }    
    return list;
  }

//執行開始
  public static void main(String args[]) {
    Integer x[] = { 12, 3, 45, 34, 78, 33, 89,56};
    FilterTool<Integer> tool = new FilterTool<Integer>();

    Member z[] = {
      new Member("Paul", "Lee", 23),
      new Member("Alice", "Wang", 39),
      new Member("Sophia", "Chen", 34),
      new Member("Steph", "Lee", 28),
      new Member("Joyce", "Chang", 21)};
    FilterTool<Member> myTool = new FilterTool<Member>();

    List<Member> myOutputs = myTool.select(z, new myMember());
    System.out.println(myOutputs);

    //直接用filter1 ,2
    List<Integer> outputs = tool.select(x, new MyFilter());
    System.out.println(outputs);
    List<Integer> outputs2 = tool.select(x, new MyFilter2());
    System.out.println(outputs2);

    //寫filter3
    Filter<Integer> filter3 = new Filter<Integer>() {
      public boolean accept(Integer x) {
        return (x % 2 == 0 && x >= 10 && x <= 60);
      }
    };
    List<Integer> outputs3 = tool.select(x, filter3);
    //印出
    System.out.println(outputs3);
//    List<Integer> outputs4 = tool.select(x, x1 -> (x1 % 2 == 0 || x1 % 3 == 0));
//    System.out.println(outputs4);
    
    FilterTool<String> tool2 = new FilterTool<String>();

    String fruits[] = { "grape", "potato", "apple", "orange", "melon", "banana", "pear", "guava", "peach"};
    List<String> result = tool2.select(fruits, fruit -> fruit.charAt(0) == 'a');
    //印出
    System.out.println(result);
    
    List<String> result2 = tool2.select(fruits, fruit -> fruit.startsWith("p"));
    //印出
    System.out.println(result2);

  }
}

