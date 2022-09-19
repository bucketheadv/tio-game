#!/usr/bin/env sh
protoc --proto_path=proto  --java_out=src/main/java messages.proto