using System;
using System.Text;
using System.Threading;

namespace TransferServer
{
    class Program
    {
        static void Main(string[] args)
        {
            Server server = new Server();            
            int portnumber = 8000;
            server.startListeningAsync(portnumber);
            Console.Out.WriteLine("> Server");
            for (;;) {                
                Thread.Sleep(99999999);                
            }            
        }
    }
}
