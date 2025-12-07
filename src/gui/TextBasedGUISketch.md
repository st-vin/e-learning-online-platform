# 1. Text-Based Sketch of the GUI

```
 ------------------------------ 
 |        Login Window        |
 ------------------------------
 | RegNo:      [___________]  |
 | Password:   [___________]  |
 |                              |
 |            (Login)          |
 ------------------------------
```

**Components required:**

- JFrame → the window

- JLabel (RegNo, Password)

- JTextField (for RegNo)

- JPasswordField (for Password)

- JButton (Login)

# 2. Description of the Login GUI

The Login GUI is a simple graphical window that allows users to enter their credentials to access a system. Here's what
each part does:

**The Window (JFrame):**
- This is the main container that holds everything together
- It's the actual window you see on your screen with a title bar ("Login Window")
- You can think of it as a picture frame that holds all the other components

**The Labels (JLabel):**
- These are just text displays that don't change
- They tell users what information to enter in each field
- In this case: "RegNo:" and "Password:" labels

**The Input Fields:**
- **JTextField (for RegNo):** A box where users type their registration number. The text is visible as you type
- **JPasswordField (for Password):** Similar to JTextField, but hides what you type (shows dots or asterisks instead) 
for security

**The Button (JButton):**
- The "Login" button that users click after entering their credentials
- When clicked, it triggers an action to verify the login information

**Layout:**
All these components are arranged vertically in a clean, organized way so users can easily understand what to do: enter 
their registration number, enter their password, then click login.

---

# 3. Role of ActionListener in Handling Button Click Events

**What is an ActionListener?**
An ActionListener is like a "listener" that sits and waits for something to happen—specifically, it waits for user 
actions like button clicks.

**How it works:**

1. **Registration:** You attach the ActionListener to a button (like adding a sensor to a doorbell)
   ```java
   loginButton.addActionListener(this);
   ```

2. **Waiting:** The ActionListener constantly monitors the button, waiting for it to be clicked

3. **Response:** When the button is clicked, the ActionListener immediately calls a special method called `actionPerformed()`
   ```java
   public void actionPerformed(ActionEvent e) {
       // Code here runs when button is clicked
   }
   ```

4. **Action Execution:** Inside `actionPerformed()`, you write what should happen—like checking if the username and 
password are correct, then either opening the main application or showing an error message

**Why it's important:**
Without ActionListener, clicking the button would do nothing. It's the bridge between the user's action (clicking) and 
the program's response (validating login). Think of it as the "brain" that tells the program: "Hey, the user just clicked 
the login button—now do something about it!"