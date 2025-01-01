package network.tcp.autocloseable;

public class ResourceV1 {

    private String name;

    public ResourceV1(String name){
        this.name = name;
    }

    public void call(){
        System.out.println("Calling resource: " + name);
    }

    public void callEx() throws CallException{
        System.out.println("Calling resource: " + name);
        throw new CallException("Call exception: " + name);
    }

    public void close(){
        System.out.println("Closing resource: " + name);
    }

    public void closeEx() throws CloseException{
        System.out.println("Closing resource: " + name);
        throw new CloseException("Close exception: " + name);
    }
}
