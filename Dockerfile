FROM ubuntu:latest
LABEL authors="pinag"

ENTRYPOINT ["top", "-b"]