package dev.esz.simplifier;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 
 * <p>
 * A java class to implement a sleep function (similar to the wait() function).
 * </p>
 * 
 * <p>
 * By inputting a long data type, the system will count the remaining time until
 * the execution of the next
 * lines of code.
 * </p>
 * 
 * <p>
 * Ex:
 * </p>
 * 
 * <pre>
 * <blockquote>
 * 
 * Timer myTimer = new Timer(milliseconds: 200);
 * //this will set the waiting time for 200 milliseconds before reading the next code line;
 * //the time units available are milliseconds, seconds, minutes and hours;
 * 
 * myTimer.sleep(count: 1);
 * //the "count" variable represents the amount of times the timer must be executed;
 * //this will wait for 200 milliseconds;
 * 
 * </pre>
 * 
 * </blockquote>
 * 
 * @see java.util.concurrent.CountDownLatch
 * @see java.util.concurrent.TimeUnit
 * @see dev.esz.simplifier.Timer
 * 
 * @author EduardoStarZ
 * 
 * @since 1.0.0
 */
public class Timer {

    private long hours;
    private long minutes;
    private long seconds;
    private long milliseconds;

    private static long totalTime;

    /**
     * <p>
     * A constructor class that sets the amount of time the timer will wait.
     * </p>
     * 
     * @param milliseconds the amount of time in milliseconds.
     * 
     * @since 1.0.0
     */
    public Timer(long milliseconds) {
        setTime(milliseconds);
        totalTime = this.milliseconds;
    }

    /**
     * <p>
     * A constructor class that sets the amount of time the timer will wait.
     * </p>
     * 
     * @param milliseconds the amount of time in milliseconds and seconds.
     * 
     * @since 1.0.0
     */
    public Timer(long milliseconds, long seconds) {
        setTime(seconds, milliseconds);
        totalTime = this.milliseconds + this.seconds;
    }

    /**
     * <p>
     * A constructor class that sets the amount of time the timer will wait.
     * </p>
     * 
     * @param milliseconds the amount of time in milliseconds, seconds and minutes.
     * 
     * @since 1.0.0
     */
    public Timer(long milliseconds, long seconds, long minutes) {
        setTime(minutes, seconds, milliseconds);
        totalTime = this.milliseconds + this.seconds + this.minutes;
    }

    /**
     * <p>
     * A constructor class that sets the amount of time the timer will wait.
     * </p>
     * 
     * @param milliseconds the amount of time in milliseconds, seconds, minutes and
     *                     hours.
     * 
     * @since 1.0.0
     */
    public Timer(long milliseconds, long seconds, long minutes, long hours) {
        setTime(hours, minutes, seconds, milliseconds);
        totalTime = this.milliseconds + this.seconds + this.minutes + this.hours;
    }

    /**
     * 
     * <p>
     * A private class to set the values for the local variables.
     * </p>
     * 
     * @param milliseconds A long that defines the amount of time in milliseconds
     * 
     * @since 1.0.0
     */
    private void setTime(long milliseconds) {
        this.milliseconds = milliseconds;
    }

    /**
     * 
     * <p>
     * A private class to set the values for the local variables.
     * </p>
     * 
     * @param milliseconds A long that defines the amount of time in milliseconds
     * @param seconds A long that defines the amount of time in seconds
     * 
     * @since 1.0.0
     */
    private void setTime(long seconds, long milliseconds) {

        this.milliseconds = milliseconds;

        this.seconds = seconds * 1000;
    }

    /**
     * 
     * <p>
     * A private class to set the values for the local variables.
     * </p>
     * 
     * @param milliseconds A long that defines the amount of time in milliseconds
     * @param seconds A long that defines the amount of time in seconds
     * @param minutes A long that defines the amount of time in minutes
     * 
     * @since 1.0.0
     */
    private void setTime(long minutes, long seconds, long milliseconds) {

        this.milliseconds = milliseconds;

        this.seconds *= 1000;

        minutes *= 1000;
        this.minutes *= 60;
    }

    /**
     * 
     * <p>
     * A private class to set the values for the local variables.
     * </p>
     * 
     * @param milliseconds A long that defines the amount of time in milliseconds
     * @param seconds A long that defines the amount of time in seconds
     * @param minutes A long that defines the amount of time in minutes
     * @param hours A long that defines the amount of time in hours
     * 
     * @since 1.0.0
     */
    private void setTime(long hours, long minutes, long seconds, long milliseconds) {
        this.milliseconds = milliseconds;

        this.seconds *= 1000;

        minutes *= 1000;
        this.minutes *= 60;

        hours *= 120;
        this.hours *= 1000;
    }

    /**
     * <p>
     * A method to make the VM to wait the defined amount of time
     * </p>
     * 
     * <p>
     * The time can be first informed in different types of time units, and then
     * it'll be set all to milliseconds for processing.
     * </p>
     * 
     * @throws RuntimeException if the current thread is interrupted while
     *                              waiting, in any means.
     */
    public boolean sleep(){
        CountDownLatch timer = new CountDownLatch(1);

        boolean finished = false;
        try {
            finished = timer.await(totalTime, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        timer.countDown();

        return finished;
    }

    /**
     * <p>
     * A method to make the VM to wait the defined amount of time
     * </p>
     * 
     * <p>
     * The time can be first informed in different types of time units, and then
     * it'll be set all to milliseconds for processing.
     * </p>
     * 
     * <p>
     * The count variable defines the amount of times the timer will run.
     * </p>
     * 
     * @param count defines the amount of times the timer will run.
     * @throws RuntimeException if the current thread is interrupted while
     *                              waiting, in any means.
     */
    public boolean sleep(int count){

        CountDownLatch timer = new CountDownLatch(count);

        boolean finished = false;
        try {
            finished = timer.await(totalTime, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        timer.countDown();

        return finished;
    }
}