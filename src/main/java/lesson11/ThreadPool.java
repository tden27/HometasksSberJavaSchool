package lesson11;

import java.util.concurrent.Executor;

public interface ThreadPool {

    // Запускает потоки. Потоки бездействуют, до тех пор пока не появится новое задание в очереди (см. execute)
    void start();

    // Складывает это задание в очередь. Освободившийся поток должен выполнить это задание. Каждое задание должны быть выполнено ровно 1 раз
    void execute(Runnable runnable);
}
