# 1. Briefly explain the difference between Byte Streams and Character Streams

**Byte Streams** (`InputStream`/`OutputStream`) operate on raw binary data. They are suitable for non-text files such as
images, audio, and serialized data. These streams do not interpret encoding and therefore treat all data as simple 
sequences of bytes.

**Character Streams** (`Reader`/`Writer`), on the other hand, operate on textual data. They interpret characters 
according to the underlying encoding (e.g., UTF-8) and allow efficient reading or writing of human-readable text. In 
this assignment, Character Streams are required because we are performing text transformations (uppercase conversion) on
a line-by-line basis.

# 2. Using Multithreading to Perform Concurrent Tasks

### **Task 1: Concurrent Processing of Multiple Course Files**

To process multiple course files at the same time, Java’s multithreading model can be used by creating multiple worker 
threads. Each file can be assigned to an individual thread implemented either by extending the `Thread` class or by 
implementing the `Runnable` interface. Since the files are independent, the threads can run concurrently without 
interfering with one another. This approach improves performance when handling multiple I/O-bound tasks.

### **Task 2: Updating a Shared Word Count Variable**

When several threads contribute to updating a single shared word-count variable, synchronization becomes necessary to 
avoid race conditions. Without proper synchronization, multiple threads might attempt to read and update the variable 
simultaneously, resulting in incorrect values.

This can be handled in several ways:

- Using a **synchronized** block or synchronized method around the update operation.

- Using an **AtomicInteger**, which provides thread-safe increment operations without explicit locking.

- Using explicit locks such as **ReentrantLock** where finer control is needed.


Each approach ensures that updates to the shared variable occur safely and consistently, preserving program correctness 
under concurrency.