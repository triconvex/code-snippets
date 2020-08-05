package ps.ww;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.Test;

public class Q2 {

    public String solution(String s) {
        String[] lines = s.split("\n");
        List<Picture> pictures = new ArrayList<>();
        for (String line : lines) {
            Picture picture = new Picture(line);
            pictures.add(picture);
        }

        Map<String, List<Picture>> collect = pictures.stream()
            .sorted(Comparator.comparing(Picture::getDateTime))
            .collect(Collectors.groupingBy(i -> i.city));

        for (List<Picture> values : collect.values()) {
            int index = 0;

            if (values.size() < 10) {
                for (Picture value : values) {
                    value.setIndex(String.valueOf(++index));
                }
            } else {
                for (Picture value : values) {
                    value.setIndex(String.format("%02d", ++index));
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (Picture picture : pictures) {
            result.append(picture.getFormattedPictureName()).append(System.lineSeparator());
        }
        return result.toString().trim();
    }

    @Getter
    private class Picture {

        private String index;
        private String city;
        private String fileName;
        private Extension extension;
        private LocalDateTime dateTime;

        public Picture(String line) {
            String[] parsedData = line.split(", ");
            this.fileName = parsedData[0].split("\\.")[0];
            this.extension = Extension.lookUp(parsedData[0].split("\\.")[1]);
            this.city = parsedData[1].substring(0, 1).toUpperCase() + parsedData[1].substring(1);
            this.dateTime = LocalDateTime.parse(parsedData[2], DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

            if (dateTime.getYear() < 2000 || dateTime.getYear() > 2020) {
                throw new IllegalArgumentException();
            }
        }

        public void setIndex(String index) {
            this.index = index;
        }

        public String getFormattedPictureName() {
            return city + index + "." + extension.getValue();
        }
    }

    @Getter
    @AllArgsConstructor
    private enum Extension {

        JPG("jpg"),
        PNG("png"),
        JPEG("jpeg");

        private final String value;

        public static Extension lookUp(String extension) {
            return Arrays.stream(Extension.values())
                .filter(e -> e.value.equals(extension))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new)
                ;
        }
    }

    @Test
    public void test() {
        String input = "photo.jpg, seoul, 2018-11-10 08:00:05\n"
            + "wow.png, newyork, 2018-10-15 12:15:05\n"
            + "a.jpg, seoul, 2018-10-07 12:15:05\n"
            + "b.jpg, paris, 2016-10-09 17:15:44\n"
            + "c.jpg, paris, 2016-07-13 19:15:22\n"
            + "d.jpg, seoul, 2018-06-14 17:18:22\n"
            + "e.jpg, seoul, 2018-08-22 13:11:13\n"
            + "1111.jpg, paris, 2018-10-14 12:15:05\n"
            + "f.jpg, seoul, 2018-09-11 14:02:12\n"
            + "g.png, seoul, 2018-05-11 09:02:23\n"
            + "h.jpeg, seoul, 2018-02-11 07:02:44\n"
            + "i.jpg, seoul, 2017-10-14 12:17:07\n"
            + "j.jpg, seoul, 2017-10-14 12:16:02\n"
            + "k.jpg, seoul, 2017-10-14 12:15:05";

        String expected = "Seoul10.jpg\n"
            + "Newyork1.png\n"
            + "Seoul09.jpg\n"
            + "Paris2.jpg\n"
            + "Paris1.jpg\n"
            + "Seoul06.jpg\n"
            + "Seoul07.jpg\n"
            + "Paris3.jpg\n"
            + "Seoul08.jpg\n"
            + "Seoul05.png\n"
            + "Seoul04.jpeg\n"
            + "Seoul03.jpg\n"
            + "Seoul02.jpg\n"
            + "Seoul01.jpg";

        assertThat(solution(input)).isEqualTo(expected);
    }

}
