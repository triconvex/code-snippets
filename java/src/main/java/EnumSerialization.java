import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.assertj.core.api.JUnitSoftAssertions;
import org.junit.Rule;
import org.junit.Test;

public class EnumSerialization {

    @Rule
    public JUnitSoftAssertions softly;

    @Test
    public void test() {

        softly.assertThat(Example.A.ordinal()).isEqualTo(0);
        softly.assertThat(Example.A.ordinal()).isEqualTo(1);
        softly.assertThat(Example.A.ordinal()).isEqualTo(2);

    }

}

@Getter
@AllArgsConstructor
@JsonFormat(shape= JsonFormat.Shape.OBJECT)
enum Example {

    A(0, "a"),
    B(1, "b"),
    C(2, "c");

    private int code;
    private String name;

}
