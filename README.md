# spring-session-oauth-gateway
replicate issue for calls made to the gateway returning a 302 after reloading the application with active session in redis

## Endpoints
- https://localhost:9093/hello.html
- https://localhost:9093/entries


## Reproducing Problem

1. Start Application.
2. User requests loading application in the browser: https://localhost:9093/hello.html
3. Session is successfully created in Redis.
4. User redirected to the Oauth2 Server for Authentication
5. User Authenticates
6. User redirected to application after successful login.
7. Application loads in browser without a problem.
8. User requests a gateway resource: https://localhost:9093/entries
9. Resources loads fine with a 200.
10. Everything great so far.
11. Restart the server.
12. (Session still active, saved on Redis)
13. User requests the gateway resource (https://localhost:9093/entries).
14. Resources returns 302 and redirected to the Ouath Server (BAD)
