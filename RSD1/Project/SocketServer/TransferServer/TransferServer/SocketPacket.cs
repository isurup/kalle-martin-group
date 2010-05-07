using System;
using System.Net;
using System.Net.Sockets;

namespace TransferServer
{
    public class SocketPacket
    {
        // Constructor that takes a Socket and a client number
        private Socket mySocket;
        public Socket MySocket
        {
            get { return mySocket; }
            set { mySocket = value; }
        }
        private byte[] dataBuffer = new byte[1024];//3776598

        public byte[] DataBuffer
        {
            get { return dataBuffer; }
            set { dataBuffer = value; }
        }
        public SocketPacket(System.Net.Sockets.Socket socket)
        {
            mySocket = socket;
        }
    }
}