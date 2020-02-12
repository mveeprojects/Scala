#!/usr/bin/env bash
mkdir ~/sftpMount #
cp ../../../../images/* ~/sftpMount/ #
docker rm -f sftp #
docker run -d --name sftp -p 2222:22 --restart always -v ~/sftpMount:/home/foo/upload atmoz/sftp foo:pass:1001 #