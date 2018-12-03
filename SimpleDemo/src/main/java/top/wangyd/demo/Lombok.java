package top.wangyd.demo;

import lombok.*;
import lombok.experimental.var;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wang
 * @date 2018年11月14日09:51:54
 */

//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
//public class Lombok {
//
//    @Getter @Setter private String name;
//    @Getter @Setter private String hobby;
//
//}

//@Data
//@AllArgsConstructor
//public class Lombok{
//
//    String name;
//    String hobby;
//
//}

@Builder
@ToString
public class Lombok{
    String name;
    String hobby;

    public List<String> returnList(){
        var list = new ArrayList<String>();
        list.add("lombok1");
        list.add("lombok2");
        return list;
    }
}

class TestLombok{
    public static void main(String[] args) {
        Lombok lombok = Lombok.builder().name("子轩").build();
        System.out.println(lombok.returnList());
        System.out.println(lombok);
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("./").getPath());
    }
}
