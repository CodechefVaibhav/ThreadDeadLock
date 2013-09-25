/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threaddeadlock;

/**
 *
 * @author pc
 */
import java.util.ArrayList;
import java.util.List;

/** In this program two threads are trying to read students and teachers details.
* @author vinod
*
*/
public class SimpleDeadLock {
    public static void main(String[] args) {
    

        final List students=new ArrayList();
        students.add("Raju");
        students.add("Radha");

        final List teachers=new ArrayList();
        teachers.add("Gopal");
        teachers.add("Ragav");
    

        Thread t1 = new Thread() {
            public void run() {
                synchronized (students) {
                    System.out.println("Now thread 1 locked student arraylist");
                    System.out.println("students details from thread1" +students);

                    try {
                        Thread.sleep(110);
                    } catch (InterruptedException e) {
                    }

                    synchronized (teachers) {
                        System.out.println("Now thread 1 locked teacher arraylist");
                        System.out.println("teacher details from thread1" +teachers);
                    }
                }
            }
        };

        Thread t2 = new Thread() {
            public void run() {
                synchronized (teachers) {
                    System.out.println("Now thread 2 locked teacher arraylist");
                    System.out.println("teacher details from thread 2" +teachers);
                    try {
                        Thread.sleep(110);
                    } catch (InterruptedException e) {
                    }

                    synchronized (students) {
                        System.out.println("Now thread 2 locked student arraylist");
                        System.out.println("students details from thread2" +students);
                    }
                }
            }
        };

        t1.start();
        t2.start();
    }
}
