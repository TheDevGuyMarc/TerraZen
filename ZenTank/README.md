![Logo](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/th5xamgrr6se0x5ro4g6.png)

# TerraZen ZenTank

ZenTank is a tank computer that helps control all types of tanks that one could have. This helps with automation of many tasks in this hobby and also with scheduling certain tasks perfectly. In addition to that you can also improve on measuring and tracking of values.

ZenTank is not only software but also a HAT board for the Raspberry Pi. We support all Raspberry Pi's with a 40 Pin GPIO.

## Tech Stack

See the README files in the specific project folders please.

## Features

### ZenTank

-

## Roadmap

Keep in mind that this is the overall Roadmap, for the specific Roadmap look in the Roadmap.md file in each sub project.

- [ ]  Implementation
- [ ]  Unit Tests
- [ ]  Integration Tests
- [ ]  Performance Tests
- [ ]  Vulnerability Tests

## Installation

If you want to install ZenTank Locally you need some prerequisites to make this work.

### Docker Way

- Install docker, docker compose, docker desktop

### Classical Way

- Install Node 20.x.x
- Install Golang 1.22.1
- Install Docker & Docker Compose

## Development

### Run Local DEV Environment

```shell
  podman-compose -f dev-podman-compose.yml up
```

### Run Local UAT Environment

```shell
  podman-compose -f uat-podman-compose.yml up
```

### Run Local PROD Environment

```shell
  podman-compose -f prod-podman-compose.yml up
```

## Tests

With ZenTank we test each module before release, that means we do unit and integration tests (automated) before new features reach the customer. What do we test how ?

**Unit Tests**:

- Backend Repository
- Backend Service
- Frontend Service

**Integration Tests**:

- Backend Controller
- Frontend Components

**Performance Tests:**

- All

**Vulnerability Tests:**

- All

### Run Tests

```bash
  npm run test:unit
  npm run test:integration
```

## Deployment

Because you need to deploy ZenTank to a Raspberry Pi there is a need to prepare the Pi and then move the code to that chip.

For that we prepared an automated way to deploy.

```bash

```

## Screenshots

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)

## Usage/Examples

## Documentation

You can find the [official documentation](#) on our website for usage examples and tutorials.

## FAQ

### Is ZenTank Free ?

Yes for now ZenTank is totally free, that might change at a later point though but don't worry if you made a free account you will be free forever.

### Is ZenTank for Aquariums and Terrariums ?

Yes it is and also for Paludariums and Vivariums if you want, we do all animals in tanks.

## Support

If you need any technical or functional support don't hesitate to write us an email we will reach back to you as fast as we can. If there is a technical problem we would prefer if you could use our GitHub issue template, for better and public issue tracking.

## License

[AGPLv3](https://choosealicense.com/licenses/agpl-3.0/)

## References
- [Golang Rest API](https://dev.to/koddr/build-a-restful-api-on-go-fiber-postgresql-jwt-and-swagger-docs-in-isolated-docker-containers-475j)
- [Drivers](https://github.com/reef-pi/drivers)
- [Hardware Access Layer](https://github.com/reef-pi/hal)
- [Unit & Integration Testing](https://medium.com/@victorsteven/understanding-unit-and-integrationtesting-in-golang-ba60becb778d)
- [Golang Mail Sending](https://medium.com/@victorsteven/sending-and-faking-emails-with-custom-templates-in-golang-15a017c191ec)