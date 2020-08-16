package ps.kakao.blind20;

import org.junit.Test;

public class 자물쇠와열쇠 {

    public boolean solution(int[][] key, int[][] lock) {
        int expandedLength = lock.length * 3;

        for(int rotateCount = 0; rotateCount < 4; rotateCount++) {
            //begin with (1,1) to (lock.length * 2 - 1, lock.length * 2 - 1)
            for(int i = 1; i < lock.length * 2; i++) {
                for(int j = 1; j < lock.length * 2; j++) {
                    int[][] expanded = getExpandedLock(lock, expandedLength);

                    //insert each key into expanded lock
                    for(int k = i; k < i + key.length; k++) {
                        for(int l = j; l < j + key.length; l++) {
                            expanded[k][l] += key[k - i][l - j];
                        }
                    }

                    //check is fit
                    if(isFit(lock.length, expanded)) {
                        return true;
                    }
                }
            }
            //rotate key
            key = getRotatedKey(key);
        }

        return false;
    }

    private int[][] getExpandedLock(int[][] lock, int length) {
        //create expanded lock
        int[][] expanded = new int[length][length];

        //insert original lock into expanded lock
        for(int i = lock.length; i < lock.length * 2; i++) {
            for(int j = lock.length; j < lock.length * 2; j++) {
                expanded[i][j] = lock[i - lock.length][j - lock.length];
            }
        }
        return expanded;
    }

    public int[][] getRotatedKey(int[][] key) {
        int length = key.length;

        int[][] temp = new int[length][length];
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                temp[i][j] = key[length - j - 1][i];
            }
        }
        return temp;
    }

    private boolean isFit(int originLength, int[][] expanded) {
        for(int i = originLength; i < originLength * 2; i++) {
            for(int j = originLength; j < originLength * 2; j++) {
                if(expanded[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    @Test
    public void test() {
        int[][] key = new int[][]{{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = new int[][]{{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        solution(key, lock);
    }

}
