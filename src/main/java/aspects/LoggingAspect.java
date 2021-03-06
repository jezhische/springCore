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
    // шаблон: ("(пропущены модификаторы) * с любым возвращаемым типом (пропущен объявленный тип)
    // * в любом пакете любого класса .logEvent метод (..) с любыми аргументами (пропущено исключение)"
    @Pointcut("execution(* *.logEvent(..))")
    private void allLogEventMethods() {
    }

    // здесь применена логическая операция для объединения пойнткатов.............. (
    @Pointcut("allLogEventMethods() && within(*.*File*Logger)")
    private void logEventInsideFileLoggers() {
    }

//    //    определяем advice для пойнтката allLogEventMethods. В этом месте мы хотим ВЫПОЛНИТЬ ADVICE ПЕРЕД
//// выполнением метода. Через аргумент типа JointPoint можно получить информацию о текущем месте выполнения
//// аспекта. Если он не нужен - не пишем:
//    @Before("allLogEventMethods()")
//    // можно то же самое записать не через имя, а через определение пойнтката:
//    //  @Before("execution(* *.logEvent(..))")
//    // в этом случае запись пойнтката не нужна, но и переиспользовать его нельзя.
//    public void logBefore(JoinPoint joinPoint) {
//        System.out.println("BEFORE: " +
//                joinPoint.getTarget().getClass().getSimpleName() + " " +
//                joinPoint.getSignature().getName());
//    }

//    // Использование кода аспекта ПОСЛЕ ВЫПОЛНЕНИЯ МЕТОДА. При этом, если хотим получить в аспект объект,
//    // который вернул метод, то в аннотации описываем имя параметра retVal и добавляем его в аргументы:
//    @AfterReturning(pointcut = "allLogEventMethods()", returning= "retVal")
//    public void logAfter(Object retVal) {
//        System.out.println("AFTER_RET: " + retVal);
//    }

//    // Чтобы посмотреть на выброшенное исключение:
//    @AfterThrowing(pointcut="allLogEventMethods()",
//            throwing="ex")
//    public void logAfterThrow(Throwable ex) {
//        System.out.println("AFTER_THR: " + ex);
//    }
}
