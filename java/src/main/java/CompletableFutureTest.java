import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureTest {

    Runnable task = () -> {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

        System.out.println("TASK completed!");
    };

    @Test
    public void completableFutureTest() {
        CompletableFuture
                .runAsync(task)
                .thenCompose(aVoid -> CompletableFuture.runAsync(task))
                .thenAcceptAsync(aVoid -> System.out.println("all tasks completed!"))
                .exceptionally(throwable -> {
                    System.out.println("exception occurred!");
                    return null;
                });

        try {
            TimeUnit.SECONDS.sleep(100);
        } catch(InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

}
