package aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by WORK_x64 on 20.03.2017.
 */
@Aspect
public class LoggingAspect {
    // в пойнткате определен шаблон, под который попадают все методы logEvent с любыми параметрами
    // во всех классах-логгерах. Имя этого пойнтката - это имя данного метода allLogEventMethods:
    // (я так понимаю, это так: первая * значит "все", вторая * значит "любого класса", (..) значит
    // "любые аргументы")
    @Pointcut("execution(* *.logEvent(..))")
    private void allLogEventMethods() {}

    // здесь применена логическая операция для объединения пойнткатов.............. (скорее всего,в
    // шаблоне написано: пойнткат allLogEventMethods&& все ....(??)... файлы с названием любойFileлюбойLogger):
    @Pointcut("allLogEventMethods() && within(*.*File*Logger)")
    private void logEventInsideFileLoggers() {}
}
