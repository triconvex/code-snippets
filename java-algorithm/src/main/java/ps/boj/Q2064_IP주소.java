package ps.boj;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Q2064_IP주소 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());


        List<IpAddress> addresses = new ArrayList<>();

        for(int i = 0; i < count; i++) {
            addresses.add(new IpAddress(br.readLine()));
        }

        addresses.sort(Comparator.comparing(o -> o.rowAddress));

        IpAddress max = addresses.get(addresses.size() - 1);
        IpAddress min = addresses.get(0);

        int m = max.getM(min);

        StringBuilder bitmask = new StringBuilder();
        for(int i = 0; i < m; i++) {
            bitmask.append("0");
        }

        for(int i = 0; i < 32 - m; i++) {
            bitmask.insert(0, "1");
        }

        max.printMin(distance(bitmask));
        System.out.println(binaryToAddress(bitmask.toString()));
    }

    private static String binaryToAddress(String binaryAddress) {
        int[] partials = new int[4];
        for(int i = 0, j = 0; i < 4; i++) {
            partials[i] = Integer.parseInt(binaryAddress.substring(j, j + 8), 2);
            j += 8;
        }

        return Arrays.stream(partials)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining("."));
    }

    private static int distance(StringBuilder bitmask) {
        int result = 0;

        for(int i = 0; i < 32;) {
            String parsed = bitmask.substring(i, i + 8);
            result += 255 - Integer.parseInt(parsed, 2);
            i += 8;
        }

        return result;
    }

    private static class IpAddress {
        private String rowAddress;
        private String[] partials;

        IpAddress(String rowAddress) {
            this.rowAddress = rowAddress;
            this.partials = rowAddress.split("\\.");
        }

        int getM(IpAddress target) {
            for(int i = 0; i < 4; i++) {
                String xor = Integer.toBinaryString(Integer.parseInt(partials[i]) ^ Integer.parseInt(target.partials[i]));
                if(!xor.equals("0")) {
                    return (3 - i) + xor.length();
                }
            }

            return -1;
        }

        void printMin(int distance) {
            StringBuilder result = new StringBuilder();

            for(int i = 3; i >= 0; i--) {
                if(Integer.parseInt(partials[i]) <= distance) {
                    result.insert(0, ".0");
                    distance -= 255;
                } else {
                    result.insert(0, Integer.parseInt(partials[i]) - distance);
                    result.insert(0, ".");
                    distance = 0;
                }
            }

            System.out.println(result.substring(1));
        }
    }

    @Test
    public void test() {


        System.out.println(Integer.toBinaryString(255));

        System.out.println(Integer.toBinaryString(255 >> 4));
        System.out.println(255 >> 4);
        System.out.println(Long.toBinaryString(255L >> 4));
        System.out.println(255L >> 4);









    }

}
