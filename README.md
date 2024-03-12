# Java Concurrency

Please read the following the "official" tutorial on [Java Concurrency](https://docs.oracle.com/javase/tutorial/essential/concurrency/index.html) and experiment with the included example programs:
* [Defining and Starting a Thread](https://docs.oracle.com/javase/tutorial/essential/concurrency/runthread.html): [HelloRunnable.java](./HelloRunnable.java) [HelloThread.java](./HelloThread.java)
* [Interrupts](https://docs.oracle.com/javase/tutorial/essential/concurrency/interrupt.html): [SimpleThreads.java](./SimpleThreads.java) 
* [Joins](https://docs.oracle.com/javase/tutorial/essential/concurrency/join.html)
* [Synchronization](https://docs.oracle.com/javase/tutorial/essential/concurrency/sync.html)
  * [Thread Intereference](https://docs.oracle.com/javase/tutorial/essential/concurrency/interfere.html): [Counter.java](./Counter.java)
  * [Synchronized Methods](https://docs.oracle.com/javase/tutorial/essential/concurrency/syncmeth.html): [SynchronizedCounter.java](./SynchronizedCounter.java)

Please read the [Concurrency in Swing](https://docs.oracle.com/javase/tutorial/uiswing/concurrency/index.html) lesson and experiment the following examples:
* [Flipper.java](./Flipper.java)
* [ProgressBarDemo.java](./ProgressBarDemo.java)

Follow the [SwingWorker tutorial](https://www.javacodegeeks.com/2012/12/multi-threading-in-java-swing-with-swingworker.html) and experiment with the following examples:
* [SwingExample.java](./SwingExample.java): single-threaded program that executed the "update code" in the "event dispatch thread".
* [SwingExample0.java](./SwingExample0.java): executes the "update code" in a normal thread, which is problematic.
* [SwingExample1.java](./SwingExample1.java): to update the GUI from another thread we should use SwingUtilities to schedule our "update code" to run on the event dispatch thread, which looks ugly.
* [SwingExample2.java](./SwingExample2.java): `SwingWorker` is an alternative to using the `Thread` class, specifically designed for Swing. It’s an abstract class and it takes two template parameters.
* [SwingExample3.java](./SwingExample3.java): update the GUI by returning a value from `doInBackground()` and then over-riding `done()`, which can safely update the GUI. 
* [SwingExample4.java](./SwingExample4.java): call the `publish()` method to ‘publish’ the values with which we want to update the user interface (which can be of whatever type the second template parameter specifies). Then we override the process() method, which receives the values that we publish.

[source](https://jenkov.com/tutorials/java-concurrency/index.html)





