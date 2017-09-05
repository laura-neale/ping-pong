# Ping-Pong
A simple app that demonstrates the use of wait and notify to co-ordinate actions between threads. It runs two threads, one which prints 'ping' and one which prints 'pong'. The threads are co-ordinated so that the output is:
```
ping
pong
ping
pong
ping
pong
```