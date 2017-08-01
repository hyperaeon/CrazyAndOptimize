package com.jdk8.chapter6;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Created by hzliyong on 2017/7/29 0029.
 */
public class ManualDiceRolls {

    private static final int N = 100000000;

    private final double fraction;

    private final Map<Integer, Double> results;

    private final int numberOfTreads;

    private final ExecutorService executors;

    private final int workPerThread;

    public static void main(String[] args) {
//        ManualDiceRolls rolls = new ManualDiceRolls();
//        rolls.simulateDiceRoles();
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

    public ManualDiceRolls() {
        fraction = 1.0 / N;
        results = new ConcurrentHashMap<>();
        numberOfTreads = Runtime.getRuntime().availableProcessors();
        executors = Executors.newFixedThreadPool(numberOfTreads);
        workPerThread = N / numberOfTreads;
    }

    public void simulateDiceRoles() {
        List<Future<?>> futures = submitJobs();
        awaitCompletion(futures);
        printResults();
    }

    private void printResults() {
        results.entrySet().forEach(System.out::print);
    }

    private List<Future<?>> submitJobs() {
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < numberOfTreads; i++ ) {
            futures.add(executors.submit(makeJob()));
        }
        return futures;
    }

    private Runnable makeJob() {
        return () -> {
            ThreadLocalRandom random = ThreadLocalRandom.current();
            for (int i = 0; i < workPerThread; i++) {
                int entry = twoDiceThrows(random);
                accumulateResult(entry);
            }
        };
    }

    private void accumulateResult(int entry) {
        results.compute(entry, (key, previous) -> previous == null ? fraction : previous + fraction);
    }

    private int twoDiceThrows(ThreadLocalRandom random) {
        int firstThrow = random.nextInt(1, 7);
        int secondThrow = random.nextInt(1, 7);
        return firstThrow + secondThrow;
    }

    private void awaitCompletion(List<Future<?>> futures) {
        futures.forEach((future -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();;
            }
        }));
        executors.shutdown();
    }

//    public Map<Integer, Double> parallelDiceRolls(int N) {
//        double fraction = 1.0 / N;
//        return IntStream.range(0, N)
//                .parallel()
//                .mapToObj(twoDiceThrows())
//                .collect(groupingBy(side -> side,
//                        summingDouble(n -> fraction)));
//    }
}
