package kakao.blind20;

import org.junit.Test;

import java.util.*;

public class 기둥과보설치 {

    private Set<Frame> installed = new HashSet<>();

    public int[][] solution(int n, int[][] build_frame) {
        for(int[] status : build_frame) {
            Frame frame = new Frame(status[0], status[1], status[2], status[3]);
            if(frame.isInstallCase()) {
                installIgnore(frame);
            } else {
                removeIgnore(frame);
            }
        }

        Comparator<Frame> frameComparator = Comparator
                .comparing(Frame::getX)
                .thenComparing(Frame::getY)
                .thenComparing(Frame::getFrameType);

        List<Frame> answers = new ArrayList<>(installed);
        answers.sort(frameComparator);

        return answers.stream()
                .map(frame -> new int[]{frame.x, frame.y, frame.frameType})
                .toArray(int[][]::new)
                ;
    }

    private void installIgnore(Frame frame) {
        if(isInstallable(frame)) {
            installed.add(frame);
        }
    }

    private void removeIgnore(Frame frame) {
        installed.remove(frame);

        for(Frame remained : installed) {
            if(!isInstallable(remained)) {
                installed.add(frame);
                return;
            }
        }
    }

    private boolean isInstallable(Frame frame) {
        int x = frame.x;
        int y = frame.y;

        if(frame.isBeam()) {
            if(installed.contains(new Frame(x, y - 1, 0))) {
                return true;
            }
            if(installed.contains(new Frame(x + 1, y - 1, 0))) {
                return true;
            }
            return installed.contains(new Frame(x - 1, y, 1))
                    && installed.contains(new Frame(x + 1, y, 1));
        } else {
            if(y == 0) {
                return true;
            }
            if(installed.contains(new Frame(x, y - 1, 0))) {
                return true;
            }
            if(installed.contains(new Frame(x - 1, y, 1))) {
                return true;
            }
            return installed.contains(new Frame(x, y, 1));
        }
    }

    private class Frame {

        private final int x;
        private final int y;
        private final int frameType;
        private int commandType;

        public Frame(int x, int y, int frameType, int commandType) {
            this.x = x;
            this.y = y;
            this.frameType = frameType;
            this.commandType = commandType;
        }

        public Frame(int x, int y, int frameType) {
            this.x = x;
            this.y = y;
            this.frameType = frameType;
        }

        public boolean isBeam() {
            return frameType == 1;
        }

        public boolean isInstallCase() {
            return commandType == 1;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getFrameType() {
            return frameType;
        }

        @Override
        public boolean equals(Object o) {
            if(this == o) return true;
            if(!(o instanceof Frame)) return false;
            Frame frame = (Frame) o;
            return x == frame.x &&
                    y == frame.y &&
                    frameType == frame.frameType;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, frameType);
        }
    }

    @Test
    public void test() {
        solution(5, new int[][]{{1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1}, {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}});
    }

}
