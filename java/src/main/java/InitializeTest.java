import lombok.*;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.Arrays;

public class InitializeTest {

    @Test
    public void test() {
        A a = A.builder().build();
        B b = B.builder().name("name").build();

        System.out.println(a + " : " + b);
    }

    @Test
    public void name() {

        System.out.println(ScrapType.findByCode("01"));

    }

    @Test
    public void test2() {
        System.out.println(String.format("P%019d", 13L));
        String a = "P0000000000000000013";

        System.out.println(getId(a));

    }

    private static long getId(String a) {
        for(int i = 0; i < a.toCharArray().length; i++) {
            if(a.charAt(i) != '0' && a.charAt(i) != 'P') {
                return Long.parseLong(a.substring(i));
            }
        }

        return 0L;
    }

}

@AllArgsConstructor
@Getter
enum ScrapType {
    AUTO_NTS("01", "소득금액증명정보"),
    NTS("01", "소득금액증명정보"),
    NHIS("02", "건강보험납부정보"),
    NPS("03", "국민연금납부정보");

    private String code;
    private String name;

    public static ScrapType findByCode(String code) {
        return Arrays.stream(ScrapType.values())
                .filter(scrapType -> scrapType.code.equals(code))
                .findFirst()
                .orElseThrow(NullPointerException::new);
    }
}

@ToString
class A {
    private LocalDateTime created;

    @Builder
    public A() {
        this.created = LocalDateTime.now();
    }
}

@NoArgsConstructor
@ToString
class B {
    private String name;
    private LocalDateTime created = LocalDateTime.now();

    @Builder
    public B(String name) {
        this.name = name;
    }

}
