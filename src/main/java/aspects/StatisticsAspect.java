package aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by WORK_x64 on 22.03.2017.
 */
@Aspect
/** Statistics aspect that counts how many times logEvent() method was called in each logger */
public class StatisticsAspect {
    private Map<Class<?>, Integer> counter = new HashMap<>();

    // создаем пойнткат с шаблоном "любое количество любого класса методов logEvent с любыми аргументами":
    @Pointcut("execution(* *.*logEvent(..))")
    private void allLogEventMethods() {}

    // создаем advice-метод для увеличения счетчика:
    @AfterReturning("allLogEventMethods")
    public void count(JoinPoint joinPoint) {
        // с помощью интерфейса JoinPoint можем получить информацию о классе, в котором в данный момент
        // был выполнен метод logEvent():
        Class<?> clazz = joinPoint.getTarget().getClass();
        // если в мапе counter нет еще ключа такого класса, то добавляем его со значением = 0:
        if (!counter.containsKey(clazz)) {
            counter.put(clazz, 0);
        }
        // если уже есть, просто переписываем, увеличивая счет:
        counter.put(clazz, counter.get(clazz) + 1);
    }

    // теперь advice-метод для того, чтобы эта информация была выведена в консоль после выполнения App.
    // Притом создаем определение пойнтката сразу в advice-аннотации :
    @AfterReturning("execution(* App.logEvent(..)")
    public void outputLoggingCounter() {
        System.out.println("Loggers statistics. Number of calls: ");
        for (Map.Entry<Class<?>, Integer> entry : counter.entrySet()) {
            System.out.println("    " + entry.getKey().getSimpleName() + ": " + entry.getValue());
        }
    }


}
