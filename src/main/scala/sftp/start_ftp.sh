#!/usr/bin/env bash
mkdir ~/ftpMount #
cp ../../../../images/* ~/ftpMount/ #
docker rm -f ftp #
docker run -d -v ~/ftpMount:/home/vsftpd -p 20:20 -p 21:21 -p 47400-47470:47400-47470 -e FTP_USER=mark  -e FTP_PASS=pass -e PASV_ADDRESS=127.0.0.1 --name ftp --restart=always bogem/ftp #