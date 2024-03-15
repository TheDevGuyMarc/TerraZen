# Architecture

The TerraZen application ecosystem is split into multiple applications to separate domains as good as possible. This makes maintaining the separate code blocks much easier in the long run. We split into the following domains:

Backend:

- ZenBreeder
- ZenLexicon
- ZenTank

Frontend:

- UI

This also means that we have more parts to maintain if we are fully transparent here. Every backend has a different complexity level and needs certain parts of data to function as it should.

One of the main problems here is that one would typically implement an api gateway or a centralized authentication system like keycloak to serve all those parts equally with protection and rights, but we can't do this. This is because of the possibility that our customers/users are deploying TerraZen on a Raspberry Pi and we don't trust the Pi to be able to run multiple java and go application and a react frontend with an additional keycloak instance. It may do this, but we couldn't check this. So for now every api is implementing their own authentication which is not great tbh.

## Database

All our applications use the same database instance for now, if this creates performance issues we will see over time. We hope to slim down the amount of DB load on the more "weak" systems like the Pi with this approach because even if they have 8GB RAM now this is still a lot to handle for such a small computer.
