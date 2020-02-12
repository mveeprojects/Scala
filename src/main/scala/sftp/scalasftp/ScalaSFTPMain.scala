package sftp.scalasftp

import java.util.Properties

import com.jcraft.jsch.{ChannelSftp, JSch}


object ScalaSFTPMain extends App {

  private val localPathPrefix = "target/"
  private val remotePathPrefix = "upload/"
  private val config = new Properties

  openSFTPConnection()

  private def openSFTPConnection(): Unit = {
    val jsch = new JSch
    jsch.setKnownHosts("~/.ssh/known_hosts")

    //    Need to sort out auth issues rather than turning host key checking off!
    config.put("StrictHostKeyChecking", "no")

    val session = jsch.getSession("foo", "localhost", 2222)
    session.setConfig(config)
    session.setPassword("pass")
    session.connect()
    println("Connected to SFTP")

    val channel = session.openChannel("sftp")
    channel.connect()

    val sftpChannel = channel.asInstanceOf[ChannelSftp]
    sftpChannel.get(remotePathPrefix + "*", localPathPrefix)
    sftpChannel.exit()
    channel.disconnect()
    session.disconnect()

    println("Disconnected from SFTP")
  }
}