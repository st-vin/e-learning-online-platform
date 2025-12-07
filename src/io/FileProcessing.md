# 1. Briefly explain the difference between Byte Streams and Character Streams

**Byte Streams** (`InputStream`/`OutputStream`) operate on raw binary data - essentially, sequences of 1s and 0s. 
They are suitable for non-text files such as images, audio, and serialized data. These streams do not interpret encoding
and therefore treat all data as simple sequences of bytes. Think of them as a delivery mechanism that moves data without caring about its meaning.

**Character Streams** (`Reader`/`Writer`), on the other hand, operate on textual data. They interpret characters according to the underlying encoding (e.g., UTF-8) and allow efficient reading or writing of human-readable text. Unlike byte streams, character streams understand that certain byte patterns represent specific letters, numbers, or symbols.

In this assignment, Character Streams are required because we are performing text transformations (uppercase conversion) on a line-by-line basis. Character streams can recognize and manipulate actual text characters, whereas byte streams would only see numerical values without understanding their textual meaning.

---

# 2. Using Multithreading to Perform Concurrent Tasks

### **Task 1: Concurrent Processing of Multiple Course Files**

To process multiple course files at the same time, Java's multithreading model can be used by creating multiple worker threads. Each file can be assigned to an individual thread implemented either by extending the `Thread` class or by implementing the `Runnable` interface.

Since the files are independent of one another, the threads can run concurrently without interfering with each other's work. This is similar to having multiple people each read their own separate book - they don't disrupt one another. This approach improves performance when handling multiple I/O-bound tasks, as files can be read and processed simultaneously rather than sequentially.

### **Task 2: Updating a Shared Word Count Variable**

When several threads contribute to updating a single shared word-count variable, synchronization becomes necessary to avoid race conditions. A race condition occurs when multiple threads attempt to read and update the same variable simultaneously, potentially resulting in incorrect or lost updates.

**Example scenario:**
1. Thread A reads the current count: 100
2. Thread B reads the current count: 100 (before Thread A writes back)
3. Thread A adds 5 and writes: 105
4. Thread B adds 3 and writes: 103
5. Result: The final count is 103 instead of the expected 108

This can be handled in several ways:

- Using a **synchronized** block or synchronized method around the update operation. This ensures only one thread can access the critical section at a time, like placing a lock on a door.

- Using an **AtomicInteger**, which provides thread-safe increment operations without explicit locking. This class handles synchronization internally and is often more efficient for simple counter operations.

- Using explicit locks such as **ReentrantLock** where finer control is needed. This provides more flexibility in controlling when and how the lock is acquired and released.

Each approach ensures that updates to the shared variable occur safely and consistently, preserving program correctness under concurrency. Without such mechanisms, the program would produce unpredictable and incorrect results when multiple threads access shared data.