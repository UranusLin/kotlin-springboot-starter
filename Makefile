# define variables
APP_NAME=kotlin-springboot-starter
DOCKER_COMPOSE=docker-compose
DOCKER_COMPOSE_FILE=src/main/docker/docker-compose.yml
SPRING_PROFILE=dev

# default target
.PHONY: all
all: build

# build Spring Boot application
.PHONY: build
build:
	./gradlew build

# run Spring Boot application
.PHONY: run
run:
	./gradlew bootRun

# build Docker image
.PHONY: docker-build
docker-build:
	$(DOCKER_COMPOSE) -f $(DOCKER_COMPOSE_FILE) build

# start Docker postgres container
.PHONY: docker-up-postgres
docker-up-postgres:
	$(DOCKER_COMPOSE) -f $(DOCKER_COMPOSE_FILE) up -d db

# start Docker container
.PHONY: docker-up
docker-up:
	$(DOCKER_COMPOSE) -f $(DOCKER_COMPOSE_FILE) up -d

# stop Docker container
.PHONY: docker-down
docker-down:
	$(DOCKER_COMPOSE) -f $(DOCKER_COMPOSE_FILE) down

# run Flyway migration
.PHONY: migrate
migrate:
	./gradlew flywayMigrate

# clean build output
.PHONY: clean
clean:
	./gradlew clean

# redeploy and start container
.PHONY: redeploy
redeploy: docker-down docker-build docker-up

# view application logs
.PHONY: logs
logs:
	$(DOCKER_COMPOSE) -f $(DOCKER_COMPOSE_FILE) logs -f

# Ktlin code style check
.PHONY: lint
lint:
	./gradlew ktlintCheck

# Ktlin code style format
.PHONY: format
format:
	./gradlew ktlintFormat

# run tests
.PHONY: test
test:
	./gradlew test
