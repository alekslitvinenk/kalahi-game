.PHONY: build

all: build run

build:
	@echo "Making docker image"
	mvn clean install
	docker build -f Dockerfile -t alekslitvinenk/kalahi ./target --no-cache

run:
	docker run -p 8080:8080 alekslitvinenk/kalahi