
![Logo](https://dev-to-uploads.s3.amazonaws.com/uploads/articles/th5xamgrr6se0x5ro4g6.png)

# TerraZen ZenBreeder

ZenBreeder is an application that helps breeders to do their work even more efficient and fully digital.
This also helps keeping track and reminding you what needs to be done.

## Tech Stack

- Java 21
- Springboot
- Spring Security
- PostgreSQL
- Redis
- GSON
- Lombok
- Tinylog

## Features

### ZenBreeder API

-

## Roadmap

Keep in mind that this is the overall Roadmap, for the specific Roadmap look in the Roadmap.md file in each sub project.

- [ ]  Implementation
- [ ]  Unit Tests
- [ ]  Integration Tests
- [ ]  Performance Tests
- [ ]  Vulnerability Tests

## Installation

If you want to install ZenLexicon Locally you need some prerequisites to make this work.

### Docker Way

- Install docker, docker-compose & docker-desktop

### Classical Way

- Install Node 20.x.x
- Install Java 21.x.x
- Install Maven latest
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

With ZenBreeder we test each module before release, that means we do unit and integration tests (automated)
before new features reach the customer. What do we test how ?

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

**Maven Profiles:**

```xml
<profiles>
   <profile>
      <id>unit-test</id>
      <build>
         <plugins>
            <plugin>
               <groupId>org.apache.maven.plugins</groupId>
               <artifactId>maven-surefire-plugin</artifactId>
               <configuration>
                  <includes>
                     <include>**/Test*.java</include>
                  </includes>
               </configuration>
            </plugin>
         </plugins>
      </build>
   </profile>
   <profile>
      <id>integration-test</id>
      <build>
         <plugins>
            <plugin>
               <groupId>org.apache.maven.plugins</groupId>
               <artifactId>maven-surefire-plugin</artifactId>
               <configuration>
                  <includes>
                     <include>**/IntegrationTest*.java</include>
                  </includes>
               </configuration>
            </plugin>
         </plugins>
      </build>
   </profile>

</profiles>
```

```bash
  mvn test -Punit-test // profile name is unit-test for unit tests
  mvn test -Pintegration-test //// profile name is integration-test for integration tests
```

## Deployment

### Raspberry Pi

```bash

```

### Server

```bash

```

## Screenshots

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)

## Usage/Examples

## Documentation

You can find the [official documentation](#) on our website for usage examples and tutorials.

## FAQ

### Is ZenLexicon Free ?

Yes for now ZenBreeder is totally free, that might change at a later point though but don't worry if you made a free account you will be free forever.

### Is ZenLexicon for Aquariums and Terrariums ?

For now ZenBreeder will only support vertebrate animals in the terrarium/paludarium section, that might change later on if we get enough reliable data.

## Support

If you need any technical or functional support don't hesitate to write us an email we will reach back to you as fast as we can. If there is a technical problem we would prefer if you could use our GitHub issue template, for better and public issue tracking.

## License

[AGPLv3](https://choosealicense.com/licenses/agpl-3.0/)
