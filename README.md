# Java Network Chat Application 🌐💬

This project is a Java-based network programming application that implements a multi-client chat server with resource management and exception handling. It demonstrates fundamental concepts of TCP/IP networking, socket programming, and proper resource cleanup.

## 🌟 Features

- Multi-client support for simultaneous chat sessions
- Chat commands system with various functionalities
- Robust resource management and cleanup
- Exception handling for network-related issues
- Logging utilities for better debugging and monitoring

## 📝 Chat Commands

- `/join|{name}` - Join the chat server with a username
- `/message|{content}` - Send message to all connected users
- `/change|{name}` - Change your username
- `/users` - List all connected users
- `/exit` - Leave the chat server

## 🗂️ Project Structure

```
src/
├── network/
│   └── tcp/
│       ├── v1/                 # Basic client-server implementation
│       │   ├── ClientV1.java
│       │   └── ServerV1.java
│       ├── v2/                 # Enhanced with continuous messaging
│       │   ├── ClientV2.java
│       │   └── ServerV2.java
│       ├── v3/                 # Multi-client support
│       │   ├── ClientV3.java
│       │   ├── ServerV3.java
│       │   └── SessionV3.java
│       ├── v4/                 # Resource management
│       │   ├── ClientV4.java
│       │   ├── ServerV4.java
│       │   └── SessionV4.java
│       ├── v5/                 # Try-with-resources implementation
│       │   ├── ClientV5.java
│       │   ├── ServerV5.java
│       │   └── SessionV5.java
│       └── v6/                 # Final version with shutdown hooks
│           ├── ClientV6.java
│           ├── ServerV6.java
│           └── SessionV6.java
├── exception/
│   └── connect/               # Network exception handling
│       ├── normal/
│       └── reset/
└── util/
    └── MyLogger.java         # Logging utility
```

## 🔧 Technical Features

- TCP/IP communication protocol
- Socket programming with Java
- Thread management for concurrent clients
- Resource cleanup with try-with-resources
- Shutdown hooks for graceful server termination
- Comprehensive exception handling for network issues

## 🎯 Learning Outcomes

- Understanding of TCP/IP networking concepts
- Implementation of multi-threaded server applications
- Proper resource management in networked applications
- Network exception handling patterns
- Socket lifecycle management

## 📚 Key Concepts Covered

- Socket and ServerSocket usage
- Input/Output streams
- Thread management
- Exception handling
- Resource cleanup
- Network timeout handling
- Connection reset scenarios
- Graceful shutdown procedures

This project serves as an excellent example of network programming in Java, demonstrating best practices for resource management and exception handling in networked applications. 🚀