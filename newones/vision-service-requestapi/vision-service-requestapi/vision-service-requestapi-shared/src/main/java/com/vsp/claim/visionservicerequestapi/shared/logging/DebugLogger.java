package com.vsp.claim.visionservicerequestapi.shared.logging;
import org.slf4j.Logger;

public final class DebugLogger {
	
	private DebugLogger() { }
	
	/**
	 * Log a message at the DEBUG level.
	 * @param log		SLF4J Logger object
	 * @param msg the message string to be logged
	 */
	public static void debugEnabled(Logger log, String msg)
	{
		if (log.isDebugEnabled()) {
			log.debug(msg);
		}
	}
	
	/**
	 * Log a message at the DEBUG level according to the specified format
	 * and argument.
	 * <p/>
	 * <p>This form avoids superfluous object creation when the logger
	 * is disabled for the DEBUG level. </p>
	 * @param log		SLF4J Logger object
	 * @param format the format string
	 * @param arg    the argument
	 */
	public static void debugEnabled(Logger log, String format, Object arg)
	{
		if (log.isDebugEnabled()) {
			log.debug(format, arg);
		}
	}
	
	/**
	 * Log a message at the DEBUG level according to the specified format
	 * and arguments.
	 * <p/>
	 * <p>This form avoids superfluous object creation when the logger
	 * is disabled for the DEBUG level. </p>
	 * @param log		SLF4J Logger object
	 * @param format the format string
	 * @param arg1   the first argument
	 * @param arg2   the second argument
	 */
	public static void debugEnabled(Logger log, String format, Object arg1, Object arg2)
	{
		if (log.isDebugEnabled()) {
			log.debug(format, arg1, arg2);
		}
	}
	
	/**
	 * Log a message at the DEBUG level according to the specified format
	 * and arguments.
	 * <p/>
	 * <p>This form avoids superfluous string concatenation when the logger
	 * is disabled for the DEBUG level. However, this variant incurs the hidden
	 * (and relatively small) cost of creating an <code>Object[]</code> before invoking the method,
	 * even if this logger is disabled for DEBUG. The variants taking
	 * {@link #debug(String, Object) one} and {@link #debug(String, Object, Object) two}
	 * arguments exist solely in order to avoid this hidden cost.</p>
	 * @param log		SLF4J Logger object
	 * @param format    the format string
	 * @param arguments a list of 3 or more arguments
	 */
	public static void debugEnabled(Logger log, String format, Object... arguments)
	{
		if (log.isDebugEnabled()) {
			log.debug(format, arguments);
		}
	}
	
}
