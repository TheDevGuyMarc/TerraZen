# Go parameters
GOCMD=go
GOBUILD=$(GOCMD) build
GOTEST=$(GOCMD) test
GOINSTALL=$(GOCMD) install
GOCLEAN=$(GOCMD) clean
BINARY_NAME=zentank
SRC_DIR=./src

# Targets
clean:
	rm -rf ./build

install:
	$(GOCMD) mod tidy
	$(GOINSTALL) $(SRC_DIR)/...

swag:
	swag init --exclude ./pkg

security:
	gosec -quiet ./...

test: security
	go test -v -timeout 30s -coverprofile=cover.out -cover ./...
	go tool cover -func=cover.out

migrate.up:
	migrate -path $(MIGRATIONS_FOLDER) -database "$(DATABASE_URL)" up

migrate.down:
	migrate -path $(MIGRATIONS_FOLDER) -database "$(DATABASE_URL)" down

migrate.force:
	migrate -path $(MIGRATIONS_FOLDER) -database "$(DATABASE_URL)" force $(version)

build: clean test
	env GOOS=linux GOARCH=arm GOARM=7 $(GOBUILD) -o $(BINARY_NAME) -v $(SRC_DIR)/...

build-linux: clean test
	env GOOS=linux GOARCH=amd64 $(GOBUILD) -o $(BINARY_NAME)_linux -v $(SRC_DIR)/...

run: swag build
	$(BUILD_DIR)/$(APP_NAME)

setup: install swag migrate.force
