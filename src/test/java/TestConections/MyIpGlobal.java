package TestConections;


public class MyIpGlobal {
    
    static String myIp = "127.0.0.1"; 
    
    public static String getIp()
    {
        return myIp;
    }
    
    public static void changeIp(String newIp)
    {
        myIp = newIp;
    }
}
