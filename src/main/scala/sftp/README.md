# ScalaFTP (FTP and SFTP)

## FTP: (File Transfer Protocol) setup and run local FTP container

[Run from project root] chmod +x start_ftp.sh && ./start_ftp.sh

[Optional] login by browser -> ftp://localhost/


## SFTP: (Ssh File Transfer Protocol) setup and run local SFTP container

[Run from project root] chmod +x start_sftp.sh && ./start_sftp.sh

[Optional] login via terminal -> sftp -P 2222 foo@localhost


## Sources

FTP server container - https://hub.docker.com/r/bogem/ftp/

FTP Client app (GUI) - https://cyberduck.io/
 
Scala FTP client (ScalaFTPMain.scala) - https://gist.github.com/owainlewis/06e8bdfa6c42acec2ef9dec756c05c2f

Scala Alpakka FTP client (ScalaAlpakkaFTPMain.scala) - https://developer.lightbend.com/docs/alpakka/current/examples/ftp-samples.html

SFTP container - https://hub.docker.com/r/atmoz/sftp/

JSCH SFTP library - http://www.jcraft.com/jsch/

SFTP client code - https://stackoverflow.com/questions/14617/how-to-retrieve-a-file-from-a-server-via-sftp

SFTP UnknownHostKey issue - https://stackoverflow.com/questions/2003419/com-jcraft-jsch-jschexception-unknownhostkey
