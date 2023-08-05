package com.library;

import com.library.SudokuSolver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

public class RunConcurrency {
    private static final ExecutorService service = Executors.newScheduledThreadPool(5);
    private static Set<Callable<Integer[][]>>sudoku_answers = new HashSet<>();

    public synchronized static void setCallableList(int [][]grid)
    {
        sudoku_answers.add(
                new Callable<Integer[][]>() {
                    @Override
                    public Integer[][] call() throws Exception {
                        return (new SudokuSolver(grid)).returnAnswer();
                    }
                }
        );
    }

    public synchronized static void runAllExecutables()
    {
        List<Future<Integer[][]>> futureTasks = null;
        for(Callable<Integer[][]>G : sudoku_answers)
        {
            Future<Integer[][]>task = service.submit(G);
            futureTasks.add(task);
        }

        futureTasks.forEach((I)->
        {
            try {
                I.get(500,TimeUnit.MILLISECONDS);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                System.err.println(e.getMessage());
                throw new RuntimeException(e);
            } catch (TimeoutException e) {
                System.err.println(e.getMessage());
                throw new RuntimeException(e);
            } catch(CancellationException A)
            {
                System.err.println(A.getMessage());
                throw new CancellationException();
            }

        });

        service.close();
    }

}
