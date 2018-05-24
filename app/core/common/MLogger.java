package core.common;

import play.Logger;

/**
 * Created by hranaivoson on 09/11/15.
 * new MLogger("controller").debug(DsnDetailView.class, "$$$$ Salaire de base (%s)", salaireBase);
 */
public class MLogger {

    private Logger.ALogger LOGGER;

    public MLogger(String logname){
        if (logname == null){
            LOGGER = Logger.of("application");
        }else {
            LOGGER = Logger.of(logname);
        }
    }


    public static String format(String msg, Object... args) {
        try {
            if (args != null && args.length > 0) {
                return String.format(msg, args);
            }
            return msg;
        }
        catch (Exception e) {
            return msg;
        }
    }

    public void trace(String message, Object... args) {
        LOGGER.trace(format(getClassMethodAndLineNumber() + " - " + message, args));
    }

    public void debug(Throwable e, String message, Object... args) {
        LOGGER.debug(format(getClassMethodAndLineNumber() + " - " + message, args), e);
    }

    public void debug(String message, Object... args) {
        LOGGER.debug(getClassMethodAndLineNumber() + " - " + format(message, args));
    }

    public void info(Throwable e, String message, Object... args) {
        LOGGER.info(format(getClassMethodAndLineNumber() + " - " + message, args), e);
    }

    public void info(String message, Object... args) {
        LOGGER.info(format(getClassMethodAndLineNumber() + " - " + message, args));
    }

    public void error(Throwable e, String message, Object... args) {
//        Logger.error(format(getClassMethodAndLineNumber() + " - " + message, args), e);
        LOGGER.error(format(getClassMethodAndLineNumber() + " - " + message, args), e);
    }

    public void error(String message, Object... args) {
        StringBuilder strTrace = new StringBuilder();
        /*StackTraceElement[] trace = Thread.currentThread().getStackTrace();
        for (StackTraceElement t: trace) {
            strTrace.append("\n\t" + t.toString());
        }*/
        LOGGER.error(format(getClassMethodAndLineNumber() + " - " + message, args));
    }

    public void warn(Throwable e, String message, Object... args) {
        LOGGER.warn(format(getClassMethodAndLineNumber() + " - " + message, args), e);
    }

    public void warn(String message, Object... args) {
        LOGGER.warn(format(getClassMethodAndLineNumber() + " - " + message, args));
    }

    private String getClassMethodAndLineNumber() {
        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
        int indice=3;
        String className = stacks[indice].getClassName();
        String methodName = stacks[indice].getMethodName();
        int lineNumber = stacks[indice].getLineNumber();
        return className+":"+methodName+":"+lineNumber;
    }


}
